package br.com.cdcadmin.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Livro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2954194054443432215L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_livro")
	private Long id;
	
	@NotBlank
	private String titulo;
	@NotBlank
	private String preco;
	
	@NotNull
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id_autor")
	private Autor autor;
	
	private Livro() {
		super();
	}
	
	private Livro(Livro livro) {
		this.titulo = livro.getTitulo();
		this.preco = livro.getPreco();
		this.autor = livro.getAutor();
	}

	public static Livro of(Livro livro) {
		return new Livro(livro);
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getPreco() {
		return preco;
	}

	public Autor getAutor() {
		return autor;
	}
	
	
	
}
