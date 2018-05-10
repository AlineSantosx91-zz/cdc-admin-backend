package br.com.cdcadmin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cdcadmin.model.Autor;
import br.com.cdcadmin.repository.AutorRepository;

@Service
public class AutorService {
	
	@Autowired
	private AutorRepository autorRepository;
	
	public Autor adicionaAutor(Autor autor) {
		return autorRepository.save(Autor.of(autor));
	}

	public Optional<Autor> buscaPorId(Long id) {
		return autorRepository.findById(id);
	}
	
	public List<Autor> buscarTodos(){
		return autorRepository.findAll();
	}

}
