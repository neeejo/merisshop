package org.example.merisshop.controller;

import org.example.merisshop.model.Prodotto;
import org.example.merisshop.service.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/prodotto")
public class ProdottoController {
    @Autowired
    private ProdottoService prodottoService;
    @GetMapping(value = "/read")
    public Prodotto read(@RequestParam Long id) {return prodottoService.read(id);}
    @PostMapping(value = "/insert")
    public Prodotto insert(@RequestBody Prodotto prodotto) {return prodottoService.insert(prodotto);}
    @PutMapping(value = "/update")
    public Prodotto update(@RequestBody Prodotto prodotto) {return prodottoService.update(prodotto);}
    @DeleteMapping(value = "/delete")
    public void delete(@RequestParam Long id) {prodottoService.delete(id);}
}
