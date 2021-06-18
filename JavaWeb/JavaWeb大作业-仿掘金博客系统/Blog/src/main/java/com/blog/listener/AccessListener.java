package com.blog.listener;

import com.blog.entity.Vistor;
import com.blog.service.VistorService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/**
 * @ClassName: AccessListener
 * @describe:用于统计访问量监听器
 */
@WebListener
public class AccessListener implements ServletRequestListener,ApplicationContextAware{
	public static ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
	public static Integer VISTOR_NUMBER=0;
	private static Map<String,Object> vistorMap=new HashMap<String, Object>();

	public void requestInitialized(ServletRequestEvent sre) {
		VistorService vistorService=(VistorService) applicationContext.getBean("vistorService");
		HttpServletRequest request=(HttpServletRequest) sre.getServletRequest();
		String ip=request.getRemoteAddr();
		if(!vistorMap.containsKey(ip))
		{
			Vistor vistor=new Vistor();
			vistorMap.put(ip,true);
			String header = request.getHeader("user-agent");
			String browserVersion="";
			if(header == null || header.equals("")){
			   System.out.println("无");
			 }
	        if(header.indexOf("MSIE")>0){
	            browserVersion = "IE";
	        }else if(header.indexOf("Firefox")>0){
	            browserVersion = "Firefox";
	        }else if(header.indexOf("Chrome")>0){
	            browserVersion = "Chrome";
	        }else if(header.indexOf("Safari")>0){
	            browserVersion = "Safari";
	        }else if(header.indexOf("Camino")>0){
	            browserVersion = "Camino";
	        }else if(header.indexOf("Konqueror")>0){
	            browserVersion = "Konqueror";
	        }
			vistor.setIp(ip);
			vistor.setBrowser(browserVersion);
			vistor.setVisitTime(new Date());
			vistorService.insertVistor(vistor);
			VISTOR_NUMBER++;
		}
		
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException { }
	public void requestDestroyed(ServletRequestEvent sre) { }



}
	