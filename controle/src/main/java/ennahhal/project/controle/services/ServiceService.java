package ennahhal.project.controle.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ennahhal.project.controle.dao.IDao;
import ennahhal.project.controle.entities.Servicee;
import ennahhal.project.controle.repositories.ServiceRepository;

@Service
public class ServiceService implements IDao<Servicee> {

	@Autowired
	private ServiceRepository serviceRepository;

	@Override
	public Servicee create(Servicee b) {
		return serviceRepository.save(b);
	}

	@Override
	public boolean delete(Servicee b) {
		try {
			serviceRepository.delete(b);
			return true;
		} catch (Exception ex) {
			return false;
		}

	}
	
	
	@Override
	public Servicee update(Servicee b) {
		return serviceRepository.save(b);
	}
	
	
	@Override
	public List<Servicee> findAll(){
		return serviceRepository.findAll();
	}
	
	
	@Override
	public Servicee findById(Long id) {
		return serviceRepository.findById(id).orElse(null);
	}
	

}
