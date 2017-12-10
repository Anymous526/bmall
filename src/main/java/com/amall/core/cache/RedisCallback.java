package com.amall.core.cache;

import redis.clients.jedis.Jedis;

public interface RedisCallback
{
	Object doWithRedis(Jedis jedis);
}
