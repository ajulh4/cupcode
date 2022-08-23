package br.edu.ifrn.cupcode.testes;

import br.edu.ifrn.cupcode.data.EstudanteDAO;
import br.edu.ifrn.cupcode.domain.Estudante;

public class EstudanteTeste {

	public static void main(String[] args) {

		Estudante e1 = new Estudante("20201114010056", "José Carlos", "da Paz Silva", "pzzz.silva@gmail.com", "123abc");
		EstudanteDAO eiDao = new EstudanteDAO();
		boolean resultado = eiDao.inserir(e1);
		
		System.out.println(resultado);

	}

}
