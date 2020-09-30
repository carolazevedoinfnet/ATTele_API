package br.com.infnet.ATTelemedicina.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.infnet.ATTelemedicina.negocio.Medico;
import br.com.infnet.ATTelemedicina.service.MedicoService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/telemedicina/medico")
public class MedicoController {
	


	@Autowired
	private MedicoService medicoService;
	
	
	@ApiOperation(value = "Retornar lista de medicos")
	@GetMapping(value = "/medicos")
	public List<Medico> obterlistaMedicos() {
		return medicoService.obterLista();
	}
	
	@ApiOperation(value = "Cadastrar medico")
	@PostMapping(value = "/medico")
	public void incluir(@RequestBody Medico medico) {
		medicoService.incluir(medico);

	}
	
	@ApiOperation(value = "Excluir medico")
	@DeleteMapping(value = "/medico/excluir/{id}")
	public void excluir(@PathVariable Integer id) {
		medicoService.excluir(id);
	}
	

	@ApiOperation(value = "Obter medico pela chave-primária")
	@GetMapping(value = "/medico/{id}/consultar")
	public Medico consultar(@PathVariable Integer id) {
		return medicoService.obterPorId(id);
	}

	

	

	
	
	
	

}
