package com.cassioroos.compassoteste.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cassioroos.compassoteste.Domain.Cidades;
import com.cassioroos.compassoteste.Domain.Clientes;
import com.cassioroos.compassoteste.Repository.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repository;

	public Cidades findById(Integer codigo) {
		Optional<Cidades> obj = repository.findById(codigo);
		return obj.orElseThrow(
				() -> new ObjectNotFoundException("Cidade não encontrada! Código " + codigo, Clientes.class.getName()));
	}

	public List<Cidades> findByDescricao(String descricao) {
		List<Cidades> obj = repository.findBynome(descricao.toLowerCase());

		if (obj.isEmpty()) {
			List<Cidades> obj2 = new ArrayList<Cidades>();
			return obj2;
		}
		return obj;
	}

	public List<Cidades> findByEstado(String descricao) {
		List<Cidades> obj = repository.findByestado(descricao.toLowerCase());

		if (obj.isEmpty()) {
			List<Cidades> obj2 = new ArrayList<Cidades>();
			return obj2;
		}
		return obj;
	}

	public Cidades inserirCidade(Cidades obj) {
		obj.setId(null);
		return repository.save(obj);
	}
}
