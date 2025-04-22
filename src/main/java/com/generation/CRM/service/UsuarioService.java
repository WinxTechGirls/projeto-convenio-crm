package com.generation.CRM.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.CRM.model.Convenio;
import com.generation.CRM.model.Usuario;
import com.generation.CRM.repository.ConvenioRepository;
import com.generation.CRM.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private ConvenioRepository convenioRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario cadastrarUsuario (Usuario usuario){
		
		Convenio convenioUsuario = convenioRepository.findById(usuario.getConvenio().getId()).get();
		
		usuario.setConvenio(convenioUsuario);
		
		if ("DESCONTO10".equalsIgnoreCase(usuario.getCodigo())) {
			usuario.setPrecoPagar(convenioUsuario.getPreco().multiply(new BigDecimal(0.90)).setScale(2,RoundingMode.HALF_EVEN));
		}
		
		else {
			usuario.setPrecoPagar(convenioUsuario.getPreco());
		}
		
		usuarioRepository.save(usuario);
		return usuario;
	}
	
	
}
