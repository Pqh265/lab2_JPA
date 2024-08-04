package com.t2208e.T2208E_Java_JPA.controller;

import com.t2208e.T2208E_Java_JPA.dto.ProductDTO;
import com.t2208e.T2208E_Java_JPA.entity.Manufacturer;
import com.t2208e.T2208E_Java_JPA.entity.Product;
import com.t2208e.T2208E_Java_JPA.mapper.ProductMapper;
import com.t2208e.T2208E_Java_JPA.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapper productMapper;

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts().stream()
                .map(productMapper::toDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
        Product product = productMapper.toEntity(productDTO);
        return productMapper.toDTO(productService.saveProduct(product));
    }

    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) throws Exception {
        Product existingProduct = productService.getProductById(id)
                .orElseThrow(() -> new Exception("Product not found"));

        existingProduct.setName(productDTO.getName());
        existingProduct.setType(productDTO.getType());
        existingProduct.setDescription(productDTO.getDescription());
        existingProduct.setImage(productDTO.getImage());
        existingProduct.setPrice(productDTO.getPrice());
        existingProduct.setDiscount(productDTO.getDiscount());

        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setId(productDTO.getManufacturerId());
        existingProduct.setManufacturer(manufacturer);

        return productMapper.toDTO(productService.saveProduct(existingProduct));
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
