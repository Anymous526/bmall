package com.amall.core.lucene;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * 
 * <p>Title: LuceneThread</p>
 * <p>Description: 全文检索多线程</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author	ljx
 * @date	2015年7月11日下午3:48:58
 * @version 1.0
 */
public class LuceneThread implements Runnable {
	private String path;
	private List<LuceneVo> vo_list = new ArrayList<LuceneVo>();

	public LuceneThread(String path, List<LuceneVo> vo_list) {
		this.path = path;
		this.vo_list = vo_list;
	}

	public void run() {
		LuceneUtil lucene = LuceneUtil.instance();
		LuceneUtil.setIndex_path(this.path);
		lucene.deleteAllIndex(true);		
		try {
			lucene.writeIndex(this.vo_list);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
