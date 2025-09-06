package com.shopstack.order.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Table(name = "orders")
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String customerEmail;

  @Column(nullable = false)
  private String status; // NEW, SHIPPED, CANCELLED

  @Column(nullable = false)
  private BigDecimal totalAmount;

  @Column(nullable = false)
  private OffsetDateTime createdAt = OffsetDateTime.now();

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }

  public String getCustomerEmail() { return customerEmail; }
  public void setCustomerEmail(String customerEmail) { this.customerEmail = customerEmail; }

  public String getStatus() { return status; }
  public void setStatus(String status) { this.status = status; }

  public BigDecimal getTotalAmount() { return totalAmount; }
  public void setTotalAmount(BigDecimal totalAmount) { this.totalAmount = totalAmount; }

  public OffsetDateTime getCreatedAt() { return createdAt; }
  public void setCreatedAt(OffsetDateTime createdAt) { this.createdAt = createdAt; }
}
