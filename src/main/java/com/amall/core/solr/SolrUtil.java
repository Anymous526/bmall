package com.amall.core.solr;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.StringUtils;
import com.amall.common.constant.Globals;
import com.amall.core.web.tools.DateUtils;

/**
 * 
 * @ClassName: Solr
 * @Description: 
 * @author lx
 * @date 2016年1月5日 下午2:52:58
 *
 */
@SuppressWarnings("deprecation")
public class SolrUtil
{

	static Logger log = Logger.getLogger (SolrUtil.class);

	/* server是线程安全的并建议使用单例模式来使用他们，因为动态创建会造成连接泄露 */
	/*
	 * httpclient对象在创建后就相当于打开了一个浏览器，多个线程并发时， 分别通过这个httpclient对象和服务器端建立了多个连接，
	 * 但由于使用的是同一个httpclient对象，如果这个对象已经和服务端建立过连接，
	 * 就会分配一个sessionid，并保存到cookie中，后面其他线程再通过这个httpclient对象和服务的建立连接时，
	 * 服务端就会根据sessionid识别成同一个session。
	 */
	private static HttpSolrServer solrServer;
	static
	{
		if (null == solrServer)
		{
			// 读取配置文件，初始化server
			Properties prop = new Properties ();
			try
			{
				prop.load (Thread.currentThread ().getContextClassLoader ().getResourceAsStream ("properties/solr.properties"));
				solrServer = new HttpSolrServer (prop.getProperty ("baseUrl"));
				solrServer.setConnectionTimeout (Integer.valueOf (prop.getProperty ("connectionTimeout")));
				solrServer.setDefaultMaxConnectionsPerHost (Integer.valueOf (prop.getProperty ("defaultMaxConnectionsPerHost")));
				solrServer.setMaxRetries (Integer.valueOf (prop.getProperty ("maxRetries")));
				solrServer.setMaxTotalConnections (Integer.valueOf (prop.getProperty ("maxTotalConnections")));
			}
			catch (IOException e)
			{
				System.out.println ("请检查tomcat服务器或端口是否开启!");
				e.printStackTrace ();
			}
		}
	}

	/**
	 * 简单查询(不支持范围查询)
	 * 
	 * @param map
	 *            查询条件键值对
	 * @param curPage
	 *            当前页
	 * @param paseSize
	 *            每页多少条
	 * @param sortFieldMap
	 *            对结果集按field排序-排序方式(true:asc , false:desc)
	 * @return
	 */
	public static QueryResponse simpleSearch (TreeMap <String, String> map , Boolean isAnd , int curPage , int paseSize , TreeMap <String, Boolean> sortFieldMap , Map <String [ ], Boolean> queryFilter_map)
		{
			SolrQuery query = null;
			try
			{
				// 初始化查询对象
				query = new SolrQuery ();
				StringBuilder querysb = new StringBuilder ();
				if (map != null)
				{
					// 组装查询条件
					Set query_set = map.entrySet ();
					Iterator query_iterator = query_set.iterator ();
					int temp = 0;
					int loopSize = query_set.size ();
					while (query_iterator.hasNext ())
					{
						temp++;
						Map.Entry <String, String> enter = (Entry <String, String>) query_iterator.next ();
						String [ ] vals = enter.getValue ().split (",");
						if (vals.length > Globals.NUBER_ONE)
						{
							for (int i = 0 ; i < vals.length ; i++)
							{
								querysb.append (enter.getKey ()).append (":").append (vals[i]);
								if (!(i == (vals.length - 1)))
								{
									if (isAnd)
									{
										querysb.append (" AND ");
									}
									else
									{
										querysb.append (" OR ");
									}
								}
							}
						}
						else
						{
							querysb.append (enter.getKey ()).append (":").append (enter.getValue ());
							if (temp < loopSize)
							{
								if (isAnd)
								{
									querysb.append (" AND ");
								}
								else
								{
									querysb.append (" OR ");
								}
							}
						}
					}
				}
				query.setQuery (querysb.toString ());
				// 设置起始位置与返回结果数
				query.setStart ((curPage - 1) * paseSize);
				query.setRows (paseSize);
				// 设置排序
				if (sortFieldMap != null)
				{
					Set sort_set = sortFieldMap.entrySet ();
					Iterator sort_iterator = sort_set.iterator ();
					while (sort_iterator.hasNext ())
					{
						Map.Entry <String, Boolean> enter = (Entry <String, Boolean>) sort_iterator.next ();
						if (enter.getValue ())
						{
							query.setSort (enter.getKey () , SolrQuery.ORDER.asc);
						}
						else
						{
							query.setSort (enter.getKey () , SolrQuery.ORDER.desc);
						}
					}
				}
				// 结果过滤查询
				if (queryFilter_map != null)
				{
					Set sort_set = queryFilter_map.entrySet ();
					Iterator sort_iterator = sort_set.iterator ();
					List <String> filterStrs = new ArrayList <> ();
					while (sort_iterator.hasNext ())
					{
						Map.Entry <String [ ], Boolean> enter = (Entry <String [ ], Boolean>) sort_iterator.next ();
						if (enter.getValue ())
						{
							filterStrs.add (enter.getKey ()[0] + ":" + "*" + enter.getKey ()[1] + "*");
						}
						else
						{
							filterStrs.add (enter.getKey ()[0] + ":" + enter.getKey ()[1]);
						}
					}
					query.setFilterQueries (filterStrs.toArray (new String [filterStrs.size ()]));
				}
			}
			catch (Exception e)
			{
				e.printStackTrace ();
			}
			QueryResponse rsp = null;
			try
			{
				rsp = solrServer.query (query);
				// System.out.println(rsp);
			}
			catch (Exception e)
			{
				e.printStackTrace ();
				return null;
			}
			// 返回查询结果
			return rsp;
		}

