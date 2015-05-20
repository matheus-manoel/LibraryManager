//import java.io.*;

public class Usuario{
	private char tipo;					//'a'=aluno, 'p'=professor, 'c'=comunidade
	private Livro livroAtual;

	//construtor
	Usuario(char tipo){
		this.tipo = tipo;
	}

	void setLivroAtual(Livro livro){
		livroAtual = livro;
	} 
	Livro getLivroAtual(){
		return this.livroAtual;
	}

	Livro getTipo(){
		return this.tipo;
	}	
}