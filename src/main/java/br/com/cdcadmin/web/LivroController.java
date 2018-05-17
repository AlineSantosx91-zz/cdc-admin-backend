package br.com.cdcadmin.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.cdcadmin.model.Livro;
import br.com.cdcadmin.service.LivroService;

@RestController
@RequestMapping("/livros")
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "false")
public class LivroController {

	@Autowired
	private LivroService livroService;

	@PostMapping
	public ResponseEntity<Livro> criar(@RequestBody @Valid Livro livro) {
		return ResponseEntity.status(HttpStatus.CREATED).body(livroService.adicionaLivro(livro));
	}
	
	@GetMapping("")
	public ResponseEntity<List<Livro>> buscarTodos() {
		return  new ResponseEntity<List<Livro>>(livroService.buscarTodos(), HttpStatus.OK);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Livro> buscarPeloCodigo(@PathVariable Long codigo) {
		Optional<Livro> livro = livroService.buscaPorCodigo(codigo);
		return livro.isPresent() ? ResponseEntity.ok(livro.get()) : ResponseEntity.notFound().build();
	}

}
