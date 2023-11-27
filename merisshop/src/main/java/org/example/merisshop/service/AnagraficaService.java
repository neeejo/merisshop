package org.example.merisshop.service;

import org.example.merisshop.model.Anagrafica;
import org.example.merisshop.model.User;
import org.example.merisshop.repository.AnagraficaRepository;
import org.example.merisshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnagraficaService {
    @Autowired
    private AnagraficaRepository anagraficaRepository;
    @Autowired
    private UserRepository userRepository;

    public Anagrafica read(Long id) {return anagraficaRepository.findById(id).orElseThrow(()->new RuntimeException("errore read anagrafica"));}

    public Anagrafica insert(Anagrafica anagrafica) {return anagraficaRepository.save(anagrafica);}

    public Anagrafica update(Anagrafica anagrafica) {return anagraficaRepository.save(anagrafica);}

    public void delete(Long id) {anagraficaRepository.deleteById(id);}

}
