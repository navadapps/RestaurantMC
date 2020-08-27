package io.navadapps.mc.events;

public class Event {
	private String type;
	private Object[] arguments;
	public Event(String type, Object ... arguments) {
		super();
		this.type = type;
		this.arguments = arguments;
	}
	
	public Object getArgument(int index) {
		if (index >= 0 && index < arguments.length) {
			return arguments[index];
		}
		else {
			return null;
		}
	}
	
	public boolean isTypeOf(String type) {
		return this.type.equals(type);
	}
	
	

}
