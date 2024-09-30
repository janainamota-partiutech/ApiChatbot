package com.partiutech.apichatbot.whatsapp.service;


import com.partiutech.apichatbot.whatsapp.dto.WhatsappDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WhatsappService {
    private static final Map<Long, WhatsappDTO> whatsapp = new HashMap<>();

    public WhatsappDTO criar(WhatsappDTO whatsappDTO) {
        Long proxId = whatsapp.keySet().size() + 1L;
        whatsappDTO.setId(proxId);
        whatsapp.put(proxId, whatsappDTO);
        return whatsappDTO;
    }

    public WhatsappDTO atualizar(WhatsappDTO whatsappDTO, Long whatsappId) {
        whatsapp.put(whatsappId, whatsappDTO);
        return whatsappDTO;
    }

    public WhatsappDTO getById(Long whatsappId) {
        return whatsapp.get(whatsappId);
    }

    public List<WhatsappDTO> getAll() {
        return new ArrayList<>(whatsapp.values());
    }

    public String delete(Long whatsappId) {
        whatsapp.remove(whatsappId);
        return "Whatsapp deletado com sucesso!";
    }
}
