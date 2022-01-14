package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AutorizacaoFilter
 */
//@WebFilter("/entrada")
public class AutorizacaoFilter extends HttpFilter implements Filter {
	
	@Override
	public void init() throws ServletException {
	
	}
	
	@Override
	public void destroy() {

	}
	
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		System.out.println("Autorizacao"); 
		
		HttpServletRequest request = (HttpServletRequest)req; 
		HttpServletResponse response = (HttpServletResponse)res; 
		
		String acaoParam = request.getParameter("acao");
		acaoParam = acaoParam.substring(0,1).toUpperCase() + acaoParam.substring(1, acaoParam.length());
		
		HttpSession sessao = request.getSession();
		
		boolean usuarioNaoLogado = sessao.getAttribute("usuarioLogado") == null;
		boolean ehUmaAcaoProtejuda = !(acaoParam.equals("Login") || acaoParam.equals("LoginForm"));
		
		if(ehUmaAcaoProtejuda && usuarioNaoLogado) {
			response.sendRedirect("entrada?acao=LoginForm");
			return;
		}
		
		chain.doFilter(request, response);
		
	}


}
