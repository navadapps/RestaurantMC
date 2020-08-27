package io.navadapps.mc.services;

import io.navadapps.mc.events.Event;
import io.navadapps.mc.events.EventBus;
import io.navadapps.mc.events.EventType;
import net.engio.mbassy.listener.Handler;

public class PaymentService {
	private EventBus bus = EventBus.getInstance();
	
	public PaymentService() {
		bus.subscribe(this);
	}
	
	@Handler
	public void onEvent(Event event) {
		if (event.isTypeOf(EventType.MENUITEM_DELIVERED)) {
			payMenuItem((String)event.getArgument(0),5);
		}
	}
	
	public void payMenuItem(String menuItem, float amount) {
		System.out.println("Payment received for menu item: " + menuItem + " for " + amount);
	}

}
