package br.com.infnet.ATTelemedicina.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RestController;

import br.com.infnet.ATTelemedicina.negocio.Consulta;
import br.com.infnet.ATTelemedicina.negocio.Exame;
import br.com.infnet.ATTelemedicina.service.ConsultaService;
import br.com.infnet.ATTelemedicina.service.ExameService;
import br.com.infnet.ATTelemedicina.service.MedicoService;
import br.com.infnet.ATTelemedicina.service.PacienteService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/telemedicina/consulta")
public class ConsultaController {

	@Autowired
	private ConsultaService consultaService;

	@ApiOperation(value = "Retornar lista de consultas")
	@GetMapping
	//@GetMapping(value = "/consulta/listaConsulta")
	public List<Consulta> obterLista() { // obterListaConsulta
		return consultaService.obterLista();
	}


	@ApiOperation(value = "Cadastrar consulta")
	@PostMapping(value = "/consulta") // /incluir
	public void incluir(@RequestBody Consulta consulta) {
		consultaService.incluir(consulta);
	}

	@ApiOperation(value = "Excluir consulta")
	@DeleteMapping(value = "/consulta/{id}/excluir")
	public void excluir(@PathVariable Integer id) {
		consultaService.excluir(id);
	}
	
	@ApiResponses(value = {		
			@ApiResponse(code = 200, message = "Consulta retornada com sucesso"),
			@ApiResponse(code = 400, message = "Erro na chamada da API"),
			@ApiResponse(code = 500, message = "Erro no processamento da chamada")
	})	
	@ApiOperation(value = "Obter consulta pela chave-primária")
	@GetMapping(value = "/consulta/{id}/consultar")
	public Consulta consultar(@PathVariable Integer id) {
		return consultaService.obterPorId(id);
	}

}
