package br.edu.ifrn.cupcode.testes;

import java.util.Iterator;
import java.util.List;

import br.edu.ifrn.cupcode.data.DificuldadeDAO;
import br.edu.ifrn.cupcode.domain.Dificuldade;

public class DificuldadeTeste {
	public static void main(String[] args) {

		DificuldadeDAO d1 = new DificuldadeDAO();

		List<Dificuldade> dificuldades = d1.buscarTodos();

		for (Dificuldade dificuldade : dificuldades) {
			System.out.println(dificuldade.getNivel());
		}

	}
}
