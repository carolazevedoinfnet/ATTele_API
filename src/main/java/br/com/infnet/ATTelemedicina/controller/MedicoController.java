package br.com.infnet.ATTelemedicina.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.infnet.ATTelemedicina.negocio.Medico;
import br.com.infnet.ATTelemedicina.service.MedicoService;
import io.swagger.annotations.ApiOperation;

@Controller
public class MedicoController {

	@Autowired
	private MedicoService medicoService;

	@ApiOperation(value = "Retornar lista de médicos")
	@GetMapping(value = "/medicos")
	public List<Medico> obterLista() /// listaMedicos
	{
		return medicoService.obterLista();
	}

	@ApiOperation(value = "Cadastrar médico")
	@PostMapping(value = "/medico")
	public void incluir(@RequestBody Medico medico) {
		medicoService.incluir(medico);
	}

	/*
	 * @RequestMapping(value = "/medico", method = RequestMethod.POST) public String
	 * incluir( Model model, Medico medico,
	 * 
	 * @RequestParam String[] especialidades) { System.out.println(especialidades);
	 * System.out.println("gravandomedico");
	 * System.out.println(medico.getEspecialidade());
	 * 
	 * medico.setEspecialidade(especialidades); medicoService.incluir(medico);
	 * return this.obterListaMedicos(model); }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	@ApiOperation(value = "Obter médico pela chave-primária")
	@GetMapping(value = "/medico/{id}/consultar")
	public Medico consultar(@PathVariable Integer id) {
		return medicoService.obterPorId(id);

	}

	@ApiOperation(value = "Excluir médico")
	@DeleteMapping(value = "/medico/excluir/{id}")
	public void excluir(@PathVariable Integer id) {
		medicoService.excluir(id);
	}

}
