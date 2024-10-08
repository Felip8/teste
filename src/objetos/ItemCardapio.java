package objetos;

public class ItemCardapio {
	
	private String nome;
	private int id;
	private boolean disp;
	private double preco;
	
	public ItemCardapio() {
		disp = true;
	}
	
	
	public ItemCardapio(String nome, int id, boolean disp, double preco) {
		super();
		this.nome = nome;
		this.id = id;
		this.disp = disp;
		this.preco = preco;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isDisp() {
		return disp;
	}

	public void setDisp(boolean disp) {
		this.disp = disp;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "id: " + id + " | " + nome + "| R$" + preco;
	}
}
