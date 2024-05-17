package com.workspace.common.models;

public class DynamicParameter<T> {

	private Class<T> type;
	private T value;
	public Class<T> getType() {
		return type;
	}
	
	
	public T getValue() {
		return value;
	}
	
}
