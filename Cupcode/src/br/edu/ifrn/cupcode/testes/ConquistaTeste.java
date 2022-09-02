package br.edu.ifrn.cupcode.testes;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifrn.cupcode.data.ConquistasDAO;
import br.edu.ifrn.cupcode.domain.Conquista;

public class ConquistaTeste {

	public static void main(String[] args) {
		
		ConquistasDAO conquistaDAO = new ConquistasDAO();
		
		Conquista a1 = conquistaDAO.buscarConquista(1);
		
		System.out.println(a1.getNome());
		
		List<Conquista> conquistas = new ArrayList<Conquista>();
		
		conquistas = conquistaDAO.buscarTodos();
		for (Conquista conquista : conquistas) {
			System.out.println(conquista.getNome());
		}

	}
}
