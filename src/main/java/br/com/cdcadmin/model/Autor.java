package br.com.cdcadmin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private String email;
	private String senha;

	private Autor() {
		super();
	}

	private Autor(Autor autor) {
		this.nome = autor.getNome();
		this.email = autor.getEmail();
		this.senha = autor.getSenha();
	}

	public static Autor of(Autor autor) {
		return new Autor(autor);
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

}
