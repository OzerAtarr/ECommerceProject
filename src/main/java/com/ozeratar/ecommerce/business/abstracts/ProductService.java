package com.ozeratar.ecommerce.business.abstracts;

import java.util.List;

import com.ozeratar.ecommerce.business.requests.create.CreateProductRequest;
import com.ozeratar.ecommerce.business.requests.update.UpdateProductRequest;
import com.ozeratar.ecommerce.business.responses.create.CreateProductResponse;
import com.ozeratar.ecommerce.business.responses.get.GetAllProductsResponse;
import com.ozeratar.ecommerce.business.responses.get.GetProductResponse;
import com.ozeratar.ecommerce.business.responses.update.UpdateProductResponse;

public interface ProductService {
	List<GetAllProductsResponse> getAll();
	GetProductResponse getById(int id);
	CreateProductResponse add(CreateProductRequest createProductRequest);
	UpdateProductResponse update(UpdateProductRequest updateProductRequest);
	void delete(int id);
}
