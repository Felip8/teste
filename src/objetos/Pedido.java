package objetos;

import java.util.List;

public class Pedido {
	
	private int id;
	private Mesa mesa;
	private Funcionario func;
	private List<ItemCardapio> pedidos;
	private double valorTotal;
	private boolean status; //true: aberto false: fechado
	
	public Pedido() {
		this.status = true;
	}

	public int getId() {
		return id;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public Funcionario getFunc() {
		return func;
	}

	public void setFunc(Funcionario func) {
		this.func = func;
	}

	public List<ItemCardapio> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<ItemCardapio> pedidos) {
		this.pedidos = pedidos;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Pedido: " + id + 
											 " |Mesa: " + mesa.getId() + 
											 " | Garçom: " + func.getNome() +
											 "\n-- ITENS --\n");

		for (int i = 0; i < pedidos.size(); i++) {
			sb.append("Nome: " + pedidos.get(i).getNome() + 
					  "| Preço: " + pedidos.get(i).getPreco() + "\n");
		}
		sb.append("\nValor Final: " + valorTotal +
				  "\n----------------------------\n");
		
		return sb.toString();		
	}	
	
	public String toStringShort() {
		return "Pedido: " + id + 
			   " |Mesa: " + mesa.getId() + 
			   " | Garçom: " + func.getNome() +
			   " | Valor Total: " + valorTotal;
	}
}
