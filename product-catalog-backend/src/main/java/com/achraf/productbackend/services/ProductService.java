package com.achraf.productbackend.services;

import com.achraf.productbackend.dtos.ProductRequestDTO;
import com.achraf.productbackend.dtos.ProductResponseDTO;

import java.util.List;

public interface ProductService {
    List<ProductResponseDTO> getAllProducts();
    ProductResponseDTO getProductById(Long id);
    ProductResponseDTO saveProduct(ProductRequestDTO requestDTO);
    ProductResponseDTO updateProduct(Long id, ProductRequestDTO requestDTO);
    ProductResponseDTO toggleSelectProduct(Long id);
    void deleteProduct(Long id);
    List<ProductResponseDTO> searchProducts(String keyword);
}
