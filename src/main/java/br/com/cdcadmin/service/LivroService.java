package br.com.cdcadmin.service;

import java.util.List;
import java.util.Optional;

import br.com.cdcadmin.model.Autor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	public ResponseEntity<Livro>  deletaLivro(Long id){
		final Optional<Livro> livro = this.buscaPorId(id);
		if(livro == null){
			return new ResponseEntity<Livro>(HttpStatus.NOT_FOUND);
		}

		livroRepository.deleteById(id);
		return new ResponseEntity<Livro>(livro.get(), HttpStatus.NO_CONTENT);
	}

	public Autor buscarAutorDoLivro(Long id){
		final Optional<Livro> livro = livroRepository.findById(id);
		return livro.get().getAutor();
	}

}
