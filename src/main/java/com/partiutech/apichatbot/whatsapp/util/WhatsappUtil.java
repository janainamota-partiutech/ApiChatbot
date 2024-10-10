package com.partiutech.apichatbot.whatsapp.util;

import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import lombok.experimental.UtilityClass;

import java.io.IOException;

import static org.apache.http.entity.ContentType.APPLICATION_JSON;


@UtilityClass
public class WhatsappUtil {

     public static HttpResponse  postarRequisicao(String conteudo) throws IOException {

        HttpRequestFactory httpRequestFactory = new NetHttpTransport().createRequestFactory();
        final String urlAPI = "https://graph.facebook.com/v20.0/463384050181203/messages";

        GenericUrl genericUrl = new GenericUrl(urlAPI);
        HttpRequest request = httpRequestFactory.buildPostRequest(genericUrl, ByteArrayContent.fromString(null, conteudo));

        request.getHeaders().setAuthorization("Bearer EAAXLmAKvZBrwBOwO6Gcom57URuolr6VWVvTXzE6NIyv5ZAtHL7WLGRl3hHuxXmIyTk6Ha7ozAVWZBsRoOdDGTW2lqTZAj4bRZAr2SbcrchCSzEwPhD5NAzBMgQoKrHs0OJ08ZCY5bsNEYlTE7kgbTUZCQmq8QpZAyF1hmOlOUPvMjzqNP9surwkFSVcm4SZBe7EGqUwZDZD");

        HttpHeaders httpHeaders = request.getHeaders();
        request.getHeaders().setContentType(APPLICATION_JSON.toString());
        return request.execute();
    }
}