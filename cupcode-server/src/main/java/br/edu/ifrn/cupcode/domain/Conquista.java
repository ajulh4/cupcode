/**
 * 
 */
package br.edu.ifrn.cupcode.domain;

/**
 * @author cupCode[]
 *
 */
public class Conquista {

	private int id;
	private String nome, descricao;
	private int icon;

	public Conquista() {
	}

	public Conquista(int id, String nome, int descricao, int icon) {
		this.id = id;
		this.nome = nome;
		this.icon = icon;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getIcon() {
		return icon;
	}

	public void setIcon(int icon) {
		this.icon = icon;
	}

}
