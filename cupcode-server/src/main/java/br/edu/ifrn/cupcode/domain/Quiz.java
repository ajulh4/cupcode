/**
 * 
 */
package br.edu.ifrn.cupcode.domain;

/**
 * @author cupCode[]
 *
 */
public class Quiz {

	private int id;
	private Assunto assunto;
	private String titulo;

	public Quiz() {
	}

	public Quiz(int id, Assunto assunto, String titulo) {
		this.id = id;
		this.assunto = assunto;
		this.titulo = titulo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Assunto getAssunto() {
		return assunto;
	}

	public void setAssunto(Assunto assunto) {
		this.assunto = assunto;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}