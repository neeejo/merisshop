package org.example.merisshop.service;

import org.example.merisshop.model.Ingrediente;
import org.example.merisshop.repository.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredienteService {
    @Autowired
    private IngredienteRepository ingredienteRepository;

    public Ingrediente read(Long id) {return ingredienteRepository.findById(id).orElseThrow(()->new RuntimeException("errore read ingrediente"));}

    public Ingrediente insert(Ingrediente ingrediente) {return ingredienteRepository.save(ingrediente);}

    public Ingrediente update(Ingrediente ingrediente) {return ingredienteRepository.save(ingrediente);}

    public void delete(Long id) {ingredienteRepository.deleteById(id);}

    public List<Ingrediente> getall() {return ingredienteRepository.findAll();}
}
