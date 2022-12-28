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

import com.ozeratar.ecommerce.business.abstracts.BrandService;
import com.ozeratar.ecommerce.business.requests.create.CreateBrandRequest;
import com.ozeratar.ecommerce.business.requests.update.UpdateBrandRequest;
import com.ozeratar.ecommerce.business.responses.create.CreateBrandResponse;
import com.ozeratar.ecommerce.business.responses.get.GetAllBrandsResponse;
import com.ozeratar.ecommerce.business.responses.get.GetBrandResponse;
import com.ozeratar.ecommerce.business.responses.update.UpdateBrandResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {
	private BrandService brandService;
	
	@GetMapping
	public List<GetAllBrandsResponse> getAll() {
		return brandService.getAll();
	}
	
	@GetMapping("/{id}")
	public GetBrandResponse getById(@PathVariable int id) {
		return brandService.getById(id);
	}

	@PostMapping
	public CreateBrandResponse add(@RequestBody CreateBrandRequest createBrandRequest) {
		return brandService.add(createBrandRequest);
	}

	@PutMapping
	public UpdateBrandResponse update(@RequestBody UpdateBrandRequest updateBrandRequest) {
		return brandService.update(updateBrandRequest);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		brandService.delete(id);
	}
}
