package app;

import java.util.Scanner;

import logica.LogicaCardapio;
import logica.LogicaFuncionario;
import logica.LogicaMesa;
import logica.LogicaPedido;

public class Main {
	
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		LogicaFuncionario.funcionarios();
		LogicaCardapio.cardapio();
		LogicaMesa.mesa();
		Menu();

	}
	
	public static Scanner getScan() {
		return scan;
	}
	
	public static void Menu() {
		int op = 0;
		int op2 = 0;
		
		do {
			System.out.println("\n-- Sistema Gerenciamento Restaurante --");
			System.out.println("[1]Funcionario\n[2]Mesa\n[3]Cardapio\n[4]Pedido\n[0]Finalizar");
			op = getScan().nextInt();
			getScan().nextLine();
			switch (op) {
			case 1: {
				do {
					System.out.println("\nFUNCIONÁRIO\n[1]Adicionar\n[2]Listar\n[0]Voltar");
					op2 = getScan().nextInt();
					getScan().nextLine();
					switch (op2) {
					case 1: {
						LogicaFuncionario.adicionarFuncionario();
						break;
					}
					case 2: {
						LogicaFuncionario.listarFuncionario();
						break;
					}
					case 0: {
						break;
					}
					default: {
						System.out.println("\nOperação Inválida");
					}
					}
				} while (op2 != 0);
				break;
			}
				case 2: {
					do {
						System.out.println("\nMESA"
								+ "\n[1]Adicionar"
								+ "\n[2]Listar"
								+ "\n[0]Voltar");
						op2 = getScan().nextInt();
						getScan().nextLine();
						switch (op2) {
						case 1: {
							LogicaMesa.adicionarMesa();
							break;
							}
						case 2: {
							LogicaMesa.listarMesa();
							break;
							}
						case 0: {
							break;
						}
						default: {
							System.out.println("\nOperação Inválida");
							break;
							}
						}
					} while (op2 != 0);
					break;
				}
				case 3: {
					do {
						System.out.println("\nCARDAPIO"
								+ "\n[1]Adicionar"
								+ "\n[2]Listar"
								+ "\n[3]Alterar Disponibilidade"
								+ "\n[0]Voltar");
						op2 = getScan().nextInt();
						getScan().nextLine();
						switch (op2) {
						case 1: {
							LogicaCardapio.adicionarItemCardapio();
							break;
						}
						case 2: {
							LogicaCardapio.listarItemCardapio();
							break;
						}
						case 3: {
							LogicaCardapio.alterarDisponibilidade();
							break;
						}
						case 0: {
							break;
						}
						default: {
							System.out.println("\nOperação Inválida");
							break;
						}
						}
					} while (op2 != 0);
					break;
				}
				case 4: {
					do {
						System.out.println("\nPEDIDO"
								+ "\n[1]Adicionar"
								+ "\n[2]Listar"
								+ "\n[3]Incrementar"
								+ "\n[4]Finalizar"
								+ "\n[0]Voltar");
						op2 = getScan().nextInt();
						getScan().nextLine();
						switch (op2) {
							case 1: {
								LogicaPedido.adicionarPedido();
								break;
							}
							case 2: {
								LogicaPedido.listarPedido();
								break;
							}
							case 3: {
								LogicaPedido.incrementarPedido();
								break;
							}
							case 4: {
								LogicaPedido.finalizarPedido();
								break;
							}
							case 0: {
								break;
							}
							default: {
								System.out.println("\nOperação Inválida");
								break;
							}
						}
					} while (op2 != 0);
				}
				break;
			}
		} while (op != 0);
	}

}
