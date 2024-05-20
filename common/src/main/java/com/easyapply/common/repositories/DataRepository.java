package com.easyapply.common.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.procedure.ProcedureCall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.scheduling.annotation.Async;

import com.easyapply.common.models.DynamicParameter;

import jakarta.persistence.ParameterMode;


public class DataRepository<T, ID> extends SimpleJpaRepository<T, ID> implements JpaRepository<T, ID> {




	EntityManager entityManager;
	public DataRepository(Class<T> object ,EntityManager entityManager)
	{
		super(object, entityManager);
		this.entityManager = entityManager;
	}

	public <Out> CompletableFuture<List<Out>> getAllData(String storedProcedure,HashMap<String, DynamicParameter<?>> dp, Class<?> entityClass)
	{
		Session session = entityManager.unwrap(Session.class);
		ProcedureCall call =session.createStoredProcedureCall(storedProcedure);
		call.addSynchronizedEntityClass(entityClass);
		for(String element : dp.keySet())
		{

			call.registerParameter(element, dp.get(element).getType(), ParameterMode.IN);
			call.setParameter(element, dp.get(element).getValue());
			
		}
		
		
		return CompletableFuture.completedFuture((List<Out>)call.getResultList());
		

	}

	@Async
	public <Out> CompletableFuture<Out> getByParams(String storedProcedure,HashMap<String, DynamicParameter<?>> dp, Class<?> entityClass)
	{
		Session session = entityManager.unwrap(Session.class);
		ProcedureCall call =session.createStoredProcedureCall(storedProcedure);
		call.addSynchronizedEntityClass(entityClass);
		for(String element : dp.keySet())
		{

			call.registerParameter(element, dp.get(element).getType(), ParameterMode.IN);
			call.setParameter(element, dp.get(element).getValue());
		}
		
		
		return CompletableFuture.completedFuture((Out)call.getSingleResult());

	}
	
	@Async
	public CompletableFuture<Integer> executeStoredprocedure(String storedProcedure, HashMap<String, DynamicParameter<?>> dp)
	{
				Session session = entityManager.unwrap(Session.class);
				ProcedureCall call =session.createStoredProcedureCall(storedProcedure);
				call.addSynchronizedEntityClass(Integer.class);
					
				for(String element : dp.keySet())
				{
		
					call.registerParameter(element, dp.get(element).getType(), ParameterMode.IN);
					call.setParameter(element, dp.get(element).getValue());
				}
				
				
				return CompletableFuture.completedFuture((Integer)call.getOutputParameterValue("ResultCount"));
	}
	
	
}
