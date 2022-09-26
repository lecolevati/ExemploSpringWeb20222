package br.edu.fateczl.ExemploSpringWeb.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.edu.fateczl.ExemploSpringWeb.model.Aluno;

@Repository
public class AlunoDao implements IAlunoDao {

	@Autowired
	GenericDao gDao;
	
	@Override
	public Aluno findAlunoSituacao(Aluno aluno) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = 
			"SELECT cod, nome, altura, peso, imc, situacao "
			+ " FROM fn_alunoimc() WHERE cod = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, aluno.getCod());
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			aluno.setAltura(rs.getFloat("altura"));
			aluno.setImc(rs.getFloat("imc"));
			aluno.setNome(rs.getString("nome"));
			aluno.setPeso(rs.getFloat("peso"));
			aluno.setSituacao(rs.getString("situacao"));
		}
		ps.close();
		rs.close();
		c.close();
		return aluno;
	}

	@Override
	public List<Aluno> findAlunosSituacao() throws SQLException, ClassNotFoundException {
		List<Aluno> alunos = new ArrayList<>();
		Connection c = gDao.getConnection();
		String sql = "SELECT cod, nome, altura, peso, imc, situacao FROM fn_alunoimc()";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Aluno aluno = new Aluno();
			aluno.setCod(rs.getInt("cod"));
			aluno.setAltura(rs.getFloat("altura"));
			aluno.setImc(rs.getFloat("imc"));
			aluno.setNome(rs.getString("nome"));
			aluno.setPeso(rs.getFloat("peso"));
			aluno.setSituacao(rs.getString("situacao"));
			
			alunos.add(aluno);
		}
		ps.close();
		rs.close();
		c.close();
		return alunos;
	}

}
