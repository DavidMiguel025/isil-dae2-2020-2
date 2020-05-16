package pe.isil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Aerolinea {
    private Long id;
    private String nombre;
    private String telefono;
    private Integer reserva;
}
