import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Tommaso M. Lopedote on 13/08/2021
 * Time: 11:02
 * Project: Restourant-java-prjk
 */
public class Order {
    ArrayList<Plate> orderList;
    String statusOrder;

    public Order(){
        orderList = new ArrayList<>();
        statusOrder = "";
    }

    public ArrayList<Plate> getOrderList() {
        return orderList;
    }

    public String getStatusOrder() {
        return statusOrder;
    }

    public void setOrderList(ArrayList<Plate> orderList) {
        this.orderList = orderList;
    }

    public void setStatusOrder(String statusOrder) {
        this.statusOrder = statusOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return getOrderList().equals(order.getOrderList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderList());
    }

    public boolean isEmpty(){
        if (orderList.isEmpty()){
            return true;
        } else {
            return false;
        }
    }
}
