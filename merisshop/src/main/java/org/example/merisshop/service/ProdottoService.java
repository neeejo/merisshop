package org.example.merisshop.service;

import org.example.merisshop.model.Prodotto;
import org.example.merisshop.repository.ProdottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ProdottoService {
    @Autowired
    private ProdottoRepository prodottoRepository;

    public Prodotto read(Long id) {return prodottoRepository.findById(id).orElseThrow(()->new RuntimeException("errore read prodotto"));}

    public Prodotto insert(Prodotto prodotto) {return prodottoRepository.save(prodotto);}

    public Prodotto update(Prodotto prodotto) {return prodottoRepository.save(prodotto);}

    public void delete(Long id) {prodottoRepository.deleteById(id);}

    public HashMap<String, Long> countTypes() {
        List<Prodotto> prodotti = prodottoRepository.findAll();
        HashMap<String, Long> typeCount = new HashMap<>();
        for(Prodotto p: prodotti) {
            if(!typeCount.containsKey(p.getTipologia())) {
                typeCount.put(p.getTipologia(), 1L);
            }else {
                Long c = typeCount.get(p.getTipologia());
                c++;
                typeCount.replace(p.getTipologia(),c);
            }
        }
        return typeCount;
    }


}
