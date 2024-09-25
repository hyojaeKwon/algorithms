select year(DIFFERENTIATION_DATE) as YEAR , b.MAX_SIZE - a.SIZE_OF_COLONY as YEAR_DEV, a.ID
from ECOLI_DATA a
    left join (
    select year(DIFFERENTIATION_DATE) as "YEAR", MAX(SIZE_OF_COLONY) as MAX_SIZE
    from ECOLI_DATA
    group by year(DIFFERENTIATION_DATE)
    ) b
on year(a.DIFFERENTIATION_DATE) = b.YEAR
order by 1, 2
