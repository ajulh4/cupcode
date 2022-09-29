package br.edu.ifrn.cupcode.testes;

import br.edu.ifrn.cupcode.data.EstudanteDAO;
import br.edu.ifrn.cupcode.domain.Estudante;

public class EstudanteTeste {

	public static void main(String[] args) {

		EstudanteDAO estudanteDAO = new EstudanteDAO();

		cadastrarEstudante(new Estudante("20201114010055", "José Carlos", "da Paz Silva", "pzzz.silva@gmail.com", "123abc"));
		trocarSenha(estudanteDAO.buscar("20201114010003"), "vinnh2020");
		
		cadastrarEstudante(new Estudante("20201114010003", "Vinicius", "Costa de Oliveira", "vinicius.grauzeriro@gmail.com", "vinnh2020"));

	}

	private static void cadastrarEstudante(Estudante e) {

		boolean resultadoCadastro = new EstudanteDAO().cadastrar(e);

		System.out.println(resultadoCadastro);

	}

	public static void trocarSenha(Estudante e, String novaSenha) {

		e.setSenha(novaSenha);

		boolean resultadoAlteracao = new EstudanteDAO().alterarSenha(e);

		System.out.println(resultadoAlteracao);

	}

}
