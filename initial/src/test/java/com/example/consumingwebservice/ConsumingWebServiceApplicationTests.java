package com.example.consumingwebservice;

import com.example.consumingwebservice.wsdl.EnumReutersValutesResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class ConsumingWebServiceApplicationTests {

	@Autowired
	GetCursOnDateClient getCursOnDateClient;

	@Test
	public void testGetReutersValutes() {
		EnumReutersValutesResponse.EnumReutersValutesResult res = getCursOnDateClient.getReutersValutes()
			.getEnumReutersValutesResult();

		Assert.assertNotNull(res);
	}
}
