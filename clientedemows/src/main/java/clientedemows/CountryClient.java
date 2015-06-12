package clientedemows;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import clientedemows.wsdl.Country;
import clientedemows.wsdl.GetCountryRequest;
import clientedemows.wsdl.GetCountryResponse;

public class CountryClient extends WebServiceGatewaySupport{

	
	public GetCountryResponse getCountryData(String countryName){
		
		GetCountryRequest request = new GetCountryRequest();
		request.setName(countryName);
		
		GetCountryResponse response = (GetCountryResponse) 
				getWebServiceTemplate().marshalSendAndReceive(request,
				new SoapActionCallback(
						"http://localhost:28080/ws/getCountry"));
		
		return response;
		
	}
	
	public void printResponse(GetCountryResponse response) {
		Country country = response.getCountry();
		
		System.out.println(country.getName());
		System.out.println(country.getPopulation());
		System.out.println(country.getCapital());
		System.out.println(country.getCurrency());
	}
	
	
	
	
}
