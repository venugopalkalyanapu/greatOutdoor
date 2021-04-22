package com.cg.go.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class GrowthReportException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public GrowthReportException(String s) {
		super(s);
	}
}