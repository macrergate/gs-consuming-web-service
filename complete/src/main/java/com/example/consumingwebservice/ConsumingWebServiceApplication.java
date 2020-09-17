
package com.example.consumingwebservice;

import com.example.consumingwebservice.wsdl.EnumReutersValutesResponse;
import com.example.consumingwebservice.wsdl.GetCursOnDateXMLResponse;
import com.example.consumingwebservice.wsdl.GetReutersCursOnDateXMLResponse;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConsumingWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumingWebServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup(GetCursOnDateClient cursClient) {
		return args -> {

			LocalDateTime dt = LocalDate.parse("2020-09-15").atStartOfDay();

			if (args.length > 0) {
				dt = LocalDateTime.parse(args[0]);
			}

			EnumReutersValutesResponse.EnumReutersValutesResult result = cursClient.getReutersValutes().getEnumReutersValutesResult();

			GetReutersCursOnDateXMLResponse response = cursClient.getReutersCourseOnDate(dt);
		};
	}

}
