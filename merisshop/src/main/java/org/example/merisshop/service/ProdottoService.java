package org.example.merisshop.service;

import org.example.merisshop.model.Prodotto;
import org.example.merisshop.repository.ProdottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdottoService {
    @Autowired
    private ProdottoRepository prodottoRepository;

    public Prodotto read(Long id) {return prodottoRepository.findById(id).orElseThrow(()->new RuntimeException("errore read prodotto"));}

    public Prodotto insert(Prodotto prodotto) {return prodottoRepository.save(prodotto);}

    public Prodotto update(Prodotto prodotto) {return prodottoRepository.save(prodotto);}

    public void delete(Long id) {prodottoRepository.deleteById(id);}

}
