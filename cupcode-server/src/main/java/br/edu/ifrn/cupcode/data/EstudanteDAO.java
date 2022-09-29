package br.edu.ifrn.cupcode.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifrn.cupcode.domain.Estudante;

public class EstudanteDAO {

	/*
	 * Método para cadastrar um novo usuário no banco de dados
	 * 
	 * OBS: o método recebe um objeto Estudante como parâmetro, de onde irá se
	 * extrair os dados
	 * 
	 */
	public boolean cadastrar(Estudante estudante) {

		/* Instanciação de uma classe de conexão com o banco de dados */
		Connection conexao = Conexao.conectar();

		/*
		 * Criação do formato do comando que será feito no banco de dados
		 * 
		 * OBS: Cada interrogação refere-se a um dos valores que será atribuído ao
		 * comando
		 * 
		 */
		String query = "INSERT INTO estudante (matricula, nome, sobrenome, email, senha, data_cadastro) VALUES(?,?,?,?,?,?);";

		/* Váriavel para verificar se o comando será executado com sucesso */
		boolean resultado = false;

		try {

			/*
			 * Instanciação de uma classe que prepara a query como comando executável no
			 * banco de dados
			 * 
			 */
			PreparedStatement command = conexao.prepareStatement(query);

			/*
			 * Uso do obj "command" para preparar os valores no banco de dados
			 * 
			 * OBS: a ordem dessa inserção deve ser igual a ordem que foram declaradas as
			 * colunas na variável "query"
			 * 
			 * OBS: os valores da inserção são extraídos do obj "estudante" recebido como
			 * parâmetro
			 */
			command.setString(1, estudante.getMatricula());
			command.setString(2, estudante.getNome());
			command.setString(3, estudante.getSobrenome());
			command.setString(4, estudante.getEmail());
			command.setString(5, estudante.getSenha());
			command.setTimestamp(6, new Timestamp(System.currentTimeMillis())); // Comando que pega o horário atual

			/*
			 * Após preencher toda a query com os valores do obj "estudante", é hora de
			 * executar o comando, o método "executeUpdate" é responsável por isso
			 * 
			 * OBS: o método abaixo retorna um inteiro com o número de linhas afetadas no
			 * banco de dados
			 * 
			 */
			int linhasAfetadas = command.executeUpdate();

			/*
			 * Se a quantidade de linhas afetadas for maior que 0, significa que o comando
			 * funcionou corretamente
			 * 
			 */
			if (linhasAfetadas > 0) {

				/*
				 * Quando o comando funcionar corretamente, a variável resultado recebe o valor
				 * "true"
				 * 
				 */
				resultado = true;

			}

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			/* Após todo o processo ser feito, a conexão com o banco de dados é fechada */
			Conexao.desconectar();

		}

		/*
		 * Após fechar a conexão, é retornada a variável "resultado", para saber se o
		 * estudante foi inserido ou não
		 */
		return resultado;

	}

	public boolean excluirConta(String matricula) {

		Connection conexao = Conexao.conectar();
		String query = "DELETE FROM estudante WHERE matricula = ?;";
		boolean resultado = false;

		try {

			PreparedStatement comando = conexao.prepareStatement(query);
			comando.setString(1, matricula);

			int linhasAfetadas = comando.executeUpdate();

			if (linhasAfetadas > 0) {

				resultado = true;

			}

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			Conexao.desconectar();

		}

		return resultado;

	}

	public boolean alterarPontuacao(Estudante estudante) {

		Connection conexao = Conexao.conectar();
		String query = "UPDATE estudante SET pontuacao = ? WHERE matricula = ?;";
		boolean resultado = false;

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

		} finally {

			Conexao.desconectar();

		}

		return resultado;

	}
	
	public boolean alterarSenha(Estudante estudante) {

		Connection conexao = Conexao.conectar();
		String query = "UPDATE estudante SET senha = ? WHERE matricula = ?;";
		boolean resultado = false;

		try {

			PreparedStatement comando = conexao.prepareStatement(query);

			comando.setString(1, estudante.getSenha());
			comando.setString(2, estudante.getMatricula());

			int linhasAfetadas = comando.executeUpdate();

			if (linhasAfetadas > 0) {

				resultado = true;

			}

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			Conexao.desconectar();

		}

		return resultado;

	}

	public Estudante buscar(String matricula) {

		Connection conexao = Conexao.conectar();
		String query = "SELECT matricula, nome, sobrenome, email, pontuacao, foto FROM estudante WHERE matricula = ?;";
		Estudante estudante = null;

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

		} finally {

			Conexao.desconectar();

		}

		return estudante;

	}

	public List<Estudante> buscarTodos() {

		Connection conexao = Conexao.conectar();
		String query = "SELECT matricula, nome, sobrenome, email, pontuacao, foto FROM estudante ORDER BY pontuacao DESC;";
		List<Estudante> estudantes = new ArrayList<Estudante>();

		try {

			PreparedStatement comando = conexao.prepareStatement(query);

			ResultSet resultSet = comando.executeQuery();

			while (resultSet.next()) {

				Estudante estudanteTemp = new Estudante();
				estudanteTemp.setMatricula(resultSet.getString("matricula"));
				estudanteTemp.setNome(resultSet.getString("nome"));
				estudanteTemp.setSobrenome(resultSet.getString("sobrenome"));
				estudanteTemp.setEmail(resultSet.getString("email"));
				estudanteTemp.setPontuacao(resultSet.getInt("pontuacao"));
				estudanteTemp.setFoto(resultSet.getInt("foto"));
				estudantes.add(estudanteTemp);
			}

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			Conexao.desconectar();

		}

		return estudantes;

	}

}