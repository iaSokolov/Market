package vtb.geekbrains.market.core.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
@Data
public class Role {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "authorities",
            joinColumns = @JoinColumn(name = "authority"),
            inverseJoinColumns = @JoinColumn(name = "username")
    )
    private List<User> user;

    public Role() {
    }

    public Role(String id, String name) {
        this.id = id;
        this.name = name;
    }
}