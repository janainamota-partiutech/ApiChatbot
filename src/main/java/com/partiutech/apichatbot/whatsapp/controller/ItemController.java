package com.partiutech.apichatbot.whatsapp.controller;

import com.partiutech.apichatbot.whatsapp.dto.ItemDTO;
import com.partiutech.apichatbot.whatsapp.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    @ResponseBody
    public ItemDTO criar(@RequestBody ItemDTO itemDTO) {
        return itemService.criar(itemDTO);
    }

    @PutMapping
    @ResponseBody
    public ItemDTO atualizar(@PathVariable Long id, @RequestBody ItemDTO itemDTO) {
        return itemService.atualizar(id, itemDTO);
    }

    @GetMapping
    @ResponseBody
    public List<ItemDTO> getAll() {
        return itemService.getAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }
}

