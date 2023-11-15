package ennahhal.project.controle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ennahhal.project.controle.entities.Servicee;

@Repository
public interface ServiceRepository extends JpaRepository<Servicee, Long> {

}
