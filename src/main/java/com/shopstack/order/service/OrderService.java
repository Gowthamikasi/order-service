package com.shopstack.order.service;

import com.shopstack.order.domain.Order;
import com.shopstack.order.dto.OrderDTO;
import com.shopstack.order.repo.OrderRepository;
import com.shopstack.order.spec.OrderSpecifications;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Service
public class OrderService {

  private final OrderRepository repo;

  public OrderService(OrderRepository repo) {
    this.repo = repo;
  }

  public Page<OrderDTO> search(String status, LocalDate fromDate, LocalDate toDate, Pageable pageable) {
    OffsetDateTime from = (fromDate == null) ? null : fromDate.atStartOfDay().atOffset(ZoneOffset.UTC);
    OffsetDateTime toExclusive = (toDate == null) ? null : toDate.plusDays(1).atStartOfDay().atOffset(ZoneOffset.UTC);

    Specification<Order> spec = Specification.where(OrderSpecifications.hasStatus(status))
        .and(OrderSpecifications.createdFrom(from))
        .and(OrderSpecifications.createdToExclusive(toExclusive));

    return repo.findAll(spec, pageable).map(this::toDto);
  }

  private OrderDTO toDto(Order o) {
    return new OrderDTO(o.getId(), o.getCustomerEmail(), o.getStatus(), o.getTotalAmount(), o.getCreatedAt());
  }
}
