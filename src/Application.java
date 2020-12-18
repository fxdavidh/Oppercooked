import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Application {

	ArrayList<Dessert> dessertList = new ArrayList<Dessert>();
	ArrayList<Beverage> beverageList = new ArrayList<Beverage>();
	ArrayList<Dessert> dessertListOrder = new ArrayList<Dessert>();
	ArrayList<Beverage> beverageListOrder = new ArrayList<Beverage>();
	Vector<Integer> indices = new Vector<Integer>();

	int saldo = 0;

	Random random = new Random();
	Date date = new Date();

	Scanner scan = new Scanner(System.in);

	private void cls() {
		for (int i = 0; i < 50; i++) {
			System.out.println("");
		}
	}

	private void enter() {
		System.out.println("Press Enter to continue!!!");
		scan.nextLine();
	}

	private void menu() {
		int menuInput, x = 0;
		do {

			do {
				cls();
				System.out.println("Welcome to Opercooked");
				System.out.println("Today Profit : $ " + saldo);
				System.out.println("========================");
				System.out.println("1. Add Dessert or Beverage");
				System.out.println("2. View Cooking Process");
				System.out.println("3. View Order History");
				System.out.println("4. Order Dessert or Beverage");
				System.out.println("5. Exit");
				System.out.printf(">> ");
				menuInput = scan.nextInt();
				scan.nextLine();
			} while (menuInput < 1 && menuInput > 5);
			switch (menuInput) {
			case 1:
				addItem();
				break;

			case 2:
				viewProcess();
				break;

			case 3:
				viewHistory();
				break;

			case 4:
				orderItem();
				break;

			case 5:
				exit();
				break;
			}

		} while (x != 1);

	}

	private void addItem() {
		int choose;
		do {
			cls();
			System.out.println("What do you want to add?");
			System.out.println("1. Dessert");
			System.out.println("2. Drink");
			System.out.printf("Choose : ");
			choose = scan.nextInt();
			scan.nextLine();
			switch (choose) {
			case 1:
				addDesert();
				break;

			case 2:
				addDrink();
				break;
			}
		} while (choose != 1 && choose != 2);
	}

	private void addDesert() {
		cls();
		String nameL, toppingL, dateL = null;
		Integer priceL, timerL;
		int extraTime = 0;
		Float caloriesL;
		do {
			System.out.print("Input the name [at least 5 characters] : ");
			nameL = scan.nextLine();
		} while (nameL.length() < 5);

		do {
			System.out.print("Input the price [10 - 500] : $ ");
			priceL = scan.nextInt();
			scan.nextLine();
		} while (priceL < 10 || priceL > 500);

		do {
			System.out.print("Input the topping ['Caramel' | 'Honey' | 'Syrup'] (Case Insesitive) : ");
			toppingL = scan.nextLine();
		} while ((toppingL.equalsIgnoreCase("Caramel") == false) && (toppingL.equalsIgnoreCase("Honey") == false)
				&& (toppingL.equalsIgnoreCase("Syrup") == false));

		do {
			System.out.print("Insert calories [1.00 - 99.00] : ");
			caloriesL = scan.nextFloat();
			scan.nextLine();
		} while (caloriesL < 1 || caloriesL > 99);

		timerL = random.nextInt(90 + 1 - 50) + 50;

		if (toppingL.equalsIgnoreCase("Caramel") == true)
			extraTime = 10;
		else if (toppingL.equalsIgnoreCase("Honey") == true) {
			extraTime = 15;
		} else if (toppingL.equalsIgnoreCase("Syrup") == true) {
			extraTime = 20;
		}

		timerL += extraTime;

		dateL = date.toString();

		dessertList.add(new Dessert(nameL, priceL, toppingL, caloriesL, timerL, dateL));

//		dessertList.get(dessertList.size() - 1).cook();

		System.out.println("Successfully added a new menu!");
		scan.nextLine();

	}

	private void addDrink() {
		cls();
		String nameL, flavorL, sizeL, dateL = null;
		Integer priceL, timerL;

		int extraTime = 0;
		do {
			System.out.print("Input the name [at least 5 characters] : ");
			nameL = scan.nextLine();
		} while (nameL.length() < 5);

		do {
			System.out.print("Input the price [10 - 500] : $ ");
			priceL = scan.nextInt();
			scan.nextLine();
		} while (priceL < 10 || priceL > 500);

		do {
			System.out.print("Input the flavor ['Mint' | 'Mix Berry' | 'Cheese'] (Case Sensitive) : ");
			flavorL = scan.nextLine();
		} while ((flavorL.equals("Mint") == false) && (flavorL.equals("Mix Berry") == false)
				&& (flavorL.equals("Cheese") == false));

		do {
			System.out.print("Input the size [S | M | L] (Case Sensitive) : ");
			sizeL = scan.nextLine();
		} while (sizeL.equals("S") == false && sizeL.equals("M") == false && sizeL.equals("L") == false);

		timerL = random.nextInt(50 - 10 + 1) + 10;

		if (flavorL.equals("Mint") == true)
			extraTime = 10;
		else if (flavorL.equals("Mix Berry") == true) {
			extraTime = 15;
		} else if (flavorL.equals("Cheese") == true) {
			extraTime = 20;
		}

		timerL += extraTime;

		dateL = date.toString();

		beverageList.add(new Beverage(nameL, priceL, flavorL, sizeL, timerL, dateL));

//		beverageList.get(beverageList.size() - 1).cook();

		System.out.println("Successfully added a new menu!");
		scan.nextLine();

	}

	private void viewProcess() {
		cls();
		int flag = -1, flag2 = -1;
		for (int i = 0; i < beverageList.size(); i++) {
			if (beverageList.get(i).timer.secs == 0) {
				indices.add(i);
				flag = 1;
			}
		}

		if (flag == 1) {
			for (int idx : indices) {
				saldo += beverageList.get(idx).getPrice();
				beverageListOrder.add(beverageList.get(idx));
				beverageList.remove(idx);
			}
		}

		for (int i = 0; i < dessertList.size(); i++) {
			if (dessertList.get(i).timer.secs == 0) {
				indices.add(i);
				flag2 = 1;
			}
		}

		if (flag2 == 1) {
			for (int idx : indices) {
				saldo += dessertList.get(idx).getPrice();
				dessertListOrder.add(dessertList.get(idx));
				dessertList.remove(idx);
			}
		}

		if (beverageList.isEmpty() == true && dessertList.isEmpty() == true) {
			System.out.println("There is no cooking process recently!");
			System.out.println("");
			enter();
		} else {
			System.out.printf("| %-5s | %-9s | %-20s | %-10s | %-10s   |\n", "No", "Type", "Name", "Price",
					"Time Left");
			for (int i = 0; i < beverageList.size(); i++) {
				System.out.printf("| %-5d | %-9s | %-20s | %-10d | %-10d s |\n", i + 1, "Drink",
						beverageList.get(i).getName(), beverageList.get(i).getPrice(), beverageList.get(i).timer.secs);
			}
			int j = beverageList.size();
			for (int i = 0; i < dessertList.size(); i++, j++) {
				System.out.printf("| %-5d | %-9s | %-20s | %-10d | %-10d s |\n", j + 1, "Dessert",
						dessertList.get(i).getName(), dessertList.get(i).getPrice(), dessertList.get(i).timer.secs);
			}
			enter();
		}
		
	}

	private void viewHistory() {
		cls();
		if (beverageListOrder.isEmpty() == true && dessertListOrder.isEmpty() == true) {
			System.out.println("There is no order history!");
			System.out.println("");
			enter();
		} else {
			System.out.printf("| %-5s | %-20s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s |\n", "No", "Name",
					"Price", "Topping", "Callories", "Flavor", "Size", "Order Time");
			for (int i = 0; i < beverageListOrder.size(); i++) {
				System.out.printf("| %-5d | %-20s | %-10d | %-10s | %-10s | %-10s | %-10s | %-10s |\n", i + 1,
						beverageListOrder.get(i).getName(), beverageListOrder.get(i).getPrice(), "-", "-",
						beverageListOrder.get(i).getFlavor(), beverageListOrder.get(i).getSize(),
						beverageListOrder.get(i).getDate());
			}
			int j = beverageListOrder.size();
			for (int i = 0; i < dessertListOrder.size(); i++, j++) {
				System.out.printf("| %-5d | %-20s | %-10d | %-10s | %-10f | %-10s | %-10s | %-10s  |\n", j + 1,
						dessertListOrder.get(i).getName(), dessertListOrder.get(i).getPrice(),
						dessertListOrder.get(i).getTopping(), dessertListOrder.get(i).getCalories(), "-", "-",
						dessertListOrder.get(i).getDate());
			}
			enter();
		}
	}

	private void orderItem() {
		cls();
		if (beverageList.isEmpty() == true && dessertList.isEmpty() == true) {
			System.out.println("There is no Dessert or Drink on the list!");
			System.out.println("");
			enter();
		} else {
			System.out.printf("| %-5s | %-20s | %-10s | %-10s | %-10s | %-10s | %-10s |\n", "No", "Name", "Price",
					"Topping", "Callories", "Flavor", "Size");
			for (int i = 0; i < beverageList.size(); i++) {
				System.out.printf("| %-5d | %-20s | %-10d | %-10s | %-10s | %-10s | %-10s |\n", i + 1,
						beverageList.get(i).getName(), beverageList.get(i).getPrice(), "-", "-",
						beverageList.get(i).getFlavor(), beverageList.get(i).getSize());
			}
			int j = beverageList.size();
			for (int i = 0; i < dessertList.size(); i++, j++) {
				System.out.printf("| %-5d | %-20s | %-10d | %-10s | %-10f | %-10s | %-10s |\n", j + 1,
						dessertList.get(i).getName(), dessertList.get(i).getPrice(), dessertList.get(i).getTopping(),
						dessertList.get(i).getCalories(), "-", "-");
			}
		}
		int tot = beverageList.size() + dessertList.size();
		int addToOrder = 0;
		do {
			System.out.printf("Choose a menu to order [1 - %d] : ", tot);
			addToOrder = scan.nextInt();
			scan.nextLine();
		} while (addToOrder < 1 || addToOrder > tot);

		if (addToOrder > beverageList.size()) {
			dessertList.get(addToOrder - beverageList.size() - 1).cook();

		} else {
			beverageList.get(beverageList.size() - 1).cook();
		}

	}

	private void exit() {
		System.out.println("Thankyou for using this program!!!");
		enter();
		System.exit(0);
	}

	public Application() {
		menu();
	}

	public static void main(String[] args) {
		new Application();

	}

}
