package descontoprogressivo.covardojinho.desconto;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import descontoprogressivo.covardojinho.modelo.Carrinho;
import descontoprogressivo.covardojinho.modelo.Compra;
import descontoprogressivo.covardojinho.modelo.Livro;

public class CarrinhoTest {
	
	@Test public void
	quandoHouverUmLivro_entao_naoTemDesconto() {
		Carrinho carrinho = carrinhoComApenasUmLivro();
		carrinho.calculaTotal();
		assertEquals(Double.valueOf(8.0), carrinho.getTotal());
	}
	
	@Test public void
	quandoHouverDoisLivrosDiferentes_entao_aplicarDescontoDeCincoPorCento() {
		Carrinho carrinho = carrinhoComDoisLivros();
		carrinho.calculaTotal();
		assertEquals(Double.valueOf(15.20), carrinho.getTotal());
	}
	
	@Test public void
	quandoHouverDoisLivrosDiferentes_e_umIgual_entao_aplicarDescontoDeCincoPorCentoNosDois() {
		Carrinho carrinho = carrinhoComTresLivros();
		carrinho.calculaTotal();
		assertEquals(Double.valueOf(23.20), carrinho.getTotal());
	}
	
	private Carrinho carrinhoComTresLivros() {
		Compra compra = new Compra(primeiroLivro(), 2);
		Compra compraSegundoLivro = new Compra(segundoLivro(), 1);
		List<Compra> compras = newArrayList(compra, compraSegundoLivro);
		Carrinho carrinho = new Carrinho();
		carrinho.setCompras(compras);
		return carrinho;
	}

	private Carrinho carrinhoComDoisLivros() {
		Compra compra = new Compra(primeiroLivro(), 1);
		Compra compraSegundoLivro = new Compra(segundoLivro(), 1);
		List<Compra> compras = newArrayList(compra, compraSegundoLivro);
		Carrinho carrinho = new Carrinho();
		carrinho.setCompras(compras);
		return carrinho;
	}

	private Carrinho carrinhoComApenasUmLivro() {
		Compra compra = new Compra(primeiroLivro(), 1);
		List<Compra> compras = newArrayList(compra);
		Carrinho carrinho = new Carrinho();
		carrinho.setCompras(compras);
		return carrinho;
	}
	
	private Livro segundoLivro() {
		return new Livro(2, "Game of Thrones II");
	}

	private Livro primeiroLivro() {
		return new Livro(1, "Game of Thrones I");
	}
	
	

}
