package br.edu.ifrn.cupcode.testes;

import java.util.List;

import br.edu.ifrn.cupcode.data.EstudanteDAO;
import br.edu.ifrn.cupcode.domain.Estudante;

public class TesteRanking {

	public static void main(String[] args) {

		EstudanteDAO objEstudanteDao = new EstudanteDAO();
		List<Estudante> ranking = objEstudanteDao.buscarTodos();

		int posicao = 1;
		for (Estudante estudante : ranking) {

			StringBuilder sb = new StringBuilder();

			sb.append("Nome = ");
			sb.append(estudante.getNome());
			sb.append("\t");

			sb.append("Pontuacao = ");
			sb.append(estudante.getPontuacao());
			sb.append("\t");

			sb.append("Posicao = ");
			sb.append(posicao);

			System.out.println(sb.toString());
			posicao++;

		}

	}

}
