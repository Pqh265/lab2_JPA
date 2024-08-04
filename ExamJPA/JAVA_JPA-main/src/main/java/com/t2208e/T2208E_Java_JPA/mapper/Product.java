package com.t2208e.T2208E_Java_JPA.mapper;

import com.t2208e.T2208E_Java_JPA.dto.ProductDTO;
import com.t2208e.T2208E_Java_JPA.entity.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO toDTO(Product product);
    Product toEntity(ProductDTO productDTO);
}
