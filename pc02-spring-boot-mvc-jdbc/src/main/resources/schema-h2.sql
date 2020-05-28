
create table loan
(
    loanNumber     identity primary key,
    clientName     varchar(100) not null,
    clientLastName varchar(100) not null,
    loanAmount     numeric     not null
);

create table payment
(
    paymentId     identity primary key,
    paymentAmount numeric not null,
    createdDate   date    not null,
    loanNumber    int     not null,
    constraint payment_loan_loanNumber_fk
        foreign key (loanNumber) references loan (loanNumber)
);

