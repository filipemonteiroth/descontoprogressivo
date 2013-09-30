package descontoprogressivo.covardojinho.modelo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;
import static com.google.common.collect.Lists.*;

public class DescontoTest {
	
	@Test public void
	quandoTotalDeLivrosDoDescontoForUm_entao_totalDeDescontosEZero() {
		Desconto desconto = new Desconto(umLivro());
		assertEquals(Double.valueOf(0.0), desconto.getTotal());
	}
	
	@Test public void
	quandoTotalDeLivrosDoDescontoForemDois_entao_totalDeDescontosECincoPorCento() {
		Desconto desconto = new Desconto(doisLivros());
		assertEquals(Double.valueOf(5.0), desconto.getTotal());
	}
	
	@Test public void
	quandoTotalDeLivrosDoDescontoForemTres_entao_totalDeDescontosEDezPorCento() {
		Desconto desconto = new Desconto(tresLivros());
		assertEquals(Double.valueOf(10.0), desconto.getTotal());
	}
	
	@Test public void
	quandoTotalDeLivrosDoDescontoForemQuatro_entao_totalDeDescontosEVintePorCento() {
		Desconto desconto = new Desconto(quatroLivros());
		assertEquals(Double.valueOf(20.0), desconto.getTotal());
	}
	
	@Test public void
	quandoTotalDeLivrosDoDescontoForemCinco_entao_totalDeDescontosEVinteECincoPorCento() {
		Desconto desconto = new Desconto(cincoLivros());
		assertEquals(Double.valueOf(25.0), desconto.getTotal());
	}

	private List<Livro> cincoLivros() {
		return newArrayList(livroUm(), livroDois(), livroTres(), livroQuatro(), livroCinco());
	}

	private Livro livroCinco() {
		return new Livro(5, "Livro 5");
	}

	private List<Livro> quatroLivros() {
		return newArrayList(livroUm(), livroDois(), livroTres(), livroQuatro());
	}

	private Livro livroQuatro() {
		return new Livro(4, "Livro 4");
	}

	private List<Livro> tresLivros() {
		return newArrayList(livroUm(), livroDois(), livroTres());
	}

	private Livro livroTres() {
		return new Livro(3, "Livro 3");
	}

	public ArrayList<Livro> umLivro() {
		return newArrayList(livroUm());
	}

	public Livro livroUm() {
		return new Livro(1, "Livro 1");
	}
	
	public ArrayList<Livro> doisLivros() {
		return newArrayList(livroUm(), livroDois());
	}

	public Livro livroDois() {
		return new Livro(2, "Livro 2");
	}

}
