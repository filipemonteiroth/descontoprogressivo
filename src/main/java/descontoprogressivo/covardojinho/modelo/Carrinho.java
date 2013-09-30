package descontoprogressivo.covardojinho.modelo;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
	
	private List<Compra> compras;
	
	private Double total;

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	public Double getTotal() {
		calculaTotal();
		return total;
	}

	public void calculaTotal() {
		total = calculaTotalDaCompra();
	}

	public double calculaTotalDaCompra() {
		Double subTotal = 0.0;
		List<Desconto> descontos = calculaDesconto();
		for (Desconto desconto : descontos) {
			Integer livrosComDesconto = desconto.getDescontos().size();
			int totalDeLivrosComDesconto = livrosComDesconto * 8;
			subTotal = subTotal + (double) (totalDeLivrosComDesconto - (totalDeLivrosComDesconto * desconto.getTotal() / 100));
		}
		int livrosRestantes = calculaLivrosRestantes();
		subTotal = subTotal + (livrosRestantes * 8);
		return subTotal;
	}

	private int calculaLivrosRestantes() {
		Integer total = 0;
		for (Compra compra : compras) {
			total += compra.getQuantidade();
		}
		return total;
	}

	private List<Desconto> calculaDesconto() {
		List<Desconto> descontos = new ArrayList<Desconto>();
		List<Compra> comprasAux = compras;
		while (existirLivros(comprasAux)) {
			List<Livro> livros = new ArrayList<Livro>();
			for (Compra compra : comprasAux) {
				if ((compra.getQuantidade() > 0) && !existeMelhorCombinacao(comprasAux, livros)) {
					livros.add(compra.getLivro());
					compra.setQuantidade(compra.getQuantidade() - 1);
				}
			}
			Desconto desconto = new Desconto(livros);
			descontos.add(desconto);	
		}		
		return descontos;
	}

	public boolean existeMelhorCombinacao(List<Compra> comprasAux, List<Livro> livros) {
		return (livros.size() == 4 && quantidadeRestante(comprasAux) >= 3);
	}

	private int quantidadeRestante(List<Compra> comprasAux) {
		Integer total = 0;
		for (Compra compra : comprasAux) {
			total += compra.getQuantidade();		
		}
		return total;
	}

	private boolean existirLivros(List<Compra> comprasAux) {
		for (Compra compra : comprasAux) {
			if (compra.getQuantidade() > 0) {
				return true;
			}			
		}
		return false;
	}

}
