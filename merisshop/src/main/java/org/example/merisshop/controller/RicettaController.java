package org.example.merisshop.controller;

import org.example.merisshop.model.Ricetta;
import org.example.merisshop.service.RicettaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ricetta")
@CrossOrigin(origins = "http://localhost:4200")
public class RicettaController {
    @Autowired
    private RicettaService ricettaService;
    @GetMapping("/read")
    public Ricetta read(@RequestParam Long id) {return ricettaService.read(id);}
    @PostMapping("/insert")
    public Ricetta insert(@RequestBody Ricetta ricetta) {return ricettaService.insert(ricetta);}
    @PutMapping("/update")
    public Ricetta update(@RequestBody Ricetta ricetta) {return ricettaService.update(ricetta);}
    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id) {ricettaService.delete(id);}
    @GetMapping("/byIniz")
    public List<Ricetta> findByIniziale(@RequestParam String c) {return ricettaService.ricettaByIniziale(c);}
    @GetMapping("/all")
    public List<Ricetta> getAll() {return ricettaService.getAll();}
}
