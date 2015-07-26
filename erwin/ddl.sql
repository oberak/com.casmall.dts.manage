-->>>TEST<<<-- ;
CREATE TABLE CM_CD_MST 
(
  CD_ID                VARCHAR(    30) NOT NULL,
  CD_DESC              VARCHAR(    50),
  CONSTRAINT PK_CM_CD_MST PRIMARY KEY (CD_ID)
);

CREATE TABLE CM_CD 
(
  CD_ID                   VARCHAR(    30) NOT NULL,
  CD_VAL                  VARCHAR(    30) NOT NULL,
  CD_NM                   VARCHAR(    200),
  MARK_PRIOR              NUMERIC(  2, 0),
  CONSTRAINT PK_CM_CD PRIMARY KEY (CD_ID, CD_VAL),
  CONSTRAINT FK_CM_CD_01 FOREIGN KEY (CD_ID) REFERENCES CM_CD_MST(CD_ID)
);

CREATE TABLE CM_USR_INF 
(
  USR_SEQ              NUMERIC( 10, 0) NOT NULL,
  LGN_ID               VARCHAR(    20),
  LGN_PW               VARCHAR(    64),
  USR_NM               VARCHAR(    10),
  TEL                  VARCHAR(    14),
  ATH_GRD              VARCHAR(    10),
  NT                   VARCHAR(    50),
  DEL_YN               VARCHAR(     1),
  RGN_DT               TIMESTAMP,
  RGN_ID               VARCHAR(    20),
  EDT_DT               TIMESTAMP,
  EDT_ID               VARCHAR(    20),
  TRN_DT               TIMESTAMP,
  ATH_CD               INTEGER,
  CONSTRAINT PK_CM_USR_INF PRIMARY KEY (USR_SEQ)
);

CREATE TABLE TS_AUTH_MGT 
(
  AUTH_SEQ              NUMERIC( 10, 0) NOT NULL,
  AUTH_KEY              VARCHAR(    30),
  AUTH_NUM              VARCHAR(    64),
  CST_NM                VARCHAR(   200),
  CST_TEL               VARCHAR(    14),
  NT                    VARCHAR(    50),
  DEL_YN                VARCHAR(     1),
  RGN_DT                   DATE,
  RGN_ID                VARCHAR(    20),
  EDT_DT                   DATE,
  EDT_ID                VARCHAR(    20),
  CONSTRAINT PK_TS_AUTH_MGT PRIMARY KEY (AUTH_SEQ)
);

