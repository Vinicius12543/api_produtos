package br.com.cotiinformatica.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.cotiinformatica.entities.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	
	@Query("SELECT p FROM Produto p ORDER BY p.nome")
	List<Produto> findAll();
	
}
