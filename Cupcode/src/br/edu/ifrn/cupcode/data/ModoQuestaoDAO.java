package br.edu.ifrn.cupcode.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifrn.cupcode.domain.ModoQuestao;

	
	public class ModoQuestaoDAO {
		public ModoQuestao buscarModoQuestao(int id) {

			ModoQuestao modoQuestao = null;
			String query = "SELECT id_modo, titulo FROM assunto WHERE id_modo = ?;";
			Connection conexao = Conexao.conectar();

			try {

				PreparedStatement comando = conexao.prepareStatement(query);

				comando.setInt(1, id);

				ResultSet resultSet = comando.executeQuery();

				if (resultSet.next()) {

					modoQuestao = new ModoQuestao();
					modoQuestao.setId(resultSet.getInt("id"));
					modoQuestao.setModo(resultSet.getString("modo"));

				}

			} catch (SQLException e) {

				System.out.println(e.getMessage());
			}

			finally {

				Conexao.desconectar();

			}

			return modoQuestao;

		}
		public List<ModoQuestao> buscarTodos() {
			
			List<ModoQuestao> modoQuestao = new ArrayList<ModoQuestao>();
			String query = "SELECT id_modo, modo FROM modo_questao;";
			Connection conexao = Conexao.conectar();

			try {

				PreparedStatement comando = conexao.prepareStatement(query);

				ResultSet resultSet = comando.executeQuery();

				while (resultSet.next()) {

					ModoQuestao d1 = new ModoQuestao();
					d1.setId(resultSet.getInt("id_modo"));
					d1.setModo(resultSet.getString("modo"));
					modoQuestao.add(d1);
					
				}

			} catch (SQLException e) {

				System.out.println(e.getMessage());
				
			}

			finally {
				
				Conexao.desconectar();
				
			}

			return modoQuestao;
			
		}
	
	}
