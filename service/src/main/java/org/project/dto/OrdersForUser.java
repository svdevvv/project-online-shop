package org.project.dto;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Builder
public class OrdersForUser {
    Integer userId;
    Integer orderId;
    BigDecimal price;
    String status;

}
