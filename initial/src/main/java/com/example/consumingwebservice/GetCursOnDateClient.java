
package com.example.consumingwebservice;

import com.example.consumingwebservice.wsdl.EnumReutersValutes;
import com.example.consumingwebservice.wsdl.EnumReutersValutesResponse;
import com.example.consumingwebservice.wsdl.GetCursOnDateXML;
import com.example.consumingwebservice.wsdl.GetCursOnDateXMLResponse;
import com.example.consumingwebservice.wsdl.GetReutersCursOnDateXML;
import com.example.consumingwebservice.wsdl.GetReutersCursOnDateXMLResponse;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class GetCursOnDateClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(GetCursOnDateClient.class);

	public GetCursOnDateXMLResponse getCourseOnDate(LocalDateTime date) {

		GetCursOnDateXML request = new GetCursOnDateXML();
		try {
			request.setOnDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(GregorianCalendar.from(date.atZone(ZoneId.systemDefault()))));
		}
		catch (DatatypeConfigurationException e) {
			throw new RuntimeException(e);
		}

		log.info("Requesting course on date " + date);

		return (GetCursOnDateXMLResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://cbr.ru/DailyInfoWebServ/DailyInfo.asmx", request,
						new SoapActionCallback("http://web.cbr.ru/GetCursOnDateXML"));
	}

	public GetReutersCursOnDateXMLResponse getReutersCourseOnDate(LocalDateTime date) {

		GetReutersCursOnDateXML request = new GetReutersCursOnDateXML();
		try {
			request.setOnDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(GregorianCalendar.from(date.atZone(ZoneId.systemDefault()))));
		}
		catch (DatatypeConfigurationException e) {
			throw new RuntimeException(e);
		}

		log.info("Requesting course on date " + date);

		return (GetReutersCursOnDateXMLResponse) getWebServiceTemplate()
			.marshalSendAndReceive("http://cbr.ru/DailyInfoWebServ/DailyInfo.asmx", request,
				new SoapActionCallback("http://web.cbr.ru/GetReutersCursOnDateXML"));
	}

	public EnumReutersValutesResponse getReutersValutes() {
		return (EnumReutersValutesResponse)getWebServiceTemplate().marshalSendAndReceive(
			"http://cbr.ru/DailyInfoWebServ/DailyInfo.asmx",
			new EnumReutersValutes(),
			new SoapActionCallback("http://web.cbr.ru/EnumReutersValutes")
		);
	}
}
