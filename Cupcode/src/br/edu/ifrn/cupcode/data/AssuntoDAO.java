package br.edu.ifrn.cupcode.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.edu.ifrn.cupcode.domain.Assunto;

public class AssuntoDAO {

	// Buscar um único assunto

	public Assunto buscarAssunto(int id) {

		Assunto assunto = null;
		String query = "SELECT id, titulo FROM assunto WHERE id = ?;";
		Connection conexao = Conexao.conectar();

		try {

			PreparedStatement comando = conexao.prepareStatement(query);

			comando.setInt(1, id);

			ResultSet resultSet = comando.executeQuery();

			if (resultSet.next()) {

				assunto = new Assunto();
				assunto.setId(resultSet.getInt("id"));
				assunto.setTitulo(resultSet.getString("titulo"));

			}

		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}

		finally {

			Conexao.desconectar();

		}

		return assunto;

	}
	// Buscar todos os assuntos

	public List<Assunto> buscarTodos() {

		List<Assunto> assuntos = new ArrayList<Assunto>();

		String query = "SELECT id, titulo from assunto;";

		Connection conexao = Conexao.conectar();

		try {

			PreparedStatement comando = conexao.prepareStatement(query);

			ResultSet resultSet = comando.executeQuery();

			while (resultSet.next()) {

				Assunto a1 = new Assunto();
				a1.setId(resultSet.getInt("id"));
				a1.setTitulo(resultSet.getString("titulo"));
				assuntos.add(a1);

			}

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		finally {

			Conexao.desconectar();

		}

		return assuntos;

	}

}
