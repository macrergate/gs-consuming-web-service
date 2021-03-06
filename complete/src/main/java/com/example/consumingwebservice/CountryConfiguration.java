
package com.example.consumingwebservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class CountryConfiguration {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in
		// pom.xml
		marshaller.setContextPath("com.example.consumingwebservice.wsdl");
		return marshaller;
	}

	@Bean
	public GetCursOnDateClient cursOnDateClient(Jaxb2Marshaller marshaller) {
		GetCursOnDateClient client = new GetCursOnDateClient();
		client.setDefaultUri("http://cbr.ru/DailyInfoWebServ/DailyInfo.asmx");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

}
