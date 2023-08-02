package br.com.cotiinformatica.entities;



import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "movimentacao")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Movimentacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idmovimentacao")
	private Integer idMovimentacao;
	
	@Column(name = "tipo", nullable = false)
	private Integer tipo;
	
	@Column(name = "observacoes", length = 500, nullable = false)
	private String observacoes;
	
	@Column(name = "quantidade", nullable = false)
	private Integer quantidade;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "datamovimentacao", nullable = false)
	private Date dataMovimentacao;
	
	@ManyToOne //Muita movimentações para 1 produto
	@JoinColumn(name = "idproduto") //chave estrangeira
	private Produto produto;

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Integer getIdProduto() {
		return idMovimentacao;
	}

	public void setIdProduto(Integer idProduto) {
		this.idMovimentacao = idProduto;
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

	public Date getDataMovimentacao() {
		return dataMovimentacao;
	}

	public void setDataMovimentacao(Date dataMovimentacao) {
		this.dataMovimentacao = dataMovimentacao;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public String toString() {
		return "Movimentacao [idMovimentacao=" + idMovimentacao + ", tipo=" + tipo + ", observacoes=" + observacoes
				+ ", quantidade=" + quantidade + ", dataMovimentacao=" + dataMovimentacao + ", produto=" + produto
				+ "]";
	}

	public Movimentacao(Integer idProduto, Integer tipo, String observacoes, Integer quantidade, Date dataMovimentacao,
			Produto produto) {
		super();
		this.idMovimentacao = idProduto;
		this.tipo = tipo;
		this.observacoes = observacoes;
		this.quantidade = quantidade;
		this.dataMovimentacao = dataMovimentacao;
		this.produto = produto;
	}
	
	public Movimentacao() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
