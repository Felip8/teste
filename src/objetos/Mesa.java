package objetos;

public class Mesa {
	
	private int id;
	private int capacidade;
	private boolean disp;
	
	public Mesa() {
		
	}

	public Mesa(int id, int capacidade, boolean disp) {
		super();
		this.id = id;
		this.capacidade = capacidade;
		this.disp = disp;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public boolean isDisp() {
		return disp;
	}

	public void setDisp(boolean disp) {
		this.disp = disp;
	}

	@Override
	public String toString() {
		return "id:" + id + "| capacidade=" + capacidade + "| disp:" + disp;
	}
}
