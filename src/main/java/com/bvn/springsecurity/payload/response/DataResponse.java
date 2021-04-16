package com.bvn.springsecurity.payload.response;

public class DataResponse extends MessageResponse {
	private Object data;

	public DataResponse(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DataResponse(String message, Object data) {
		super(message);
		this.data = data;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}
