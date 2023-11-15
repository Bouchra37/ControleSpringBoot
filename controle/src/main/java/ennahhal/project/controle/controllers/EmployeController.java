package ennahhal.project.controle.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ennahhal.project.controle.entities.Employe;
import ennahhal.project.controle.services.EmployeService;

@RestController
@RequestMapping("/controle/employe")
public class EmployeController {

	@Autowired
	private EmployeService employeService;

	@GetMapping
	public List<Employe> findAllEmployes() {
		return employeService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable Long id) {
		Employe employe = employeService.findById(id);
		if (employe == null) {
			return new ResponseEntity<Object>("Employe with ID " + id + " not found", HttpStatus.BAD_REQUEST);
		} else {
			return ResponseEntity.ok(employe);
		}
	}

	@PostMapping
	public Employe createEmploye(@RequestBody Employe employe) {
		employe.setId(0L);
		return employeService.create(employe);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateEmploye(@PathVariable Long id, @RequestBody Employe employe) {
		if (employeService.findById(id) == null) {
			return new ResponseEntity<Object>("Employe with ID " + id + " no found", HttpStatus.BAD_REQUEST);
		}

		else {
			employe.setId(id);
			return ResponseEntity.ok(employeService.update(employe));
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteEmploye(@PathVariable Long id) {
		Employe employe = employeService.findById(id);
		if (employe == null) {
			return new ResponseEntity<Object>("Batimenr with ID " + id + " not found", HttpStatus.BAD_REQUEST);

		} else {
			employeService.delete(employe);
			return ResponseEntity.ok("Employe deleted");
		}

	}
	
	@GetMapping("/service/{serviceId}")
	public ResponseEntity<List<Employe>> getEscaliersByBatiment(@PathVariable Long serviceId) {
        List<Employe> escaliers = employeService.findEmployesByService(serviceId);
        return new ResponseEntity<>(escaliers,HttpStatus.OK);

	}

}
