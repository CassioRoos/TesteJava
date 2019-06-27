package com.cassioroos.compassoteste.Domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.cassioroos.compassoteste.Domain.Enums.Sexo;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Clientes implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String nome;
	private Integer sexo;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataNascimento;
	private Integer idade;
	
	@ManyToOne
	@JoinColumn(name = "cidade_codigo")
	private Cidades cidade;
	
	public Clientes() {
		
	}

	public Clientes(Integer id, String nome, Integer sexo, Date dataNascimento, Integer idade) {
		super();
		this.id = id;
		this.nome = nome;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.idade = idade;
	}

	public Cidades getCidade() {
		return cidade;
	}

	public void setCidade(Cidades cidade) {
		this.cidade = cidade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Sexo getSexo() {
		return Sexo.toEnum(sexo);
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo.getCodigo();
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;	
		Clientes other = (Clientes) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
