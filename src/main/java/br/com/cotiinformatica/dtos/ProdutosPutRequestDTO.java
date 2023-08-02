package br.com.cotiinformatica.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProdutosPutRequestDTO {
	
	@Min(value = 1, message = "Id do produto deve ser maior ou igual a 1")
	private Integer idProduto;
	
	@Pattern(regexp = "^[A-Za-zÀ-Üà-ü0-9\\s]{8,150}$",
			message = "Por favor, informe um nome válido de 8 a 150 caracteres.")
	@NotBlank(message = "Por favor informe o nome do produto")
	private String nome;
	
	@Pattern(regexp = "^[A-Za-zÀ-Üà-ü0-9\\s]{8,500}$",
			message = "Por favor, informe uma descrição válido de 8 a 500 caracteres.")
	@NotBlank(message = "Por favor informe a descrição do produto")
	private String descricao;
	
	@Min(value = 1, message = "O preço deve ser maior que 1.")
	private Double preco;
	
	@Min(value = 1, message = "O preço deve ser maior que 1.")
	private Integer quantidade;
	
	
	
	
	
	
	
	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}



	public ProdutosPutRequestDTO(Integer idProduto, String nome, String descricao, Double preco, Integer quantidade) {
		super();
		this.idProduto = idProduto;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.quantidade = quantidade;
	}
	public ProdutosPutRequestDTO() {
		// TODO Auto-generated constructor stub
	}
}