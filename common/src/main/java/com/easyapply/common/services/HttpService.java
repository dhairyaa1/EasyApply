package com.easyapply.common.services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class HttpService {

	@Autowired
	RestTemplate restTemplate;

	
	public <T, O> O post(String url, T object, Class<O> returnClass) throws Exception {
		return (O) restTemplate.postForObject(url, object, returnClass.getClass());
	}
	public <T, O> O get(String url, T object, Class<O> returnClass) throws Exception {
		return (O) restTemplate.getForObject(url, returnClass.getClass());
	}
	public <T> void delete(String url, T object) throws Exception {
		 restTemplate.delete(url);
	}
}
