package br.com.infnet.ATTelemedicina.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.infnet.ATTelemedicina.negocio.Usuario;


@Repository
public interface IusuarioRepository extends CrudRepository<Usuario, Integer> {
	
	@Query("from Usuario u where u.login =:login and u.senha =:senha")
	Usuario autenticacao (String login, String senha);

}
