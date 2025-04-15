package org.project.dto;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Builder
public class ProductFilter {
    String name;
    String description;
    BigDecimal price;
    String status;
}
