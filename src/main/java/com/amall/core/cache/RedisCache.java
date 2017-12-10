package com.amall.core.cache;

import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;

import org.apache.ibatis.cache.Cache;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public final class RedisCache implements Cache
{

	private final ReadWriteLock readWriteLock = new DummyReadWriteLock();

	private String id;

	private static JedisPool pool;

	public RedisCache(final String id)
	{
		if (id == null)
		{
			throw new IllegalArgumentException("Cache instances require an ID");
		}
		this.id = id;
		RedisConfig redisConfig = RedisConfigurationBuilder.getInstance().parseConfiguration();
		
		pool = new JedisPool(redisConfig, redisConfig.getHost(), redisConfig.getPort(),
				redisConfig.getConnectionTimeout(), redisConfig.getSoTimeout(), redisConfig.getPassword(),
				redisConfig.getDatabase(), redisConfig.getClientName());
	}

	private Object execute(RedisCallback callback)
	{
		Jedis jedis = pool.getResource();
		try
		{
			return callback.doWithRedis(jedis);
		} finally
		{
			jedis.close();
		}
	}

	@Override
	public String getId()
	{
		return this.id;
	}

	@Override
	public int getSize()
	{
		return (Integer) execute(new RedisCallback()
		{
			@Override
			public Object doWithRedis(Jedis jedis)
			{
				Map<byte[], byte[]> result = jedis.hgetAll(id.toString().getBytes());
				return result.size();
			}
		});
	}

	@Override
	public void putObject(final Object key, final Object value)
	{
		execute(new RedisCallback()
		{
			@Override
			public Object doWithRedis(Jedis jedis)
			{
				jedis.hset(id.toString().getBytes(), key.toString().getBytes(), SerializeUtil.serialize(value));
				return null;
			}
		});
	}

	@Override
	public Object getObject(final Object key)
	{
		return execute(new RedisCallback()
		{
			@Override
			public Object doWithRedis(Jedis jedis)
			{
				return SerializeUtil.unserialize(jedis.hget(id.toString().getBytes(), key.toString().getBytes()));
			}
		});
	}

	@Override
	public Object removeObject(final Object key)
	{
		return execute(new RedisCallback()
		{
			@Override
			public Object doWithRedis(Jedis jedis)
			{
				return jedis.hdel(id.toString(), key.toString());
			}
		});
	}

	@Override
	public void clear()
	{
		execute(new RedisCallback()
		{
			@Override
			public Object doWithRedis(Jedis jedis)
			{
				jedis.del(id.toString());
				return null;
			}
		});

	}

	@Override
	public ReadWriteLock getReadWriteLock()
	{
		return readWriteLock;
	}

	@Override
	public String toString()
	{
		return "Redis {" + id + "}";
	}

}