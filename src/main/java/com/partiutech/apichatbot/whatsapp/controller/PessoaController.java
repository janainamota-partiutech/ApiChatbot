package com.partiutech.apichatbot.whatsapp.controller;

import com.partiutech.apichatbot.whatsapp.dto.PessoaDTO;
import com.partiutech.apichatbot.whatsapp.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    @ResponseBody
    public PessoaDTO criar(@RequestBody PessoaDTO pessoaDTO) {
        return pessoaService.criar(pessoaDTO);
    }

    @PutMapping("/{cpf}")
    @ResponseBody
    public PessoaDTO atualizar(@PathVariable String cpf, @RequestBody PessoaDTO pessoaDTO) {
        pessoaDTO.setCpf(cpf);
        return pessoaService.atualizar(pessoaDTO);
    }

    @GetMapping
    @ResponseBody
    public List<PessoaDTO> getAll() {
        return pessoaService.getAll();
    }

    @DeleteMapping("/{cpf}")
    @ResponseBody
    public void delete(@PathVariable String cpf) {
        pessoaService.delete(cpf);
    }
}