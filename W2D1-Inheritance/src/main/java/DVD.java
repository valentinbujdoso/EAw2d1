import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("DVD")
@Data
@NoArgsConstructor
public class DVD extends Product{
    private String genre;

    public DVD(String name, String description, String genre) {
        super(name, description);
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "DVD{" +
                "name='" + getName() + '\'' +
                "genre='" + genre + '\'' +
                "description='" + getDescription() + '\'' +
                '}';
    }
}
