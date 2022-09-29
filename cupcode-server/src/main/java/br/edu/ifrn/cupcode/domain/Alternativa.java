/**
 * 
 */
package br.edu.ifrn.cupcode.domain;

/**
 * @author cupCode[]
 *
 */
public class Alternativa {

	private int id;
	private Questao questao;
	private String texto;
	private boolean respostaCerta;

	public Alternativa() {
	}

	public Alternativa(int id, Questao questao, String texto, boolean respostaCerta) {
		this.id = id;
		this.questao = questao;
		this.texto = texto;
		this.respostaCerta = respostaCerta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Questao getQuestao() {
		return questao;
	}

	public void setQuestao(Questao questao) {
		this.questao = questao;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public boolean isRespostaCerta() {
		return respostaCerta;
	}

	public void setRespostaCerta(boolean respostaCerta) {
		this.respostaCerta = respostaCerta;
	}

}
