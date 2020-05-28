
insert into loan(loanNumber, clientName, clientLastName, loanAmount) values (1, 'Jose', 'Ventura', 1000.0);
insert into payment(paymentId, paymentAmount, createdDate, loanNumber) values (1, 100.0, now(),1);
