package vtb.geekbrains.market.core.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @Column(name = "username")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private Boolean enabled;

    @ManyToMany
    @JoinTable(name = "authorities",
            joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "authority"))
    private List<Role> role;

    public User() {
    }

    public User(String name, String password, Boolean enabled) {
        this.name = name;
        this.password = password;
        this.enabled = enabled;
    }
}