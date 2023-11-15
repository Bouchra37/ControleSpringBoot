package ennahhal.project.controle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ennahhal.project.controle.entities.Employe;

import java.util.List;

@Repository	
public interface EmployeRepository extends JpaRepository<Employe, Long> {

	@Query("SELECT emp FROM Employe emp WHERE emp.service.id=:serviceId")
	List<Employe> findEmployesByService(@Param("serviceId")Long serviceId);
	
}
