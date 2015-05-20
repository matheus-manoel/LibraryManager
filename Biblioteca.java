//parei nos emprestimos (setEmrpestimoALuno, comunidade, professor, etc). Ler melhor as especificações do trabalho para continuar.
//tirar o 'tipo' e criar classe de usuário que estende o usuário


//import java.io.*;
import java.util.*;
//comment updated
//yeah
public class Biblioteca{
	ArrayList<Livro> emprestimos = new ArrayList();

	void setEmprestimo(Usuario usuario, Livro livro){
		emprestimos.add(livro);
		livro.setEmprestado(true);
		livro.setUsuario(usuario);

		if(usuario.getTipo() == 'a'){					//aluno
			setEmprestimoAluno();

		}else if(usuario.getTipo() == 'p'){				//professor
			setEmprestimoProfessor();

		}else if(usuario.getTipo() == 'c'){				//comunidade
			setEmprestimoComunidade();
		}
	}

	void setDevolucao(Usuario usuario, Livro livro){
		emprestimos.remove(livro);
		livro.setEmprestado(false);
		livro.setUsuario(null);
	}

	void showLivrosEmprestados(){
		if(ArrayList.isEmpty()){
			//printar q ta vazio
		
		} else{

			//verificar se é ate aqui mesmo ou ate aqui +/- 1
			for(i = 0; i < emprestimos.size(); i++){
				//printar na tela o elemento 'emprestimos.get(i)'
			}
		}
	}

}
