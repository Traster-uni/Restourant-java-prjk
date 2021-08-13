import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * Created by Tommaso M. Lopedote on 13/08/2021
 * Time: 11:02
 * Project: Restourant-java-prjk
 */

/**
 * Order class extends ArrayList<>, in fact it behave like one but
 * with the added attribute String statusOrder needed to keep track of the
 * proper state of the order.
 * The possible states are:
 * "ready" = the order need to be prepared.
 * "evaded" = the order has left the kitchen.
 * "payed" = the order has been payed.
 * @param <E>
 */
public class Order<E> extends ArrayList<E> {
    String statusOrder;

    /**
     * Order instance default constructor.
     */
    public Order() {
        super();
        statusOrder = "";
    }

    /**
     * Retrurns the status of the order attribute
     * @return statusOrder - String
     */
    public String getStatusOrder() {
        return statusOrder;
    }

    /**
     * Sets the status of the Order instance.
     * @param statusOrder - String
     */
    public void setStatusOrder(String statusOrder) {
        this.statusOrder = statusOrder;
    }

}
