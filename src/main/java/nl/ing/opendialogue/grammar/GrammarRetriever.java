package nl.ing.opendialogue.grammar;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class GrammarRetriever {

	
	/**
	 * get rules from rest api (api.parse.com)
	 * @return grammarRules
	 */
	
	public static List<GrammarRule> getGrammarRules() {
		RestTemplate restTemplate = new RestTemplate();

	
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("X-Parse-Application-Id",
				"6bhJqVKE7B5fZzDQsohh8PFBLSvq4hWelSbxP9nd");
		headers.add("X-Parse-REST-API-Key",
				"eKQ2aKFGjTbkjkoQs59vUxKrsRincnYg0J4dhh1M");

		System.out.println("HEADER VALUES" + headers.values());

		HttpEntity<String> entity = new HttpEntity<String>(headers);

		System.out.println(entity.getHeaders().size());

		ResponseEntity<GrammarResponse> response = restTemplate.exchange(
				"https://api.parse.com/1/classes/NavigationRule",
				HttpMethod.GET, entity, GrammarResponse.class);
		
		return response.getBody().getRules();
		

	}
	
	
	
	
	
	
}
