select max(BOARD_NUM) from board;
INSERT INTO web_gradle_erp.board
(BOARD_NUM, BOARD_NAME, BOARD_PASS, BOARD_SUBJECT, BOARD_CONTENT, BOARD_FILE, BOARD_RE_REF, BOARD_RE_LEV, BOARD_RE_SEQ, BOARD_READCOUNT, BOARD_DATE)
VALUES(1, '김상건', '1111', '마칠 시간', '5시', 'test.txt', 0, 0, 0, 0, '2021-03-03');

select * from board;

select BOARD_NUM,BOARD_NAME,BOARD_PASS,BOARD_SUBJECT,BOARD_CONTENT,
BOARD_FILE,BOARD_RE_REF,BOARD_RE_LEV,BOARD_RE_SEQ,BOARD_READCOUNT,BOARD_DATE 
from board 
order by BOARD_RE_REF desc, BOARD_RE_SEQ asc
limit 0, 10;

select BOARD_NUM,BOARD_NAME,BOARD_PASS,BOARD_SUBJECT,BOARD_CONTENT,
BOARD_FILE,BOARD_RE_REF,BOARD_RE_LEV,BOARD_RE_SEQ,BOARD_READCOUNT,BOARD_DATE from board 
order by BOARD_RE_REF desc, BOARD_RE_SEQ asc
limit 10, 10;

/*-listcount-*/
select count(*) from board;

select * from board;


/*read board*/
select BOARD_NUM,BOARD_NAME,BOARD_PASS,BOARD_SUBJECT,BOARD_CONTENT,BOARD_FILE,BOARD_RE_REF,BOARD_RE_LEV,BOARD_RE_SEQ,BOARD_READCOUNT,BOARD_DATE from board where BOARD_NUM = 1;

update board set BOARD_READCOUNT = BOARD_READCOUNT + 1 where BOARD_NUM = 23;

/*글 삭제*/
select * from board where BOARD_RE_REF =20;

delete 
from board where BOARD_NUM = 26;

select 1 from board where BOARD_NUM = 49 and BOARD_PASS = 'cc';
/*글 수정*/
select BOARD_NUM,BOARD_NAME,BOARD_PASS,BOARD_SUBJECT,BOARD_CONTENT,
BOARD_FILE,BOARD_RE_REF,BOARD_RE_LEV,BOARD_RE_SEQ,BOARD_READCOUNT,BOARD_DATE 
from board 
order by BOARD_RE_REF desc, BOARD_RE_SEQ;

update board 
	set BOARD_SUBJECT = 'aaa', BOARD_CONTENT = 'aaa'
	where BOARD_NUM = 49;
	
update board set BOARD_RE_SEQ = BOARD_RE_SEQ +1 where BOARD_RE_REF = ? and BOARD_RE_SEQ = ?


select * from board where BOARD_RE_REF = 20;