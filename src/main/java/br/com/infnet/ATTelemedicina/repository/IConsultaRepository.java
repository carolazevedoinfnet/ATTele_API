package br.com.infnet.ATTelemedicina.repository;




import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.infnet.ATTelemedicina.negocio.Consulta;

@Repository
public interface IConsultaRepository extends CrudRepository<Consulta, Integer>{

	List<Consulta> findAll(Sort by);

}
