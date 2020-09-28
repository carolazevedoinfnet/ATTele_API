package br.com.infnet.ATTelemedicina.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.infnet.ATTelemedicina.negocio.Medico;
import br.com.infnet.ATTelemedicina.negocio.Paciente;
import br.com.infnet.ATTelemedicina.repository.IPacienteRepository;



@Service 
public class PacienteService {
	
	@Autowired
	private IPacienteRepository pacienteRepository;


	public void incluir(Paciente paciente) {
		pacienteRepository.save(paciente);
	}

	public List<Paciente> obterLista(){
		return (List<Paciente>)pacienteRepository.findAll();
	}

	public Paciente obterPorId (Integer id) {
		return pacienteRepository.findById(id).orElse(null);
	}

	
	public void excluir(Integer id) {
		pacienteRepository.deleteById(id);
		
		
}
	
}
