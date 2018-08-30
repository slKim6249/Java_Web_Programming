ALTER TABLE SPRING.REPLY
 DROP PRIMARY KEY CASCADE;

DROP TABLE SPRING.REPLY CASCADE CONSTRAINTS;

CREATE TABLE SPRING.REPLY
(
  REPLY_ID         VARCHAR2(20 CHAR)            NOT NULL,
  BOARD_ID         INTEGER,
  EMAIL            VARCHAR2(100 BYTE),
  REPLY            CLOB,
  CRT_DT           TIMESTAMP(6),
  PARENT_REPLY_ID  VARCHAR2(20 CHAR)
)
LOB (REPLY) STORE AS BASICFILE (
  TABLESPACE  USERS
  ENABLE      STORAGE IN ROW
  CHUNK       8192
  RETENTION
  NOCACHE
  LOGGING
      STORAGE    (
                  INITIAL          64K
                  NEXT             1M
                  MINEXTENTS       1
                  MAXEXTENTS       UNLIMITED
                  PCTINCREASE      0
                  BUFFER_POOL      DEFAULT
                 ))
TABLESPACE USERS
PCTUSED    0
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
MONITORING;


CREATE UNIQUE INDEX SPRING.REPLY_PK ON SPRING.REPLY
(REPLY_ID)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           );

ALTER TABLE SPRING.REPLY ADD (
  CONSTRAINT REPLY_PK
  PRIMARY KEY
  (REPLY_ID)
  USING INDEX SPRING.REPLY_PK
  ENABLE VALIDATE);


-- Spring Schema에서 -> Sequences 
-- Create Sequence

-- SPRING  -> Schema

-- REPLY_ID_SEQ -> Sequence Name
-- 1 -> Start With
-- 1 -> Increment by
-- 1 -> Min Value
-- 999999 -> Max Value
-- 24 -> Cache
-- Cycle, Order -> Check