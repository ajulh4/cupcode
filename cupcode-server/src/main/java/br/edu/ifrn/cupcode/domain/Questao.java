/**
 * 
 */
package br.edu.ifrn.cupcode.domain;

/**
 * @author cupCode[]
 *
 */
public class Questao {

	private int id;
	private Quiz quiz;
	private Dificuldade dificuldade;
	private ModoQuestao modo;
	private String enunciado;
	private int pontuacao;

	public Questao() {
	}

	public Questao(int id, Quiz quiz, Dificuldade dificuldade, ModoQuestao modo, String enunciado, int pontuacao) {
		this.id = id;
		this.quiz = quiz;
		this.dificuldade = dificuldade;
		this.modo = modo;
		this.enunciado = enunciado;
		this.pontuacao = pontuacao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public Dificuldade getDificuldade() {
		return dificuldade;
	}

	public void setDificuldade(Dificuldade dificuldade) {
		this.dificuldade = dificuldade;
	}

	public ModoQuestao getModo() {
		return modo;
	}

	public void setModo(ModoQuestao modo) {
		this.modo = modo;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

}
