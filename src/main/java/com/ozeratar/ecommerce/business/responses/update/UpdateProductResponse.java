package com.ozeratar.ecommerce.business.responses.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductResponse {
	private int id;
	private String name;
	private int brandId;
	private int categoryId;
	private double price;
	private int stock;
}
