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

import br.com.infnet.ATTelemedicina.service.MedicoService;
import br.com.infnet.ATTelemedicina.service.PacienteService;
import io.swagger.annotations.ApiOperation;

import br.com.infnet.ATTelemedicina.negocio.Paciente;

@RestController
@RequestMapping("/api/telemedicina/paciente")
public class PacienteController {

	@Autowired
	private PacienteService pacienteService;

	@Autowired
	private MedicoService medicoService;

	@ApiOperation(value = "Obter paciente pela chave-primária")
	@GetMapping(value = "/paciente/{id}/consultar")
	public Paciente consultar(@PathVariable Integer id) {
		return pacienteService.obterPorId(id);
	}

	@ApiOperation(value = "Retornar lista de pacientes")
	@GetMapping(value = "/pacientes")
	public List<Paciente> obterlistaPacientes() {
		return pacienteService.obterLista();
	}

	@ApiOperation(value = "Cadastrar paciente")
	@PostMapping(value = "/paciente")
	public void incluir(@RequestBody Paciente paciente) {
		pacienteService.incluir(paciente);

	}

	@ApiOperation(value = "Excluir paciente")
	@DeleteMapping(value = "/paciente/excluir/{id}")
	public void excluir(@PathVariable Integer id) {
		pacienteService.excluir(id);
	}

}
