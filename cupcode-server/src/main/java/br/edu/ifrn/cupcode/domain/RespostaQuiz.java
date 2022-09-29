/**
 * 
 */
package br.edu.ifrn.cupcode.domain;

/**
 * @author cupCode[]
 *
 */
public class RespostaQuiz {

	private int id, idQuestao, idAlternativaEscolhida;
	private Quiz quiz;

	public RespostaQuiz() {
	}

	public RespostaQuiz(int id, int idQuestao, int idAlternativaEscolhida, Quiz quiz) {
		this.id = id;
		this.idQuestao = idQuestao;
		this.idAlternativaEscolhida = idAlternativaEscolhida;
		this.quiz = quiz;
	}

	public int getId() {
		return id;
	}

	public int getIdQuestao() {
		return idQuestao;
	}

	public int getIdAlternativaEscolhida() {
		return idAlternativaEscolhida;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setIdQuestao(int idQuestao) {
		this.idQuestao = idQuestao;
	}

	public void setIdAlternativaEscolhida(int idAlternativaEscolhida) {
		this.idAlternativaEscolhida = idAlternativaEscolhida;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

}
