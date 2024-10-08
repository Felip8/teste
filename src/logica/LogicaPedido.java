package logica;

import java.util.ArrayList;
import java.util.List;

import app.Main;
import objetos.ItemCardapio;
import objetos.Pedido;

public class LogicaPedido {
		
	private static List<Pedido> listaPedidos = new ArrayList<Pedido>();
	private static int idPedido = 1;
	private static int idMesa = 0;
	
	public static void adicionarPedido() {
		Pedido pedido = new Pedido();
		List<ItemCardapio> novaListaItemPedido = new ArrayList<ItemCardapio>();
		
		//id auto incrementado
		pedido.setId(idPedido);
		idPedido++;
		
		//identificar garçom
		System.out.println("\n-- IDENTIFIQUE-SE --\n");
		LogicaFuncionario.listarGarcom();
		System.out.println("Selecionar garçom [id]:");
		pedido.setFunc(LogicaFuncionario.capturarGarçom(Main.getScan().nextInt()));
		
		
		//associar mesa ao pedido e mudar disponibilidade da mesa
		System.out.println("\n -- MESAS DISPONÍVEIS --");
		LogicaMesa.listarMesaDisponivel();
		System.out.println("\n Selecionar mesa [id]:");
		idMesa = Main.getScan().nextInt();
		pedido.setMesa(LogicaMesa.capturarMesaDisponível(idMesa));
		LogicaMesa.mudarDisponibilidadeMesa(idMesa);
		
		//adicinar itens ao pedido
		System.out.println("\n -- CARDÁPIO --");
		LogicaCardapio.listarItemCardapioDisponivel();
		
		System.out.println("Adicionar item [id]:");
		ItemCardapio item = LogicaCardapio.capturarItemCardapio(Main.getScan().nextInt());
		
		System.out.println("Quantidade:");
		int quantidadeItem = Main.getScan().nextInt();
		
		for (int i = 0; i < quantidadeItem; i++) {
			pedido.setValorTotal(pedido.getValorTotal() + item.getPreco());
			novaListaItemPedido.add(item);
		}
		
		pedido.setPedidos(novaListaItemPedido);
		
		listaPedidos.add(pedido);
	}
	
	public static void listarPedido() {
		for (Pedido pedido : listaPedidos) {
			System.out.println(pedido.toString());
		}
	}
	
	public static void listarPedidosAbertos() {
		System.out.println("-- PEDIDOS ABERTOS --");
		for (Pedido pedido : listaPedidos) {
			if(pedido.isStatus()) {
				System.out.println(pedido.toStringShort());
			}
		}
	}
	
	public static void listarPedidosFechados() {
		System.out.println("-- PEDIDOS FECHADOS --");
		for (Pedido pedido : listaPedidos) {
			if(!pedido.isStatus()) {
				System.out.println(pedido.toStringShort());
			}
		}
	}
	
	public static void mudarStatusPedido(int id) {
		for (Pedido pedido : listaPedidos) {
			if(pedido.getId() == id) {
				pedido.setStatus(!pedido.isStatus());
			}
		}
	}
	
	public static void incrementarPedido() {
		int idPedido = 0;
		int idItemCardapio = 0;
		int qtdAdd = 0;
		ItemCardapio novoItem = new ItemCardapio();
		
		listarPedidosAbertos();
		System.out.println("Selecione o pedido [id]:");
		idPedido = Main.getScan().nextInt();
		Main.getScan().nextLine();
		
		LogicaCardapio.listarItemCardapioDisponivel();
		System.out.println("Selecione o item [id]:");
		idItemCardapio = Main.getScan().nextInt();
		Main.getScan().nextLine();
		novoItem = LogicaCardapio.capturarItemCardapio(idItemCardapio);
		
		System.out.println("Quantidade: ");
		qtdAdd = Main.getScan().nextInt();
		Main.getScan().nextLine();
		
		for (Pedido pedido : listaPedidos) {
			if (pedido.getId() == idPedido) {
				for (int i = 0; i < qtdAdd; i++) {
					pedido.setValorTotal(pedido.getValorTotal() + novoItem.getPreco());
					pedido.getPedidos().add(novoItem);
				}
			}
		}
	}
	
	public static void finalizarPedido() {
		int idPedido = 0;
		
		listarPedidosAbertos();
		System.out.println("Selecione o pedido a ser finalizado [id]: ");
		idPedido = Main.getScan().nextInt();
		Main.getScan().nextLine();
		mudarStatusPedido(idPedido);
		
		for (Pedido pedido : listaPedidos) {
			if (pedido.getId() == idPedido) {
				pedido.getFunc().setVendas(pedido.getFunc().getVendas() + pedido.getValorTotal());
				pedido.getMesa().setDisp(true);
			}
		}
	}
}
