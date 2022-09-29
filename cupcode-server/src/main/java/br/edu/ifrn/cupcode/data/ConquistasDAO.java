package br.edu.ifrn.cupcode.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifrn.cupcode.domain.Conquista;

public class ConquistasDAO {

	public Conquista buscarConquista(int id) {

		Connection conexao = Conexao.conectar();
		String query = "SELECT id, nome, descricao FROM conquista WHERE id = ?;";
		Conquista conquista = null;

		try {

			PreparedStatement comando = conexao.prepareStatement(query);

			comando.setInt(1, id);

			ResultSet resultSet = comando.executeQuery();

			if (resultSet.next()) {

				conquista = new Conquista();
				conquista.setId(resultSet.getInt("id"));
				conquista.setNome(resultSet.getString("nome"));
				conquista.setDescricao(resultSet.getString("descricao"));

			}

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			Conexao.desconectar();

		}

		return conquista;

	}

	public List<Conquista> buscarTodos() {

		Connection conexao = Conexao.conectar();
		String query = "SELECT id, nome, descricao FROM conquista;";
		List<Conquista> conquistas = new ArrayList<Conquista>();

		try {

			PreparedStatement comando = conexao.prepareStatement(query);

			ResultSet resultSet = comando.executeQuery();

			while (resultSet.next()) {

				Conquista conquista = new Conquista();
				conquista.setId(resultSet.getInt("id"));
				conquista.setNome(resultSet.getString("nome"));
				conquista.setDescricao(resultSet.getString("descricao"));
				conquistas.add(conquista);
			}

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			Conexao.desconectar();

		}

		return conquistas;
	}

}