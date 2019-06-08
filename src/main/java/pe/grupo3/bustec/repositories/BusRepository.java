package pe.grupo3.bustec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.grupo3.bustec.modelos.Bus;

@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {
   
}

