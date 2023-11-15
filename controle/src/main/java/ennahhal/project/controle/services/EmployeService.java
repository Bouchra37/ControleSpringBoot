package ennahhal.project.controle.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ennahhal.project.controle.dao.IDao;
import ennahhal.project.controle.entities.Employe;
import ennahhal.project.controle.repositories.EmployeRepository;


@Service
public class EmployeService implements IDao<Employe> {

	@Autowired
	private EmployeRepository employeRepository;

	@Override
	public Employe create(Employe b) {
		return employeRepository.save(b);
	}

	@Override
	public boolean delete(Employe b) {
		try {
			employeRepository.delete(b);
			return true;
		} catch (Exception ex) {
			return false;
		}

	}
	
	
	@Override
	public Employe update(Employe b) {
		return employeRepository.save(b);
	}
	
	
	@Override
	public List<Employe> findAll(){
		return employeRepository.findAll();
	}
	
	
	@Override
	public Employe findById(Long id) {
		return employeRepository.findById(id).orElse(null);
	}
	
	
	public List<Employe> findEmployesByService(Long serviceId){
		return employeRepository.findEmployesByService(serviceId);
	}
	

}
