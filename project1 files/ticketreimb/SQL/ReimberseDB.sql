-- Drop table

-- DROP TABLE reimberse.employeelogin;

CREATE TABLE reimberse.employeelogin (
	employeeid int4 NOT NULL,
	address varchar NULL,
	city varchar NULL,
	username varchar NOT NULL,
	"password" varchar NOT NULL,
	manager bool NULL DEFAULT false,
	CONSTRAINT employeelogin_pkey PRIMARY KEY (employeeid)
);
-- Drop table

-- DROP TABLE reimberse.tickets;

CREATE TABLE reimberse.tickets (
	employeeid int4 NOT NULL,
	ticketnumber serial NOT NULL,
	tickettype varchar NULL,
	ticketamount float8 NULL,
	"comment" varchar(255) NULL,
	CONSTRAINT tickets_pkey PRIMARY KEY (ticketnumber),
	CONSTRAINT type_ticket CHECK ((((tickettype)::text = 'lodging'::text) OR ((tickettype)::text = 'travel'::text) OR ((tickettype)::text = 'food'::text) OR ((tickettype)::text = 'other'::text))),
	CONSTRAINT tickets_fk FOREIGN KEY (employeeid) REFERENCES reimberse.employeelogin(employeeid) ON DELETE CASCADE
);
insert into reimberse.employeelogin (employeeid,username ,"password",address,city,manager)
	values (420, 'Seraphim2000', 'gangrel', '10607 Fake Street', 'Houston', true),
		(805, 'N05F3R47U', 'hackerleet', '1075 Main Street', 'New York', false),
			(705, 'VladImpales', 'blood', '2121 Dark Road', 'Chicago', false)