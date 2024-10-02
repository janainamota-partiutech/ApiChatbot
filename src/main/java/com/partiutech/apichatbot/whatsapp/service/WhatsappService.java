package com.partiutech.apichatbot.whatsapp.service;


import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.HttpStatusCodes;
import com.partiutech.apichatbot.whatsapp.dto.WhatsappDTO;
import com.partiutech.apichatbot.whatsapp.util.WhatsappUtil;
import jakarta.xml.ws.ResponseWrapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WhatsappService {
    private static final Map<Long, WhatsappDTO> whatsapp = new HashMap<>();

    public WhatsappDTO criar(WhatsappDTO whatsappDTO) throws Exception {
        try {
            String conteudo = "{\"messaging_product\":\"whatsapp\",\"to\":\"21964942829\",\"type\":\"template\",\"template\":{\"name\":\"hello_world\",\"language\":{\"code\":\"en_US\"}}}";
            HttpResponse httpResponse = WhatsappUtil.postarRequisicao(conteudo);
            if (!HttpStatusCodes.isSuccess(httpResponse.getStatusCode())) {
                throw new Exception("Erro ao enviar mensagem.");
            }
        } catch (HttpResponseException httpResponseException) {
            throw new Exception(httpResponseException.getMessage(), httpResponseException);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
