package home.main.java.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

/**
 * Created by Alexej on 02.08.2015.
 */
public class FilterJS implements Filter {

	private final Logger LOG= LogManager.getLogger(this.getClass().getName());


	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)servletRequest;
		if(request.getRequestURI().startsWith("/js")||request.getRequestURI().startsWith("/style")){
			request.getRequestDispatcher(request.getRequestURI()).forward(servletRequest,servletResponse);
		}else{
			request.getRequestDispatcher("/servlet").forward(servletRequest,servletResponse);
		}
	}

	@Override
	public void destroy() {

	}
}
