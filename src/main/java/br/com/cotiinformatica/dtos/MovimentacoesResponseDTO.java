package br.com.cotiinformatica.dtos;

import org.springframework.http.HttpStatus;

import br.com.cotiinformatica.entities.Movimentacao;
import br.com.cotiinformatica.entities.Produto;
import lombok.Data;

@Data
public class MovimentacoesResponseDTO {
	
	private HttpStatus status;
	private String mensagem;
	private Produto produto;
	private Movimentacao movimentacao;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Movimentacao getMovimentacao() {
		return movimentacao;
	}
	public void setMovimentacao(Movimentacao movimentacao) {
		this.movimentacao = movimentacao;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
	
}