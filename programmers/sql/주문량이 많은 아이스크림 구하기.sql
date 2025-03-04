-- 코드를 입력하세요
SELECT f.FLAVOR
from first_half as f
         right outer join (select shipment_id, flavor, sum(total_order) as to_sum from july group by flavor) as j
                          on f.shipment_id = j.shipment_id
group by f.flavor
order by SUM(f.total_order + j.to_sum) desc
limit 3
