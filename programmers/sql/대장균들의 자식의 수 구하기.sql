select ID, IFNULL(CNT, 0) as CHILD_COUNT
from ECOLI_DATA e
    left join (
    select PARENT_ID, count(*) as CNT
    from ECOLI_DATA
    group by PARENT_ID
    ) as me
        on e.ID = me.PARENT_ID
order by e.ID