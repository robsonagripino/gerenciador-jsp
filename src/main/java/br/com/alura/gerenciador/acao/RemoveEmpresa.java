package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class RemoveEmpresa implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		System.out.println("removendo empresa");
		Integer id = Integer.valueOf(request.getParameter("id"));

		Banco banco = new Banco();
		banco.deleta(id);;
		
		//response.set
		return "redirect:entrada?acao=listaEmpresas";
	}
}
