package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.db.DB;
import br.com.db.DbException;
import br.com.model.Personagem;

public class PersonagemDAO implements InterfaceDAO<Personagem> {

	private Connection conn = null;

	public PersonagemDAO() {
		this.conn = DB.getConnection();
	}

	@SuppressWarnings("finally")
	@Override
	public boolean insert(Personagem t) {
		PreparedStatement stmt = null;
		int linhas = 0;

		try {
			stmt = this.conn
					.prepareStatement("insert into personagem (nome, clan, ano_nascimento) " + "values (?, ?, ?);");
			stmt.setString(1, t.getNome());
			stmt.setString(2, t.getClan());
			stmt.setInt(3, t.getAnoNascimento());

			linhas = stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DbException(e.getMessage());
		} finally {
			if (linhas > 0) {
				return true;
			} else {
				return false;
			}
		}

	}

	@Override
	public Personagem findById(int id) {
		System.out.println("findById");
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.prepareStatement("select * from personagem where id = ?;");
			stmt.setInt(1, id);

			rs = stmt.executeQuery();

			while (rs.next()) {
				Personagem p = new Personagem();
				p.setId(rs.getInt("id"));
				p.setNome(rs.getString("nome"));
				p.setClan(rs.getString("clan"));
				p.setAnoNascimento(rs.getInt("ano_nascimento"));

				return p;
			}
		} catch (SQLException e) {
			System.out.println("vish..." + e.getMessage());
			throw new DbException(e.getMessage());
		}
		return null;
	}

	@Override
	public ArrayList<Personagem> findAll() {
		System.out.println("findAll");
		Statement stmt = null;
		ResultSet rs = null;

		try {

			stmt = this.conn.createStatement();
			rs = stmt.executeQuery("select * from personagem");

			ArrayList<Personagem> personagens = new ArrayList<Personagem>();

			while (rs.next()) {
				personagens.add(new Personagem(rs.getInt("id"), rs.getString("nome"), rs.getInt("ano_nascimento"),
						rs.getString("clan")));
			}
			return personagens;
		} catch (SQLException e) {
			System.out.println("vish... " + e.getMessage());
			throw new DbException(e.getMessage());
		} catch (Exception e) {
			System.out.println("vix... " + e.getMessage());
			throw new DbException(e.getMessage());
		}
	}

	@SuppressWarnings("finally")
	@Override
	public boolean update(Personagem t) {
		PreparedStatement stmt = null;
		int linhas = 0;

		try {
			stmt = this.conn
					.prepareStatement("update personagem set " + 
			"nome= ? , clan = ? , ano_nascimento = ? where id = ?;");

			stmt.setString(1, t.getNome());
			stmt.setString(2, t.getClan());
			stmt.setInt(3, t.getAnoNascimento());
			stmt.setInt(4, t.getId());

			linhas = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DbException(e.getMessage());
		} finally {
			if (linhas > 0) {
				return true;
			} else {
				return false;
			}
		}
	}

	@Override
	public boolean delete(int id) {
		PreparedStatement stmt = null;
		int linhas = 0;

		try {
			stmt = this.conn.prepareStatement("delete from personagem where id = ?;");
			stmt.setInt(1, id);

			linhas = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		if (linhas > 0) {
			return true;
		}
		return false;

	}

}