	/**
	 * 简单查询,对查询结果集分组统计(不支持范围查询)
	 * 
	 * @param map
	 *            查询条件键值对
	 * @param curPage
	 *            当前页
	 * @param paseSize
	 *            每页多少条
	 * @param sortFieldMap
	 *            对结果集按field排序-排序方式(true:asc , false:desc)
	 * @param facetField
	 *            分组属性(目前只支持一个属性)
	 * @param facetPrefix
	 *            分组筛选(like查询)
	 * @return
	 */
	public static QueryResponse simpleSearchGroup (TreeMap <String, String> map , Boolean isAnd , int curPage , int paseSize , TreeMap <String, Boolean> sortFieldMap , String facetField , String facetPrefix)
		{
			SolrQuery query = null;
			try
			{
				// 初始化查询对象
				query = new SolrQuery ();
				StringBuilder querysb = new StringBuilder ();
				if (map != null)
				{
					// 组装查询条件
					Set query_set = map.entrySet ();
					Iterator query_iterator = query_set.iterator ();
					int temp = 0;
					int loopSize = query_set.size ();
					while (query_iterator.hasNext ())
					{
						temp++;
						Map.Entry <String, String> enter = (Entry <String, String>) query_iterator.next ();
						String [ ] vals = enter.getValue ().split (",");
						if (vals.length > Globals.NUBER_ONE)
						{
							for (int i = 0 ; i < vals.length ; i++)
							{
								querysb.append (enter.getKey ()).append (":").append (vals[i]);
								if (!(i == (vals.length - 1)))
								{
									if (isAnd)
									{
										querysb.append (" AND ");
									}
									else
									{
										querysb.append (" OR ");
									}
								}
							}
						}
						else
						{
							querysb.append (enter.getKey ()).append (":").append (enter.getValue ());
							if (temp < loopSize)
							{
								if (isAnd)
								{
									querysb.append (" AND ");
								}
								else
								{
									querysb.append (" OR ");
								}
							}
						}
					}
				}
				query.setQuery (querysb.toString ());
				// 设置起始位置与返回结果数
				query.setStart ((curPage - 1) * paseSize);
				query.setRows (paseSize);
				// 设置排序
				if (sortFieldMap != null)
				{
					Set sort_set = sortFieldMap.entrySet ();
					Iterator sort_iterator = sort_set.iterator ();
					while (sort_iterator.hasNext ())
					{
						Map.Entry <String, Boolean> enter = (Entry <String, Boolean>) sort_iterator.next ();
						if (enter.getValue ())
						{
							query.setSort (enter.getKey () , SolrQuery.ORDER.asc);
						}
						else
						{
							query.setSort (enter.getKey () , SolrQuery.ORDER.desc);
						}
					}
				}
				// 对结果集分组操作,并且对分组结果进行筛选,并统计每组总数
				query.setFacet (Boolean.TRUE);
				query.addFacetField (new String [ ] { facetField });
				query.setFacetPrefix (facetPrefix);
				// 按查询维度结果集的数量排序(分组排序,按照每组总计数)
				query.setFacetSort ("count");
			}
			catch (Exception e)
			{
				e.printStackTrace ();
			}
			QueryResponse rsp = null;
			try
			{
				rsp = solrServer.query (query);
				// System.out.println(rsp);
			}
			catch (Exception e)
			{
				e.printStackTrace ();
				return null;
			}
			// 返回查询结果
			return rsp;
		}

