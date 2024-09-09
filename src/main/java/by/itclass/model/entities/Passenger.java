package by.itclass.model.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "passenger")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter @Setter
@AllArgsConstructor
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull private String fio;
    @NonNull private String place;
    @ManyToOne
    @NonNull private Flight flight;
}
