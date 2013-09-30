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
	
	@Test public void
	quandoHouverTresLivrosDiferentes_entao_aplicarDescontoDeDezPorCento() {
		Carrinho carrinho = carrinhoComTresLivrosDiferentes();
		carrinho.calculaTotal();
		assertEquals(Double.valueOf(21.60), carrinho.getTotal());
	}
	
	@Test public void
	quandoHouverTresLivrosDiferentes_e_umIgual_entao_aplicarDescontoDeDezPorCentoNosTres() {
		Carrinho carrinho = carrinhoComTresLivrosDiferentesEUmIgual();
		carrinho.calculaTotal();
		assertEquals(Double.valueOf(29.60), carrinho.getTotal());
	}
	
	@Test public void
	quandoHouverQuatroLivrosDiferentes_entao_aplicarDescontoDeVintePorCento() {
		Carrinho carrinho = carrinhoComQuatroLivrosDiferentes();
		carrinho.calculaTotal();
		assertEquals(Double.valueOf(25.60), carrinho.getTotal());
	}
	
	@Test public void
	quandoHouverCincoLivrosDiferentes_entao_aplicarDescontoDeVintePorCento() {
		Carrinho carrinho = carrinhoComCincoLivrosDiferentes();
		carrinho.calculaTotal();
		assertEquals(Double.valueOf(30.00), carrinho.getTotal());
	}
	
	@Test public void
	quandoHouverCincoLivros_sendo_tresDiferentesEDoisDiferentes_entao_deveCalcularDescontoDeDezECincoPorCento() {
		Carrinho carrinho = carrinhoComCincoLivros();
		carrinho.calculaTotal();
		assertEquals(Double.valueOf(36.80), carrinho.getTotal());
	}
	
	private Carrinho carrinhoComCincoLivros() {
		Compra compra = new Compra(primeiroLivro(), 1);
		Compra compraSegundoLivro = new Compra(segundoLivro(), 2);
		Compra compraTerceiroLivro = new Compra(terceiroLivro(), 2);
		List<Compra> compras = newArrayList(compra, compraSegundoLivro, compraTerceiroLivro);
		Carrinho carrinho = new Carrinho();
		carrinho.setCompras(compras);
		return carrinho;
	}

	private Carrinho carrinhoComCincoLivrosDiferentes() {
		Compra compra = new Compra(primeiroLivro(), 1);
		Compra compraSegundoLivro = new Compra(segundoLivro(), 1);
		Compra compraTerceiroLivro = new Compra(terceiroLivro(), 1);
		Compra compraQuartoLivro = new Compra(quartoLivro(), 1);
		Compra compraQuintoLivro = new Compra(quintoLivro(), 1);
		List<Compra> compras = newArrayList(compra, compraSegundoLivro, compraTerceiroLivro, compraQuartoLivro, compraQuintoLivro);
		Carrinho carrinho = new Carrinho();
		carrinho.setCompras(compras);
		return carrinho;
	}

	private Carrinho carrinhoComQuatroLivrosDiferentes() {
		Compra compra = new Compra(primeiroLivro(), 1);
		Compra compraSegundoLivro = new Compra(segundoLivro(), 1);
		Compra compraTerceiroLivro = new Compra(terceiroLivro(), 1);
		Compra compraQuartoLivro = new Compra(quartoLivro(), 1);
		List<Compra> compras = newArrayList(compra, compraSegundoLivro, compraTerceiroLivro, compraQuartoLivro);
		Carrinho carrinho = new Carrinho();
		carrinho.setCompras(compras);
		return carrinho;
	}

	private Carrinho carrinhoComTresLivrosDiferentesEUmIgual() {
		Compra compra = new Compra(primeiroLivro(), 1);
		Compra compraSegundoLivro = new Compra(segundoLivro(), 2);
		Compra compraTerceiroLivro = new Compra(terceiroLivro(), 1);
		List<Compra> compras = newArrayList(compra, compraSegundoLivro, compraTerceiroLivro);
		Carrinho carrinho = new Carrinho();
		carrinho.setCompras(compras);
		return carrinho;
	}

	private Carrinho carrinhoComTresLivrosDiferentes() {
		Compra compra = new Compra(primeiroLivro(), 1);
		Compra compraSegundoLivro = new Compra(segundoLivro(), 1);
		Compra compraTerceiroLivro = new Compra(terceiroLivro(), 1);
		List<Compra> compras = newArrayList(compra, compraSegundoLivro, compraTerceiroLivro);
		Carrinho carrinho = new Carrinho();
		carrinho.setCompras(compras);
		return carrinho;
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
	
	private Livro quintoLivro() {
		return new Livro(5, "Game of Thrones V");
	}
	
	private Livro quartoLivro() {
		return new Livro(4, "Game of Thrones IV");
	}
	
	private Livro terceiroLivro() {
		return new Livro(3, "Game of Thrones III");
	}
	
	private Livro segundoLivro() {
		return new Livro(2, "Game of Thrones II");
	}

	private Livro primeiroLivro() {
		return new Livro(1, "Game of Thrones I");
	}
	
	

}
