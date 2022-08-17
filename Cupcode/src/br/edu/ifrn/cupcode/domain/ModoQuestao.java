/**
 * 
 */
package br.edu.ifrn.cupcode.domain;

/**
 * @author cupCode[]
 *
 */
public class ModoQuestao {

	private int id;
	private String modo;

	public ModoQuestao() {
	}

	public ModoQuestao(int id, String modo) {
		this.id = id;
		this.modo = modo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModo() {
		return modo;
	}

	public void setModo(String modo) {
		this.modo = modo;
	}

}
