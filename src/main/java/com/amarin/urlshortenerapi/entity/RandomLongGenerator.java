package com.amarin.urlshortenerapi.entity;

import java.io.Serializable;
import java.util.random.RandomGenerator;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class RandomLongGenerator implements IdentifierGenerator
{
	public static final String generatorName = "randomGenerator";
	private RandomGenerator random = RandomGenerator.getDefault();
	
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException
	{
		return random.nextLong(Long.MAX_VALUE);
	}
}
