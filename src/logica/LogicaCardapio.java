package logica;

import java.util.ArrayList;
import java.util.List;

import app.Main;
import objetos.ItemCardapio;

public class LogicaCardapio {
	
	public static List<ItemCardapio> cardapio = new ArrayList<ItemCardapio>();
	private static int proximoId = 1;
	
	public static void cardapio() {
		ItemCardapio item1 = new ItemCardapio("Risoto", 1, true, 35.0);
		ItemCardapio item2 = new ItemCardapio("Bife", 2, true, 20.0);
		ItemCardapio item3 = new ItemCardapio("Coca-Cola", 3, true, 6.0);
		ItemCardapio item4 = new ItemCardapio("Sorvete", 4, true, 15.0);
		
		cardapio.add(item1);
		cardapio.add(item2);
		cardapio.add(item3);
		cardapio.add(item4);
	}

	public static void adicionarItemCardapio() {	
		ItemCardapio item = new ItemCardapio();
		
		item.setId(proximoId);
		proximoId++;
		
		System.out.println("Nome do prato/bebida:");
		item.setNome(Main.getScan().nextLine());
		
		System.out.println("Preço:");
		item.setPreco(Main.getScan().nextDouble());
		
		cardapio.add(item);
	}
	
	public static void listarItemCardapio() {
		for (ItemCardapio item : cardapio) {
			System.out.println(item.toString());
		}
	}
	
	public static void alterarDisponibilidade() {
		int idItem = 0;
		System.out.println("\n-- ALTERAR DISPONIBILIDADE --");
		for (ItemCardapio item : cardapio) {
			System.out.println(item.getId() + "|" +  item.getNome() + "|" + item.isDisp());
		}
		System.out.println("\nInsira o Id do item que deseja alterar:");
		idItem = Main.getScan().nextInt();
		Main.getScan().nextLine();
		for (ItemCardapio item : cardapio) {
			if (item.getId() == idItem) {
				item.setDisp(!item.isDisp());
			}
		}
		
	}
	
	public static void listarItemCardapioDisponivel() {
		for (ItemCardapio item : cardapio) {
			if(item.isDisp()) {
				System.out.println(item.toString());
			}
		}
	}
	
	public static ItemCardapio capturarItemCardapio(int id) {
		for (ItemCardapio item : cardapio) {
			if(item.isDisp()) {
				if(item.getId() == id) {
					return item;
				}
			}
		}
		
		System.out.println("\nId inválido");
		return null;
	}
}
