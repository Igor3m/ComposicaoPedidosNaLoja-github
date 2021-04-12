package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Cliente;
import entities.ItemDePedido;
import entities.Pedido;
import entities.Produto;
import entities.StatusDoPedido;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter cliente data: ");
		System.out.println("Name: ");
		String nome = sc.nextLine();
		System.out.println("Email: ");
		String email = sc.nextLine();
		System.out.println("Birth date (DD/MM/YYYY): ");
		Date data = sdf.parse(sc.next());
		Cliente umCliente = new Cliente(nome, email, data);
		
		System.out.println("Enter order data: ");
		System.out.println("Status: ");
		StatusDoPedido status = StatusDoPedido.valueOf(sc.next());	
		
		Pedido pedido = new Pedido(new Date(), status, umCliente);
		
		System.out.println("How many items to this order?");
		int quantidade = sc.nextInt();
		for (int i=1; i<=quantidade; i++) {
			System.out.println("Enter" + i + "item data: ");
			System.out.println("Product name: ");
			sc.nextLine();
			String nomeProduto = sc.nextLine();
			System.out.println("Product price: ");
			double precoProduto = sc.nextDouble();
			System.out.println("Quantity: ");
			int quantidadeProduto = sc.nextInt();
			Produto produto = new Produto(nomeProduto, precoProduto);
			ItemDePedido itemDePedido = new ItemDePedido(quantidadeProduto, precoProduto, produto);
			pedido.addItem(itemDePedido);
		}
		
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println(pedido);
		
		sc.close();
	}

}
