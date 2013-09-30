package descontoprogressivo.covardojinho.desconto;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.*;
import descontoprogressivo.covardojinho.modelo.Desconto;
import descontoprogressivo.covardojinho.modelo.Livro;

public class CalculadorDeCompra {

	public List<Desconto> calculaDesconto(List<Livro> livros) {
		Desconto desconto = buscaDesconto(livros);
		return newArrayList(desconto);
	}

	public Desconto buscaDesconto(List<Livro> livros) {
		List<Livro> descontos = new ArrayList<Livro>();		
		for (Livro livro : livros) {
			if (!encontrou(livro, descontos)) {
				descontos.add(livro);
			}
		}
		double totalDoDesconto = calculaDescontosPorLivros(descontos);
		return new Desconto(totalDoDesconto, descontos);
	}

	private double calculaDescontosPorLivros(List<Livro> descontos) {
		if (descontos.size() == 2) {
			return 5.0;
		}
		return 0.0;
	}

	private boolean encontrou(Livro livro, List<Livro> descontos) {
		if (!descontos.isEmpty()) {
			for (Livro livroDeDesconto : descontos) {
				if (livro.getId().equals(livroDeDesconto.getId())){
					return true;
				}
			}
		}
		return false;
	}

}
