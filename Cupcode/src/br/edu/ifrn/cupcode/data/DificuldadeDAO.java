package br.edu.ifrn.cupcode.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.edu.ifrn.cupcode.domain.Dificuldade;

public class DificuldadeDAO {

	public List<Dificuldade> buscarTodos() {
		
		List<Dificuldade> dificuldades = new ArrayList<Dificuldade>();

		String query = "SELECT id_dificuldade, nivel from dificuldade_questao;";

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