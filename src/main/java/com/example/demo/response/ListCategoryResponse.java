package com.example.demo.response;

import com.example.demo.domain.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ListCategoryResponse {

    List<CategoryResponse> categoryList;
}
