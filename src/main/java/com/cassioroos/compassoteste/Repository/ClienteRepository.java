package com.cassioroos.compassoteste.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cassioroos.compassoteste.Domain.Clientes;

public interface ClienteRepository extends JpaRepository<Clientes, Integer> {
	
	@Query("SELECT c FROM Clientes c WHERE lower(c.nome) like %:nome%")
	List<Clientes> findBynome(String nome);

}
