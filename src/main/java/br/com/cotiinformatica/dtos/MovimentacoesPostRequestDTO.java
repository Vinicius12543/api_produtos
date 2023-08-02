package br.com.cotiinformatica.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class MovimentacoesPostRequestDTO {
	
	@Min(value = 1,  message = "Id do produto deve ser maior ou igual a 1.")
	private Integer idProduto;
	
	@Min(value  = 1, message  = "Tipo da movimentação deve ser (1) Entrada ou (2) Saída")
	@Max(value  = 2, message  = "Tipo da movimentação deve ser (1) Entrada ou (2) Saída")
	private Integer tipo;
	
	@Pattern(regexp = "^[A-Za-zÀ-Üà-ü0-9\\s]{8,500}$",
			message = "Por favor, informe uma observação válida de 8 a 500 caracteres.")
	@NotBlank(message = "Por favor, informe as observações da movimentação")
	private String observacoes;
	
	@Min(value = 1, message = "Quantidade da movimentação deve ser maior ou igual a 1.")
	private Integer quantidade;
	
	@Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}",
			message = "Informe uma data no formato 'yyyy-MM-dd'.")
	@NotBlank(message = "Por favor, informe uma data válida")
	private String dataMovimentacao;
	
	
	
	
	
	
	
	public MovimentacoesPostRequestDTO() {
		
	}
	
	public MovimentacoesPostRequestDTO(Integer idProduto, Integer tipo, String observacoes, Integer quantidade,
			String dataMovimentacao) {
		super();
		this.idProduto = idProduto;
		this.tipo = tipo;
		this.observacoes = observacoes;
		this.quantidade = quantidade;
		this.dataMovimentacao = dataMovimentacao;
	}
	
	public Integer getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}
	public Integer getTipo() {
		return tipo;
	}
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public String getDataMovimentacao() {
		return dataMovimentacao;
	}
	public void setDataMovimentacao(String dataMovimentacao) {
		this.dataMovimentacao = dataMovimentacao;
	}
	
	
}
