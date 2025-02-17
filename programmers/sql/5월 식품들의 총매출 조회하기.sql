-- 코드를 입력하세요
SELECT o.product_id as PRODUCT_ID,
       p.product_name as PRODUCT_NAME,
       sum(o.AMOUNT * p.PRICE) as TOTAL_SALES
from food_order as o
    join food_product as p
        on o.PRODUCT_ID = p.PRODUCT_ID
where year(o.PRODUCE_DATE) = 2022 and month(o.PRODUCE_DATE) = 5
group by o.PRODUCT_ID
order by 3 desc, 1
