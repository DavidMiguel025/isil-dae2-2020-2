package pe.isil.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pe.isil.model.Aerolinea;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcAerolineaRepository implements AerolineaRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(Aerolinea aerolinea) {
        final String SQL = "INSERT INTO aerolinea(nombre, telefono, reserva) VALUES (?,?,?)";
        jdbcTemplate.update(SQL, aerolinea.getNombre(), aerolinea.getTelefono(), aerolinea.getReserva());
    }

    @Override
    public void update(Aerolinea aerolinea) {
        final String SQL = "UPDATE aerolinea SET nombre=?, telefono=?, reserva=? WHERE id=?";
        jdbcTemplate.update(SQL, aerolinea.getNombre(), aerolinea.getTelefono(), aerolinea.getReserva(), aerolinea.getId());
    }

    @Override
    public void delete(Aerolinea aerolinea) {
        final String SQL = "DELETE aerolinea WHERE id=?";
        jdbcTemplate.update(SQL, aerolinea.getId());

    }

    @Override
    public List<Aerolinea> findAll() {
        final String SQL = "SELECT * FROM aerolinea";
        List<Aerolinea> aerolineas = jdbcTemplate.query(SQL, JdbcAerolineaRepository::AerolineaRowMapper);
        return aerolineas;
    }

    private static Aerolinea AerolineaRowMapper(ResultSet resultSet, int i) throws SQLException {
        long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        String telefono = resultSet.getString("telefono");
        int reserva = resultSet.getInt("reserva");
        return new Aerolinea(id, nombre, telefono, reserva);
    }

    @Override
    public Aerolinea findById(Long id) {
        final String SQL = "SELECT * FROM aerolinea WHERE id = ?";
        Aerolinea aerolinea = jdbcTemplate.queryForObject(SQL, new Object[]{id}, JdbcAerolineaRepository::AerolineaRowMapper);
        return aerolinea;
    }
}
