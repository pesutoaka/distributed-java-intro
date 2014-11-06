package pl.edu.amu.dji.jms.lab2.wholesaler.service;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import sun.plugin2.message.Message;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Session;

public class OfferService {

    private JmsTemplate jmsTemplate;

    private Destination offerTopic;

    private Destination orderQueue;

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void setOfferTopic(Destination offerTopic) {
        this.offerTopic = offerTopic;
    }

    public void setOrderQueue(Destination orderQueue) {
        this.orderQueue = orderQueue;
    }

    public void sendOffer(final Double price) {
        MessageCreator mc = new MessageCreator() {
            @Override
            public javax.jms.Message createMessage(Session session) throws JMSException {
                MapMessage ms = session.createMapMessage();
                ms.setDouble("price",price);
                ms.setJMSReplyTo(orderQueue);
                return ms;
            }
        };
    }
}
