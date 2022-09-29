package br.edu.ifrn.cupcode.testes;

import java.util.List;

import br.edu.ifrn.cupcode.data.ConquistasDAO;
import br.edu.ifrn.cupcode.domain.Conquista;

public class ConquistaTeste {

	public static void main(String[] args) {
		
		ConquistasDAO conquistaDAO = new ConquistasDAO();
		
		List<Conquista> conquistas = conquistaDAO.buscarTodos();

		for (Conquista conquista : conquistas) {
			System.out.println(conquista.getNome());
		}

	}
}
