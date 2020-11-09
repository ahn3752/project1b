create table banking_tb(
    accountNum varchar(50) ,
    name varchar(30) ,
    balance varchar(50) ,
    
    primary key (accountNum)
);

create sequence seq_banking
    increment by 1
    start with 1
    minvalue 1
    nomaxvalue
    nocycle
    nocache;
    
