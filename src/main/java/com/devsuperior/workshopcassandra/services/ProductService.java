package com.devsuperior.workshopcassandra.services;

import com.devsuperior.workshopcassandra.model.dto.ProductDTO;
import com.devsuperior.workshopcassandra.model.entities.Product;
import com.devsuperior.workshopcassandra.repositories.ProductRepository;
import com.devsuperior.workshopcassandra.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductDTO findById(UUID id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Id não encontrado"));
        return new ProductDTO(product);
    }

    public List<ProductDTO> findByDepartment(String department) {
        List<Product> products;

        if ("".equals(department)) {
            products = productRepository.findAll();
        } else {
            products = productRepository.findByDepartment(department);
        }

        return products.stream().map(ProductDTO::new).toList();
    }
}
