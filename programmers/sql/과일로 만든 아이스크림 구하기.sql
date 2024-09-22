SELECT I.FLAVOR
from ICECREAM_INFO I
    inner join FIRST_HALF F
        on I.FLAVOR = F.FLAVOR
where F.TOTAL_ORDER > 3000
  and I.INGREDIENT_TYPE = "fruit_based"
order by F.TOTAL_ORDER desc