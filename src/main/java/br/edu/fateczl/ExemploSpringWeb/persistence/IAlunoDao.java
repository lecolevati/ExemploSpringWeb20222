package br.edu.fateczl.ExemploSpringWeb.persistence;

import java.sql.SQLException;
import java.util.List;

import br.edu.fateczl.ExemploSpringWeb.model.Aluno;

public interface IAlunoDao {

	public Aluno findAlunoSituacao(Aluno aluno) throws SQLException, ClassNotFoundException;
	public List<Aluno> findAlunosSituacao() throws SQLException, ClassNotFoundException;
	
}
