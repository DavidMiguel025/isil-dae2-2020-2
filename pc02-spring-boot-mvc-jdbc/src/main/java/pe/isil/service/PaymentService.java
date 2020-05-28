package pe.isil.service;

import org.springframework.stereotype.Service;
import pe.isil.model.Payment;
import pe.isil.repository.JdbcPaymentRepository;

import java.util.List;

@Service
public class PaymentService implements BaseService<Payment, Long> {

    private JdbcPaymentRepository jdbcPaymentRepository;

    public PaymentService(JdbcPaymentRepository jdbcPaymentRepository) {
        this.jdbcPaymentRepository = jdbcPaymentRepository;
    }

    @Override
    public void create(Payment payment) {
        jdbcPaymentRepository.create(payment);
    }

    @Override
    public void update(Payment payment) {
        jdbcPaymentRepository.update(payment);
    }

    @Override
    public void delete(Payment payment) {
        jdbcPaymentRepository.delete(payment);
    }

    @Override
    public List<Payment> findAll() {
        return jdbcPaymentRepository.findAll();
    }

    public List<Payment> findByLoan(Long loanNumber) {
        return jdbcPaymentRepository.findByLoan(loanNumber);
    }

    @Override
    public Payment findById(Long id) {
        return jdbcPaymentRepository.findById(id);
    }
}
