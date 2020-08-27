package io.navadapps.mc.services;

import java.util.ArrayList;
import java.util.List;

import io.navadapps.mc.events.Event;
import io.navadapps.mc.events.EventBus;
import io.navadapps.mc.events.EventType;
import net.engio.mbassy.listener.Handler;

public class CookService {

	private List<String> cookedMenuItems = new ArrayList<String>();
	private EventBus bus = EventBus.getInstance();
	
	public CookService() {
		bus.subscribe(this);
	}
	
	@Handler
    public void onEvent(Event event) { 
		if (event.isTypeOf(EventType.MENUITEM_ORDERED)) {
			cookFood((String)event.getArgument(0));
		}
		
	}
	public void cookFood(String menuItem) {
		System.out.println("Cooking menu item: " + menuItem);
		cookedMenuItems.add(menuItem);
		
		bus.publish(new Event(EventType.MENUITEM_COOKED, menuItem));
		
		cookedMenuItems.clear();
		
		
	}

}
