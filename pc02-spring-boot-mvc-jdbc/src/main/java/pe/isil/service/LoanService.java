package pe.isil.service;

import org.springframework.stereotype.Service;
import pe.isil.model.Loan;
import pe.isil.repository.JdbcLoanRepository;

import java.util.List;

@Service
public class LoanService implements BaseService<Loan, Long>{

    private JdbcLoanRepository jdbcLoanRepository;

    public LoanService(JdbcLoanRepository jdbcLoanRepository) {
        this.jdbcLoanRepository = jdbcLoanRepository;
    }

    @Override
    public void create(Loan loan) {
        jdbcLoanRepository.create(loan);
    }

    @Override
    public void update(Loan loan) {
        jdbcLoanRepository.update(loan);
    }

    @Override
    public void delete(Loan loan) {
        jdbcLoanRepository.delete(loan);
    }

    @Override
    public List<Loan> findAll() {
        return jdbcLoanRepository.findAll();
    }

    @Override
    public Loan findById(Long id) {
        return jdbcLoanRepository.findById(id);
    }
}
