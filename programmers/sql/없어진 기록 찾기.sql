SELECT o.ANIMAL_ID, o.NAME
from ANIMAL_OUTS as o
         left outer join ANIMAL_INS as i
                         on o.ANIMAL_ID = i.ANIMAL_ID
where o.ANIMAL_ID not in (
    select o.ANIMAL_ID
    from ANIMAL_OUTS as o
             join ANIMAL_INS as i
                  on o.ANIMAL_ID = i.ANIMAL_ID
)
order by 1, 2