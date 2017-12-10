package com.amall.core.web.tools;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import com.amall.core.web.tools.CommUtil;

/**
 * excel 导出
 * 
 * @author dinglei
 *
 */
public class ExcelExport {

	// 单元格默认宽度
	private final static Integer DEFAULT_COLUMN_WIDTH = 17;

	// true 字符显示
	private final static String BOOLEAN_TRUE_STRING_VALUE = "是";

	// false 字符显示
	private final static String BOOLEAN_FALSE_STRING_VALUE = "否";

	/**
	 * 导出excel
	 * 
	 * @param sheetTitle
	 *            sheel 标题
	 * @param titles
	 *            sheel页中标题栏
	 * @param values
	 *            内容值
	 * @param outPutStream
	 *            输出流
	 */
	public void export(String sheetTitle, List<String> titles,
			List<List<Object>> values, OutputStream outPutStream) {

		// 创建
		HSSFWorkbook workBook = new HSSFWorkbook();
		HSSFSheet sheet = workBook.createSheet(sheetTitle);

		// 设置单元格默认宽度
		sheet.setDefaultColumnWidth(DEFAULT_COLUMN_WIDTH);

		// excel表单元头样式
		HSSFCellStyle titleCellStyle = titleCellStyle(workBook);

		titleCellStyle.setFont(titleCellFont(workBook));

		// excel表单元内容样式
		HSSFCellStyle contentCellStyle = contentCellStyle(workBook);

		contentCellStyle.setFont(contentCellFont(workBook));

		// 设置表格标题栏
		HSSFRow hssfRow = sheet.createRow(0);
		for (int i = 0; i < titles.size(); i++) {
			HSSFCell cell = hssfRow.createCell(i);
			cell.setCellStyle(titleCellStyle);
			cell.setCellValue(new HSSFRichTextString(titles.get(i)));
		}
		if (null != values && values.size() > 0) {

			Iterator<List<Object>> cells = values.iterator();
			int index = 0;
			while (cells.hasNext()) {

				index++;
				// 创建一行
				HSSFRow row = sheet.createRow(index);

				List<Object> objs = cells.next();

				for (int i = 0; i < objs.size(); i++) {
					HSSFCell cell = row.createCell(i);
					cell.setCellStyle(contentCellStyle);
					cell.setCellValue(new HSSFRichTextString(
							objectToString(objs.get(i))));
				}

			}
		}

		// 把excel 写入流
		try {
			workBook.write(outPutStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 关闭流
		try {
			outPutStream.flush();
			outPutStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 特殊类型转换
	 * 
	 * @param obj
	 * @return
	 */
	private static String objectToString(Object obj) {
		if (obj instanceof Date) {
			return CommUtil.formatLongDate(obj);
		}

		if (obj instanceof BigDecimal) {
			BigDecimal val = (BigDecimal) obj;
			return String.valueOf(val.doubleValue());
		}

		if (obj instanceof Boolean) {
			Boolean bool = (Boolean) obj;
			return bool ? BOOLEAN_TRUE_STRING_VALUE
					: BOOLEAN_FALSE_STRING_VALUE;
		}

		if (obj instanceof java.util.List) {
			StringBuffer sb = new StringBuffer();
			try {
				List<Object> list = (List<Object>) obj;
				for (int i = 0; i < list.size(); i++) {
					sb.append(objectToString(list.get(i)));
					sb.append(" - ");
				}
			} catch (Exception e) {
				sb.append("");
			}
			return sb.toString();
		}
		return String.valueOf(obj);
	}

	/**
	 * 标题单元格样式
	 * 
	 * @param workBook
	 * @return
	 */
	private static HSSFCellStyle titleCellStyle(HSSFWorkbook workBook) {
		HSSFCellStyle cellStyle = workBook.createCellStyle();

		cellStyle.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
		cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);

		return cellStyle;

	}

	/**
	 * 内容单元格样式
	 * 
	 * @param workBook
	 * @return
	 */
	private static HSSFCellStyle contentCellStyle(HSSFWorkbook workBook) {
		HSSFCellStyle cellStyle = workBook.createCellStyle();
		cellStyle.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
		cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

		return cellStyle;

	}

	/**
	 * 标题单元格字体
	 * 
	 * @param workBook
	 * @return
	 */
	private static HSSFFont titleCellFont(HSSFWorkbook workBook) {
		HSSFFont font = workBook.createFont();
		font.setColor(HSSFColor.VIOLET.index);
		font.setFontHeightInPoints((short) 12);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		return font;
	}

	/**
	 * 标题单元格字体
	 * 
	 * @param workBook
	 * @return
	 */
	private static HSSFFont contentCellFont(HSSFWorkbook workBook) {
		HSSFFont font = workBook.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
		return font;
	}
}
