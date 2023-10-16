package com.ggpsgeorge.spring_store_rest_api_with_some_external_calls;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    
    private Long id;

    private String title;
    private BigDecimal price;
    private String description;
    private String category;
    private String image;
    private Rating rating;
    
}
