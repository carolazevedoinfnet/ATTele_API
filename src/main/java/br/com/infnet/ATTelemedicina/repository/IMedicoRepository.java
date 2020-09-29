package br.com.infnet.ATTelemedicina.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.infnet.ATTelemedicina.negocio.Medico;





@Repository
public interface IMedicoRepository extends CrudRepository<Medico, Integer> {

	//List<Medico> findAll(Sort by);
}
