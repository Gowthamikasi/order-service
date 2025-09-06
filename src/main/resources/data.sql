INSERT INTO orders (id, customer_email, status, total_amount, created_at) VALUES
 (1, 'alice@example.com', 'NEW',        49.99, DATEADD('DAY', -10, CURRENT_TIMESTAMP)),
 (2, 'bob@example.com',   'SHIPPED',   129.00, DATEADD('DAY', -5,  CURRENT_TIMESTAMP)),
 (3, 'carl@example.com',  'CANCELLED',  20.00, DATEADD('DAY', -2,  CURRENT_TIMESTAMP)),
 (4, 'dora@example.com',  'SHIPPED',    75.50, DATEADD('DAY', -1,  CURRENT_TIMESTAMP));
