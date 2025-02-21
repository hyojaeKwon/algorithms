-- 코드를 작성해주세요
select id as ID, EMAIL, FIRST_NAME, LAST_NAME
from developers
where SKILL_CODE & (select CODE from skillcodes where name = "C#")
   or SKILL_CODE & (select CODE from skillcodes where name = "Python")
order by 1