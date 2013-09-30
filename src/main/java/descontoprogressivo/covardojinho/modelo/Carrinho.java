package descontoprogressivo.covardojinho.modelo;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
	
	private List<Compra> compras;
	
	private Double total;

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public void calculaTotal() {
		total = calculaTotalDaCompra();
	}

	public double calculaTotalDaCompra() {
		Desconto desconto = calculaDesconto();
		Integer livrosComDesconto = desconto.getDescontos().size();
		int totalDeLivrosComDesconto = livrosComDesconto * 8;
		Double subTotal = (double) (totalDeLivrosComDesconto - (totalDeLivrosComDesconto * desconto.getTotal() / 100));
		int livrosRestantes = calculaLivrosRestantes(livrosComDesconto);
		subTotal = subTotal + (livrosRestantes * 8);
		return subTotal;
	}

	private int calculaLivrosRestantes(int totalDeLivrosComDesconto) {
		return totalDeLivros() - totalDeLivrosComDesconto;
	}

	private Integer totalDeLivros() {
		Integer total = 0;
		for (Compra compra : compras) {
			total += compra.getQuantidade();
		}
		return total;
	}

	private Desconto calculaDesconto() {
		List<Livro> livros = buscaLivrosDiferentes();
		if (livros.size() == 2) {
			Desconto desconto = new Desconto(5.0, livros);
			return desconto;
		}
		Desconto desconto = new Desconto(0.0, livros);
		return desconto;
	}

	private List<Livro> buscaLivrosDiferentes() {
		List<Livro> livros = new ArrayList<Livro>();
		for (Compra compra : compras) {
			if (!encontrou(compra.getLivro(), livros)) {
				livros.add(compra.getLivro());
			}
		}
		return livros;
	}

	private boolean encontrou(Livro livro, List<Livro> livrosDiferentes) {
		for (Livro livroDiferente : livrosDiferentes) {
			if (livro.getId().equals(livroDiferente.getId())) {
				return true;
			}
		}
		return false;
	}
	
}
