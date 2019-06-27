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

import com.cassioroos.compassoteste.DTO.ClienteDTO;
import com.cassioroos.compassoteste.Domain.Clientes;
import com.cassioroos.compassoteste.Service.ClienteService;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService service;

	@RequestMapping(value = "/{codigo}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer codigo) {
		Clientes obj = service.findById(codigo);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value = "/{nome}/nome", method = RequestMethod.GET)
	public ResponseEntity<?> findByNome(@PathVariable String nome) {
		List<Clientes> obj = service.findByNome(nome);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody ClienteDTO obj) {
		Clientes cli = service.inserirCliente(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{codigo}").buildAndExpand(cli.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{codigo}", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@PathVariable Integer codigo, @RequestBody ClienteDTO obj) {
		service.update(codigo, obj);
		return ResponseEntity.noContent().build();
	}
	
	
	@RequestMapping(value = "/{codigo}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer codigo) {
		service.delete(codigo);
		return ResponseEntity.noContent().build();
	}
}
