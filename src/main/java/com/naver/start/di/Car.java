package com.naver.start.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component // auto new car create
public class Car
{
	private Engine engine;
	private Wheel leftWheel;
	private Wheel rightWheel;

	@Autowired
	public Car(Engine engine, Wheel leftWheel, Wheel rightWheel)
	{
		this.engine = new Engine();
		this.leftWheel = leftWheel;
		this.rightWheel = rightWheel;
	}
}
