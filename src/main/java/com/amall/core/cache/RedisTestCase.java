package com.amall.core.cache;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public final class RedisTestCase
{
	private static final String DEFAULT_ID = "REDIS";

	private static RedisCache cache;

	@BeforeClass
	public static void newCache()
	{
		cache = new RedisCache(DEFAULT_ID);
	}

	@Test
	public void shouldDemonstrateCopiesAreEqual()
	{
		for (int i = 0; i < 1000; i++)
		{
			cache.putObject(i, i);
			assertEquals(i, cache.getObject(i));
		}
	}

	@Test
	public void shouldRemoveItemOnDemand()
	{
		cache.putObject(0, 0);
		assertNotNull(cache.getObject(0));
		cache.removeObject(0);
		assertNull(cache.getObject(0));
	}

	@Test
	public void shouldFlushAllItemsOnDemand()
	{
		for (int i = 0; i < 5; i++)
		{
			cache.putObject(i, i);
		}
		assertNotNull(cache.getObject(0));
		assertNotNull(cache.getObject(4));
		cache.clear();
		assertNull(cache.getObject(0));
		assertNull(cache.getObject(4));
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotCreateCache()
	{
		cache = new RedisCache(null);
	}

	@Test
	public void shouldVerifyCacheId()
	{
		assertEquals("REDIS", cache.getId());
	}

	@Test
	public void shouldVerifyToString()
	{
		assertEquals("Redis {REDIS}", cache.toString());
	}
}
