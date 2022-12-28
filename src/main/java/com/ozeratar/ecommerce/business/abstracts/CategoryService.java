package com.ozeratar.ecommerce.business.abstracts;

import java.util.List;

import com.ozeratar.ecommerce.business.requests.create.CreateCategoryRequest;
import com.ozeratar.ecommerce.business.requests.update.UpdateCategoryRequest;
import com.ozeratar.ecommerce.business.responses.create.CreateCategoryResponse;
import com.ozeratar.ecommerce.business.responses.get.GetAllCategoriesResponse;
import com.ozeratar.ecommerce.business.responses.get.GetCategoryResponse;
import com.ozeratar.ecommerce.business.responses.update.UpdateCategoryResponse;

public interface CategoryService {
	List<GetAllCategoriesResponse> getAll();
	GetCategoryResponse getById(int id);
	CreateCategoryResponse add(CreateCategoryRequest createCategoryRequest);
	UpdateCategoryResponse update(UpdateCategoryRequest updateCategoryRequest);
	void delete(int id);
}
