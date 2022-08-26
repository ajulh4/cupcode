package br.edu.ifrn.cupcode.data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import br.edu.ifrn.cupcode.domain.Estudante;

public class EstudanteDAO {
	
	public boolean inserir(Estudante estudante) {

		String query = "INSERT INTO estudante (matricula, nome, sobrenome, email, senha, data_cadastro) VALUES(?,?,?,?,?,?);";
		boolean resultado = false;
		Connection conexao = Conexao.conectar();

		try {

			PreparedStatement comando = conexao.prepareStatement(query);

			comando.setString(1, estudante.getMatricula());
			comando.setString(2, estudante.getNome());
			comando.setString(3, estudante.getSobrenome());
			comando.setString(4, estudante.getEmail());
			comando.setString(5, estudante.getSenha());
			comando.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
			
			int linhasAfetadas = comando.executeUpdate();
			
			if (linhasAfetadas > 0) {
				
				resultado = true;
				
			}
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
			
		}

		finally {
			
			Conexao.desconectar();
			
		}
		
		return resultado;
		
	}
	
	public boolean alterarPontuacao(Estudante estudante) {
		
		String query = "UPDATE estudante SET pontuacao = ? WHERE matricula = ?;";
		boolean resultado = false;
		Connection conexao = Conexao.conectar();

		try {

			PreparedStatement comando = conexao.prepareStatement(query);

			comando.setInt(1, estudante.getPontuacao());
			comando.setString(2, estudante.getMatricula());
			
			int linhasAfetadas = comando.executeUpdate();
			
			if (linhasAfetadas > 0) {
				
				resultado = true;
				
			}
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
			
		}

		finally {
			
			Conexao.desconectar();
			
		}
		
		return resultado;
		
	}
	
	public Estudante buscarEstudante(String matricula) {
		
		Estudante estudante = null;
		String query = "SELECT matricula, nome, sobrenome, email, pontuacao, foto FROM estudante WHERE matricula = ?;";
		Connection conexao = Conexao.conectar();

		try {

			PreparedStatement comando = conexao.prepareStatement(query);

			comando.setString(1, matricula);
			
			ResultSet resultSet = comando.executeQuery();
			
			if (resultSet.next()) {
				
				estudante = new Estudante();
				estudante.setMatricula(resultSet.getString("matricula"));
				estudante.setNome(resultSet.getString("nome"));
				estudante.setSobrenome(resultSet.getString("sobrenome"));
				estudante.setEmail(resultSet.getString("email"));
				estudante.setPontuacao(resultSet.getInt("pontuacao"));
				estudante.setFoto(resultSet.getInt("foto"));
				
			}
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}

		finally {
			
			Conexao.desconectar();
			
		}
		
		return estudante;
		
	}
	
	  /*
	@Override
	public void removerEstudante(String numero) {
		String query = "DELETE from Estudante where numero = ?;";

		Connection conexao = Conexao.conectar();

		try {

			PreparedStatement comando = conexao.prepareStatement(query);

			comando.setString(1, numero);
			
			int linhasAfetadas = comando.executeUpdate();
			
			if (linhasAfetadas > 0) {
				System.out.println("Estudante removida com sucesso!");
			}
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}

		finally {
			Conexao.desconectar();
		}
		
	}

	

	@Override
	public boolean verificarExistencia(String numero) {
		
		return buscarEstudante(numero) != null;
	}

	@Override
	public List<Estudante> buscarTodos() {
		List<Estudante> Estudantes = new ArrayList<Estudante>();
		
		String query = "SELECT agencia, numero, titular, saldo from Estudante;";

		Connection conexao = Conexao.conectar();

		try {

			PreparedStatement comando = conexao.prepareStatement(query);

			ResultSet resultSet = comando.executeQuery();
			
			while (resultSet.next()) {
				
				
				Estudante c1 = new Estudante();
				c1.setAgencia(resultSet.getString("agencia"));
				c1.setNumero(resultSet.getString("numero"));
				c1.setTitular(resultSet.getString("titular"));
				c1.setSaldo(resultSet.getDouble("saldo"));
				Estudantes.add(c1);
			}
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}

		finally {
			Conexao.desconectar();
		}
		
		return Estudantes;
	}
*/	
}
