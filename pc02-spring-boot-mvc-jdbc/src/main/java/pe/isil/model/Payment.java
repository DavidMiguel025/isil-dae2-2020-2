package pe.isil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Payment {
    private Long paymentId;
    private Double paymentAmount;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdDate;
    private Loan loan;
}
