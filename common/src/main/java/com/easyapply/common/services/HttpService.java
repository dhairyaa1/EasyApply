package com.easyapply.common.services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.client.RestTemplate;

public class HttpService {

	@Autowired
	RestTemplate restTemplate;


	@Async
	public <T, O> CompletableFuture<O> post(String url, T object, Class<O> returnClass) throws Exception {
		return CompletableFuture.completedFuture ((O) restTemplate.postForObject(url, object, returnClass.getClass()));
	}
	@Async
	public < O> CompletableFuture<O> get(String url, Class<O> returnClass) throws Exception {
		return CompletableFuture.completedFuture((O) restTemplate.getForEntity(url, returnClass.getClass()).getBody());
	}
	public <T> CompletableFuture<Boolean> delete(String url, T object) throws Exception {
		 restTemplate.delete(url);
		 return CompletableFuture.completedFuture(true);
	}
}
