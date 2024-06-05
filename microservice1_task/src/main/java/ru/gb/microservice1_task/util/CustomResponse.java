package ru.gb.microservice1_task.util;


import java.util.List;

import lombok.Data;

@Data
public class CustomResponse<T> {

	private int code;

	private String message;

	private List<T> responseList;

	public CustomResponse(List<T> response, CustomStatus customStatus) {
		this.code = customStatus.getCode();
		this.message = customStatus.getMessage();
		this.responseList = response;
	}
}