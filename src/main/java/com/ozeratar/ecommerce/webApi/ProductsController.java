package com.ozeratar.ecommerce.webApi;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ozeratar.ecommerce.business.abstracts.ProductService;
import com.ozeratar.ecommerce.business.requests.create.CreateProductRequest;
import com.ozeratar.ecommerce.business.requests.update.UpdateProductRequest;
import com.ozeratar.ecommerce.business.responses.create.CreateProductResponse;
import com.ozeratar.ecommerce.business.responses.get.GetAllProductsResponse;
import com.ozeratar.ecommerce.business.responses.get.GetProductResponse;
import com.ozeratar.ecommerce.business.responses.update.UpdateProductResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductsController {
	private ProductService productService;

	@GetMapping
	public List<GetAllProductsResponse> getAll() {
		return productService.getAll();
	}
	
	@GetMapping("/{id}")
	public GetProductResponse getById(@PathVariable int id) {
		return productService.getById(id);
	}

	@PostMapping
	public CreateProductResponse add(@Valid @RequestBody CreateProductRequest createProductRequest) {
		return productService.add(createProductRequest);
	}

	@PutMapping
	public UpdateProductResponse update(@Valid @RequestBody UpdateProductRequest updateProductRequest) {
		return productService.update(updateProductRequest);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		productService.delete(id);
	}

}
