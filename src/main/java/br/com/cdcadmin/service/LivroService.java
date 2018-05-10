package br.com.cdcadmin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cdcadmin.model.Livro;
import br.com.cdcadmin.repository.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository livroRepository;
	
	public Livro adicionaLivro(Livro livro) {
		return livroRepository.save(Livro.of(livro));
	}

	public Optional<Livro> buscaPorCodigo(Long codigo) {
		return livroRepository.findById(codigo);
	}
	
	public List<Livro> buscarTodos(){
		return livroRepository.findAll();
	}

}
