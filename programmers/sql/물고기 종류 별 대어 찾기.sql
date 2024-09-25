select f.ID, n.FISH_NAME, f.LENGTH
from FISH_INFO f
         inner join FISH_NAME_INFO n
                    on f.FISH_TYPE = n.FISH_TYPE
where f.LENGTH in (
    select MAX(LENGTH)
    from FISH_INFO
    where FISH_TYPE = n.FISH_TYPE
    group by FISH_TYPE
)
order by 1