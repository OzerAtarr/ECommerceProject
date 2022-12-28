package com.ozeratar.ecommerce.business.abstracts;

import java.util.List;

import com.ozeratar.ecommerce.business.requests.create.CreateBrandRequest;
import com.ozeratar.ecommerce.business.requests.update.UpdateBrandRequest;
import com.ozeratar.ecommerce.business.responses.create.CreateBrandResponse;
import com.ozeratar.ecommerce.business.responses.get.GetAllBrandsResponse;
import com.ozeratar.ecommerce.business.responses.get.GetBrandResponse;
import com.ozeratar.ecommerce.business.responses.update.UpdateBrandResponse;

public interface BrandService {
	List<GetAllBrandsResponse> getAll();
	GetBrandResponse getById(int id);
	CreateBrandResponse add(CreateBrandRequest createBrandRequest);
	UpdateBrandResponse update(UpdateBrandRequest updateBrandRequest);
	void delete(int id);
}
