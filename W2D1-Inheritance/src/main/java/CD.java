import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("CD")
@Data
@NoArgsConstructor
public class CD extends Product{
    private String artist;

    public CD(String name, String description, String artist) {
        super(name, description);
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "DVD{" +
                "name='" + getName() + '\'' +
                "genre='" + artist + '\'' +
                "description='" + getDescription() + '\'' +
                '}';
    }
}
