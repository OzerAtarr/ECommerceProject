package com.ozeratar.ecommerce.business.requests.create;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequest {
	@Size(min = 2,max = 50)
	@NotNull
	@NotBlank
	private String name;
	@NotEmpty
	private int brandId;
	@Min(1)
	private int categoryId;
	private double price;
	private int stock;
}
