package org.example.merisshop.controller;

import org.example.merisshop.model.Ingrediente;
import org.example.merisshop.service.IngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingrediente")
@CrossOrigin(origins = "http://localhost:4200")
public class IngredienteController {
    @Autowired
    private IngredienteService ingredienteService;

    @GetMapping("/read")
    public Ingrediente read(@RequestParam Long id) {return ingredienteService.read(id);}

    @PostMapping("/insert")
    public Ingrediente insert(@RequestBody Ingrediente ingrediente) {return ingredienteService.insert(ingrediente);}

    @PutMapping("/update")
    public Ingrediente update(@RequestBody Ingrediente ingrediente) {return ingredienteService.update(ingrediente);}

    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id) {ingredienteService.delete(id);}
    @GetMapping("/all")
    public List<Ingrediente> getALl() {return ingredienteService.getall();}
}