	/**
	 * 时间范围段查询,不支持分组
	 * 
	 * @param map
	 *            查询条件键值对
	 * @param fieldTime
	 *            时间范围段查询的属性名称
	 * @param startTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @param curPage
	 *            当前页
	 * @param paseSize
	 *            每页条数
	 * @param sortFieldMap
	 *            对结果集按field排序-排序方式(true:asc , false:desc)
	 * @return
	 */
	public static QueryResponse rangeTimeSearch (TreeMap <String, String> map , Boolean isAnd , String fieldTime , String startTime , String endTime , int curPage , int paseSize , TreeMap <String, Boolean> sortFieldMap)
		{
			SolrQuery query = null;
			try
			{
				// 初始化查询对象
				query = new SolrQuery ();
				StringBuilder querysb = new StringBuilder ();
				if (map != null)
				{
					// 组装查询条件
					Set query_set = map.entrySet ();
					Iterator query_iterator = query_set.iterator ();
					int temp = 0;
					int loopSize = query_set.size ();
					while (query_iterator.hasNext ())
					{
						temp++;
						Map.Entry <String, String> enter = (Entry <String, String>) query_iterator.next ();
						String [ ] vals = enter.getValue ().split (",");
						if (vals.length > Globals.NUBER_ONE)
						{
							for (int i = 0 ; i < vals.length ; i++)
							{
								querysb.append (enter.getKey ()).append (":").append (vals[i]);
								if (!(i == (vals.length - 1)))
								{
									if (isAnd)
									{
										querysb.append (" AND ");
									}
									else
									{
										querysb.append (" OR ");
									}
								}
							}
						}
						else
						{
							querysb.append (enter.getKey ()).append (":").append (enter.getValue ());
							if (temp < loopSize)
							{
								if (isAnd)
								{
									querysb.append (" AND ");
								}
								else
								{
									querysb.append (" OR ");
								}
							}
						}
					}
				}
				// 时间范围段查询
				if (!StringUtils.isEmpty (startTime) && !StringUtils.isEmpty (endTime))
				{
					String querystime = DateUtils.parseTZDate (startTime);
					String queryetime = DateUtils.parseTZDate (endTime);
					querysb.append (fieldTime).append (":").append ("[").append (querystime).append (" TO ").append (queryetime).append ("]");
				}
				else if (!StringUtils.isEmpty (startTime) && StringUtils.isEmpty (endTime))
				{
					String querystime = DateUtils.parseTZDate (startTime);
					querysb.append (fieldTime).append (":").append ("[").append (querystime).append (" TO *]");
				}
				else if (StringUtils.isEmpty (startTime) && !StringUtils.isEmpty (endTime))
				{
					String queryetime = DateUtils.parseTZDate (endTime);
					querysb.append (fieldTime).append (":").append ("[* TO ").append (queryetime).append ("]");
				}
				query.setQuery (querysb.toString ());
				// 设置起始位置与返回结果数
				query.setStart ((curPage - 1) * paseSize);
				query.setRows (paseSize);
				// 设置排序
				if (sortFieldMap != null)
				{
					Set sort_set = sortFieldMap.entrySet ();
					Iterator sort_iterator = sort_set.iterator ();
					while (sort_iterator.hasNext ())
					{
						Map.Entry <String, Boolean> enter = (Entry <String, Boolean>) sort_iterator.next ();
						if (enter.getValue ())
						{
							query.setSort (enter.getKey () , SolrQuery.ORDER.asc);
						}
						else
						{
							query.setSort (enter.getKey () , SolrQuery.ORDER.desc);
						}
					}
				}
			}
			catch (Exception e)
			{
				e.printStackTrace ();
			}
			QueryResponse rsp = null;
			try
			{
				rsp = solrServer.query (query);
			}
			catch (Exception e)
			{
				e.printStackTrace ();
				return null;
			}
			// 返回查询结果
			return rsp;
		}

