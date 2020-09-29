package br.com.infnet.ATTelemedicina.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.infnet.ATTelemedicina.negocio.Paciente;





@Repository
public interface IPacienteRepository extends CrudRepository<Paciente, Integer> {

	//List<Paciente> findAll(Sort by);
}