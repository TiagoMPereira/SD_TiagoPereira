package br.inatel.labs.labjpa;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.inatel.labs.labjpa.entity.NotaCompra;
import br.inatel.labs.labjpa.entity.NotaCompraItem;
import br.inatel.labs.labjpa.service.NotaCompraService;

@SpringBootTest
public class LoadingDemo {

	@Autowired
	private NotaCompraService service;
	
	@Test
	public void demoEagerLoading() {
		try {
			NotaCompraItem item = service.buscarNotaCompraItemPeloId((long) 1);
			
			LocalDate dataEmissao = item.getNotaCompra().getDataEmissao();
			
			System.out.println(dataEmissao);
			
			System.out.println("Aconteceu carregamento Eager"); // Acontece para relacionamentos quando o oposto é 1
			
			
		}catch (Exception e){
			e.printStackTrace();
			
		}
	}
	
	@Test
	public void demoLazyLoading() {
		try {
			NotaCompra nota = service.buscarNotaCompraPeloId((long) 1);
			
			List<NotaCompraItem> listaNotaCompraItem = nota.getListaNotaCompraItem();
			int numeroItens = listaNotaCompraItem.size();
			
			System.out.println(numeroItens);
			
			 // Acontece para relacionamentos quando o oposto é * (many
			// Cria uma proxy dos muitos objetos relacionados com a nota
			
		}catch (Exception e){
			System.out.println("Ocorreu o LAZY loading, como a lista é uma proxy não há size");
			e.printStackTrace();
			
		}
	}
	
	@Test
	public void demoPlanejandoConsulta() {
		try {
			NotaCompra nota = service.buscarNotaCompraItemPeloIdComListaItem((long) 1);
			
			List<NotaCompraItem> listaNotaCompraItem = nota.getListaNotaCompraItem();
			int numeroItens = listaNotaCompraItem.size();
			
			System.out.println(numeroItens);
			
			// Consegue retornar o size pois foi forçado o carregamento dos objetos com o .size() na service
			
		}catch (Exception e){
			System.out.println("Ocorreu o LAZY loading, como a lista é uma proxy não há size");
			e.printStackTrace();
			
		}
	}
}
