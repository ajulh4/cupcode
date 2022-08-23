package br.edu.ifrn.cupcode.data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
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

	/*
	 * @Override
	public void alterarEstudante(Estudante Estudante) {
		
		String query = "UPDATE Estudante set agencia = ?, titular = ?, saldo = ? where numero = ?;";

		Connection conexao = Conexao.conectar();

		try {

			PreparedStatement comando = conexao.prepareStatement(query);

			comando.setString(1, Estudante.getAgencia());
			comando.setString(2, Estudante.getTitular());
			comando.setDouble(3, Estudante.getSaldo());
			comando.setString(4, Estudante.getNumero());
			
			int linhasAfetadas = comando.executeUpdate();
			
			if (linhasAfetadas > 0) {
				System.out.println("Estudante atualizada com sucesso!");
			}
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}

		finally {
			Conexao.desconectar();
		}
	}

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
	public Estudante buscarEstudante(String numero) {
		
		Estudante c1 = null;
		
		String query = "SELECT agencia, numero, titular, saldo from Estudante where numero = ?;";

		Connection conexao = Conexao.conectar();

		try {

			PreparedStatement comando = conexao.prepareStatement(query);

			comando.setString(1, numero);
			
			ResultSet resultSet = comando.executeQuery();
			
			if (resultSet.next()) {
				
				c1 = new Estudante();
				c1.setAgencia(resultSet.getString("agencia"));
				c1.setNumero(resultSet.getString("numero"));
				c1.setTitular(resultSet.getString("titular"));
				c1.setSaldo(resultSet.getDouble("saldo"));
			}
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}

		finally {
			Conexao.desconectar();
		}
		
		return c1;
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
