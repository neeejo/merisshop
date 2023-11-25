package org.example.merisshop.controller;

import org.example.merisshop.model.Ordine;
import org.example.merisshop.service.OrdineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ordine")
public class OrdineController {
    @Autowired
    private OrdineService ordineService;
    @GetMapping(value = "/read")
    public Ordine read(@RequestParam Long id) {return ordineService.read(id);}
    @PostMapping(value = "/insert")
    public Ordine insert(@RequestBody Ordine ordine) {return ordineService.insert(ordine);}
    @PutMapping(value = "/update")
    public Ordine update(@RequestBody Ordine ordine) {return ordineService.update(ordine);}
    @DeleteMapping(value = "/delete")
    public void delete(@RequestParam Long id) {ordineService.delete(id);}
}