	public static QueryResponse rangeTimeSearchGroup (TreeMap <String, String> map , Boolean isAnd , String fieldTime , String startTime , String endTime , int curPage , int paseSize , TreeMap <String, Boolean> sortFieldMap , String facetField , String facetPrefix)
		{
			SolrQuery query = null;
			try
			{
				// 初始化查询对象
				query = new SolrQuery ();
				StringBuilder querysb = new StringBuilder ();
				if (map != null)
				{
					// 组装查询条件
					Set query_set = map.entrySet ();
					Iterator query_iterator = query_set.iterator ();
					int temp = 0;
					int loopSize = query_set.size ();
					while (query_iterator.hasNext ())
					{
						temp++;
						Map.Entry <String, String> enter = (Entry <String, String>) query_iterator.next ();
						String [ ] vals = enter.getValue ().split (",");
						if (vals.length > Globals.NUBER_ONE)
						{
							for (int i = 0 ; i < vals.length ; i++)
							{
								querysb.append (enter.getKey ()).append (":").append (vals[i]);
								if (!(i == (vals.length - 1)))
								{
									if (isAnd)
									{
										querysb.append (" AND ");
									}
									else
									{
										querysb.append (" OR ");
									}
								}
							}
						}
						else
						{
							querysb.append (enter.getKey ()).append (":").append (enter.getValue ());
							if (temp < loopSize)
							{
								if (isAnd)
								{
									querysb.append (" AND ");
								}
								else
								{
									querysb.append (" OR ");
								}
							}
						}
					}
				}
				// 时间范围段查询
				if (!StringUtils.isEmpty (startTime) && !StringUtils.isEmpty (endTime))
				{
					String querystime = DateUtils.parseTZDate (startTime);
					String queryetime = DateUtils.parseTZDate (endTime);
					querysb.append (fieldTime).append (":").append ("[").append (querystime).append (" TO ").append (queryetime).append ("]");
				}
				else if (!StringUtils.isEmpty (startTime) && StringUtils.isEmpty (endTime))
				{
					String querystime = DateUtils.parseTZDate (startTime);
					querysb.append (fieldTime).append (":").append ("[").append (querystime).append (" TO *]");
				}
				else if (StringUtils.isEmpty (startTime) && !StringUtils.isEmpty (endTime))
				{
					String queryetime = DateUtils.parseTZDate (endTime);
					querysb.append (fieldTime).append (":").append ("[* TO ").append (queryetime).append ("]");
				}
				query.setQuery (querysb.toString ());
				// 设置起始位置与返回结果数
				query.setStart ((curPage - 1) * paseSize);
				query.setRows (paseSize);
				// 设置排序
				if (sortFieldMap != null)
				{
					Set sort_set = sortFieldMap.entrySet ();
					Iterator sort_iterator = sort_set.iterator ();
					while (sort_iterator.hasNext ())
					{
						Map.Entry <String, Boolean> enter = (Entry <String, Boolean>) sort_iterator.next ();
						if (enter.getValue ())
						{
							query.setSort (enter.getKey () , SolrQuery.ORDER.asc);
						}
						else
						{
							query.setSort (enter.getKey () , SolrQuery.ORDER.desc);
						}
					}
				}
				// 对结果集分组操作,并且对分组结果进行筛选,并统计每组总数
				query.setFacet (Boolean.TRUE);
				query.addFacetField (new String [ ] { facetField });
				query.setFacetPrefix (facetPrefix);
				// 按查询维度结果集的数量排序(分组排序,按照每组总计数)
				query.setFacetSort ("count");
			}
			catch (Exception e)
			{
				e.printStackTrace ();
			}
			QueryResponse rsp = null;
			try
			{
				rsp = solrServer.query (query);
			}
			catch (Exception e)
			{
				e.printStackTrace ();
				return null;
			}
			// 返回查询结果
			return rsp;
		}

