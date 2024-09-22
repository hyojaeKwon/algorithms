SELECT R.REST_ID, I.REST_NAME, I.FOOD_TYPE, I.FAVORITES, I.ADDRESS,	ROUND(AVG(R.REVIEW_SCORE),2) AS "SCORE"
from REST_INFO I
         inner join REST_REVIEW R
                    on I.REST_ID = R.REST_ID
group by REST_ID
having I.ADDRESS like '서울%'
ORDER BY 6 DESC, 4 DESC;