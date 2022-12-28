package com.ozeratar.ecommerce.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ozeratar.ecommerce.business.abstracts.CategoryService;
import com.ozeratar.ecommerce.business.requests.create.CreateCategoryRequest;
import com.ozeratar.ecommerce.business.requests.update.UpdateCategoryRequest;
import com.ozeratar.ecommerce.business.responses.create.CreateCategoryResponse;
import com.ozeratar.ecommerce.business.responses.get.GetAllCategoriesResponse;
import com.ozeratar.ecommerce.business.responses.get.GetCategoryResponse;
import com.ozeratar.ecommerce.business.responses.update.UpdateCategoryResponse;
import com.ozeratar.ecommerce.dataAccess.CategoryRepository;
import com.ozeratar.ecommerce.entities.Category;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {
	private CategoryRepository categoryRepository;
	
	@Override
	public List<GetAllCategoriesResponse> getAll() {
		List<GetAllCategoriesResponse> categoriesResponse = new ArrayList<GetAllCategoriesResponse>();
		List<Category> categories = categoryRepository.findAll();
		
		for (Category category : categories) {
			GetAllCategoriesResponse response = new GetAllCategoriesResponse();
			response.setId(category.getId());
			response.setName(category.getName());
			
			categoriesResponse.add(response);
			
		}
		return categoriesResponse;
	}

	@Override
	public GetCategoryResponse getById(int id) {
		GetCategoryResponse response = new GetCategoryResponse();
		Category category = categoryRepository.findById(id).orElse(null);
		response.setId(category.getId());
		response.setName(category.getName());
		
		return response;
	}

	@Override
	public CreateCategoryResponse add(CreateCategoryRequest createCategoryRequest) {
		CreateCategoryResponse response = new CreateCategoryResponse();
		Category category = new Category();
		category.setName(createCategoryRequest.getName());
		
		categoryRepository.save(category);
		
		response.setId(category.getId());
		response.setName(category.getName());

		
		return response;
	}

	@Override
	public UpdateCategoryResponse update(UpdateCategoryRequest updateCategoryRequest) {
		UpdateCategoryResponse response = new UpdateCategoryResponse();
		Category category = categoryRepository.findById(updateCategoryRequest.getId()).orElse(null);
		category.setName(updateCategoryRequest.getName());
		
		categoryRepository.save(category);
		
		response.setId(category.getId());
		response.setName(category.getName());
		
		return response;
	}

	@Override
	public void delete(int id) {
		categoryRepository.deleteById(id);
	}

}
