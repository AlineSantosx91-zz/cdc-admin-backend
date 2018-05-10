package br.com.cdcadmin.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Autor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8703569209143886086L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_autor")
	private Long id;

	private String nome;
	private String email;
	private String senha;
	
    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="autor")

	private List<Livro> livros;

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

	public List<Livro> getLivros() {
		return livros;
	}
	

}
