package com.achraf.productbackend.mappers;

import com.achraf.productbackend.dtos.ProductRequestDTO;
import com.achraf.productbackend.dtos.ProductResponseDTO;
import com.achraf.productbackend.entities.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductResponseDTO fromProduct(Product product) {
        if (product == null) return null;
        ProductResponseDTO dto = new ProductResponseDTO();
        BeanUtils.copyProperties(product, dto);
        return dto;
    }

    public Product fromProductRequestDTO(ProductRequestDTO requestDTO) {
        if (requestDTO == null) return null;
        Product product = new Product();
        BeanUtils.copyProperties(requestDTO, product);
        return product;
    }
}