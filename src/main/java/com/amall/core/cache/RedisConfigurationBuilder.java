package com.amall.core.cache;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.cache.CacheException;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

public class RedisConfigurationBuilder
{
	/**
	 * This class instance.
	 */
	private static final RedisConfigurationBuilder INSTANCE = new RedisConfigurationBuilder();

	private static final String SYSTEM_PROPERTY_REDIS_PROPERTIES_FILENAME = "redis.properties.filename";

	private static final String REDIS_RESOURCE = "properties/redis.properties";

	private final String redisPropertiesFilename;

	/**
	 * Hidden constructor, this class can't be instantiated.
	 */
	private RedisConfigurationBuilder()
	{
		redisPropertiesFilename = System.getProperty(SYSTEM_PROPERTY_REDIS_PROPERTIES_FILENAME, REDIS_RESOURCE);
	}

	/**
	 * Return this class instance.
	 *
	 * @return this class instance.
	 */
	public static RedisConfigurationBuilder getInstance()
	{
		return INSTANCE;
	}

	/**
	 * Parses the Config and builds a new {@link RedisConfig}.
	 *
	 * @return the converted {@link RedisConfig}.
	 */
	public RedisConfig parseConfiguration()
	{
		return parseConfiguration(getClass().getClassLoader());
	}

	/**
	 * Parses the Config and builds a new {@link RedisConfig}.
	 *
	 * @param the
	 *            {@link ClassLoader} used to load the
	 *            {@code memcached.properties} file in classpath.
	 * @return the converted {@link RedisConfig}.
	 */
	public RedisConfig parseConfiguration(ClassLoader classLoader)
	{
		Properties config = new Properties();

		InputStream input = classLoader.getResourceAsStream(redisPropertiesFilename);
		if (input != null)
		{
			try
			{
				config.load(input);
			} catch (IOException e)
			{
				throw new RuntimeException("An error occurred while reading classpath property '"
						+ redisPropertiesFilename + "', see nested exceptions", e);
			} finally
			{
				try
				{
					input.close();
				} catch (IOException e)
				{
					// close quietly
				}
			}
		}

		RedisConfig jedisConfig = new RedisConfig();
		jedisConfig.setHost("localhost");
		setConfigProperties(config, jedisConfig);
		return jedisConfig;
	}

	/** 
	* @Title: setConfigProperties 
	* @Description: 从配置文件读取属性填写到配置属性bean
	* @param properties
	* @param config
	* @throws 
	* @author tangxiang
	* @date 2016年2月29日
	*/
	public void setConfigProperties(Properties properties, Object config)
	{
		if (properties != null)
		{
			MetaObject metaCache = SystemMetaObject.forObject(config);
			for (Map.Entry<Object, Object> entry : properties.entrySet())
			{
				String name = (String) entry.getKey();
				String value = (String) entry.getValue();
				if (metaCache.hasSetter(name))
				{
					Class<?> type = metaCache.getSetterType(name);
					if (String.class == type)
					{
						metaCache.setValue(name, value);
					} else if (int.class == type || Integer.class == type)
					{
						metaCache.setValue(name, Integer.valueOf(value));
					} else if (long.class == type || Long.class == type)
					{
						metaCache.setValue(name, Long.valueOf(value));
					} else if (short.class == type || Short.class == type)
					{
						metaCache.setValue(name, Short.valueOf(value));
					} else if (byte.class == type || Byte.class == type)
					{
						metaCache.setValue(name, Byte.valueOf(value));
					} else if (float.class == type || Float.class == type)
					{
						metaCache.setValue(name, Float.valueOf(value));
					} else if (boolean.class == type || Boolean.class == type)
					{
						metaCache.setValue(name, Boolean.valueOf(value));
					} else if (double.class == type || Double.class == type)
					{
						metaCache.setValue(name, Double.valueOf(value));
					} else
					{
						throw new CacheException("Unsupported property type: '" + name + "' of type " + type);
					}
				}
			}
		}
	}
}
