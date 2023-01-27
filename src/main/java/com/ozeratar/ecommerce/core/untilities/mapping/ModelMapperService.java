package com.ozeratar.ecommerce.core.untilities.mapping;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
	ModelMapper forResponse();
	ModelMapper forRequest();
}
