package com.seezoon.framework.modules;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.TreeMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ReflectionUtils;

import com.alibaba.fastjson.JSON;
import com.beust.jcommander.internal.Maps;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.seezoon.framework.common.http.HttpRequestUtils;
import com.seezoon.framework.front.wechat.dto.QrPayCallbackReturn;
import com.seezoon.framework.front.wechat.dto.UnifiedOrder;
import com.seezoon.framework.front.wechat.utils.WxUtils;

public class T {

	protected Logger logger = LoggerFactory.getLogger(T.class);
	@Test
	public void t2() throws Exception  {
		File file = new File("/Users/hdf/Downloads/1.txt"); 
		PrintStream ps = new PrintStream(file);
		OutputStreamWriter osw = new OutputStreamWriter(ps);
		BufferedWriter bw = new BufferedWriter(osw);
		
		while (true) {
			Thread.sleep(1000);
			bw.write("dsasssss");
			bw.flush();
		}
	}
	@Test
	public void t3() throws Exception  {
		Thread.sleep(2000);
		File file = new File("/Users/hdf/Downloads/1.txt"); 
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		while (true) {
			Thread.sleep(1000);
			System.out.println(br.readLine());
		}
	}
	@Test
	public void t4() {
		System.out.println(StringEscapeUtils.escapeHtml4("https://mmt4ossbucket1.oss-cn-hangzhou.aliyuncs.com"));
	}
	@Test
	public void t5() throws IOException {
		FileWriter fw = new FileWriter("/Users/hdf/Documents/temp/x1.txt");
		fw.write("sss");
		fw.close();
	}
	@Test
	public void t6() throws Exception {
		ZipOutputStream zos  = new ZipOutputStream(new FileOutputStream("/Users/hdf/Documents/temp/x1.zip"));
		zos.putNextEntry(new ZipEntry("/Users/hdf/Documents/temp/x1.txt"));
		IOUtils.write("xx", zos);
		zos.closeEntry();
		zos.close();
	}
	@Test
	public void t7() {
//		Field field = ReflectionUtils.findField(demoParam.getClass(), "id");
//		Class<?> declaringClass = field.getDeclaringClass();
//		System.out.println(declaringClass.getName());
//		Class clazz2 = demoParam.getClass();  
//	    Type type2 = clazz2.getGenericSuperclass();  
//	    ParameterizedType parameterizedType2 = (ParameterizedType) type2;  
//	    System.out.println(parameterizedType2);  
//	    System.out.println(parameterizedType2.getActualTypeArguments()[0].equals(Integer.class));  
	}
	@Test
	public void t8() {
		String ipInfo = HttpRequestUtils.doGet("http://ip.taobao.com/service/getIpInfo.php", Maps.newHashMap("ip","223.73.212.106"));
	}
	@Test
	public void t9() throws JsonProcessingException {
		UnifiedOrder order = new UnifiedOrder();
		order.setAppid("1");
		 XmlMapper xmlMapper = new XmlMapper();
		 xmlMapper.setSerializationInclusion(Include.NON_NULL);
		String writeValueAsString = xmlMapper.writeValueAsString(order);
		 System.out.println(writeValueAsString);
		 UnifiedOrder xmlToBean = WxUtils.xmlToBean(writeValueAsString, UnifiedOrder.class);
		 System.out.println(JSON.toJSONString(xmlToBean));
	}
	@Test
	public void t10() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		TreeMap<String,Object> treeMap = new TreeMap<>();
		UnifiedOrder order = new UnifiedOrder();
		Map<String, String> describe = BeanUtils.describe(order);
		System.out.println(JSON.toJSONString(describe));
		
	}
	@Test
	public void t11() {
		Field[] declaredFields = QrPayCallbackReturn.class.getDeclaredFields();
		System.out.println(UnifiedOrder.class.getSuperclass().getDeclaredFields().length);
		for (Field field:declaredFields) {
			System.out.println(field.getName());
		}
	}
}
