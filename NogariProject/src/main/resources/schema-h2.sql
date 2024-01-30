CREATE TABLE "DEPT" (
                        "DEPT_CD"	VARCHAR2(10)		NOT NULL,
                        "DEPT_NM"	VARCHAR2(150)		NULL,
                        "MGR_ID"	VARCHAR2(20)		NULL,
                        "UPPER_DEPT_CD"	VARCHAR2(10)		NULL,
                        "SORT"	NUMBER(3)		NULL,
                        "EXP_DT"	VARCHAR(8)		NULL,
                        "REG_DT"	DATE		NULL,
                        "REG_ID"	VARCHAR2(20)		NULL,
                        "UPD_DT"	DATE		NULL,
                        "UPD_ID"	VARCHAR2(20)		NULL
);

COMMENT ON COLUMN "DEPT"."DEPT_CD" IS '부서코드';

COMMENT ON COLUMN "DEPT"."DEPT_NM" IS '부서이름';

COMMENT ON COLUMN "DEPT"."MGR_ID" IS '관리자ID';

COMMENT ON COLUMN "DEPT"."UPPER_DEPT_CD" IS '상위부서코드';

COMMENT ON COLUMN "DEPT"."SORT" IS '정렬순서';

COMMENT ON COLUMN "DEPT"."EXP_DT" IS '유효일시';

COMMENT ON COLUMN "DEPT"."REG_DT" IS '등록일시';

COMMENT ON COLUMN "DEPT"."REG_ID" IS '등록자';

COMMENT ON COLUMN "DEPT"."UPD_DT" IS '수정일시';

COMMENT ON COLUMN "DEPT"."UPD_ID" IS '수정자';

ALTER TABLE "DEPT" ADD CONSTRAINT "PK_DEPT" PRIMARY KEY (
                                                         "DEPT_CD"
    );