	/**
	 * 针对查询结果集,过滤查询某个数值属性在数字范围内的结果
	 * 
	 * @param map
	 *            查询条件键值对
	 * @param fieldTime
	 *            数值范围段查询的属性名称
	 * @param startNumber
	 *            开始数值
	 * @param endNumber
	 *            结束数值
	 * @param curPage
	 *            当前页
	 * @param paseSize
	 *            每页条数
	 * @param sortFieldMap
	 *            对结果集按field排序-排序方式(true:asc , false:desc)
	 * @return
	 */
	public static QueryResponse rangeNumberSearch (TreeMap <String, String> map , Boolean isAnd , String fieldName , BigDecimal startNumber , BigDecimal endNumber , int curPage , int paseSize , TreeMap <String, Boolean> sortFieldMap , Map <String [ ], Boolean> queryFilter_map)
		{
			SolrQuery query = null;
			StringBuilder querysb = new StringBuilder ();
			try
			{
				// 初始化查询对象
				query = new SolrQuery ();
				if (map != null)
				{
					// 组装查询条件
					Set query_set = map.entrySet ();
					Iterator query_iterator = query_set.iterator ();
					int temp = 0;
					int loopSize = query_set.size ();
					while (query_iterator.hasNext ())
					{
						temp++;
						Map.Entry <String, String> enter = (Entry <String, String>) query_iterator.next ();
						String [ ] vals = enter.getValue ().split (",");
						if (vals.length > Globals.NUBER_ONE)
						{
							for (int i = 0 ; i < vals.length ; i++)
							{
								querysb.append (enter.getKey ()).append (":").append (vals[i]);
								if (!(i == (vals.length - 1)))
								{
									if (isAnd)
									{
										querysb.append (" AND ");
									}
									else
									{
										querysb.append (" OR ");
									}
								}
							}
						}
						else
						{
							querysb.append (enter.getKey ()).append (":").append (enter.getValue ());
							if (temp < loopSize)
							{
								if (isAnd)
								{
									querysb.append (" AND ");
								}
								else
								{
									querysb.append (" OR ");
								}
							}
						}
					}
				}
				// 结果集数字范围段查询
				if (startNumber != null && endNumber != null)
				{
					query.setFilterQueries (new String [ ] { fieldName + ":" + "[" + startNumber + " TO " + endNumber + "]" });
				}
				else if (startNumber != null && endNumber == null)
				{
					query.setFilterQueries (new String [ ] { fieldName + ":" + "[" + startNumber + " TO *]" });
				}
				else if (startNumber == null && endNumber != null)
				{
					query.setFilterQueries (new String [ ] { fieldName + ":" + "[* TO " + startNumber + "]" });
				}
				query.setQuery (querysb.toString ());
				// 设置起始位置与返回结果数
				query.setStart ((curPage - 1) * paseSize);
				query.setRows (paseSize);
				// 设置排序
				if (sortFieldMap != null)
				{
					Set sort_set = sortFieldMap.entrySet ();
					Iterator sort_iterator = sort_set.iterator ();
					while (sort_iterator.hasNext ())
					{
						Map.Entry <String, Boolean> enter = (Entry <String, Boolean>) sort_iterator.next ();
						if (enter.getValue ())
						{
							query.setSort (enter.getKey () , SolrQuery.ORDER.asc);
						}
						else
						{
							query.setSort (enter.getKey () , SolrQuery.ORDER.desc);
						}
					}
				}
				// 结果过滤查询
				if (queryFilter_map != null)
				{
					Set sort_set = queryFilter_map.entrySet ();
					Iterator sort_iterator = sort_set.iterator ();
					List <String> filterStrs = new ArrayList <> ();
					while (sort_iterator.hasNext ())
					{
						Map.Entry <String [ ], Boolean> enter = (Entry <String [ ], Boolean>) sort_iterator.next ();
						if (enter.getValue ())
						{
							filterStrs.add (enter.getKey ()[0] + ":" + "*" + enter.getKey ()[1] + "*");
						}
						else
						{
							filterStrs.add (enter.getKey ()[0] + ":" + enter.getKey ()[1]);
						}
					}
					query.setFilterQueries (filterStrs.toArray (new String [filterStrs.size ()]));
				}
			}
			catch (Exception e)
			{
				e.printStackTrace ();
			}
			QueryResponse rsp = null;
			try
			{
				rsp = solrServer.query (query);
			}
			catch (Exception e)
			{
				e.printStackTrace ();
				return null;
			}
			// 返回查询结果
			return rsp;
		}

	public static <BeanVoClass> List <BeanVoClass> createListBeanVo (List <SolrDocument> docs , Class <?> BeanVoClass) throws InstantiationException , IllegalAccessException , InvocationTargetException
		{
			List <Object> listObject = new ArrayList <> ();
			Field [ ] beanVoFields = BeanVoClass.getDeclaredFields ();
			for (SolrDocument doc : docs)
			{
				Object t = BeanVoClass.newInstance ();
				for (Iterator <?> iter = doc.iterator () ; iter.hasNext () ;)
				{
					Map.Entry <String, Object> entry = (Map.Entry <String, Object>) iter.next ();
					for (Field fieldVo : beanVoFields)
					{
						fieldVo.setAccessible (true);
						if (fieldVo.getName ().equalsIgnoreCase (entry.getKey ()))
						{
							BeanUtils.setProperty (t , fieldVo.getName () , entry.getValue ());
						}
					}
				}
				listObject.add (t);
			}
			return (List <BeanVoClass>) listObject;
		}
}
