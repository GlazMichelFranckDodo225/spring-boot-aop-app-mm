package com.dgmf.mapper;

import com.dgmf.dto.ProductDtoRequest;
import com.dgmf.dto.ProductDtoResponse;
import com.dgmf.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductDtoResponse mapToProductDtoResponse(Product product) {
        ProductDtoResponse productDtoResponse = ProductDtoResponse.builder()
                .productId(product.getProductId())
                .productName(product.getProductName())
                .productPrice(product.getProductPrice())
                .build();

        return productDtoResponse;
    }

    public Product mapToProduct(ProductDtoRequest productDtoRequest) {
        Product product = Product.builder()
                .productName(productDtoRequest.getProductName())
                .productPrice(productDtoRequest.getProductPrice())
                .build();

        return product;
    }

}
