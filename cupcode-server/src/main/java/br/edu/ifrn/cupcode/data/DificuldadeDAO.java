package br.edu.ifrn.cupcode.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.edu.ifrn.cupcode.domain.Dificuldade;
import br.edu.ifrn.cupcode.domain.ModoQuestao;

public class DificuldadeDAO {
	
	public Dificuldade buscarDificuldade(int id) {

		Dificuldade dificuldade = null;
		String query = "SELECT id_dificuldade, nivel FROM dificuldade_questao WHERE id_dificuldade = ?;";
		Connection conexao = Conexao.conectar();

		try {

			PreparedStatement comando = conexao.prepareStatement(query);

			comando.setInt(1, id);

			ResultSet resultSet = comando.executeQuery();

			if (resultSet.next()) {

				dificuldade = new Dificuldade();
				dificuldade.setId(resultSet.getInt("id_dificuldade"));
				dificuldade.setNivel(resultSet.getString("nivel"));

			}

		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}

		finally {

			Conexao.desconectar();

		}

		return dificuldade;

	}

	public List<Dificuldade> buscarTodos() {
		
		List<Dificuldade> dificuldades = new ArrayList<Dificuldade>();

		String query = "SELECT id_dificuldade, nivel FROM dificuldade_questao;";

		Connection conexao = Conexao.conectar();

		try {

			PreparedStatement comando = conexao.prepareStatement(query);

			ResultSet resultSet = comando.executeQuery();

			while (resultSet.next()) {

				Dificuldade d1 = new Dificuldade();
				d1.setId(resultSet.getInt("id_dificuldade"));
				d1.setNivel(resultSet.getString("nivel"));
				dificuldades.add(d1);
				
			}

		} catch (SQLException e) {

			System.out.println(e.getMessage());
			
		}

		finally {
			
			Conexao.desconectar();
			
		}

		return dificuldades;
		
	}
	
}