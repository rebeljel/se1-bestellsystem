package system;

import java.util.function.Consumer;

import datamodel.Order;
import datamodel.OrderItem;

final class OrderProcessor implements Components.OrderProcessor{

	private final Components.InventoryManager inventoryManager;

	public OrderProcessor(Components.InventoryManager inventoryManager) {
		this.inventoryManager = inventoryManager;
	}

	@Override
	public boolean accept(Order order) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean accept(Order order, Consumer<Order> acceptCode, Consumer<Order> rejectCode,
			Consumer<OrderItem> rejectedOrderItemCode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long orderValue(Order order) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long vat(long grossValue) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long vat(long grossValue, int rateIndex) {
		// TODO Auto-generated method stub
		return 0;
	}

}
