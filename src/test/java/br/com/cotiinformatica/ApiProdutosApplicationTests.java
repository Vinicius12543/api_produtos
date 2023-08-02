package br.com.cotiinformatica;

import static org.assertj.core.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Locale;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

import br.com.cotiinformatica.dtos.MovimentacoesPostRequestDTO;
import br.com.cotiinformatica.dtos.MovimentacoesResponseDTO;
import br.com.cotiinformatica.dtos.ProdutosPostRequestDTO;
import br.com.cotiinformatica.dtos.ProdutosPutRequestDTO;
import br.com.cotiinformatica.dtos.ProdutosResponseDTO;
import br.com.cotiinformatica.entities.Produto;

@SpringBootTest
@AutoConfigureMockMvc // habilitando a biblioteca MockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ApiProdutosApplicationTests {

	@Autowired // executar as requisições para a API
	private MockMvc mockMvc;

	@Autowired // serializar e deserializar os dados para API
	private ObjectMapper mapper;

	private static Produto produto;

	private Locale Locale;

	@Test
	@Order(1)
	public void testProdutosPost() throws Exception {

		Faker faker = new Faker(Locale = new Locale("pt_BR"));

		ProdutosPostRequestDTO dto = new ProdutosPostRequestDTO();
		dto.setNome(faker.commerce().productName());
		dto.setDescricao(faker.commerce().productName());
		dto.setPreco(Double.valueOf(faker.number().randomNumber(4, false)));
		dto.setQuantidade(faker.number().randomDigit());

		MvcResult result = mockMvc.perform(post("/api/produtos") // endpoint
				.contentType("application/json") // formato dos dados
				.content(mapper.writeValueAsString(dto))) // enviando os dados
				.andExpect(status().isCreated()) // resultado esperado pelo teste
				.andReturn(); // capturando o retorno dos dados da API

		// capturando os dados do produto retornado pela API após o cadastro
		String responseBody = result.getResponse().getContentAsString();
		ProdutosResponseDTO response = mapper.readValue(responseBody, ProdutosResponseDTO.class);

		// capturando o id do produto
		produto = response.getProduto();
	}

	@Test
	@Order(2)
	public void testProdutosPut() throws Exception {

		Faker faker = new Faker(Locale = new Locale("pt_BR"));

		ProdutosPutRequestDTO dto = new ProdutosPutRequestDTO();
		dto.setIdProduto(produto.getIdProduto());
		dto.setNome(faker.commerce().productName());
		dto.setDescricao(faker.commerce().productName());
		dto.setPreco(Double.valueOf(faker.number().randomNumber(4, false)));
		dto.setQuantidade(faker.number().randomDigit());

		mockMvc.perform(put("/api/produtos") // endpoint
				.contentType("application/json") // formato dos dados
				.content(mapper.writeValueAsString(dto))) // enviando os dados
				.andExpect(status().isOk()); // resultado esperado pelo teste
	}

	@Test
	@Order(3)
	public void testProdutosGetAll() throws Exception {
		mockMvc.perform(get("/api/produtos")) // endpoint
				.andExpect(status().isOk()); // resultado esperado pelo teste
	}

	@Test
	@Order(4)
	public void testProdutosGetById() throws Exception {
		mockMvc.perform(get("/api/produtos/" + produto.getIdProduto())) // endpoint
				.andExpect(status().isOk()); // resultado esperado pelo teste
	}

	@Test
	@Order(5)
	public void testMovimentacoesPost() throws Exception{

		MovimentacoesPostRequestDTO dto = new MovimentacoesPostRequestDTO();
		dto.setIdProduto(produto.getIdProduto());
		dto.setDataMovimentacao("2023-07-10");
		dto.setObservacoes("Movimentação teste");
		dto.setQuantidade(10);
		dto.setTipo(1);

		mockMvc.perform(post("/api/movimentacoes") // endpoint
				.contentType("application/json") // formato dos dados
				.content(mapper.writeValueAsString(dto))) // enviando os dados
				.andExpect(status().isCreated()); // resultado esperado pelo teste
	}

	@Test
	@Order(6)
	public void testMovimentacoesGetAll() throws Exception {
		mockMvc.perform(get("/api/movimentacoes/2023-07-01/2023-07-30")) // endpoint
				.andExpect(status().isOk()); // resultado esperado pelo teste
	}

	@Test
	@Order(7)
	public void testProdutosDelete() throws Exception {
		
		testProdutosPost();
		
		mockMvc.perform(get("/api/produtos/" + produto.getIdProduto())) // endpoint
		.andExpect(status().isOk()); // resultado esperado pelo teste
	}
}
