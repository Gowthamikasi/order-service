package com.shopstack.order;

import com.shopstack.order.service.OrderService;
import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class OrderServiceApplicationTests {
   @MockBean
  private OrderService service;
   @Test
  void contextLoads() {
    // Simple smoke test to ensure Spring context starts
  }
}
