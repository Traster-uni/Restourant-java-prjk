import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.Consumer;

/**
 * Created by Tommaso M. Lopedote on 13/08/2021
 * Time: 11:02
 * Project: Restourant-java-prjk
 */
public class Order<E> extends ArrayList<E> {
    String statusOrder;

    public Order() {
        super();
        statusOrder = "";
    }

    public String getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(String statusOrder) {
        this.statusOrder = statusOrder;
    }

}
