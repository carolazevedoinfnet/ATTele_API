package br.com.infnet.ATTelemedicina.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.infnet.ATTelemedicina.negocio.Exame;



@Repository
public interface IExameRepository extends CrudRepository<Exame, Integer> {

	List<Exame> findAll(Sort by);
}
