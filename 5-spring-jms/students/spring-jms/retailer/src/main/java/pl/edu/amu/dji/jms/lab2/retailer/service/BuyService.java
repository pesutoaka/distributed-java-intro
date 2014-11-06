package pl.edu.amu.dji.jms.lab2.retailer.service;

import org.springframework.jms.core.JmsTemplate;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

public class BuyService implements MessageListener {

    private JmsTemplate jmsTemplate;

    private Double maxPrice;

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }

    @Override
    public void onMessage(Message message) {
        MapMessage ms = (MapMessage)message;
        try {
            Double price = ms.getDouble("price");
            if (maxPrice.compareTo(price) == 1) {

            }
        }catch (JMSException e){

        }
        //throw new UnsupportedOperationException();
    }
}
