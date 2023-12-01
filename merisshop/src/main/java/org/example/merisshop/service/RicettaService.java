package org.example.merisshop.service;

import org.example.merisshop.model.Ingrediente;
import org.example.merisshop.model.Ricetta;
import org.example.merisshop.repository.RicettaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RicettaService {
    @Autowired
    private RicettaRepository ricettaRepository;

    public Ricetta read(Long id) {return ricettaRepository.findById(id).orElseThrow(()->new RuntimeException("errore read ricetta"));}

    public Ricetta insert(Ricetta ricetta) {return ricettaRepository.save(ricetta);}

    public Ricetta update(Ricetta ricetta) {return ricettaRepository.save(ricetta);}

    public void delete(Long id) {ricettaRepository.deleteById(id);}

    public List<Ricetta> ricettaByIniziale(String c) {
        return ricettaRepository.findAll().stream()
                .filter(ricetta -> ricetta.getIngredienti().stream().anyMatch(ingrediente -> ingrediente.getNome().substring(0,1).equalsIgnoreCase(c)))
                .collect(Collectors.toList());
    }
    public List<Ricetta> getAll() {return ricettaRepository.findAll();}
}
