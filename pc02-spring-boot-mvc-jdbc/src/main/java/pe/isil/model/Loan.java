package pe.isil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Loan {
    private Long loanNumber;
    private String clientName;
    private String clientLastName;
    private Double loanAmount;
    private List<Payment> payments;
}
