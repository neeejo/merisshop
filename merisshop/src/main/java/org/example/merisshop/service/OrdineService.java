package org.example.merisshop.service;

import org.example.merisshop.model.Ordine;
import org.example.merisshop.repository.OrdineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdineService {
    @Autowired
    private OrdineRepository ordineRepository;

    public Ordine read(Long id) {return ordineRepository.findById(id).orElseThrow(()->new RuntimeException("errore read ordine"));}

    public Ordine insert(Ordine ordine) {return ordineRepository.save(ordine);}

    public Ordine update(Ordine ordine) {return ordineRepository.save(ordine);}

    public void delete(Long id) {ordineRepository.deleteById(id);}

}
