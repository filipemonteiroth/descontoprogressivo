package descontoprogressivo.covardojinho.modelo;

import java.util.ArrayList;
import java.util.List;

public class Desconto {
	
	private Double total;
	
	private List<Livro> descontos = new ArrayList<Livro>();

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public List<Livro> getDescontos() {
		return descontos;
	}

	public Desconto(Double total, List<Livro> descontos) {
		super();
		this.total = total;
		this.descontos = descontos;
	}
	
}
