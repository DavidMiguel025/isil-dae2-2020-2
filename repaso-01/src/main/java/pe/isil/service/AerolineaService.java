package pe.isil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.model.Aerolinea;
import pe.isil.repository.JdbcAerolineaRepository;

import java.util.List;

@Service
public class AerolineaService implements BaseService<Aerolinea, Long>{

    @Autowired
    JdbcAerolineaRepository jdbcAerolineaRepository;

    @Override
    public void create(Aerolinea aerolinea) {
        jdbcAerolineaRepository.create(aerolinea);
    }

    @Override
    public void update(Aerolinea aerolinea) {
        jdbcAerolineaRepository.update(aerolinea);
    }

    @Override
    public void delete(Aerolinea aerolinea) {
        jdbcAerolineaRepository.delete(aerolinea);
    }

    @Override
    public List<Aerolinea> findAll() {
        return jdbcAerolineaRepository.findAll();
    }

    @Override
    public Aerolinea findById(Long id) {
        return jdbcAerolineaRepository.findById(id);
    }
}
