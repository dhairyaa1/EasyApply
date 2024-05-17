package com.workspace.common.services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpService {

	private final String url;
	private final HttpClient client = HttpClient.newHttpClient();

	public HttpService(String url) {
		this.url = url;

	}

	
	public <T, O> O post(T object) throws Exception {
		ObjectMapper mapper = new ObjectMapper();

		HttpRequest request = HttpRequest.newBuilder(URI.create(url)).header("", "")
				.POST(HttpRequest.BodyPublishers.ofString( mapper.writeValueAsString(object))).build();

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response);
		O output ;
		
		output = mapper.readValue(response.body(), mapper.constructType(new TypeReference<O>() {}));
		return output ;
	}
}
