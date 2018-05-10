package br.com.cdcadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cdcadmin.model.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long>{

}
