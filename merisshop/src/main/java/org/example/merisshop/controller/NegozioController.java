package org.example.merisshop.controller;

import org.example.merisshop.model.Negozio;
import org.example.merisshop.service.NegozioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/negozio")
public class NegozioController {
    @Autowired
    private NegozioService negozioService;
    @GetMapping(value = "/read")
    public Negozio read(@RequestParam Long id) {return negozioService.read(id);}
    @PostMapping(value="/insert")
    public Negozio insert(@RequestBody Negozio negozio) {return negozioService.insert(negozio);}
    @PutMapping(value = "/update")
    public Negozio update(@RequestBody Negozio negozio) {return negozioService.update(negozio);}
    @DeleteMapping(value = "/delete")
    public void delete(@RequestParam Long id) {negozioService.delete(id);}
}
