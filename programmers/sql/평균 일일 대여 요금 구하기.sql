-- 코드를 입력하세요
SELECT ROUND(AVG(DAILY_FEE)) "AVERAGE_FEE"
    from CAR_RENTAL_COMPANY_CAR
    where CAR_TYPE = "SUV";