package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.acao.ListaEmpresas;
import br.com.alura.gerenciador.acao.RemoveEmpresa;
import br.com.alura.gerenciador.acao.MostraEmpresa;
import br.com.alura.gerenciador.acao.Acao;
import br.com.alura.gerenciador.acao.AlteraEmpresa;
import br.com.alura.gerenciador.acao.NovaEmpresa;
import br.com.alura.gerenciador.acao.NovaEmpresaForm;
/**
 * Servlet implementation class UnicaEntradaServlet
 */
//@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acaoParam = request.getParameter("acao");
		acaoParam = acaoParam.substring(0,1).toUpperCase() + acaoParam.substring(1, acaoParam.length());
//		
//		HttpSession sessao = request.getSession();
//		
//		boolean usuarioNaoLogado = sessao.getAttribute("usuarioLogado") == null;
//		boolean ehUmaAcaoProtejuda = !(acaoParam.equals("Login") || acaoParam.equals("LoginForm"));
//		
//		if(ehUmaAcaoProtejuda && usuarioNaoLogado) {
//			response.sendRedirect("entrada?acao=LoginForm");
//			return;
//		}
//		
	
		
		String nomeDaClasse = "br.com.alura.gerenciador.acao." + acaoParam;
		String nome;
		
		try {
			Class classe = Class.forName(nomeDaClasse);
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException e) {
			throw new ServletException(e);		}

		String[] tipoEEndereco = nome.split(":");
		if( tipoEEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(tipoEEndereco[1]);
		}
		
//		if(acao.equals("ListaEmpresas")) {
//			ListaEmpresas acaoLista = new ListaEmpresas();
//			nome = acaoLista.executa(request, response);
//			
//		} else if(acao.equals("RemoveEmpresa")) {
//			RemoveEmpresa acaoRemove = new RemoveEmpresa();
//			nome = acaoRemove.executa(request, response);;
//			
//		} else if(acao.equals("MostraEmpresa")) {
//			MostraEmpresa acaoMostra = new MostraEmpresa();
//			nome = acaoMostra.executa(request, response);
//		} else if (acao.equals("AlteraEmpresa")) {
//			AlteraEmpresa acaoAltera = new AlteraEmpresa();
//			nome = acaoAltera.executa(request, response);
//		} else if (acao.equals("NovaEmpresa")) {
//			NovaEmpresa acaoNova = new NovaEmpresa();
//			nome = acaoNova.executa(request, response);
//		} else if (acao.equals("NovaEmpresaForm")) {
//			NovaEmpresaForm acaoNova = new NovaEmpresaForm();
//			nome = acaoNova.executa(request, response);
//		}

	}

}
