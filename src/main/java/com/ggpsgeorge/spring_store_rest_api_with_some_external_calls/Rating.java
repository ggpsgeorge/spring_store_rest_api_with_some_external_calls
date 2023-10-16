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
public class Rating {
    private BigDecimal rate;
    private BigDecimal count;
}
