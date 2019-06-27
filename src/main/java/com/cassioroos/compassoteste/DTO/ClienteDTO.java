package com.cassioroos.compassoteste.DTO;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ClienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nome;
	private Integer sexo;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataNascimento;
	private Integer idade;
	private Integer cidadeid;

	public ClienteDTO() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getSexo() {
		return sexo;
	}

	public void setSexo(Integer sexo) {
		this.sexo = sexo;
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

	public Integer getCidadeid() {
		return cidadeid;
	}

	public void setCidadeid(Integer cidadeid) {
		this.cidadeid = cidadeid;
	}

}
