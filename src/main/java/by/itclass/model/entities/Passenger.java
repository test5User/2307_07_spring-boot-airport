package by.itclass.model.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "passenger")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter @Setter
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull private String fio;
    @NonNull private String place;
    @ManyToOne
    private Flight flight;
}
