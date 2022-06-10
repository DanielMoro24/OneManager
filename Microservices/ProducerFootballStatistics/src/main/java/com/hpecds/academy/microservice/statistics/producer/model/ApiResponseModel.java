package com.hpecds.academy.microservice.statistics.producer.model;

public class ApiResponseModel {
	private String get;
	private ParametersModel parameters;
	private String[] errors;
	private int results;
	private PagingModel paging;
	private Object[] response;

	public ApiResponseModel() {
		super();
	}

	public ApiResponseModel(String get, ParametersModel parameters, String[] errors, int results, PagingModel paging,
			Object[] response) {
		this.get = get;
		this.parameters = parameters;
		this.errors = errors;
		this.results = results;
		this.paging = paging;
		this.response = response;
	}

	public String getGet() {
		return get;
	}

	public void setGet(String get) {
		this.get = get;
	}

	public ParametersModel getParameters() {
		return parameters;
	}

	public void setParameters(ParametersModel parameters) {
		this.parameters = parameters;
	}

	public String[] getErrors() {
		return errors;
	}

	public void setErrors(String[] errors) {
		this.errors = errors;
	}

	public int getResults() {
		return results;
	}

	public void setResults(int results) {
		this.results = results;
	}

	public PagingModel getPaging() {
		return paging;
	}

	public void setPaging(PagingModel paging) {
		this.paging = paging;
	}

	public Object[] getResponse() {
		return response;
	}

	public void setResponse(Object[] response) {
		this.response = response;
	}

}
