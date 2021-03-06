package descontoprogressivo.covardojinho.main;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

import descontoprogressivo.covardojinho.modelo.Carrinho;
import descontoprogressivo.covardojinho.modelo.Compra;
import descontoprogressivo.covardojinho.modelo.Livro;

public class StartApp {

	public static void main(String[] args) {
		primeiroDesafio();
		desafioPrincipal();
	}

	public static void primeiroDesafio() {
		Compra compra = new Compra(primeiroLivro(), 1);
		Compra compraSegundoLivro = new Compra(segundoLivro(), 1);
		Compra compraTerceiroLivro = new Compra(terceiroLivro(), 2);
		List<Compra> compras = newArrayList(compra, compraSegundoLivro, compraTerceiroLivro);
		Carrinho carrinho = new Carrinho();
		carrinho.setCompras(compras);
		System.out.println("1 Copias do Livro 1");
		System.out.println("1 Copias do Livro 2");
		System.out.println("2 Copias do Livro 3");
		System.out.println("Total das suas compras foi: " + carrinho.getTotal());
	}

	public static void desafioPrincipal() {
		Compra compra = new Compra(primeiroLivro(), 2);
		Compra compraSegundoLivro = new Compra(segundoLivro(), 2);
		Compra compraTerceiroLivro = new Compra(terceiroLivro(), 2);
		Compra compraQuartoLivro = new Compra(quartoLivro(), 1);
		Compra compraQuintoLivro = new Compra(quintoLivro(), 1);
		List<Compra> compras = newArrayList(compra, compraSegundoLivro, compraTerceiroLivro, compraQuartoLivro, compraQuintoLivro);
		Carrinho carrinho = new Carrinho();
		carrinho.setCompras(compras);
		System.out.println("2 Copias do Livro 1");
		System.out.println("2 Copias do Livro 2");
		System.out.println("2 Copias do Livro 3");
		System.out.println("1 Copia do Livro 4");
		System.out.println("1 Copia do Livro 5");
		System.out.println("Total das suas compras foi: " + carrinho.getTotal());
	}
	
	private static Livro quintoLivro() {
		return new Livro(5, "Game of Thrones V");
	}
	
	private static Livro quartoLivro() {
		return new Livro(4, "Game of Thrones IV");
	}
	
	private static Livro terceiroLivro() {
		return new Livro(3, "Game of Thrones III");
	}
	
	private static Livro segundoLivro() {
		return new Livro(2, "Game of Thrones II");
	}

	private static Livro primeiroLivro() {
		return new Livro(1, "Game of Thrones I");
	}

}
