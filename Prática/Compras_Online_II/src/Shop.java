/**
 * @author Lucas Girotto System class. Represents the shop interface that the user will buy from,
 *         handling all the logic
 */
public class Shop {

	// Instance variables
	// Shopping List
	private int size;
	private Item[] items;
	private int boughtSize;
	private Item[] boughtItems;

	// Coupon
	private int couponAmount;
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
		size = 0;
		boughtItems = new Item[shoppingSize];
		boughtSize = 0;

		// Initialize coupon's value
		couponAmount = 0;
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
	public void populateShoppingList(int itemValue, String itemName) {
		items[size] = new Item(itemName, itemValue);
		size++;
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
			String name = items[i].getName();

			if (price <= couponAmount - pricePaid) {
				pricePaid += price;
				sortedInsert(new Item(name, price));
			}
		}
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

	/**
	 * 
	 * @return
	 */
	public ItemIterator iterator() {
		return new ItemIterator(boughtItems, boughtSize);
	}

	/**
	 * 
	 */
	private void sortedInsert(Item item) {
		int i = boughtSize - 1;

		while (i >= 0 && item.compareTo(boughtItems[i]) >= 0) {
			boughtItems[i + 1] = boughtItems[i];
			i--;
		}

		boughtItems[i + 1] = item;
		boughtSize++;
	}
}