package vtb.geekbrains.market.core.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "authorities")
public class Authority {
    @Embeddable
    public static class Id implements Serializable {
        @Column(name = "username")
        String username;

        @Column(name = "authority")
        String authority;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Id id = (Id) o;
            return Objects.equals(username, id.username) && Objects.equals(authority, id.authority);
        }

        @Override
        public int hashCode() {
            return Objects.hash(username, authority);
        }
    }

    @EmbeddedId
    private Authority.Id id;

    @ManyToOne
    @JoinColumn(name = "authority", insertable = false, updatable = false)
    private Role roles;

    @ManyToOne
    @JoinColumn(name = "username", insertable = false, updatable = false)
    private User user;
}