package com.dragon.action;

import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.I18nInterceptor;

public abstract class AbstractBaseAction extends ActionSupport implements
		SessionAware, ServletRequestAware, ServletResponseAware,
		ServletContextAware {

	private static final long serialVersionUID = 1L;

	protected Map<String, Object> session = null;
	protected HttpServletRequest request = null;
	protected HttpServletResponse response = null;
	protected ServletContext context = null;

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletRequest getServletRequest() {
		return request;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public HttpServletResponse getServletResponse() {
		return response;
	}

	public void setSession(Map<String, Object> session) {
		Locale locale = request.getLocale();
		session.put(I18nInterceptor.DEFAULT_SESSION_ATTRIBUTE, locale);
		this.session = session;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setServletContext(ServletContext context) {
		this.context = context;
	}

	public ServletContext getServletContext() {
		return context;
	}

	public byte[] getCustomImageInBytes() {
		return null;
	}

	public String getCustomContentType() {
		return null;
	}
}
