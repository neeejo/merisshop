package org.example.merisshop.controller;

import org.example.merisshop.model.Anagrafica;
import org.example.merisshop.service.AnagraficaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/anagrafica")
public class AnagraficaController {
    @Autowired
    private AnagraficaService anagraficaService;
    @GetMapping(value = "/read")
    public Anagrafica read(@RequestParam Long id) {return anagraficaService.read(id);}
    @PostMapping(value = "/insert")
    public Anagrafica insert(@RequestBody Anagrafica anagrafica) {return anagraficaService.insert(anagrafica);}
    @PutMapping(value = "/update")
    public Anagrafica update(@RequestBody Anagrafica anagrafica) {return anagraficaService.update(anagrafica);}
    @DeleteMapping(value = "/delete")
    public void delete(@RequestParam Long id) {anagraficaService.delete(id);}
}
