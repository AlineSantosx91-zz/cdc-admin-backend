package br.com.cdcadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cdcadmin.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{

}
