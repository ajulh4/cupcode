package br.edu.ifrn.cupcode.testes;

import br.edu.ifrn.cupcode.data.EstudanteDAO;
import br.edu.ifrn.cupcode.domain.Estudante;

public class EstudanteTeste {

	public static void main(String[] args) {

		Estudante objEstudante = new Estudante("20201114010003", "Vinicius", "Costa de Oliveira", "vinicius.grauzeriro@gmail.com", "vinil2.0");
		EstudanteDAO objEstudanteDAO = new EstudanteDAO();
		boolean resultadoCadastro = objEstudanteDAO.cadastrar(objEstudante);

		System.out.println(resultadoCadastro);

		objEstudante = objEstudanteDAO.buscar("20201114010003");
		objEstudante.setPontuacao(100);

		boolean resultadoAlteracao = objEstudanteDAO.alterarPontuacao(objEstudante);

		System.out.println(resultadoAlteracao);

	}

}
