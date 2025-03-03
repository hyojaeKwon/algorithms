SELECT p.MEMBER_NAME, r.REVIEW_TEXT, DATE_FORMAT(r.REVIEW_DATE, "%Y-%m-%d") as REVIEW_DATE
from MEMBER_PROFILE as p
         join rest_review as r
              on p.member_id = r.member_id
where (p.member_id, 1) in (select member_id, rank() over (order by count(*) desc) as rnk
                           from REST_REVIEW
                           group by member_id)
order by 3, 2