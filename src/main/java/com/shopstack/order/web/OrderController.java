package com.shopstack.order.web;

import com.shopstack.order.dto.OrderDTO;
import com.shopstack.order.service.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

  private final OrderService service;

  public OrderController(OrderService service) {
    this.service = service;
  }

  @GetMapping
  public Page<OrderDTO> find(
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "20") int size,
      @RequestParam(required = false) String status,
      @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate,
      @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toDate,
      @RequestParam(defaultValue = "createdAt,desc") String sort
  ) {
    String[] s = sort.split(",");
    String sortField = s[0];
    Sort.Direction dir = (s.length > 1 ? Sort.Direction.fromString(s[1]) : Sort.Direction.DESC);

    int cappedSize = Math.min(Math.max(size, 1), 100);
    Pageable pageable = PageRequest.of(Math.max(page, 0), cappedSize, Sort.by(dir, sortField));

    return service.search(status, fromDate, toDate, pageable);
  }
}
