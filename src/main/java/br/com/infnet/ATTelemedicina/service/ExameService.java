package br.com.infnet.ATTelemedicina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.infnet.ATTelemedicina.negocio.Exame;
import br.com.infnet.ATTelemedicina.repository.IExameRepository;



@Service 
public class ExameService {

	@Autowired
	private IExameRepository exameRepository;


	public void incluir(Exame exame) {
		exameRepository.save(exame);
		
	}
	
	public List<Exame> obterLista(){
		return (List<Exame>)exameRepository.findAll();
	}
	
	public Exame obterPorId (Integer id) {
		return exameRepository.findById(id).orElse(null);
	}
	
	public void excluir(Integer id) {
		exameRepository.deleteById(id);
}
	
	
}

