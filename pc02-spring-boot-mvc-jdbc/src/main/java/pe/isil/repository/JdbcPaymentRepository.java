package pe.isil.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pe.isil.model.Payment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Repository
public class JdbcPaymentRepository implements PaymentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(Payment payment) {
        final String SQL = "INSERT INTO payment(paymentAmount, createdDate, loanNumber) VALUES (?,?,?)";
        jdbcTemplate.update(SQL, payment.getPaymentAmount(), payment.getCreatedDate(), payment.getLoan().getLoanNumber() );
    }

    @Override
    public void update(Payment payment) {
        final String SQL = "UPDATE payment SET paymentAmount=?, createdDate=?, loanNumber=? WHERE paymentId=?";
        jdbcTemplate.update(SQL, payment.getPaymentAmount(), payment.getCreatedDate(), payment.getLoan().getLoanNumber(), payment.getPaymentId() );
    }

    @Override
    public void delete(Payment payment) {
        final String SQL = "DELETE payment WHERE paymentId=?";
        jdbcTemplate.update(SQL, payment.getPaymentId() );
    }

    @Override
    public List<Payment> findAll() {
        final String SQL = "SELECT * FROM payment";
        List<Payment> payments = jdbcTemplate.query(SQL, JdbcPaymentRepository::PaymentRowMapper);
        return payments;
    }

    @Override
    public Payment findById(Long paymentId) {
        final String SQL = "SELECT * FROM payment WHERE paymentId=?";
        Payment payment = jdbcTemplate.queryForObject(SQL,
                new Object[]{paymentId},
                JdbcPaymentRepository::PaymentRowMapper);
        return payment;
    }

    public List<Payment> findByLoan(Long loanNumber) {
        final String SQL = "SELECT * FROM payment WHERE loanNumber=?";
        List<Payment> payments = jdbcTemplate.query(SQL,new Object[]{loanNumber}, JdbcPaymentRepository::PaymentRowMapper);
        return payments;
    }

    private static Payment PaymentRowMapper(ResultSet resultSet, int i) throws SQLException {
        Long paymentId = resultSet.getLong("paymentId");
        Double paymentAmount = resultSet.getDouble("paymentAmount");
        LocalDate createdDate = resultSet.getDate("createdDate").toLocalDate();
        return new Payment(paymentId, paymentAmount, createdDate, null);
    }
}
