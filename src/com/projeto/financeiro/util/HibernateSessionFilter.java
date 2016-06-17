package com.projeto.financeiro.util;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.Filter;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.engine.spi.FilterDefinition;

@WebFilter(servletNames={"Faces Servlet"})
public class HibernateSessionFilter implements Filter {
	
	@Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
                 throws IOException, ServletException {
		
		Session session = HibernateUtil.getSession();
		Transaction trx = null;
		
		try{
			
			trx = session.beginTransaction();
			request.setAttribute("session", session);
			
			chain.doFilter(request, response);
			
			trx.commit();
		}catch (Exception e){
			if(trx != null){
				trx.rollback();
			}
		}finally{
			session.close();
		}
		
		
		
	}
	
    @Override
	public void destroy(){
		}
	
	@Override
	public void init(FilterConfig config) throws ServletException{
		
	}


}

