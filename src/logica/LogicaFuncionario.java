package logica;

import java.util.ArrayList;
import java.util.List;

import app.Main;
import objetos.Funcionario;

public class LogicaFuncionario {
	
	private static List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
	private static int proximoId = 1; 
	
	public static void funcionarios() {
		Funcionario func1 = new Funcionario("Gustavo", "Garçom", 1, 0.0);
		Funcionario func2 = new Funcionario("Thales", "Garçom", 2, 0.0);
		Funcionario func3 = new Funcionario("Alessandra", "Garçom", 3, 0.0);
		
		listaFuncionarios.add(func1);
		listaFuncionarios.add(func2);
		listaFuncionarios.add(func3);
		
	}
	
	public static void adicionarFuncionario() {
		Funcionario funcionario = new Funcionario();
		
		funcionario.setId(proximoId);
		proximoId++;
		
		System.out.println("Nome do colaborador:");
		funcionario.setNome(Main.getScan().nextLine());
		
		System.out.println("Cargo: [1]Cozinheiro(a) [2]Garçom [3]Gerente");
		switch (Main.getScan().nextInt()) {
			case 1: {
				funcionario.setCargo("Cozinheiro");
				break;
			}
			case 2: {
				funcionario.setCargo("Garçom");
				break;
			}
			case 3: {
				funcionario.setCargo("Gerente");
				break;
			}
		}
		
		listaFuncionarios.add(funcionario);
	}
	
	public static void listarFuncionario() {
		System.out.println("\nLISTA DE FUNCIONARIOS");
		for (Funcionario funcionario : listaFuncionarios) {
			System.out.println(funcionario.toString());
		}
	}
	
	public static void listarGarcom() {
		System.out.println("\n -- LISTA DE GARÇONS --");
		for (Funcionario funcionario : listaFuncionarios) {
			if(funcionario.getCargo() == "Garçom") {
				System.out.println("Id: " + funcionario.getId() + "| " + funcionario.getNome());
			}
		}
	}
	
	public static Funcionario capturarGarçom(int id) {
		for (Funcionario funcionario : listaFuncionarios) {
			if(funcionario.getCargo() == "Garçom") {
				if(funcionario.getId() == id) {
					return funcionario;
				}
			}
		}
		
		System.out.println("\nId de garçom inválido");
		return null;
	}
	
	public static void incrementarVendasFuncionario(Funcionario vendedor) {
		for (Funcionario funcionario : listaFuncionarios) {
			if(funcionario.getId() == vendedor.getId()) {
				
				funcionario.setVendas(funcionario.getVendas());
			}
		}
	}
}
