import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.Orderitem;
import entities.Product;
import entities.enuns.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Enter cliente data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Birth date: ");
		Date birthDate = sdf.parse(sc.next());

		Client client = new Client(name, email, birthDate);

		System.out.println("Enter order data:");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());

		Order order = new Order(new Date(), status, client);

		System.out.print("How many items to this order?: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			String productName = sc.next();
			System.out.print("Product price: ");
			Double productPrice = sc.nextDouble();

			Product product = new Product(productName, productPrice);

			System.out.print("Quantity: ");
			Integer quantity = sc.nextInt();

			Orderitem item = new Orderitem(quantity, productPrice, product);
			order.addItem(item);
		}
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);

		sc.close();

	}

}
