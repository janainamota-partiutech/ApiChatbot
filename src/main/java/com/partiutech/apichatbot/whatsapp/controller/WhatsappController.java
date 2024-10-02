package com.partiutech.apichatbot.whatsapp.controller;

import com.partiutech.apichatbot.whatsapp.dto.WhatsappDTO;
import com.partiutech.apichatbot.whatsapp.service.WhatsappService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.List;

@Controller
@RequestMapping(value = "/whatsapp", produces = MediaType.APPLICATION_JSON_VALUE)

public class WhatsappController {
    @Autowired
    private WhatsappService whatsappService;

    @PostMapping
    @ResponseBody
    public WhatsappDTO criar(@RequestBody WhatsappDTO whatsappDTO) throws Exception {
        return whatsappService.criar(whatsappDTO);
    }

    @PostMapping("/{whatsappId}")
    @ResponseBody
    public WhatsappDTO atualizar(@PathVariable("whatsappId") Long whatsappId, @RequestBody WhatsappDTO whatsappDTO) {
        return whatsappService.atualizar(whatsappDTO, whatsappId);
    }

    @GetMapping
    @ResponseBody
    public List<WhatsappDTO> getAll() {
        return whatsappService.getAll();
    }

    @DeleteMapping
    @ResponseBody
    public String delete(@PathVariable("whatsappId") Long whatsappId) {
        return whatsappService.delete(whatsappId);
    }


}
