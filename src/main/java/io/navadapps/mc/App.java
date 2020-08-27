package io.navadapps.mc;

import io.navadapps.mc.services.CookService;
import io.navadapps.mc.services.OrderService;
import io.navadapps.mc.services.PaymentService;

public class App 
{
    public static void main( String[] args )
    {
        OrderService orderService = new OrderService();
        CookService cookService = new CookService();
        PaymentService paymentService = new PaymentService();
        
        orderService.addOrder("Veggie Pullav");
        orderService.addOrder("Paneer Paratha");
        orderService.addOrder("Channa Masala");
        
        orderService.sendOrders();
        
        orderService.deliverMenuItems();
        
    }
}
