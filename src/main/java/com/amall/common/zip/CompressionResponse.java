package com.amall.common.zip;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * 
 * <p>Title: CompressionResponse</p>
 * <p>Description: 对HttpServletResponse进行装饰扩展，方便进行gzip压缩</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-27上午12:23:25
 * @version 1.0
 */
public class CompressionResponse extends HttpServletResponseWrapper {
	protected HttpServletResponse response;
	private ServletOutputStream out;
	private CompressedStream compressedOut;
	private PrintWriter writer;
	protected int contentLength;

	public CompressionResponse(HttpServletResponse response) throws IOException {
		super(response);
		this.response = response;
		this.compressedOut = new CompressedStream(response.getOutputStream());
	}

	public void setContentLength(int len) {
		this.contentLength = len;
	}

	public ServletOutputStream getOutputStream() throws IOException {
		if (this.out == null) {
			if (this.writer != null) {
				throw new IllegalStateException(
						"getWriter() has already been called on this response.");
			}
			this.out = this.compressedOut;
		}
		return this.out;
	}

	public PrintWriter getWriter() throws IOException {
		if (this.writer == null) {
			if (this.out != null) {
				throw new IllegalStateException(
						"getOutputStream() has already been called on this response.");
			}
			this.writer = new PrintWriter(this.compressedOut);
		}
		return this.writer;
	}

	public void flushBuffer() {
		try {
			if (this.writer != null)
				this.writer.flush();
			else if (this.out != null)
				this.out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void reset() {
		super.reset();
		try {
			this.compressedOut.reset();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void resetBuffer() {
		super.resetBuffer();
		try {
			this.compressedOut.reset();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void close() throws IOException {
		this.compressedOut.close();
	}
}
