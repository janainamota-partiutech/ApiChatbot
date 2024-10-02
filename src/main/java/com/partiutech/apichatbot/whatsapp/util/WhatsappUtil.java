package com.partiutech.apichatbot.whatsapp.util;

import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import lombok.experimental.UtilityClass;

import java.io.IOException;

import static org.apache.http.entity.ContentType.APPLICATION_JSON;
import static sun.security.util.KnownOIDs.ContentType;

@UtilityClass
public class WhatsappUtil {

    public HttpResponse postarRequisicao(String conteudo) throws IOException {

        HttpRequestFactory httpRequestFactory = new NetHttpTransport().createRequestFactory();
        final String urlAPI = "https://graph.facebook.com/v20.0/463384050181203/messages";

        GenericUrl genericUrl = new GenericUrl(urlAPI);
        HttpRequest request = httpRequestFactory.buildPostRequest(genericUrl, ByteArrayContent.fromString(null, conteudo));

        request.getHeaders().setAuthorization("Bearer EAAXLmAKvZBrwBO8rnSwMUVres74ntspxwx9ZAdbWyEGAtZBl3ZCvwgGGSInaW6zDG8f3gGpeW8nMe4kZAM0pUZCSZCh98DMPGXYde1kWLEO9NYGz053CZA47Ib9fmBovbKrYruimL2nzIBjal0glhuH9tcZAVWDYtgaab57viJerwAZB8ZCTkQ5lK6wdJcr16QxvJxZCZB5slHjQFDF9HUGJkzPt3kFXrhTYZD");

        HttpHeaders httpHeaders = request.getHeaders();
        request.getHeaders().setContentType(APPLICATION_JSON.toString());
        return request.execute();
    }
}