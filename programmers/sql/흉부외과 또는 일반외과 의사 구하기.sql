SELECT DR_NAME,DR_ID,MCDP_CD,date_format(HIRE_YMD,"%Y-%m-%d") AS HIRE_YMD
from DOCTOR
where MCDP_CD IN('CS','GS')
order by HIRE_YMD desc, DR_NAME;