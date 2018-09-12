package com.ktds.youtube.common.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ���� �ٿ�ε带 �����ϰ� ��.
 * Internet Explorer, Mozilia ��� ȣȯ
 * @author Minchang Jang (mc.jang@hucloud.co.kr)
 *
 */
public class DownloadUtil {

	private String uploadPathWithFileName;
	
	public DownloadUtil(String uploadPathWithFileName) {
		this.uploadPathWithFileName = uploadPathWithFileName;
	}
	
	/**
	 * ������ �ٿ�ε� ��.
	 * @param request
	 * @param response
	 * @param displayFileName �ٿ�ε� �� �� ����ڿ��� ������ ������ �̸�
	 * @throws UnsupportedEncodingException
	 */
	public void download(HttpServletRequest request,
						HttpServletResponse response,
						String displayFileName) throws UnsupportedEncodingException {
		
		File downloadFile = new File(uploadPathWithFileName);
		
		response.setContentType("application/download; charset=utf-8");
		response.setContentLength( (int) downloadFile.length());
		
		// ������� ������ ������ �����´�.
		String userAgent = request.getHeader("User-Agent");
		// ������� �������� MicroSoft Internet Explorer ���� Ȯ���Ѵ�.
		boolean internetExplorer = userAgent.indexOf("MSIE") > -1;
		if( !internetExplorer ) {
			internetExplorer = userAgent.indexOf("Gecko") > -1;
		}
		
		// �ٿ�ε��� ������ �̸��� ���������� �����´�.
		String fileName = new String(displayFileName.getBytes(), "UTF-8");
		if ( internetExplorer ) {
			fileName = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");
		}
		else {
			// File�� �̸��� UTF-8 Ÿ�Կ��� ISO-8859-1 Ÿ������ �����Ѵ�.
			fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
		}
		
		// �������� ���� ������ �̸��� response�� ����Ѵ�.
		response.setHeader("Content-Disposition",
				"attachment; filename=\"" + fileName + "\";");
		// �������� �ٿ�ε� ���� �� Binary ���Ϸ� �����϶�� ������.
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		FileInputStream fin = null;
		FileChannel inputChannel = null;
		WritableByteChannel outputChannel = null;
		
		try {
			fin = new FileInputStream(downloadFile);
			inputChannel = fin.getChannel();

			outputChannel = Channels.newChannel(response.getOutputStream());
			inputChannel.transferTo(0, fin.available(), outputChannel);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			try {
				if (outputChannel.isOpen())
					outputChannel.close();
			} catch (Exception e) {}
			try {
				if (inputChannel.isOpen())
					inputChannel.close();
			} catch (Exception e) {}
			try {
				if (fin != null)
					fin.close();
			} catch (Exception e) {}
		}
	}
	
}
