//import java.io.*;

public class Livro{
	private char tipo;
	private String nome;
	private String editora;
	private int numPaginas;
	private boolean isEmprestado;
	private Usuario usuario;

	//construtor
	Livro(char tipo, String nome, String editora, int numPaginas){
		this.tipo = tipo;
		this.nome = nome;
		this.editora = editora;
		this.numPaginas = numPaginas;

		this.isEmprestado = false;
	}

	void setIsEmprestado(boolean resposta){
		isEmprestado = resposta;
	}
	
	void getIsEmprestado(){
		return isEmprestado;
	}	

	void setUsuario(Usuario usuario){
		this.usuario = usuario;
	}
	
	void getUsuario(){
		return this.usuario;
	}	

}
