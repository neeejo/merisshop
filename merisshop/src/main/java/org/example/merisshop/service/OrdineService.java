package org.example.merisshop.service;

import com.google.protobuf.MapEntry;
import org.example.merisshop.model.Ordine;
import org.example.merisshop.model.Prodotto;
import org.example.merisshop.repository.OrdineRepository;
import org.example.merisshop.repository.ProdottoRepository;
import org.hibernate.tool.schema.spi.SqlScriptException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.server.ExportException;
import java.util.*;
import java.util.stream.Collectors;

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
        /*List<Ordine> ordini = ordineRepository.findAll();
        List<Ordine> res = new ArrayList<>();
        double tot = 0;
            for (Ordine o : ordini) {
                Ordine newo = new Ordine();
                List<Prodotto> plist = new ArrayList<>();
                for (Prodotto p : o.getProdotti()) {
                    if (p.getTipologia().equalsIgnoreCase(tipologia)) {
                        plist.add(p);
                        tot += p.getPrezzo();
                        newo.setProdotti(plist);
                        newo.setId(o.getId());
                        newo.setQuantita(o.getQuantita());
                        newo.setTotale(tot);
                        res.add(newo);
                    }
                }

            }
        return res;*/
           return ordineRepository.findAll().stream()
                    .map(ordine -> {
                        Ordine newo = new Ordine();
                        newo.setId(ordine.getId());
                        newo.setQuantita(ordine.getQuantita());
                        List<Prodotto> plist = ordine.getProdotti().stream()
                            .filter(prodotto -> prodotto.getTipologia().equalsIgnoreCase(tipologia))
                            .collect(Collectors.toList());
                        double tot = plist.stream()
                                .mapToDouble(Prodotto::getPrezzo).sum();

                        newo.setProdotti(plist);
                        newo.setTotale(tot);
                        return newo;
                    })
                   .filter(ordine -> !ordine.getProdotti().isEmpty())
                   .collect(Collectors.toList());
    }

    public List<Ordine> lowerThen(Double amount) {
        return ordineRepository.findAll().stream()
                .filter(ordine -> ordine.getTotale() < amount)
                .collect(Collectors.toList());
    }
    public HashMap<String,Long> bestSeller() {
        HashMap<String, Long> sold = new HashMap<>();
        List<Ordine> ordini = ordineRepository.findAll();
        List<Prodotto> prodsInOrdini = new ArrayList<>();
        for(Ordine o : ordini) {
            for(Prodotto p : o.getProdotti()) {
                prodsInOrdini.add(p);
            }
        }
        for(Prodotto p: prodsInOrdini) {
            if(!sold.containsKey(p.getNome())) {
                sold.put(p.getNome(), 1L);
            }else {
                Long c = sold.get(p.getNome());
                c++;
                sold.replace(p.getNome(),c);
            }
        }
        Optional<Long> max = sold.values().stream().max(Long::compare);
        HashMap<String,Long> bestSeller = new HashMap<>();
        if(max.isPresent()) {
            Long mValue = max.get();
            List<String> bestKeys = sold.entrySet().stream()
                    .filter(entry -> entry.getValue().equals(mValue))
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());
            for(String s : bestKeys) {
                bestSeller.put(s,mValue);
            }
            return bestSeller;
        }else {
            throw new RuntimeException("errore lista");
        }
        /*Optional<Map.Entry<String, Long>> maxValue = sold.entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue));

        return  maxValue.orElseThrow(()->new RuntimeException("lista vuota"));*/
    }
}
