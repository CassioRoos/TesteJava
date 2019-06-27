package com.cassioroos.compassoteste.Domain.Enums;

public enum Sexo {
	MASCULINO(1, "Masculino"), FEMININO(2, "Feminino");

	private Integer codigo;
	private String descricao;

	private Sexo(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static Sexo toEnum(Integer codigo) {
		if (codigo == null) {
			return null;
		}

		for (Sexo x : Sexo.values()) {
			if (codigo.equals(x.codigo)) {
				return x;
			}
		}

		throw new IllegalArgumentException("Código inválido");
	}
}
