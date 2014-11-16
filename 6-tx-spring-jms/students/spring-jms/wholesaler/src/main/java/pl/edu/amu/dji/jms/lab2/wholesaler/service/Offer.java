package pl.edu.amu.dji.jms.lab2.wholesaler.service;

import javax.print.attribute.standard.Destination;
import java.net.URI;

/**
 * Created by nn nn on 2014-11-13.
 */
public class Offer {
    private double price;
    private Destination replyTo = null;

    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        this.price = price;
    }

    public Destination getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(Destination replyTo) {
        this.replyTo = replyTo;
    }
}
