package descontoprogressivo.covardojinho.desconto;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

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
		Double desconto = calculadorDeCompra.calculaDesconto(apenasUmLivro());
		assertEquals(Double.valueOf(8.0), desconto);
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
