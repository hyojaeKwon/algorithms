SELECT rh.CAR_ID as CAR_ID, c.CAR_TYPE as CAR_TYPE, ROUND(c.DAILY_FEE * 30 * ((100 - p.DISCOUNT_RATE) / 100)) as FEE
from CAR_RENTAL_COMPANY_RENTAL_HISTORY as rh
         left join CAR_RENTAL_COMPANY_CAR as c on rh.CAR_ID = c.CAR_ID
         left join CAR_RENTAL_COMPANY_DISCOUNT_PLAN as p on c.CAR_TYPE = p.CAR_TYPE and p.DURATION_TYPE like "30%"

where c.CAR_TYPE in ('세단', 'SUV')
  and rh.CAR_ID not in (select CAR_ID
                        from CAR_RENTAL_COMPANY_RENTAL_HISTORY
                        where START_DATE <= '2022-12-01' and END_DATE >= '2022-11-01')
group by rh.CAR_ID
having FEE > 500000
   and FEE < 2000000

order by 3 desc, 2, 1 desc
