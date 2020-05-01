package pe.isil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {

    private String documentNumber;
    private String name;
    private String lastNameFather;
    private String lastNameMother;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate; // yyyy-MM-dd

}
