package org.example.merisshop.service;

import org.example.merisshop.model.Ordine;
import org.example.merisshop.model.Prodotto;
import org.example.merisshop.repository.OrdineRepository;
import org.example.merisshop.repository.ProdottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdineService {
    @Autowired
    private OrdineRepository ordineRepository;
    @Autowired
    private ProdottoRepository prodottoRepository;

    public Ordine read(Long id) {return ordineRepository.findById(id).orElseThrow(()->new RuntimeException("errore read ordine"));}

    public Ordine insert(Ordine ordine) {
        for(Prodotto p : ordine.getProdotti()) {
            Prodotto read = prodottoRepository.findById(p.getProdottoID()).orElseThrow(()->
                    new RuntimeException("can't find prodotto"));
            p.setNegozio(read.getNegozio());
            p.setNome(read.getNome());
            p.setTipologia(read.getTipologia());
            p.setPrezzo(read.getPrezzo());
        }

        double tot = ( ordine.getProdotti() != null && !ordine.getProdotti().isEmpty()) ?
                ordine.getProdotti().stream().mapToDouble(Prodotto::getPrezzo).sum() : 0;
        ordine.setTotale(tot);
        return ordineRepository.save(ordine);}

    public Ordine update(Ordine ordine) {return ordineRepository.save(ordine);}

    public void delete(Long id) {ordineRepository.deleteById(id);}

    //public Long ordersByTypes() {return null;}

}
