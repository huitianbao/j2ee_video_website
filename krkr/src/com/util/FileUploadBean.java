package com.util;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletInputStream;
import java.util.Dictionary;
import java.util.Hashtable;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
/**
 * Desc:�ļ��ϴ��࣬ʵ�ֽ��ļ��ϴ�����������
 * @author gjw
 * @version 1.0
 * 
 */
public class FileUploadBean {
	private String savePath, filepath, filename, contentType;
	private byte[] b;
	byte t;
	private Dictionary fields;
	/**
	 * ȡ���ϴ��ļ���
	 * @return �ļ�����
	 */
	public String getFilename() {
		return filename;
	}
	/**
	 * ȡ���ļ�·��
	 * @return �ļ�·��
	 */
	public String getFilepath() {
		return filepath;
	}
	/**
	 * ���ñ���·��
	 * @param savePath �����·��
	 */
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	/**
	 * ȡ����������
	 * @return �ϴ��ļ���������
	 */
	public String getContentType() {
		return contentType;
	}
	/**
	 * ȡ���ֶ����ֵ
	 * @param fieldName �ֶ��������ִ�Сд
	 * @return ���ֶε�ֵ
	 */
	public String getFieldValue(String fieldName) {
		if (fields == null || fieldName == null)
			return null;
		return (String) fields.get(fieldName);
	}
	/**
	 * �����ļ�����
	 * @param s �ϴ����ļ�·
	 */
	private void setFilename(String s) {
		if (s == null)
			return;
		int pos = s.indexOf("filename=\"");
		if (pos != -1) {
			filepath = s.substring(pos + 10, s.length() - 1);
			// Windows����������������ļ�·��������
			// ��Linux/Unix��Mac�����ֻ�����ļ�����
			pos = filepath.lastIndexOf("\\");
			if (pos != -1)
				filename = filepath.substring(pos + 1);
			else
				filename = filepath;
		}
	}
	/**
	 * �����ļ���������
	 * @param s ��������
	 */
	private void setContentType(String s) {
		if (s == null)
			return;
		int pos = s.indexOf(": ");
		if (pos != -1)
			contentType = s.substring(pos + 2, s.length());
	}
	/**
	 * ȡ��Request������ֽ���
	 * @param request HttpServletRequest����
	 */
	public void getByte(HttpServletRequest request)
	{
		DataInputStream is;
		int i = 0;
		try
		{
			is = new DataInputStream(request.getInputStream());
			b = new byte[request.getContentLength()];
			while (true)
			{
				try
				{
					t = is.readByte();
					b[i] = t;
					i++;
				}
				catch (EOFException e)
				{
					break;
				}
			}
			is.close();
		}
		catch (IOException e)
		{
		}
	}
	/**
	 * 
	 * @param request
	 * @throws IOException
	 */
	public void doUpload1(HttpServletRequest request) throws
	IOException {
		byte[] line = new byte[128];
		FileOutputStream os = new FileOutputStream("c:\\Demo.out");
		ServletInputStream in = request.getInputStream();
		getByte(request);
		String temp = "";
		temp = new String(b, "ISO8859_1");
		byte[] img = temp.getBytes("ISO8859_1");
		for (int i = 0; i < img.length; i++)
		{
			os.write(img[i]);
		}
		os.close();
	}
	/**
	 * ��GB2312ת�룬�ϴ��ļ�
	 * @param request request����
	 * @throws IOException ��ȡ�ļ��쳣
	 */
	public void doUpload(HttpServletRequest request) throws IOException {
		request.setCharacterEncoding("GB2312");
		ServletInputStream in = request.getInputStream();
		byte[] line = new byte[1280];
		int i = in.readLine(line, 0, 1280);
		if (i < 3)
			return;
		int boundaryLength = i - 2;
		String boundary = new String(line, 0, boundaryLength); // -2���������ַ�
		fields = new Hashtable();
		while (i != -1) {
			String newLine = new String(line, 0, i);
			if (newLine.startsWith("Content-Disposition: form-data; name=\"")) 
			{
				if (newLine.indexOf("filename=\"") != -1) 
				{
					setFilename(new String(line, 0, i - 2));
					if (filename == null)
						return;
					// �ļ�����
					i = in.readLine(line, 0, 1280);
					setContentType(new String(line, 0, i - 2));
					i = in.readLine(line, 0, 1280);
					// ����
					i = in.readLine(line, 0, 1280);
					newLine = new String(line, 0, i, "ISO8859_1");
					FileOutputStream pw = new FileOutputStream(
							(savePath == null ? "" : savePath) + filename);
					// PrintWriter pw = new PrintWriter(new BufferedWriter(new
					// FileWriter((savePath==null? "" : savePath) + filename)));
					while (i != -1 && !newLine.startsWith(boundary)) {
						// �ļ����ݵ����һ�а��������ַ�
						// ������Ǳ����鵱ǰ���Ƿ�����
						// ��һ��
						i = in.readLine(line, 0, 1280);
						if ((i == boundaryLength + 2 || i == boundaryLength + 4)&& (new String(line, 0, i).startsWith(boundary)))
							pw.write(newLine.substring(0, newLine.length() - 2).getBytes("ISO8859_1"));
						else
							pw.write(newLine.getBytes("ISO8859_1"));
						newLine = new String(line, 0, i, "ISO8859_1");
					}
					pw.close();
				}
				else 
				{
					// ��ͨ������Ԫ��
					// ��ȡ����Ԫ������
					int pos = newLine.indexOf("name=\"");
					String fieldName = newLine.substring(pos + 6, newLine.length() - 3);
					i = in.readLine(line, 0, 1280);
					i = in.readLine(line, 0, 1280);
					newLine = new String(line, 0, i);
					StringBuffer fieldValue = new StringBuffer(1280);
					while (i != -1 && !newLine.startsWith(boundary)) {
						// ���һ�а��������ַ�
						// ������Ǳ����鵱ǰ���Ƿ������һ��
						i = in.readLine(line, 0, 1280);
						if ((i == boundaryLength + 2 || i == boundaryLength + 4)&& (new String(line, 0, i).startsWith(boundary)))
							fieldValue.append(newLine.substring(0, newLine.length() - 2));
						else
							fieldValue.append(newLine);
						newLine = new String(line, 0, i);
					}
					fields.put(fieldName, fieldValue.toString());
				}
			}
			i = in.readLine(line, 0, 1280);
		}
	}
}
