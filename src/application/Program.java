package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Produto;
import entities.ProdutoImportado;
import entities.ProdutoUsado;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		List<Produto> list = new ArrayList<>();

		System.out.print("Digite o número de produtos: ");
		int N = sc.nextInt();

		for (int i = 1; i <= N; i++) {
			System.out.println("Dados do produto nº" + i + ":");
			System.out.print("Comum, usado ou importado (c/u/i)? ");
			char resp = sc.next().charAt(0);
			System.out.print("Nome: ");
			String nome = sc.next();
			System.out.println("Preco: ");
			double preco = sc.nextDouble();

			if (resp == 'c') {
				list.add(new Produto(nome, preco));

			} else if (resp == 'u') {
				System.out.println("Data de fabricacao (DD/MM/AAAA): ");
				LocalDate data = LocalDate.parse(sc.next(), df);
				list.add(new ProdutoUsado(nome, preco, data));

			} else {
				System.out.print("Taxa alfandegaria: ");
				double taxa = sc.nextDouble();
				list.add(new ProdutoImportado(nome, preco, taxa));
			}
		}
		System.out.println();
		System.out.println("ETIQUETAS DE PRECO:");
		for (Produto prod : list) {
			System.out.println(prod.etiquetaPreco());
		}

		sc.close();

	}

}
