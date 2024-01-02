package com.dgmf.controller;

import com.dgmf.dto.ProductDtoRequest;
import com.dgmf.dto.ProductDtoResponse;
import com.dgmf.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDtoResponse> addProduct(
            @RequestBody ProductDtoRequest productDtoRequest
    ) {
        return new ResponseEntity<>(
                productService.addProduct(productDtoRequest),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<ProductDtoResponse>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }
}
