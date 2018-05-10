package br.com.cdcadmin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String titulo;
	private String preco;
	
	private Livro() {
		super();
	}
	
	private Livro(Livro livro) {
		this.titulo = livro.getTitulo();
		this.preco = livro.getPreco();
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
	
	
	
}
