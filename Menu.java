import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.math.BigDecimal;


public class Menu{
	private Scanner scanner;
	ArrayList<ShoppingCart> groceryList = new ArrayList<ShoppingCart>();

public void showMainMenu(){
	scanner = new Scanner(System.in);
	int option = 0;
	
	do
	{
	System.out.println("-- Shopping List Menu --");
	System.out.println("(1) Add an item to the list. ");
	System.out.println("(2) Display list of items. ");
	System.out.println("(3) Exit. ");
	System.out.println("Please select one of the options.");
	
	option = scanner.nextInt();
	switch (option) {
	case 1: 
		showMenu();
	break;
	case 2: 
		showList();
	break;
	case 3:
		System.out.println("Closing Application");
		System.exit(0);
	break;
	default:
	System.out.println("Invalid option - please enter a number.");
	break;
	}
	
	}
	while(option < 1 || option > 3);
}

public void showMenu() {

	System.out.println("Please enter the Item Name:");
	@SuppressWarnings("resource")
	Scanner scan = new Scanner(System.in);
	String itemName = scan.nextLine();
	System.out.println("Please enter the item price:");
	BigDecimal itemPrice = scan.nextBigDecimal();
	System.out.println("Please enter the quantity of the item:");
	int itemQty = scan.nextInt();

	groceryList.add(new ShoppingCart(itemName, itemPrice, itemQty));
	
		try {
			FileOutputStream fOut = new FileOutputStream("groceryList");
			ObjectOutputStream oOut = new ObjectOutputStream(fOut);
			oOut.writeObject(groceryList);
			oOut.close();
			fOut.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	showMainMenu();
}

@SuppressWarnings("unchecked")
public void showList() {
	 try {
		 FileInputStream fIn = new FileInputStream("groceryList");
		 ObjectInputStream oIn = new ObjectInputStream(fIn);
		 groceryList = (ArrayList<ShoppingCart>) oIn.readObject();
		 oIn.close();
		 fIn.close();
	 }catch (IOException e) {
		 e.printStackTrace();
	 }catch (ClassNotFoundException c) {
		 System.out.println("Class not found");
		 c.printStackTrace();
		 return;
	 }
	 for (ShoppingCart tmp: groceryList) {
		 System.out.println(tmp);
	 }
	 	showMainMenu();
}
}