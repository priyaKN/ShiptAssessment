1.	List the stores allowed to sell alcohol?
Ans:
	SELECT name
FROM INTERVIEW.STORES
	WEHRE allowed_alcohol = true;
	
	
2.	Give the product name of the 2 most expensive items based on their price at store id 1?
Ans:
	SELECT A.name  AS Product_name
       From interview.products  as  A
	Inner join  interview.store_prices as  B  on A.product_id = B.product_id
	Where B.store_id = 1
	ORDER BY B.price DESC
LIMIT 2; 


3.	List the products that are not sold in the store id 2?
Ans: 
SELECT Product_id FROM interview.store_prices
WHERE store_id <> 2



4.	What is the most popular item sold?
Ans: 
	SELECT TOP 1 product_id 
FROM interview.order_lines
GROUP BY product_id
ORDER BY (COUNT(product_id)) DESC



5.	Write a SQL statement to update the line_total field?
Ans: 
	UPDATE interview.order_lines
	SET line_total = numeric value;
