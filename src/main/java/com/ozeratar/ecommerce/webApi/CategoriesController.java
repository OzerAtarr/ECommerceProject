package com.ozeratar.ecommerce.webApi;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ozeratar.ecommerce.business.abstracts.CategoryService;
import com.ozeratar.ecommerce.business.requests.create.CreateCategoryRequest;
import com.ozeratar.ecommerce.business.requests.update.UpdateCategoryRequest;
import com.ozeratar.ecommerce.business.responses.create.CreateCategoryResponse;
import com.ozeratar.ecommerce.business.responses.get.GetAllCategoriesResponse;
import com.ozeratar.ecommerce.business.responses.get.GetCategoryResponse;
import com.ozeratar.ecommerce.business.responses.update.UpdateCategoryResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoriesController {
	private CategoryService categoryService;
	
	@GetMapping
	public List<GetAllCategoriesResponse> getAll() {
		return categoryService.getAll();
	}
	
	@GetMapping("/{id}")
	public GetCategoryResponse getById(@PathVariable int id) {
		return categoryService.getById(id);
	}

	@PostMapping
	public CreateCategoryResponse add(@RequestBody CreateCategoryRequest createCategoryRequest) {
		return categoryService.add(createCategoryRequest);
	}

	@PutMapping
	public UpdateCategoryResponse update(@RequestBody UpdateCategoryRequest updateCategoryRequest) {
		return categoryService.update(updateCategoryRequest);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		categoryService.delete(id);
	}
}
