package com.amall.core.web.tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.StringReader;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.AndFileFilter;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.NotFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;

public class FileUtil {
	/**
	 * 
	 * <p>Title: string2File</p>
	 * <p>Description: 文件复制</p>
	 * @param res  目标路径
	 * @param filePath 原文件路径
	 * @return 复制成功返回true，否则返回false
	 */
	public static boolean string2File(String res, String filePath) {
		boolean flag = true;
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		try {
			File distFile = new File(filePath);
			if (!distFile.getParentFile().exists())
				distFile.getParentFile().mkdirs();
			bufferedReader = new BufferedReader(new StringReader(res));
			bufferedWriter = new BufferedWriter(new FileWriter(distFile));
			char[] buf = new char[1024];
			int len;
			while ((len = bufferedReader.read(buf)) != -1) {
				bufferedWriter.write(buf, 0, len);
			}
			bufferedWriter.flush();
			bufferedReader.close();
			bufferedWriter.close();
		} catch (IOException e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}
	/**
	 * 
	 * <p>Title: copyFile</p>
	 * <p>Description: 文件或文件夹复制</p>
	 * @param resFilePath 原文件或文件夹路径
	 * @param distFolder  目标路径
	 * @throws IOException
	 */
	public static void copyFile(String resFilePath, String distFolder)
			throws IOException {
		File resFile = new File(resFilePath);
		File distFile = new File(distFolder);
		if (resFile.isDirectory())
			FileUtils.copyDirectoryToDirectory(resFile, distFile);
		else if (resFile.isFile())
			FileUtils.copyFileToDirectory(resFile, distFile, true);
	}
	
	/**
	 * 
	 * <p>Title: deleteFile</p>
	 * <p>Description: 删除文件</p>
	 * @param targetPath  文件路径
	 * @throws IOException 
	 */
	public static void deleteFile(String targetPath) throws IOException {
		File targetFile = new File(targetPath);
		if (targetFile.isDirectory())
			FileUtils.deleteDirectory(targetFile);
		else if (targetFile.isFile())
			targetFile.delete();
	}
	
	/**
	 * 
	 * <p>Title: moveFile</p>
	 * <p>Description: 移动文件</p>
	 * @param resFilePath  原文件或文件夹路径
	 * @param distFolder 目标文件夹路径
	 * @throws IOException
	 */
	public static void moveFile(String resFilePath, String distFolder)
			throws IOException {
		File resFile = new File(resFilePath);
		File distFile = new File(distFolder);
		if (resFile.isDirectory())
			FileUtils.copyDirectory(resFile, distFile, true);
		else if (resFile.isFile())
			FileUtils.copyDirectory(resFile, distFile, true);
	}
	
	/**
	 * 
	 * <p>Title: genFileSize</p>
	 * <p>Description: 获得文件夹或文件大小 </p>
	 * @param distFilePath
	 * @return long  是文件或文件夹的情况下返回其大小，否则返回-1
	 */
	public static long genFileSize(String distFilePath) {
		File distFile = new File(distFilePath);
		if (distFile.isFile())
			return distFile.length();
		if (distFile.isDirectory()) {
			return FileUtils.sizeOfDirectory(distFile);
		}
		return -1L;
	}
	
	/**
	 * 
	 * <p>Title: isExist</p>
	 * <p>Description: 根据路径判断文件是否存在</p>
	 * @param filePath 文件路径
	 * @return boolean  存在返回true，否则返回false
	 */
	public static boolean isExist(String filePath) {
		return new File(filePath).exists();
	}
	
	/**
	 * 
	 * <p>Title: listFilebySuffix</p>
	 * <p>Description: 获得指定后缀名，在文件夹中的所有文件名</p>
	 * @param folder  文件夹
	 * @param suffix  后缀名
	 * @return  String[] 含有文件名的字符串数组
	 */
	public static String[] listFilebySuffix(String folder, String suffix) {
		IOFileFilter fileFilter1 = new SuffixFileFilter(suffix);
		IOFileFilter fileFilter2 = new NotFileFilter(
				DirectoryFileFilter.INSTANCE);
		FilenameFilter filenameFilter = new AndFileFilter(fileFilter1,
				fileFilter2);
		return new File(folder).list(filenameFilter);
	}
}
