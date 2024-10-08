package objetos;

public class Funcionario {
	
	private String nome;
	private String cargo;
	private int id;
	private double vendas;
	
	public Funcionario() {
		
	}
	
	

	public Funcionario(String nome, String cargo, int id, double vendas) {
		this.nome = nome;
		this.cargo = cargo;
		this.id = id;
		this.vendas = vendas;
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getVendas() {
		return vendas;
	}

	public void setVendas(double vendas) {
		this.vendas = vendas;
	}

	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + ", cargo=" + cargo + ", id=" + id + ", vendas=" + vendas + "]";
	}
}
