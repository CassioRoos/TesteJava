package com.cassioroos.compassoteste.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cassioroos.compassoteste.Domain.Cidades;

public interface CidadeRepository extends JpaRepository<Cidades, Integer> {
	
	@Query("SELECT c FROM Cidades c WHERE lower(c.nome) like %:nome%")
	List<Cidades> findBynome(String nome);
	
	@Query("SELECT c FROM Cidades c WHERE lower(c.estado) like %:estado%")
	List<Cidades> findByestado(String estado);
}
