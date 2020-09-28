package br.com.infnet.ATTelemedicina.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RestController;

import br.com.infnet.ATTelemedicina.negocio.Consulta;
import br.com.infnet.ATTelemedicina.negocio.Exame;

import br.com.infnet.ATTelemedicina.service.ExameService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/telemedicina")
public class ExameController {

	@Autowired
	private ExameService exameService;

	@ApiOperation(value = "Retornar lista de exames")
	@GetMapping(value = "/exames")
	public List<Exame> obterListaExames() {
		return exameService.obterLista();
	}

	@ApiOperation(value = "Cadastrar exame")
	@PostMapping(value = "/exame")
	public void incluir(@RequestBody Exame exame) {
		exameService.incluir(exame);

	}

	@ApiOperation(value = "Excluir exame")
	@DeleteMapping(value = "/exame/excluir/{id}")
	public void excluir(@PathVariable Integer id) {
		exameService.excluir(id);
	}

	@ApiOperation(value = "Obter exame pela chave-primária")
	@GetMapping(value = "/exame/{id}/consultar")
	public Exame consultar(@PathVariable Integer id) {
		return exameService.obterPorId(id);
	}

}
