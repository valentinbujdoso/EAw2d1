import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("Book")
@Data
@NoArgsConstructor
public class Book extends Product{
    private String title;

    public Book(String name, String description, String title) {
        super(name, description);
        this.title = title;
    }

    @Override
    public String toString() {
        return "DVD{" +
                "name='" + getName() + '\'' +
                "genre='" + title + '\'' +
                "description='" + getDescription() + '\'' +
                '}';
    }
}
