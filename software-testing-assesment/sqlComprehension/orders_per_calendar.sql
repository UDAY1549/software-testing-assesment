SELECT EXTRACT(year from order_date),COUNT(order_id) AS num_orders
FROM orders
GROUP BY EXTRACT(year from order_date);