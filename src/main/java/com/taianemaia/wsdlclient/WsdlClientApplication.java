package com.taianemaia.wsdlclient;

import com.taianemaia.wsdlclient.clients.PaisClient;
import com.taianemaia.wsdlclient.wsdl.GetPaisRequest;
import com.taianemaia.wsdlclient.wsdl.GetPaisResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//import com.taianemaia.wsdlclient.clients.PaisClient;

@SpringBootApplication
public class WsdlClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsdlClientApplication.class, args);
	}
	
	@Bean
	CommandLineRunner lookup(PaisClient quoteClient) {
		return args -> {
			String pais = "Brasil";

			GetPaisResponse response = quoteClient.getPais(pais);
			System.out.println(response.getPais().getCapital());
			System.out.println(response.getPais().getMoeda());
			System.out.println(response.getPais().getPopulacao());

			response = quoteClient.getPais("Reino Unido");
			System.out.println(response.getPais().getCapital());
			System.out.println(response.getPais().getMoeda());
			System.out.println(response.getPais().getPopulacao());
		};
	}

}
