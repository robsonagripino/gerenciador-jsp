package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class AlteraEmpresa implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		System.out.println("alterando empresa");
		System.out.println(request.getParameter("id"));
		Integer id = Integer.valueOf(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String data = request.getParameter("data");
	
		Banco banco = new Banco();
		Empresa empresa = banco.getEmpresa(id);	

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date dataAbertura = sdf.parse(data);
			
			empresa.setNome(nome);
			empresa.setDataAbertura(dataAbertura);
		} catch (ParseException e){
			throw new ServletException(e);
		}
		
		return "redirect:entrada?acao=ListaEmpresas";
	}
}
