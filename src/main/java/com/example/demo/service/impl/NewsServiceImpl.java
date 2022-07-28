package com.example.demo.service.impl;

import com.example.demo.constant.ERole;
import com.example.demo.domain.Comment;
import com.example.demo.domain.News;
import com.example.demo.domain.SubComment;
import com.example.demo.domain.User;
import com.example.demo.exception.CommentNotFoundException;
import com.example.demo.repository.UserRepository;
import com.example.demo.response.CommentResponse;
import com.example.demo.utils.DateConvert;
import com.example.demo.utils.NewsUtil;
import com.example.demo.utils.SubCommentUtil;
import com.example.demo.exception.EventNotFoundException;
import com.example.demo.exception.NewsNotFoundException;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.NewsRepository;
import com.example.demo.repository.SubCommentRepository;
import com.example.demo.request.create.CreateCommentRequest;
import com.example.demo.request.create.CreateNewsRequest;
import com.example.demo.request.create.CreateSubCommentRequest;
import com.example.demo.request.update.UpdateNewsRequest;
import com.example.demo.response.NewSearchResponse;
import com.example.demo.response.NewsResponse;
import com.example.demo.service.JwtService;
import com.example.demo.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {
    private final MongoTemplate mongoTemplate;
    @Autowired
    private JwtService jwtService;

    @Autowired
    public NewsRepository newsRepository;

    @Autowired
    public CommentRepository commentRepository;

    @Autowired
    public SubCommentRepository subCommentRepository;

    @Autowired
    public UserRepository userRepository;

    @Override
    public News updateById(String id, UpdateNewsRequest request) {
        Optional<News> news = newsRepository.findById(id);
        if (news.isEmpty()) {
            throw new NewsNotFoundException("Can't find news with id = " + request.getId());
        }
        News updateEntity = news.get();
        NewsUtil.convertNewsRequestToNews1(request, updateEntity);

        return newsRepository.save(updateEntity);
    }

    @Override
    public News insert(String token, CreateNewsRequest request) {
        return newsRepository.insert(NewsUtil.convertNewsRequestToNews(token, request));
    }

    @Override
    public List<News> findAll(Integer page, Integer pageSize) {
        return newsRepository.findAll(PageRequest.of(page, pageSize)).toList();
    }

    @Override
    public News findById(String id) {
        Optional<News> news = newsRepository.findById(id);
        if (news.isEmpty()) {
            throw new NewsNotFoundException("Can not find news with id = " + id);
        }
        return news.get();
    }

    @Override
    public NewSearchResponse findByHashTag(String hashTag, int page, int pageSize) {
        List<NewsResponse> newsResponses = newsRepository.findByHashTagLike(hashTag)
                .stream().skip(pageSize * page)
                .limit(pageSize)
                .map(item -> {
                    int sum = 0;
                    List<Comment> comments = item.getComments();
                    for (int i = 0; i < comments.size(); i++) {
                        sum += comments.get(i).getSubComment().size();
                    }
                    sum += comments.size();
                    return NewsResponse.builder()
                            .banner(item.getBanner())
                            .title(item.getTitle())
                            .content(item.getContent())
                            .hashTag(item.getHashTag())
                            .lastUpdatedDate(DateConvert.convertLongToDate(item.getLastUpdatedDate()))
                            .commentNumber(sum)
                            .build();
                }).collect(Collectors.toList());
        return new NewSearchResponse(page, pageSize, newsResponses, hashTag);
    }

    @Override
    public NewsResponse getNewsDetailById(String newsId) {
        News news = newsRepository.findById(newsId).get();
        if (news == null) {
            throw new NewsNotFoundException("News Id does not exist");
        }
        Integer commentNumber = 0;
        List<Comment> comments = news.getComments();
        for (int i = 0; i < comments.size(); i++) {
            Query query = new Query();
            query.addCriteria(Criteria.where("entityId").is(newsId));
            List<SubComment> countSubNumber = mongoTemplate.find(query, SubComment.class);
            commentNumber += countSubNumber.size();
            commentNumber += 1;
        }
        NewsResponse response = NewsResponse.builder()
                .banner(news.getBanner())
                .title(news.getTitle())
                .content(news.getContent())
                .lastUpdatedDate(DateConvert.convertLongToDate(news.getLastUpdatedDate()))
                .commentNumber(commentNumber)
                .build();
        return response;
    }

    @Override
    public void deleteNewsById(String id, String token) {
        String createUserIdCheck = jwtService.parseTokenToUserId(token);
        News news = newsRepository.findById(id).get();
        if (!createUserIdCheck.equals(news.getCreateUserId())) {
            throw new NewsNotFoundException("NewsId does not exist");
        }
        newsRepository.deleteById(id);
    }

    @Override
    public News addComment(String newsId, String token, CreateCommentRequest createCommentRequest) {
        News news = newsRepository.findById(newsId).get();
        if (news == null) {
            throw new NewsNotFoundException("NewsId does not exist");
        }
        String userId = jwtService.parseTokenToUserId(token);

        Comment comment = new Comment();
        comment.setUserId(userId);
        comment.setEntityId(newsId);
        comment.setContent(createCommentRequest.getContent());
        comment.setCreatedDate(System.currentTimeMillis());
        commentRepository.save(comment);
        news.getComments().add(comment);
        return newsRepository.save(news);
    }

    @Override
    public void deleteComment(String commentId, String token) {
        Comment comment = commentRepository.findById(commentId).get();
        if (comment == null) {
            throw new EventNotFoundException("NewsId does not exit");
        }
        String userId = jwtService.parseTokenToUserId(token);
        ERole eRole = ERole.valueOf(jwtService.parseTokenToRole(token));
        if ((!userId.equals(comment.getUserId()) || !(eRole.equals(ERole.ADMIN)))) {
            throw new EventNotFoundException("Unauthorized to delete comment");
        }
        for (SubComment c : comment.getSubComment()) {
            subCommentRepository.deleteById(c.getId());
        }

        commentRepository.deleteById(commentId);
    }

    @Override
    public Long showCommentNumber(String newsId) {
        News news = newsRepository.findById(newsId).get();
        if (news == null) {
            throw new NewsNotFoundException("This newsId does not exist");
        }
        Long commentNumber = Long.valueOf(news.getComments().size());
        return commentNumber;
    }

    @Override
    public Comment addSubCommentToComment(String token, String commentId, CreateSubCommentRequest
            createSubCommentRequest) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        if (comment.isEmpty()) {
            throw new NewsNotFoundException("");
        }
        Comment comment1 = comment.get();
        String userId = jwtService.parseTokenToUserId(token);
        SubComment subComment = SubCommentUtil.convertSubCommentRequestToSubComment(createSubCommentRequest,
                comment1.getEntityId(), userId, commentId);
        subCommentRepository.save(subComment);

        comment1.getSubComment().add(subComment);
        Optional<News> news = newsRepository.findById(comment1.getEntityId());
        if (news.isPresent()) {
            List<Comment> comments = news.get().getComments();
            for (Comment c: comments) {
                if (c.getId().equals(comment1.getId())) {
                    c.getSubComment().add(subComment);
                }
            }
            newsRepository.save(news.get());
        }
        return commentRepository.save(comment1);
    }

    @Override
    public void deleteSubComment(String token, String subCommentId) {
        SubComment subComment = subCommentRepository.findById(subCommentId).get();
        if (subComment == null) {
            throw new NewsNotFoundException("SubCommentId does not exist");
        }
        Comment comment = commentRepository.findById(subComment.getCommentId()).get();
        String userId = comment.getUserId();

        ERole role = ERole.valueOf(jwtService.parseTokenToRole(token));
        String userId1 = jwtService.parseTokenToUserId(token);
        String commentId = subComment.getCommentId();

        if (!(role.equals(ERole.ADMIN)) || !(subComment.getUserId().equals(userId1)) || !(userId.equals(commentId))) {
            throw new NewsNotFoundException("Unauthorized to delete Subcomment");
        }
        subCommentRepository.delete(subComment);
    }

    @Override
    public List<CommentResponse> getListComment(String newsId, int page, int pageSize) {
        Optional<News> optionalNews = newsRepository.findById(newsId);
        if (!optionalNews.isPresent()) {
            throw new CommentNotFoundException("News id does not exist");
        }

        News news = optionalNews.get();
        List<CommentResponse> result = news
                .getComments()
                .stream()
                .map(comment -> {
                    User user = userRepository.findById(comment.getUserId()).get();
                    return CommentResponse.builder()
                            .avatar(user.getAvatar())
                            .userName(user.getName())
                            .content(comment.getContent())
                            .createdDate(comment.getCreatedDate())
                            .subCommentNumber(comment.getSubComment().size())
                            .build();
                })
                .skip(page * pageSize)
                .limit(pageSize)
                .collect(Collectors.toList());

        return result;
    }
}

