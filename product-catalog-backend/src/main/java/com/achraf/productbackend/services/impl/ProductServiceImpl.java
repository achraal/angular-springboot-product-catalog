package com.achraf.productbackend.services.impl;

import com.achraf.productbackend.dtos.ProductRequestDTO;
import com.achraf.productbackend.dtos.ProductResponseDTO;
import com.achraf.productbackend.entities.Product;
import com.achraf.productbackend.mappers.ProductMapper;
import com.achraf.productbackend.repositories.ProductRepository;
import com.achraf.productbackend.services.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(productMapper::fromProduct)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponseDTO getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produit non trouvé : " + id));
        return productMapper.fromProduct(product);
    }

    @Override
    public ProductResponseDTO saveProduct(ProductRequestDTO requestDTO) {
        Product product = productMapper.fromProductRequestDTO(requestDTO);
        Product savedProduct = productRepository.save(product);
        return productMapper.fromProduct(savedProduct);
    }

    @Override
    public ProductResponseDTO updateProduct(Long id, ProductRequestDTO requestDTO) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produit non trouvé : " + id));
        product.setName(requestDTO.getName());
        product.setPrice(requestDTO.getPrice());
        product.setSelected(requestDTO.isSelected());
        Product updatedProduct = productRepository.save(product);
        return productMapper.fromProduct(updatedProduct);
    }

    @Override
    public ProductResponseDTO toggleSelectProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produit non trouvé : " + id));
        product.setSelected(!product.isSelected());
        Product updatedProduct = productRepository.save(product);
        return productMapper.fromProduct(updatedProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductResponseDTO> searchProducts(String keyword) {
        return productRepository.findByNameContainingIgnoreCase(keyword).stream()
                .map(productMapper::fromProduct)
                .collect(Collectors.toList());
    }
}