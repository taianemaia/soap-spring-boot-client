package com.taianemaia.wsdlclient.clients;

import com.taianemaia.wsdlclient.wsdl.GetPaisRequest;
import com.taianemaia.wsdlclient.wsdl.GetPaisResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class PaisClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(PaisClient.class);

    public GetPaisResponse getPais(String pais) {

        GetPaisRequest request = new GetPaisRequest();
        request.setNome(pais);

        log.info("Obtendo dados sobre: " + pais);

        GetPaisResponse response = (GetPaisResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/paises", request,
                        new SoapActionCallback(
                                "http://taianemaia.com/wsdlserver/assets/GetPaisRequest"));

        return response;
    }

}