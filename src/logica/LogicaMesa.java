package logica;

import java.util.ArrayList;
import java.util.List;

import app.Main;
import objetos.Mesa;

public class LogicaMesa {
	
	public static List<Mesa> listaMesa = new ArrayList<Mesa>();
	private static int proximoId = 1;
	
	public static void mesa() {
		Mesa mesa1 = new Mesa(1, 2, true);
		Mesa mesa2 = new Mesa(2, 6, true);
		Mesa mesa3 = new Mesa(3, 4, true);
		
		listaMesa.add(mesa1);
		listaMesa.add(mesa2);
		listaMesa.add(mesa3);
	}
	
	public static void adicionarMesa() {
		Mesa mesa = new Mesa();
		
		mesa.setId(proximoId);
		proximoId++;
		
		System.out.println("Capacidade: ");
		mesa.setCapacidade(Main.getScan().nextInt());
		
		mesa.setDisp(true);
		
		listaMesa.add(mesa);
	}
	
	public static void listarMesa() {
		for (Mesa mesa : listaMesa) {
			System.out.println(mesa.toString());
		}
	}
	
	public static void listarMesaDisponivel() {
		for (Mesa mesa : listaMesa) {
			if(mesa.isDisp()) {
				System.out.println("id: " + mesa.getId() + "| capacidade: " + mesa.getCapacidade());
			}
		}
	}
	
	public static Mesa capturarMesaDisponível(int id) {
		for (Mesa mesa : listaMesa) {
			if(mesa.isDisp()) {
				if(mesa.getId() == id) {
					return mesa;
				} 
			} 
		}
		
		System.out.println("Id inválido ou mesa indisponível");
		return null;
	}
	
	public static void mudarDisponibilidadeMesa(int id) {
		for (Mesa mesa : listaMesa) {
			if(mesa.getId() == id) {
				mesa.setDisp(!mesa.isDisp());
			}
		}
	}
}
