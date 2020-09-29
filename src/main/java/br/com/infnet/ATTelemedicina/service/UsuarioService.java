package br.com.infnet.ATTelemedicina.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.infnet.ATTelemedicina.negocio.Usuario;
import br.com.infnet.ATTelemedicina.repository.IusuarioRepository;

@Service 
public class UsuarioService {
	
	@Autowired
	private IusuarioRepository usuarioRepository;
	
	public Usuario isValid(String login, String senha) {
		
		/*
		 * Usuario usuario = null; if (login.equalsIgnoreCase(senha)) { usuario = new
		 * Usuario (login, senha);
		 * 
		 * }
		 * 
		 * return usuario;
		 */
		 
	
		return usuarioRepository.autenticacao(login, senha);
	}
	
	public List<Usuario> obterLista(){
		return (List<Usuario>)usuarioRepository.findAll();
	}

	public void incluir(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	public void excluir(Integer id) {
		usuarioRepository.deleteById(id);
}
}
