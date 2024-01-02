package com.dgmf.service;

import com.dgmf.dto.ProductDtoRequest;
import com.dgmf.dto.ProductDtoResponse;

import java.util.List;

public interface ProductService {
    ProductDtoResponse addProduct(ProductDtoRequest productDtoRequest);
    List<ProductDtoResponse> getAllProducts();
}
