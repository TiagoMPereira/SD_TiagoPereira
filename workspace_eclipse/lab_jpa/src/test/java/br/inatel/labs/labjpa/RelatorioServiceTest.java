package br.inatel.labs.labjpa;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.inatel.labs.labjpa.dto.TotalCompradoPorFornecedor;
import br.inatel.labs.labjpa.service.RelatorioService;

@SpringBootTest
public class RelatorioServiceTest {

	@Autowired
	private RelatorioService service;
	
	@Test
	void test() {
		List<TotalCompradoPorFornecedor> listaDTO = service.pesquisarTotalCompraPorFornecedor();
		
		assertFalse(listaDTO.isEmpty());
		
		System.out.println("FornecedorRazaoSocial : TotalComprado");
		
		listaDTO.forEach( r -> {
			System.out.print(r.fornecedorRazaoSocial());
			System.out.print(" : ");
			System.out.println(r.totalComprado());
		}
				
		);
		
	}
	
	
}
