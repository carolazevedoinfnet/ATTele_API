package br.com.infnet.ATTelemedicina.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.infnet.ATTelemedicina.negocio.Exame;
import br.com.infnet.ATTelemedicina.negocio.Medico;
import br.com.infnet.ATTelemedicina.repository.IMedicoRepository;

@Service 
public class MedicoService {
	
	@Autowired
	private IMedicoRepository medicoRepository;


	public void incluir(Medico medico) {
		medicoRepository.save(medico);
		
	}
	public void excluir(Integer id) {
		medicoRepository.deleteById(id);
}
	
	public List<Medico> obterLista(){
		return (List<Medico>)medicoRepository.findAll();
	}
	
	public Medico obterPorId (Integer id) {
		return medicoRepository.findById(id).orElse(null);
	}
}

