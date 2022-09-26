package br.edu.fateczl.ExemploSpringWeb.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Aluno {

	private int cod;
	private String nome;
	private String situacao;
	private float altura;
	private float peso;
	private float imc;
	
}
