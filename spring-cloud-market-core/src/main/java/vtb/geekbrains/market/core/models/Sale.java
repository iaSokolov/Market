package vtb.geekbrains.market.core.models;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class Sale {
    @Data
    public static class Id implements Serializable {
        Long product_id;
        Long customer_id;

        public Id() {
        }

        public Id(Long product_id, Long customer_id) {
            this.product_id = product_id;
            this.customer_id = customer_id;
        }
    }

    private Sale.Id id;
    private BigDecimal amount;

    public Sale() {
    }

    public Sale(Id id, BigDecimal amount) {
        this.id = id;
        this.amount = amount;
    }
}