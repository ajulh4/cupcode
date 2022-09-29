package br.edu.ifrn.cupcode.testes;

import java.util.List;

import br.edu.ifrn.cupcode.data.AssuntoDAO;
import br.edu.ifrn.cupcode.domain.Assunto;

public class AssuntoTeste {

	public static void main(String[] args) {

		AssuntoDAO a1 = new AssuntoDAO();
		
		List<Assunto> assuntos = a1.buscarTodos();
		
		for (Assunto assunto : assuntos) {
			System.out.println(assunto.getId() + " " + assunto.getTitulo());
			
		}
		

	}

}
