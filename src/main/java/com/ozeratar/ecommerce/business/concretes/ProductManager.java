package com.ozeratar.ecommerce.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ozeratar.ecommerce.business.abstracts.ProductService;
import com.ozeratar.ecommerce.business.requests.create.CreateProductRequest;
import com.ozeratar.ecommerce.business.requests.update.UpdateProductRequest;
import com.ozeratar.ecommerce.business.responses.create.CreateProductResponse;
import com.ozeratar.ecommerce.business.responses.get.GetAllProductsResponse;
import com.ozeratar.ecommerce.business.responses.get.GetProductResponse;
import com.ozeratar.ecommerce.business.responses.update.UpdateProductResponse;
import com.ozeratar.ecommerce.core.untilities.mapping.ModelMapperService;
import com.ozeratar.ecommerce.dataAccess.ProductRepository;
import com.ozeratar.ecommerce.entities.Brand;
import com.ozeratar.ecommerce.entities.Category;
import com.ozeratar.ecommerce.entities.Product;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {
	private ProductRepository productRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GetAllProductsResponse> getAll() {
		List<Product> products = productRepository.findAll();
		List<GetAllProductsResponse> productsResponse = products.stream()
				.map(product -> this.modelMapperService.forResponse().map(product, GetAllProductsResponse.class)).collect(Collectors.toList());
		
		return productsResponse;
	}

	@Override
	public GetProductResponse getById(int id) {
		Product product = productRepository.findById(id).orElse(null);
		GetProductResponse response = modelMapperService.forResponse().map(product, GetProductResponse.class);
		
		return response;
	}

	@Override
	public CreateProductResponse add(CreateProductRequest createProductRequest) {
		Product product = modelMapperService.forRequest().map(createProductRequest, Product.class);
		Product addedProduct = productRepository.save(product);
		CreateProductResponse response = modelMapperService.forResponse().map(addedProduct, CreateProductResponse.class);
		
		return response;
	}

	@Override
	public UpdateProductResponse update(UpdateProductRequest updateProductRequest) {
		Product product = modelMapperService.forRequest().map(updateProductRequest, Product.class);
		Product updatedProduct = productRepository.save(product);
		UpdateProductResponse response = modelMapperService.forResponse().map(updatedProduct, UpdateProductResponse.class);
		
		return response;
	}

	@Override
	public void delete(int id) {
		productRepository.deleteById(id);
	}

}
