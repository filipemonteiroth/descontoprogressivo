package descontoprogressivo.covardojinho.modelo;

import java.util.ArrayList;
import java.util.List;

public class Desconto {
	
	private List<Livro> descontos = new ArrayList<Livro>();

	public Double getTotal() {
		if (descontos.size() == 2) {
			return 5.0;
		} else if (descontos.size() == 3) {
			return 10.0;
		} else if (descontos.size() == 4) {
			return 20.0;
		} else if (descontos.size() == 5) {
			return 25.0;
		}
		return 0.0;
	}

	public List<Livro> getDescontos() {
		return descontos;
	}
	
	public void setDescontos(List<Livro> descontos) {
		this.descontos = descontos;
	}

	public Desconto(List<Livro> descontos) {
		this.descontos = descontos;
	}
	
}
