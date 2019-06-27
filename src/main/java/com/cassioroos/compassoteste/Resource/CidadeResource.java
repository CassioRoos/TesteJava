package com.cassioroos.compassoteste.Resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cassioroos.compassoteste.Domain.Cidades;
import com.cassioroos.compassoteste.Service.CidadeService;

@RestController
@RequestMapping(path = "/cidades")
public class CidadeResource {

	@Autowired
	private CidadeService service;

	@RequestMapping(value = "/{codigo}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable(required = false) Integer codigo) {
		Cidades obj = service.findById(codigo);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/{nome}/nome", method = RequestMethod.GET)
	public ResponseEntity<?> findByDescricao(@PathVariable String nome) {
		List<Cidades> obj = service.findByDescricao(nome);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value = "/{estado}/estado", method = RequestMethod.GET)
	public ResponseEntity<?> findByEstado(@PathVariable String estado) {
		List<Cidades> obj = service.findByEstado(estado);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Cidades obj){
		obj = service.inserirCidade(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{codigo}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
