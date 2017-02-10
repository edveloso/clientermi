import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import br.com.caelum.estoque.entidades.Livro;
import br.com.caelum.estoque.services.EstoqueRmi;
import br.com.caelum.estoque.services.LivroService;


public class Main {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		
		for (;;) {
			LivroService service = (LivroService) Naming.lookup("rmi://localhost:1099/LivroService");
			System.out.println(service.cadastrar(new Livro()));
			
			EstoqueRmi ser = (EstoqueRmi) Naming.lookup("rmi://localhost:1099/estoque");
			System.out.println(ser.getItemEstoque("tdd").getQuantidade());
		}
		
		
	}
	
}
