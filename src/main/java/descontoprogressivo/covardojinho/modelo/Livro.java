package descontoprogressivo.covardojinho.modelo;

public class Livro {
	
	private Integer id;
	
	private String nome;
	
	private Double valor = 8.00;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Livro(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
}
