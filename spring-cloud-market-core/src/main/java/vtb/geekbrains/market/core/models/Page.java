package vtb.geekbrains.market.core.models;

import lombok.Getter;

@Getter
public class Page {
    private Integer number;

    public Page(Integer number) {
        this.number = number;
    }
}
