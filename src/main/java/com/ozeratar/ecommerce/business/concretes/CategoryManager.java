package com.ozeratar.ecommerce.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ozeratar.ecommerce.business.abstracts.CategoryService;
import com.ozeratar.ecommerce.business.requests.create.CreateCategoryRequest;
import com.ozeratar.ecommerce.business.requests.update.UpdateCategoryRequest;
import com.ozeratar.ecommerce.business.responses.create.CreateCategoryResponse;
import com.ozeratar.ecommerce.business.responses.get.GetAllCategoriesResponse;
import com.ozeratar.ecommerce.business.responses.get.GetCategoryResponse;
import com.ozeratar.ecommerce.business.responses.update.UpdateCategoryResponse;
import com.ozeratar.ecommerce.core.untilities.mapping.ModelMapperService;
import com.ozeratar.ecommerce.dataAccess.CategoryRepository;
import com.ozeratar.ecommerce.entities.Category;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {
	private CategoryRepository categoryRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GetAllCategoriesResponse> getAll() {
		List<Category> categories = categoryRepository.findAll();
		List<GetAllCategoriesResponse> categoriesResponse = categories.stream()
				.map(category-> this.modelMapperService.forResponse()
						.map(category, GetAllCategoriesResponse.class)).collect(Collectors.toList());
	
		return categoriesResponse;
	}

	@Override
	public GetCategoryResponse getById(int id) {
		Category category = categoryRepository.findById(id).orElse(null);
		GetCategoryResponse response = modelMapperService.forResponse().map(category, GetCategoryResponse.class);
		
		return response;
	}

	@Override
	public CreateCategoryResponse add(CreateCategoryRequest createCategoryRequest) {
		Category category = modelMapperService.forRequest().map(createCategoryRequest, Category.class);
		Category addedCategory = categoryRepository.save(category);
		CreateCategoryResponse response = modelMapperService.forResponse().map(addedCategory, CreateCategoryResponse.class);
		
		return response;
	}

	@Override
	public UpdateCategoryResponse update(UpdateCategoryRequest updateCategoryRequest) {
		Category category = modelMapperService.forRequest().map(updateCategoryRequest, Category.class);
		Category updatedCategory = categoryRepository.save(category);
		UpdateCategoryResponse response = modelMapperService.forResponse().map(updatedCategory, UpdateCategoryResponse.class);
		
		return response;
	}

	@Override
	public void delete(int id) {
		categoryRepository.deleteById(id);
	}

}
