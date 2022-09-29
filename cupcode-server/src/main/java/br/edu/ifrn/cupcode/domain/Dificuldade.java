/**
 * 
 */
package br.edu.ifrn.cupcode.domain;

/**
 * @author cupCode[]
 *
 */
public class Dificuldade {

	private int id;
	private String nivel;

	public Dificuldade() {
	}

	public Dificuldade(int id, String nivel) {
		this.id = id;
		this.nivel = nivel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

}
