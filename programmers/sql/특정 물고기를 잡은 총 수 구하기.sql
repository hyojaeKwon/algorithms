select Count(*) as FISH_COUNT
from FISH_INFO i
    inner join FISH_NAME_INFO n
        on i.FISH_TYPE = n.FISH_TYPE
where n.FISH_NAME = "BASS" or n.FISH_NAME = "SNAPPER"