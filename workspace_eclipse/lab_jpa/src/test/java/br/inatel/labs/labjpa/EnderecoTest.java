package br.inatel.labs.labjpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.inatel.labs.labjpa.entity.Endereco;
import br.inatel.labs.labjpa.service.EnderecoService;

@SpringBootTest
public class EnderecoTest {
	
	@Autowired
	private EnderecoService service;
	
	@Test
	public void testarUUIDGerado() {
		Endereco endereco = new Endereco();
		endereco.setRua("Rua");
		endereco.setNumero("123");
		endereco.setCidade("Pousão");
		endereco.setUf("MG");
		
		endereco = service.salvar(endereco);
		
		System.out.println(endereco);
	}

}
