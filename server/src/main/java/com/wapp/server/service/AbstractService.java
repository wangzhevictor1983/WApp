package com.wapp.server.service;

import com.wapp.server.models.IModel;

public abstract class AbstractService<T> implements IService{
	private IModel inputData;
	private T result;
	public void setModel(IModel model) {
		inputData = model;
	}
	protected abstract void process();
	protected T getResult() {
		process();
		return result;
	}
}
