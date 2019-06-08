package pe.grupo3.bustec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.grupo3.bustec.modelos.Horario;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Long>{

}