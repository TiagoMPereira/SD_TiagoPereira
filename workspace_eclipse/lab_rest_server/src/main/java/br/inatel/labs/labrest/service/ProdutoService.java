package br.inatel.labs.labrest.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.inatel.labs.labrest.model.Produto;
import jakarta.annotation.PostConstruct;

@Service
public class ProdutoService {
	
	private List<Produto> produtos = new ArrayList<>();

	@PostConstruct
	private void setup() {
		Produto p1 = new Produto(1L, "Furadeira", new BigDecimal(230.0));
		Produto p2 = new Produto(2L, "Serra", new BigDecimal(500.0));
		Produto p3 = new Produto(3L, "Parafusadeira", new BigDecimal(400.0));
		
		produtos.add(p1);
		produtos.add(p2);
		produtos.add(p3);
	}
	
	
	public List<Produto> findAll(){
		return this.produtos;
	}
	
}
