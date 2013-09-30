package descontoprogressivo.covardojinho.desconto;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import descontoprogressivo.covardojinho.modelo.Desconto;
import descontoprogressivo.covardojinho.modelo.Livro;
import static org.junit.Assert.*;

public class CalculadorDeCompraTest {
	
	private CalculadorDeCompra calculadorDeCompra;
	
	@Before
	public void setUp() {
		calculadorDeCompra = new CalculadorDeCompra();
	}
	
	@Test public void
	quandoHouverUmLivro_entao_naoTemDesconto() {
		List<Desconto> desconto = calculadorDeCompra.calculaDesconto(apenasUmLivro());
		assertEquals(Double.valueOf(0.0), desconto.get(0).getTotal());
	}
	
	@Test public void
	quandoHouverDoisLivrosDiferentes_entao_aplicarDescontoDeCincoPorCento() {
		List<Desconto> desconto = calculadorDeCompra.calculaDesconto(doisLivrosDiferentes());
		assertEquals(Double.valueOf(5.0), desconto.get(0).getTotal());
	}

	private List<Livro> doisLivrosDiferentes() {
		List<Livro> livros = new ArrayList<Livro>();
		livros.add(primeiroLivro());
		livros.add(segundoLivro());
		return livros;
	}

	private Livro segundoLivro() {
		return new Livro(2, "Game of Thrones II");
	}

	private List<Livro> apenasUmLivro() {
		List<Livro> livros = new ArrayList<Livro>();
		livros.add(primeiroLivro());
		return livros;
	}

	private Livro primeiroLivro() {
		return new Livro(1, "Game of Thrones I");
	}
	
	

}
