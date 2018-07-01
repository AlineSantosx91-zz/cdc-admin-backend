package br.com.cdcadmin.service;

import java.util.List;
import java.util.Optional;

import br.com.cdcadmin.model.Autor;
import org.springframework.beans.BeanUtils;
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

	public Optional<Livro> buscaPorId(Long id) {
		return livroRepository.findById(id);
	}
	
	public List<Livro> buscarTodos(){
		return livroRepository.findAll();
	}

	public Livro alterarLivro (Livro livroParam, Long id){

		final Optional<Livro> livro = livroRepository.findById(id);
		BeanUtils.copyProperties(livroParam, livro);

		return livroRepository.save(livroParam);
	}

	public void deletaLivro(Long id){
		livroRepository.deleteById(id);
	}

	public Autor buscarAutorDoLivro(Long id){
		final Optional<Livro> livro = livroRepository.findById(id);
		return livro.get().getAutor();
	}

}
