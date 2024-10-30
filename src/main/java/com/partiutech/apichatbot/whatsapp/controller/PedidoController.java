package com.partiutech.apichatbot.whatsapp.controller;

import com.partiutech.apichatbot.whatsapp.dto.PedidoDTO;

import com.partiutech.apichatbot.whatsapp.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    @ResponseBody
    public PedidoDTO criar(@RequestBody PedidoDTO pedidoDTO){
        return pedidoService.criar(pedidoDTO);
    }

    @PutMapping
    @ResponseBody
    public PedidoDTO atualizar(@RequestBody Long id, @RequestBody PedidoDTO pedidoDTO){
        return pedidoService.atualizar(id, pedidoDTO);
    }

    @GetMapping
    @ResponseBody
    public List<PedidoDTO> getAll(){
        return pedidoService.getAll();
    }

    @DeleteMapping
    @ResponseBody
    public void delete(@PathVariable Long id){
        pedidoService.delete(id);
    }
}