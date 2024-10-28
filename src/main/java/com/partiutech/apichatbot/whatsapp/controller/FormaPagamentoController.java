package com.partiutech.apichatbot.whatsapp.controller;


import com.partiutech.apichatbot.whatsapp.dto.FormaPagamentoDTO;
import com.partiutech.apichatbot.whatsapp.service.FormaPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
public class FormaPagamentoController {

    @Autowired
    private FormaPagamentoService formaPagamentoService;

    @PostMapping
    @ResponseBody
    public FormaPagamentoDTO criar(@RequestBody FormaPagamentoDTO formaPagamentoDTO) {
        return formaPagamentoService.criar(formaPagamentoDTO);
    }

    @PutMapping
    @ResponseBody
    public FormaPagamentoDTO atualizar(@RequestBody Long id, @RequestBody FormaPagamentoDTO formaPagamentoDTO) {
        return formaPagamentoService.atualizar(id, formaPagamentoDTO);
    }

    @GetMapping
    @ResponseBody
    public List<FormaPagamentoDTO> getAll() {
        return formaPagamentoService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public FormaPagamentoDTO getById(@PathVariable Long id) {
        return formaPagamentoService.getById(id);
    }

    @DeleteMapping
    @ResponseBody
    public void delete(@PathVariable Long id) {
        formaPagamentoService.delete(id);
    }
}
