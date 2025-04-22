package com.generation.CRM.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.CRM.model.Convenio;
import com.generation.CRM.repository.ConvenioRepository;
import com.generation.CRM.repository.TipoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/convenios")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class ConvenioController {
	
	@Autowired
	private ConvenioRepository convenioRepository;
	
	@Autowired
	private TipoRepository tipoRepository;
	
	@GetMapping
	public ResponseEntity<List<Convenio>> getAll(){
		return ResponseEntity.ok(convenioRepository.findAll());
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<Convenio> getById(@PathVariable Long id) {
		return convenioRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@GetMapping ("/nome/{nome}")
	public ResponseEntity<List<Convenio>> getByNome(@PathVariable String nome){
		return ResponseEntity
				.ok(convenioRepository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@GetMapping ("/preco/{preco}")
	public ResponseEntity<List<Convenio>> getByMaxPreco(@PathVariable BigDecimal preco){
		return ResponseEntity
				.ok(convenioRepository.findAllByPrecoLessThanEqual(preco));
	}
	
	@PostMapping
	public ResponseEntity<Convenio> post(@Valid @RequestBody Convenio convenio){
		if (tipoRepository.existsById(convenio.getTipo().getId()))
			return ResponseEntity.status(HttpStatus.CREATED).
				body(convenioRepository.save(convenio));
		
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tipo não existe!", null);
		
		//chamar o service
		
	}
	
	@PutMapping
	public ResponseEntity<Convenio> put(@Valid @RequestBody Convenio convenio){
		if(convenioRepository.existsById(convenio.getId())) {
			
			if (tipoRepository.existsById(convenio.getTipo().getId())) {
				return ResponseEntity.status(HttpStatus.OK)
						.body(convenioRepository.save(convenio));
			}
			
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tipo não existe", null);
			
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Convenio> convenio = convenioRepository.findById(id);
		
		
		if(convenio.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		convenioRepository.deleteById(id);
	}
}
