package org.example.merisshop.service;

import org.example.merisshop.model.Ordine;
import org.example.merisshop.model.Prodotto;
import org.example.merisshop.repository.OrdineRepository;
import org.example.merisshop.repository.ProdottoRepository;
import org.hibernate.tool.schema.spi.SqlScriptException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrdineService {
    @Autowired
    private OrdineRepository ordineRepository;
    @Autowired
    private ProdottoRepository prodottoRepository;

    public Ordine read(Long id) {return ordineRepository.findById(id).orElseThrow(()->new RuntimeException("errore read ordine"));}

    public Ordine insert(Ordine ordine) {
        for(Prodotto p : ordine.getProdotti()) {
            Prodotto read = prodottoRepository.findById(p.getId()).orElseThrow(()->
                    new RuntimeException("can't find prodotto"));
            p.setNegozio(read.getNegozio());
            p.setNome(read.getNome());
            p.setTipologia(read.getTipologia());
            p.setPrezzo(read.getPrezzo());
        }

        double tot = ( ordine.getProdotti() != null && !ordine.getProdotti().isEmpty()) ?
                ordine.getProdotti()
                        .stream()
                        .mapToDouble(Prodotto::getPrezzo)
                        .sum() : 0;
        ordine.setTotale(tot);
        return ordineRepository.save(ordine);}

    public Ordine update(Ordine ordine) {return ordineRepository.save(ordine);}

    public void delete(Long id) {ordineRepository.deleteById(id);}

    public List<Ordine> findAllByProdottiTipologia(String tipologia) {
        List<Ordine> ordini = ordineRepository.findAll();
        List<Ordine> res = new ArrayList<>();
        double tot = 0;
            for (Ordine o : ordini) {
                Ordine newo = new Ordine();
                List<Prodotto> plist = new ArrayList<>();
                for (Prodotto p : o.getProdotti()) {
                    if (p.getTipologia().equalsIgnoreCase(tipologia)) {
                        plist.add(p);
                        tot += p.getPrezzo();
                    }
                }
            newo.setProdotti(plist);
            newo.setId(o.getId());
            newo.setQuantita(o.getQuantita());
            newo.setTotale(tot);
            res.add(newo);
            }
        return res;


       /* for(Ordine o : ordini) {
            Ordine ordine = new Ordine();
            List<Prodotto> prodotti = new ArrayList<>();
            double tot = 0;
            //if(o.getProdotti().stream().map(Prodotto::getTipologia).toString().equalsIgnoreCase(tipologia)) {
            for(Prodotto p : o.getProdotti()) {
                if(p.getTipologia().equalsIgnoreCase(tipologia)) {
                    prodotti.add(p);
                    tot+=p.getPrezzo();

                }
            }
            if(!prodotti.isEmpty()) {
                ordine.setOrdineID(o.getOrdineID());
                ordine.setProdotti(prodotti);
                ordine.setTotale(tot);
                ordine.setQuantita(1L);
                res.add(ordine);
            }
        }*/
        //return res;
    }

}
