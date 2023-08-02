package br.com.cotiinformatica.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.dtos.ProdutosPostRequestDTO;
import br.com.cotiinformatica.dtos.ProdutosPutRequestDTO;
import br.com.cotiinformatica.dtos.ProdutosResponseDTO;
import br.com.cotiinformatica.entities.Produto;
import br.com.cotiinformatica.repositories.ProdutoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/produtos")
public class ProdutosController {

	@Autowired
	private ProdutoRepository produtoRepository;

	@PostMapping
	public ResponseEntity<ProdutosResponseDTO> post(@RequestBody @Valid ProdutosPostRequestDTO dto) {

		ProdutosResponseDTO response = new ProdutosResponseDTO();

		try {

			Produto produto = new Produto();
			produto.setNome(dto.getNome());
			produto.setDescricao(dto.getDescricao());
			produto.setPreco(dto.getPreco());
			produto.setQuantidade(dto.getQuantidade());

			produtoRepository.save(produto);

			response.setStatus(HttpStatus.CREATED);
			response.setMensagem("Produto cadastrado com sucesso");
			response.setProduto(produto);

		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMensagem(e.getMessage());
		}

		return ResponseEntity.status(response.getStatus().value()).body(response);

	}

	@PutMapping
	public ResponseEntity<ProdutosResponseDTO> put(@RequestBody @Valid ProdutosPutRequestDTO dto) {

		ProdutosResponseDTO response = new ProdutosResponseDTO();

		try {
			Optional<Produto> produto = produtoRepository.findById(dto.getIdProduto());
			// verificando se o produto não existe
			if (produto.isEmpty()) {

				response.setStatus(HttpStatus.BAD_REQUEST);
				response.setMensagem("Produto não encontrado. Verifique o ID informado.");
			} else {
				// alternar os dados do produto
				Produto item = produto.get();
				item.setNome(dto.getNome());
				item.setDescricao(dto.getDescricao());
				item.setPreco(dto.getPreco());
				item.setQuantidade(dto.getQuantidade());

				produtoRepository.save(item);

				response.setStatus(HttpStatus.OK);
				response.setMensagem("Produto alterado com sucesso");
				response.setProduto(item);

			}

		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMensagem(e.getMessage());
		}

		return ResponseEntity.status(response.getStatus().value()).body(response);

	}

	@DeleteMapping("{idProduto}")
	public ResponseEntity<ProdutosResponseDTO> delete(@PathVariable("idProduto") Integer idProduto) {

		ProdutosResponseDTO response = new ProdutosResponseDTO();

		try {

			Optional<Produto> produto = produtoRepository.findById(idProduto);

			if (produto.isPresent()) {

				produtoRepository.delete(produto.get());

				response.setStatus(HttpStatus.OK);
				response.setMensagem("Produto excluído com sucesso");
				response.setProduto(produto.get());
			} else {
				response.setStatus(HttpStatus.BAD_REQUEST);
				response.setMensagem("Produto não encontrado. Verifique o ID inserido.");

			}

		} catch (Exception e) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMensagem(e.getMessage());
		}

		return ResponseEntity.status(response.getStatus().value()).body(response);
	}

	@GetMapping
	public ResponseEntity<List<Produto>> getAll() {

		try {

			// consultar todos os produtos cadastrados
			List<Produto> produtos = produtoRepository.findAll();

			if (produtos.size() > 0) {
				return ResponseEntity.status(200).body(produtos);
			} else {
				return ResponseEntity.status(204).body(null);
			}

		} catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}

	}

	@GetMapping("{idProduto}")
	public ResponseEntity<Produto> getById(@PathVariable("idProduto") Integer idProduto) {

		try {

			Optional<Produto> produto = produtoRepository.findById(idProduto);
			// verificando se o produto foi encontrado
			if (produto.isPresent()) {
				// HTTP STATUS 200 (OK)
				return ResponseEntity.status(200).body(produto.get());

			} else {
				// HTTP STATUS 204 (NO CONTENT)
				return ResponseEntity.status(204).body(null);
			}

		} catch (Exception e) {
			return ResponseEntity.status(500).body(null);

		}

	}

}
