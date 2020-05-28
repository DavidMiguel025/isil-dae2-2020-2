package pe.isil.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pe.isil.model.Loan;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcLoanRepository implements LoanRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(Loan loan) {
        final String SQL = "INSERT INTO loan(clientName, clientLastName, loanAmount) VALUES (?,?,?)";
        jdbcTemplate.update(SQL, loan.getClientName(), loan.getClientLastName(), loan.getLoanAmount() );
    }

    @Override
    public void update(Loan loan) {
        final String SQL = "UPDATE loan SET clientName=?, clientLastName=?, loanAmount=? WHERE loanNumber=?";
        jdbcTemplate.update(SQL, loan.getClientName(), loan.getClientLastName(), loan.getLoanAmount(), loan.getLoanNumber() );
    }

    @Override
    public void delete(Loan loan) {
        final String SQL = "DELETE loan WHERE loanNumber=?";
        jdbcTemplate.update(SQL, loan.getLoanNumber() );
    }

    @Override
    public List<Loan> findAll() {
        final String SQL = "SELECT * FROM loan";
        List<Loan> loans = jdbcTemplate.query(SQL, JdbcLoanRepository::LoanRowMapper);
        return loans;
    }

    @Override
    public Loan findById(Long loanNumber) {
        final String SQL = "SELECT * FROM loan WHERE loanNumber=?";
        Loan loan = jdbcTemplate.queryForObject(SQL,
                new Object[]{loanNumber},
                JdbcLoanRepository::LoanRowMapper);
        return loan;
    }

    private static Loan LoanRowMapper(ResultSet resultSet, int i) throws SQLException {
        Long loanNumber = resultSet.getLong("loanNumber");
        String clientName = resultSet.getString("clientName");
        String clientLastName = resultSet.getString("clientLastName");
        Double loanAmount = resultSet.getDouble("loanAmount");
        return new Loan(loanNumber, clientName, clientLastName, loanAmount, null);
    }
}
