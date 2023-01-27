package com.ozeratar.ecommerce.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ozeratar.ecommerce.business.abstracts.BrandService;
import com.ozeratar.ecommerce.business.requests.create.CreateBrandRequest;
import com.ozeratar.ecommerce.business.requests.update.UpdateBrandRequest;
import com.ozeratar.ecommerce.business.responses.create.CreateBrandResponse;
import com.ozeratar.ecommerce.business.responses.get.GetAllBrandsResponse;
import com.ozeratar.ecommerce.business.responses.get.GetBrandResponse;
import com.ozeratar.ecommerce.business.responses.update.UpdateBrandResponse;
import com.ozeratar.ecommerce.core.untilities.mapping.ModelMapperService;
import com.ozeratar.ecommerce.dataAccess.BrandRepository;
import com.ozeratar.ecommerce.entities.Brand;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
	private BrandRepository brandRepository;
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllBrandsResponse> getAll() {
		List<Brand> brands = brandRepository.findAll();
		List<GetAllBrandsResponse> brandsResponse = brands.stream()
				.map(brand -> this.modelMapperService.forResponse().map(brand, GetAllBrandsResponse.class))
				.collect(Collectors.toList());
		return brandsResponse;
	}

	@Override
	public GetBrandResponse getById(int id) {
		Brand brand = brandRepository.findById(id).orElse(null);
		GetBrandResponse response = modelMapperService.forResponse().map(brand, GetBrandResponse.class);

		return response;
	}

	@Override
	public CreateBrandResponse add(CreateBrandRequest createBrandRequest) {
		Brand brand = modelMapperService.forRequest().map(createBrandRequest, Brand.class);
		Brand addedBrand = brandRepository.save(brand);
		CreateBrandResponse response = modelMapperService.forResponse().map(addedBrand, CreateBrandResponse.class);
		
		
		return response;
	}

	@Override
	public UpdateBrandResponse update(UpdateBrandRequest updateBrandRequest) {
		Brand brand = modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
		Brand updatedBrand = brandRepository.save(brand);
		UpdateBrandResponse response = modelMapperService.forResponse().map(updatedBrand, UpdateBrandResponse.class);

		return response;
	}

	@Override
	public void delete(int id) {
		brandRepository.deleteById(id);
	}

}
