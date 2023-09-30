package br.inatel.labs.labjpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.inatel.labs.labjpa.repository.NotaCompraItemRepository;
import br.inatel.labs.labjpa.repository.NotaCompraRepository;
import br.inatel.labs.labjpa.entity.NotaCompra;
import br.inatel.labs.labjpa.entity.NotaCompraItem;


@Service
@Transactional
public class NotaCompraService {
	
	@Autowired
	private NotaCompraRepository ncRepository;
	
	@Autowired
	private NotaCompraItemRepository nciRepository;
	
	// NOTA COMPRA
	public NotaCompra salvar(NotaCompra nc) {
		return ncRepository.save(nc);
	}
	
	public Optional<NotaCompra> buscarNotaCompraPeloId(Long id) {
		return ncRepository.findById(id);
	}
	
	public List<NotaCompra> listarNotaCompra(){
		return ncRepository.findAll();
	}
	
	public NotaCompra buscarNotaCompraItemPeloIdComListaItem(Long id) {
		Optional<NotaCompra> nota = ncRepository.findById(id);
		if (nota.isPresent()) {
			NotaCompra notaCompra = nota.get();
			notaCompra.getListaNotaCompraItem();
			return notaCompra;
		} else {
			throw new RuntimeException("ERRO");
		}
	}

	
	// NOTA COMPRA ITEM
	public NotaCompraItem salvarNotaCompraItem(NotaCompraItem item) {
		return nciRepository.save(item);
	}
	
	public Optional<NotaCompraItem> buscarNotaCompraItemPeloId(Long id) {
		return nciRepository.findById(id);
	}
	
	public List<NotaCompraItem> listarNotaCompraItem(){
		return nciRepository.findAll();
	}
	
}
