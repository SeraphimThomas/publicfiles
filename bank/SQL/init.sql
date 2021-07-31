CREATE SCHEMA bank_data AUTHORIZATION postgres;

CREATE TABLE bank_data.account_balance (
	accountid int4 NOT NULL,
	account_balance float4 NULL DEFAULT 0.0
);


-- bank_data.account_balance definition

-- Drop table

-- DROP TABLE bank_data.account_balance;

CREATE TABLE bank_data.account_balance (
	accountid int4 NOT NULL,
	account_balance float4 NULL DEFAULT 0.0
);


-- bank_data.account_balance foreign keys

ALTER TABLE bank_data.account_balance ADD CONSTRAINT account_balance_fk FOREIGN KEY (accountid) 
REFERENCES bank_data.bank_accounts(accountid) ON DELETE CASCADE ON UPDATE CASCADE;

CREATE TABLE bank_data.bank_accounts (
	accountid int4 NOT NULL,
	user_name varchar NOT NULL,
	"password" varchar NOT NULL,
	CONSTRAINT account_balance_account_balance_check1 CHECK ((account_balance >= (0.0)::double precision)),
	CONSTRAINT newtable_pk PRIMARY KEY (accountid)
);
