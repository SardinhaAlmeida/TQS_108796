package HW1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "bus")
public class Bus {

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "bus_number")
    private int busNumber;
    // @Column(name = "bus_id")
    // private Long id;

    @Column(name = "origin")
    private String origin;

    @Column(name = "destination")
    private String destination;

    @Column(name = "date")
    private String date;

    @Column(name = "departure_time")
    private String departureTime;

    @Column(name = "arrival_time")
    private String arrivalTime;

    @Column(name = "price")
    private int price;

    @Column(name = "capacity")
    private int capacity;

}


