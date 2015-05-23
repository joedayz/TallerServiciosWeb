package clientedemows;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import clientedemows.wsdl.GetCountryResponse;

public class Application {

	public static void main(String[] args) {

		
		ApplicationContext ctx = SpringApplication.run(CountryConfiguration.class, args);

		CountryClient countryClient = ctx.getBean(CountryClient.class);

		String countryName = "Spain";

		GetCountryResponse countryData = countryClient.getCountryData(countryName);
		
		countryClient.printResponse(countryData);

	}

}
