package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	private static List<Empresa> empresas = new ArrayList<Empresa>();
	private static List<Usuario> usuarios = new ArrayList<Usuario>();
	private static Integer chaveSequencial = 1;
	
	static {
		Empresa empresa1 = new Empresa();
		empresa1.setId(chaveSequencial);
		empresa1.setNome("Alura");
		empresas.add(empresa1);
		
		Empresa empresa2 = new Empresa();
		empresa2.setId(++chaveSequencial);
		empresa2.setNome("Caelum");
		empresas.add(empresa2);

		Empresa empresa3 = new Empresa();
		empresa3.setId(++chaveSequencial);
		empresa3.setNome("Facebook");
		Banco.empresas.add(empresa3);
		
		
		Usuario u1 = new Usuario();
		u1.setLogin("Nico");
		u1.setSenha("12345");
		usuarios.add(u1);
		
		Usuario u2 = new Usuario();
		u2.setLogin("Ana");
		u2.setSenha("12345");
		usuarios.add(u2);
	}
	
	public void adiciona(Empresa empresa) {
		empresa.setId(++Banco.chaveSequencial);
		Banco.empresas.add(empresa);
	}
	
	public List<Empresa> getEmpresas() {
		return Banco.empresas;
	}
	
	public void deleta(Integer id) {
		Banco.empresas.remove(getEmpresa(id));
	}
	
	public void altera(Integer id, Empresa novaEmpresa) {
		Empresa empresa = getEmpresa(id);
		
		empresa.setDataAbertura(novaEmpresa.getDataAbertura());
		empresa.setNome(novaEmpresa.getNome());
	}
	
	public Empresa getEmpresa(Integer id) {
		for (Empresa empresa : Banco.empresas) {
			if(empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}

	public Usuario existeUsuario(String login, String senha) {
		for(Usuario usuario: usuarios) {
			if(usuario.ehIgual(login, senha)) {
				return usuario;
			}
		}
		
		return null;
	}

}
