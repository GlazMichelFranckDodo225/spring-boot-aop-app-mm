package com.dgmf.service.impl;

import com.dgmf.dto.ProductDtoRequest;
import com.dgmf.dto.ProductDtoResponse;
import com.dgmf.entity.Product;
import com.dgmf.mapper.ProductMapper;
import com.dgmf.repository.ProductRepository;
import com.dgmf.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public List<ProductDtoResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDtoResponse> productDtoResponses = products.stream()
                .map(product -> productMapper.mapToProductDtoResponse(product))
                .collect(Collectors.toList());

        return productDtoResponses;
    }

    @Override
    public ProductDtoResponse addProduct(ProductDtoRequest productDtoRequest) {
        Product product = productMapper.mapToProduct(productDtoRequest);
        Product savedProduct = productRepository.save(product);
        ProductDtoResponse productDtoResponse =
                productMapper.mapToProductDtoResponse(savedProduct);

        return productDtoResponse;
    }
}
