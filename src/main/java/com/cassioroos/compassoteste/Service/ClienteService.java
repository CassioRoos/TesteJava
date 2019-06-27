package com.cassioroos.compassoteste.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cassioroos.compassoteste.DTO.ClienteDTO;
import com.cassioroos.compassoteste.Domain.Cidades;
import com.cassioroos.compassoteste.Domain.Clientes;
import com.cassioroos.compassoteste.Domain.Enums.Sexo;
import com.cassioroos.compassoteste.Repository.CidadeRepository;
import com.cassioroos.compassoteste.Repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	@Autowired
	private CidadeRepository cidadeRepository;

	public Clientes findById(Integer codigo) {
		Optional<Clientes> obj = repository.findById(codigo);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado! Código " + codigo,
				Clientes.class.getName()));
	}

	public Clientes inserirCliente(ClienteDTO obj) {
		Clientes cli = new Clientes(null, obj.getNome(), obj.getSexo(), obj.getDataNascimento(), obj.getIdade());
		Optional<Cidades> cid = cidadeRepository.findById(obj.getCidadeid());
		cli.setCidade(
				cid.orElseThrow(() -> new ObjectNotFoundException("Cidade não encontrada! Código " + obj.getCidadeid(),
						Clientes.class.getName())));
		return repository.save(cli);
	}

	public List<Clientes> findByNome(String nome) {
		List<Clientes> obj = repository.findBynome(nome.toLowerCase());

		if (obj.isEmpty()) {
			List<Clientes> obj2 = new ArrayList<Clientes>();
			return obj2;
		}
		return obj;
	}
	
	public Clientes update(Integer codigo, ClienteDTO obj) {
		Clientes cli = findById(codigo);
		
		if (obj.getNome() !=null) {
			cli.setNome(obj.getNome());
		}

		if (obj.getCidadeid() != null) {
			Optional<Cidades> cid = cidadeRepository.findById(obj.getCidadeid());
			cli.setCidade(
					cid.orElseThrow(() -> new ObjectNotFoundException("Cidade não encontrada! Código " + obj.getCidadeid(),
							Clientes.class.getName())));
		}
		
		if (obj.getDataNascimento() != null) {
			cli.setDataNascimento(obj.getDataNascimento());
		}
		
		if (obj.getIdade() != null) {
			cli.setIdade(obj.getIdade());
		}
		
		if (obj.getSexo() != null) {
			cli.setSexo(Sexo.toEnum(obj.getSexo()));
		}
		
		return repository.save(cli);
	}
	
	public void delete(Integer codigo) {
		Clientes cli = findById(codigo);
		repository.deleteById(cli.getId());
	}
}
