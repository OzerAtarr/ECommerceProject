package com.ozeratar.ecommerce.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ozeratar.ecommerce.business.abstracts.ProductService;
import com.ozeratar.ecommerce.business.requests.create.CreateProductRequest;
import com.ozeratar.ecommerce.business.requests.update.UpdateProductRequest;
import com.ozeratar.ecommerce.business.responses.create.CreateProductResponse;
import com.ozeratar.ecommerce.business.responses.get.GetAllProductsResponse;
import com.ozeratar.ecommerce.business.responses.get.GetProductResponse;
import com.ozeratar.ecommerce.business.responses.update.UpdateProductResponse;
import com.ozeratar.ecommerce.dataAccess.ProductRepository;
import com.ozeratar.ecommerce.entities.Brand;
import com.ozeratar.ecommerce.entities.Category;
import com.ozeratar.ecommerce.entities.Product;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {
	private ProductRepository productRepository;
	
	@Override
	public List<GetAllProductsResponse> getAll() {
		List<GetAllProductsResponse> productsResponse = new ArrayList<GetAllProductsResponse>();
		List<Product> products = productRepository.findAll();
		
		for (Product product : products) {
			GetAllProductsResponse response = new GetAllProductsResponse();
			response.setId(product.getId());
			response.setName(product.getName());
			response.setPrice(product.getPrice());
			response.setStock(product.getStock());
			response.setCategoryId(product.getCategory().getId());
			response.setBrandId(product.getBrand().getId());
			
			productsResponse.add(response);
		}
		
		return productsResponse;
	}

	@Override
	public GetProductResponse getById(int id) {
		GetProductResponse response = new GetProductResponse();
		Product product = productRepository.findById(id).orElse(null);
		response.setId(product.getId());
		response.setName(product.getName());
		response.setPrice(product.getPrice());
		response.setStock(product.getStock());
		response.setBrandId(product.getBrand().getId());
		response.setCategoryId(product.getCategory().getId());
		
		return response;
	}

	@Override
	public CreateProductResponse add(CreateProductRequest createProductRequest) {
		CreateProductResponse response = new CreateProductResponse();
		Product product = new Product();
		product.setName(createProductRequest.getName());
		product.setPrice(createProductRequest.getPrice());
		product.setStock(createProductRequest.getStock());
		
		Category category = new Category();
		category.setId(createProductRequest.getCategoryId());
		product.setCategory(category);

		Brand brand = new Brand();
		brand.setId(createProductRequest.getBrandId());
		product.setBrand(brand);
		
		productRepository.save(product);
		
		response.setId(product.getId());
		response.setName(product.getName());
		response.setPrice(product.getPrice());
		response.setStock(product.getStock());
		response.setBrandId(product.getBrand().getId());
		response.setCategoryId(product.getCategory().getId());
		
		return response;
	}

	@Override
	public UpdateProductResponse update(UpdateProductRequest updateProductRequest) {
		UpdateProductResponse response = new UpdateProductResponse();
		Product product = productRepository.findById(updateProductRequest.getId()).orElse(null);
		product.setName(updateProductRequest.getName());
		product.setPrice(updateProductRequest.getPrice());
		product.setStock(updateProductRequest.getStock());
		
		Category category = new Category();
		category.setId(updateProductRequest.getCategoryId());
		product.setCategory(category);

		Brand brand = new Brand();
		brand.setId(updateProductRequest.getBrandId());
		product.setBrand(brand);
		
		productRepository.save(product);
		
		response.setId(product.getId());
		response.setName(product.getName());
		response.setPrice(product.getPrice());
		response.setStock(product.getStock());
		response.setBrandId(product.getBrand().getId());
		response.setCategoryId(product.getCategory().getId());
		
		return response;
	}

	@Override
	public void delete(int id) {
		productRepository.deleteById(id);
	}

}
