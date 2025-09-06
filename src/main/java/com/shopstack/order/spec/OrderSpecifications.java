package com.shopstack.order.spec;

import com.shopstack.order.domain.Order;
import org.springframework.data.jpa.domain.Specification;
import java.time.OffsetDateTime;

public final class OrderSpecifications {
  private OrderSpecifications() {}

  public static Specification<Order> hasStatus(String status) {
    return (root, query, cb) -> (status == null || status.isBlank())
        ? null
        : cb.equal(root.get("status"), status);
  }

  public static Specification<Order> createdFrom(OffsetDateTime from) {
    return (root, query, cb) -> (from == null)
        ? null
        : cb.greaterThanOrEqualTo(root.get("createdAt"), from);
  }

  public static Specification<Order> createdToExclusive(OffsetDateTime toExclusive) {
    return (root, query, cb) -> (toExclusive == null)
        ? null
        : cb.lessThan(root.get("createdAt"), toExclusive);
  }
}
