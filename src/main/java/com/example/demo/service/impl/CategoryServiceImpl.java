package com.example.demo.service.impl;

import com.example.demo.converter.CategoryConverter;
import com.example.demo.converter.DateConvert;
import com.example.demo.domain.Category;
import com.example.demo.exception.NewsNotFoundException;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.request.category.CreateCategoryRequest;
import com.example.demo.request.category.UpdateCategoryRequest;
import com.example.demo.response.CategoryResponse;
import com.example.demo.response.ListCategoryResponse;
import com.example.demo.service.CategoryService;
import com.example.demo.service.JwtService;
import com.example.demo.util.JwtData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final JwtService jwtService;

    private final CategoryRepository categoryRepository;
    private final QuestionRepository questionRepository;

    @Override
    public CategoryResponse insertCategory(String token, CreateCategoryRequest boxRequest) {
        JwtData data = jwtService.parseToken(token);
        String userId = data.getUserId();
        Category category = categoryRepository.insert(CategoryConverter.convertBoxRequestToBox(userId, boxRequest));
        return CategoryConverter.convertCategoryToCategoryResponse(category);
    }

    @Override
    public Category save(String token, UpdateCategoryRequest request, String categoryId) {
        Optional<Category> category = categoryRepository.findById(categoryId);
        if (categoryId.isEmpty()) {
            throw new NewsNotFoundException("CATEGORY ID DOES NOT EXIST");
        }
        Category updateCategory = category.get();
        JwtData data = jwtService.parseToken(token);
        String userId = data.getUserId();
        return categoryRepository.save(CategoryConverter.convertUpdateCategoryRequestToCategory(userId, request, updateCategory));
    }

    @Override
    public void deleteCategoryById(String token, String boxId) throws Exception {
        JwtData data = jwtService.parseToken(token);
        String createBoxBy = data.getUserId();
        Category category = categoryRepository.findById(boxId).get();
        if (!createBoxBy.equals(category.getCreateUserId())) {
            throw new Exception("CAN'T DELETE BECAUSE DON'T HAVE PERMISSION");
        }

        if (category == null) {
            throw new Exception("BOX ID DOES NOT EXIST");
        }
        categoryRepository.deleteById(boxId);
    }

    @Override
    public ListCategoryResponse getListCategory(int page, int pageSize) {
        List<CategoryResponse> collect = categoryRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Category::getLastUpdateTime).reversed())
                .map(category -> {
                    int num = questionRepository.countAllByCategoryId(category.getId());
                    return CategoryResponse.builder()
                            .id(category.getId())
                            .banner(category.getBanner())
                            .title(category.getTitle())
                            .lastUpdateTime(DateConvert.convertLongToDate(category.getLastUpdateTime()))
                            .questionNum(num)
                            .build();
                })
                .skip((long) page * pageSize)
                .limit(pageSize)
                .collect(Collectors.toList());
        return new ListCategoryResponse(collect);
    }
}
