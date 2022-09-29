package br.edu.ifrn.cupcode.testes;

import java.util.List;


import br.edu.ifrn.cupcode.data.ModoQuestaoDAO;
import br.edu.ifrn.cupcode.domain.ModoQuestao;

public class ModoQuestaoTeste {

	public static void main(String[] args) {

		ModoQuestaoDAO d1 = new ModoQuestaoDAO();

		List<ModoQuestao> modoQuestao= d1.buscarTodos();

		for (ModoQuestao modoQuestao1 : modoQuestao) {
			System.out.println(modoQuestao1.getModo());
		}
		
	}

}
