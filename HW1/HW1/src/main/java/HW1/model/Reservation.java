package HW1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Long id;

    @Column(name = "credit_card_number")
    private Long creditCardNumber;

    @Column(name = "credit_card_mm")
    private Long creditCardMM;

    @Column(name = "credit_card_yy")
    private Long creditCardYY;

    @Column(name = "credit_card_cvv")
    private Long creditCardCVV;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "bus_number")
    private Bus bus;

    @Column(name = "token")
    private String token;

    public Reservation(Long creditCardNumber, Long creditCardMM, Long creditCardYY, Long creditCardCVV, Person person, Bus bus) {
        this.creditCardNumber = creditCardNumber;
        this.creditCardMM = creditCardMM;
        this.creditCardYY = creditCardYY;
        this.creditCardCVV = creditCardCVV;
        this.person = person;
        this.bus = bus;
    }
    
}