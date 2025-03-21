package org.project.dto;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Builder
public class FindProductFilter {
    String name;
    String description;
    String category;
    BigDecimal price;
    String status;
}
