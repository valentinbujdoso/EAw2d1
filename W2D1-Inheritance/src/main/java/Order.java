import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Order_table")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderid;
    private String date;
    @ManyToOne
    private Customer customer;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<OrderLine> orderLineList = new ArrayList<>();


    public Order(String date) {
        this.date = date;
    }

    public  void addOrderLine(OrderLine orderLine) {
        orderLineList.add(orderLine);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderid=" + orderid +
                ", date='" + date + '\'' +
                ", orderLineList=" + orderLineList +
                '}';
    }
}
