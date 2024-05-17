package org.workspace.common.exceptionhandling;

public class UserFriendlyException extends Exception{

	public UserFriendlyException(Exception e)
	{
		super(e);
	}
}
