package com.example.consumingwebservice;

import com.example.consumingwebservice.wsdl.EnumReutersValutesResponse;
import com.example.consumingwebservice.wsdl.GetReutersCursOnDateXMLResponse;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.oxm.Marshaller;

//@SpringBootApplication
public class ConsumingWebServiceApplication {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		LocalDateTime dt = LocalDate.parse("2020-09-15").atStartOfDay();

		if (args.length > 0) {
			dt = LocalDateTime.parse(args[0]);
		}

		GetCursOnDateClient cursClient = context.getBean(GetCursOnDateClient.class);

		EnumReutersValutesResponse resp1 = cursClient.getReutersValutes();

		System.out.println("resp1.getEnumReutersValutesResult() = " + resp1.getEnumReutersValutesResult());

		GetReutersCursOnDateXMLResponse resp2 = cursClient.getReutersCourseOnDate(dt);

		System.out.println("resp2.getGetReutersCursOnDateXMLResult() = " + resp2.getGetReutersCursOnDateXMLResult());

		context.close();
	}
}
