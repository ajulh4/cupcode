package br.edu.ifrn.cupcode.testes;

import br.edu.ifrn.cupcode.data.EstudanteDAO;
import br.edu.ifrn.cupcode.domain.Estudante;

public class EstudanteTeste {

	public static void main(String[] args) {

		/*
		 * Inserindo novo estudante Estudante objEstudante1 = new
		 * Estudante("20201114010055", "José Carlos", "da Paz Silva", "pzzz.silva@gmail.com", "123abc");
		 * EstudanteDAO objEstudanteDAO = new EstudanteDAO();
		 * 
		 * boolean resultadoInserção = objEstudanteDAO.inserir(objEstudante1);
		 * 
		 * System.out.println(resultadoInserção);
		 */

		//Alterando a pontuação do estudante inserido
		EstudanteDAO objEstudanteDAO = new EstudanteDAO();
		Estudante objEstudante1 = objEstudanteDAO.buscarEstudante("20201114010055");
		objEstudante1.setPontuacao(12);

		boolean resultadoAlteracao = objEstudanteDAO.alterarPontuacao(objEstudante1);

		System.out.println(resultadoAlteracao);

	}

}
