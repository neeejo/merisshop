package org.example.merisshop.service;

import org.example.merisshop.model.Negozio;
import org.example.merisshop.repository.NegozioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NegozioService {
    @Autowired
    private NegozioRepository negozioRepository;

    public Negozio read(Long id) {return negozioRepository.findById(id).orElseThrow(()->new RuntimeException("errore read negozio"));}

    public Negozio insert(Negozio negozio) {return negozioRepository.save(negozio);}

    public Negozio update(Negozio negozio) {return negozioRepository.save(negozio);}

    public void delete(Long id) {negozioRepository.deleteById(id);}
}
