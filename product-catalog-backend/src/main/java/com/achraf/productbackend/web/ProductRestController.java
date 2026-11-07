package com.achraf.productbackend.web;

import com.achraf.productbackend.dtos.ProductRequestDTO;
import com.achraf.productbackend.dtos.ProductResponseDTO;
import com.achraf.productbackend.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductRestController {

    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductResponseDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductResponseDTO getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> saveProduct(@RequestBody ProductRequestDTO requestDTO) {
        ProductResponseDTO savedProduct = productService.saveProduct(requestDTO);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ProductResponseDTO updateProduct(@PathVariable Long id, @RequestBody ProductRequestDTO requestDTO) {
        return productService.updateProduct(id, requestDTO);
    }

    @PatchMapping("/{id}")
    public ProductResponseDTO toggleSelectProduct(@PathVariable Long id) {
        return productService.toggleSelectProduct(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public List<ProductResponseDTO> searchProducts(@RequestParam String kw) {
        return productService.searchProducts(kw);
    }
}