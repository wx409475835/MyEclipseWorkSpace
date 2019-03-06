package com.nyist.cn.Example;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.nyist.cn.Model.User;

//使用 管理员  踢人功能
public class KickPerson implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		Map map = (Map) event.getSession().getServletContext().getAttribute("map");
		if(map==null){
			map = new HashMap();											//new 一个map集合
			event.getSession().getServletContext().setAttribute("map",map);	//将map集合存到applicationScope中去
		}
		Object object = event.getValue();						//拿到用户的值
		if(object instanceof User){
			User user = (User)object;							//如果是User类型将其转换成User对象
			map.put(user.getUsername(),event.getSession());		//将用户名  和 其对应的session值保存到map集合中去 
		}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		
	}

}
