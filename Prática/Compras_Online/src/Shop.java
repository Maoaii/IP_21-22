/**
 * @author Lucas Girotto 
 * System class. 
 * Represents the shop interface that the user will buy from, handling all the logic
 */
public class Shop {

	// Instance variables
		// Shopping List
	private int size;
	private Item[] items;

		// Coupon
	private int couponAmount;
	private int maxPrice;
	private String priciestItem;
	private int pricePaid;

	/**
	 * Shop Constructor
	 * 
	 * @param shoppingSize: amount of items on display to be bought
	 * @pre shoppingSize != null
	 */
	public Shop(int shoppingSize) {

		// Creating a shopping list
		items = new Item[shoppingSize];
		size = shoppingSize;

		// Initialize coupon's value
		couponAmount = 0;
		priciestItem = "";
		pricePaid = 0;
	}

	/**
	 * Populates the shopping list with items
	 * 
	 * @param itemName:   name to be assigned to item
	 * @param itemValue:  price to be assigned to item
	 * @param itemNumber: item's index on the list
	 * @pre itemName != null && itemValue != null && itemNumber != null
	 */
	public void populateShoppingList(int itemValue, String itemName, int itemNumber) {
		items[itemNumber] = new Item(itemName, itemValue);
	}

	/**
	 * Assigns a value to the coupon
	 * 
	 * @param value
	 * @pre value != null
	 */
	public void couponValue(int value) {
		couponAmount = value;
	}

	/**
	 * Handles the logic of buying an item: Paying for the item; storing the name of the priciest
	 * item; and storing the price of the priciest item
	 */
	public void buyItems() {
		for (int i = 0; i < size; i++) {
			int price = items[i].getValue();

			if (price <= couponAmount - pricePaid) {
				pricePaid += price;
				if (price > maxPrice) {
					maxPrice = price;
					priciestItem = items[i].getName();
				}
			}
		}
	}

	/**
	 * @return the name of the priciest item
	 */
	public String getPriciestItem() {
		return priciestItem;
	}

	/**
	 * @return the amount of money spent
	 */
	public int getPricePaid() {
		return pricePaid;
	}

	/**
	 * @return the amount of money left from coupon
	 */
	public int couponRemaining() {
		return couponAmount - pricePaid;
	}

	/**
	 * @return true if something was bought
	 */
	public boolean boughtSomething() {
		return pricePaid != 0;
	}
}