package io.navadapps.mc.events;

import net.engio.mbassy.bus.MBassador;
import net.engio.mbassy.bus.error.IPublicationErrorHandler;

public class EventBus {
	private static final EventBus INSTANCE = new EventBus();
	
	private MBassador<Event> mbassador;
	
	private EventBus() {
		mbassador = new MBassador<Event>(new IPublicationErrorHandler.ConsoleLogger());
	}
	
	public static EventBus getInstance() {
		return INSTANCE;
	}
	public void subscribe(Object object) {
		mbassador.subscribe(object);
	}
	
	public void unsubscribe(Object object) {
		mbassador.unsubscribe(object);
	}
	
	public void publish(Event event) {
		mbassador.publish(event);
	}
}
