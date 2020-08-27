package io.navadapps.mc.services;

import java.util.ArrayList;
import java.util.List;

import io.navadapps.mc.events.Event;
import io.navadapps.mc.events.EventBus;
import io.navadapps.mc.events.EventType;
import net.engio.mbassy.listener.Handler;

public class OrderService { 
	
	private List<String> orders = new ArrayList<String>();
	
	private List<String> menuItems = new ArrayList<String>();
	
	private EventBus bus = EventBus.getInstance();
	
	public OrderService() {
		bus.subscribe(this);
	}
	
	@Handler
	public void onEvent(Event event) {
		if (event.isTypeOf(EventType.MENUITEM_COOKED)) {
			receiveMenuItem((String)event.getArgument(0));
		}
	}
	
	public void addOrder(String orderedMenuItem) {
		orders.add(orderedMenuItem);
	}
	
	public void receiveMenuItem(String menuItem) {
		menuItems.add(menuItem);
	}

	public void deliverMenuItems() {
		if (menuItems.size() > 0) {
			for (String menuItem : menuItems) {
				System.out.println("Deliver menu item to Customer: " + menuItem);
				bus.publish(new Event(EventType.MENUITEM_DELIVERED, menuItem));
			}
			menuItems.clear();
		}
		else {
			System.out.println("Could not delivery any menu item.  No menu item available!");
		}
	}
	
	public void sendOrders() {
		for (String order: orders) {
			bus.publish(new Event(EventType.MENUITEM_ORDERED, order));
		}
		orders.clear();
	}

}
