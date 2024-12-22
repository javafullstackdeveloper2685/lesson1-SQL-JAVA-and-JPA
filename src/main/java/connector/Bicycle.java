package connector;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name="bicycles")
public class Bicycle {

    @Id
    public UUID id;

    @Column(name = "size")
    public String size;

    @Column(name = "user_name")
    public String usersName;

    public Bicycle(UUID id, String size, String usersName) {
        this.id = id;
        this.size = size;
        this.usersName = usersName;
    }
}
