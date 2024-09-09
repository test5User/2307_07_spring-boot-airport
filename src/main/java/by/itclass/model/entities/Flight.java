package by.itclass.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "flight")
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull private String number;
    @NonNull private String direction;
    @ManyToOne
    @NonNull private Airplane airplane;
    @OneToMany(mappedBy = "flight", fetch = FetchType.EAGER)
    private List<Passenger> passengers;

    public Flight(int id, @NonNull String number, @NonNull String direction, @NonNull Airplane airplane) {
        this.id = id;
        this.number = number;
        this.direction = direction;
        this.airplane = airplane;
    }
}
