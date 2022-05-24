CREATE TABLE T_LETITBE
(
    SEQ_VC      VARCHAR2(2),
    WORDS_VC    VARCHAR2(100)
);

INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (1,'Let it be');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (2,'내버려 두어라');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (3,'When I find myself in times of trouble');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (4,'내가 괴로움의 시간에서 방황할 때면 ');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (5,'Mother Mary comes to me Speaking words of wisdom,');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (6,'어머니는 내게 다가와 현명한 말씀을 해주신다. ');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (7,'Let it be ');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (8,'내버려 두어라.');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (9,'And in my hour of darkness ');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (10,'그리고 내가 어둠속에 헤매일 때, ');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (11,'She is standing right in front of me Speaking words of wisdom,');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (12,'그녀는 내 바로 앞에서, 현명한 말씀을 해주신다. ');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (13,'Let it be. ');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (14,'내버려 두어라.');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (15,'And when the broken hearted people Living in the world agree, There will be an answer, ');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (16,'이 세상의 상처받은 사람들은 이 말씀이 방법이 될 거라 믿는다. ');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (17,'Let it be ');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (18,'내버려 두어라.');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (19,'For though they may be parted ');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (20,'그들이 헤어지더라도 여전히 그들이 만날 기회는 있을것이다. ');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (21,'There is still a chance that they will see, There will be an answer,');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (22,'방법은 있을 것이다.');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (23,'let it be ');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (24,'내버려 두어라.');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (25,'And the night is cloudy, there is still a light that shines on me.');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (26,'구름이 낀 밤에도, 아직 날 비추어주는 빛이 있어. ');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (27,'Shine until tomorrow, let it be.');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (28,'희망은 계속될 것이다.내버려 두어라. ');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (29,'I wake up to the sound of music,');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (30,'음악 소리에 난 깨어나고, ');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (31,'Mother Mary comes to me,Speaking words of whisdom,');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (32,'어머니 메어리는 내게 다가와,현명한 말씀을 해 주신다. ');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (33,'Let it be.');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (34,'내버려 두어라.');
COMMIT;

--//////////// 풀이 시작 

-- -- -- --  # 1 인라인뷰와 ROWNUM, alias별칭으로 풀이해보기 

-- 1) 영어 가사만 나오게 하기 
                                --> ROWNUM 를 조회하는 인라인뷰를 생성 
                                --> MOD()로 인라인뷰의 ROWNUM을 나누었을 때 나머지가 0이 아니면 영어 가사 row 조회
SELECT SEQ_VC, WORDS_VC "영어가사" FROM (SELECT ROWNUM NUM,T_LETITBE.* FROM T_LETITBE)
WHERE (MOD(NUM, 2))!= 0;

-- 2) 한글 가사만 나오게 하기 
                                --> ROWNUM 를 조회하는 인라인뷰를 생성 
                                --> MOD()로 인라인뷰의 ROWNUM을 나누었을 때 나머지가 0이면 한글 가사 row 조회
SELECT SEQ_VC, WORDS_VC "한글가사" FROM (SELECT ROWNUM NUM,T_LETITBE.* FROM T_LETITBE)
WHERE (MOD(NUM, 2)) = 0;

-- 3) 영어 가사와 한글가사가 번갈아 나오게 하기 
                                --> UNION ALL 로 앞선 두 쿼리의 결과의 합집합을 생성한 뒤 A라는 별칭 붙인다.
                                --> A의 SEQ_VC 컬럼을 숫자 타입으로 형변환 한 후 오름차 순으로 정렬한다.
                                --> 조회한다. 
SELECT *
FROM 
    (
     SELECT SEQ_VC, WORDS_VC "가사" FROM (SELECT ROWNUM NUM,T_LETITBE.* FROM T_LETITBE)
     WHERE (MOD(NUM, 2))!= 0
        
     UNION ALL
        
     SELECT SEQ_VC, WORDS_VC "가사" FROM (SELECT ROWNUM NUM,T_LETITBE.* FROM T_LETITBE)
     WHERE (MOD(NUM, 2)) = 0
     ) A
     ORDER BY TO_NUMBER(A.SEQ_VC) ASC; -- SEQ.VC 가 VARCHAR2 문자 타입이므로 정렬을 위해서는 숫자타입으로 형변환 
 
 
-- -- -- --  # 2 오라클 정규 표현식을 사용해서 풀이해보기 'REGEXP_LIKE' 
  
-- 1) 영어가사만 나오게 하기
-- [:alpha:] = 알파벳이 하나 이상이 오는 WORDS_VC를 조회해라
SELECT * FROM T_LETITBE WHERE REGEXP_LIKE(WORDS_VC,'[:alpha:]'); 
                            -- >  !!!!! 왜 Let it be가 있는 row만 조회가 안될까?.?
                            
-- 2. 한글가사만 나오게 하기
-- [가-힣] = 한글이 하나 이상이 오는 WORD_VC를 조회해라 
SELECT * FROM T_LETITBE WHERE REGEXP_LIKE(WORDS_VC, '[가-힣]'); 
                            -- > 한글가사 row는 잘 출력된다. 

-- 3. 영어가사와 한글가사가 번갈아 나오게 하기 
SELECT * 
FROM (
    SELECT * FROM T_LETITBE WHERE REGEXP_LIKE(WORDS_VC,'[:alpha:]')
    
    UNION ALL
    
    SELECT * FROM T_LETITBE WHERE REGEXP_LIKE(WORDS_VC, '[가-힣]') 
    ) U
    ORDER BY TO_NUMBER(U.SEQ_VC) ASC;
                                                            --////////// 풀이 끝
                                                            --////////// [:alpha:] 로 Let it be 조회 안되는 이유 미해결 !! 


