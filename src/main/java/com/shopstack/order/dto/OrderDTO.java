package com.shopstack.order.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record OrderDTO(
    Long id,
    String customerEmail,
    String status,
    BigDecimal totalAmount,
    OffsetDateTime createdAt
) {}
