package com.amall.core.web.ucapi;

import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedList;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;

public class XMLHelper {
	/**
	 * 
	 * <p>Title: uc_unserialize</p>
	 * <p>Description: dom解析传入的参数  添加到集合中</p>
	 * @param input
	 * @return
	 */
	public static LinkedList<String> uc_unserialize(String input) {
		LinkedList result = new LinkedList();

		DOMParser parser = new DOMParser();
		try {
			parser.parse(new InputSource(new StringReader(input)));
			Document doc = parser.getDocument();
			NodeList nl = doc.getChildNodes().item(0).getChildNodes();
			int length = nl.getLength();
			for (int i = 0; i < length; i++)
				if (nl.item(i).getNodeType() == 1)
					result.add(nl.item(i).getTextContent());
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}
