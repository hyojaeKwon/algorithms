-- 코드를 입력하세요
SELECT NAME, DATETIME
from ANIMAL_INS
where ANIMAL_ID not in (
    select i.ANIMAL_ID
    from animal_ins as i
        join animal_outs as o
            on i.animal_id = o.animal_id
)
order by DATETIME
limit 3

