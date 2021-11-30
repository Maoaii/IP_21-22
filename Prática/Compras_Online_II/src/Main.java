import java.util.Scanner;

/**
 * @author Lucas Girotto Main class. Handles the input from user and outputs for the user
 */
public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int itemSize = readInt(in);
		Shop shop = new Shop(itemSize);

		handleShoppingList(in, itemSize, shop);

		ItemIterator iterator = shop.iterator();

		groceryBag(shop, iterator);

		in.close();
	}

	/**
	 * Populates the shopping list and buys items with coupon created
	 * 
	 * @param in:       input reader
	 * @param itemSize: amount of items in display
	 * @param shop:     shop interface
	 * @pre in != null && itemSize != null && shop != null
	 */
	private static void handleShoppingList(Scanner in, int itemSize, Shop shop) {
		populateShoppingList(in, itemSize, shop);

		shop.couponValue(readInt(in));

		shop.buyItems();
	}

	/**
	 * Checks to see what was bought. Prints the priciest item, how much we paid in total and money
	 * remaining
	 * 
	 * @param shop: shop interface
	 * @pre shop != null
	 */
	private static void groceryBag(Shop shop, ItemIterator it) {
		if (shop.boughtSomething()) {
			while (it.hasNext()) {
				Item item = it.next();
				System.out.println(item.getName());
			}
		}
		System.out.println(
				String.valueOf(shop.getPricePaid()) + " " + String.valueOf(shop.couponRemaining()));
	}

	/**
	 * Populates the shopping list with items
	 * 
	 * @param in:       input reader
	 * @param itemSize: amount of items on display
	 * @param shop:     shop interface
	 * @pre in != null && itemSize != null && shop != null
	 */
	private static void populateShoppingList(Scanner in, int itemSize, Shop shop) {
		for (int i = 0; i < itemSize; i++) {
			shop.populateShoppingList(readInt(in), in.nextLine());
		}
	}

	/**
	 * @param in: input reader
	 * @pre in != null
	 * @return integer read
	 */
	private static int readInt(Scanner in) {
		int tmp = in.nextInt();
		in.nextLine();
		return tmp;
	}
}