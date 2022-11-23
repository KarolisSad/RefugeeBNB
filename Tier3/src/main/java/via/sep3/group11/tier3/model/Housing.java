package via.sep3.group11.tier3.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "housing")
public class Housing {

    @Id
    @SequenceGenerator(name = "housing_sequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "housing_sequence")
    private long housingId;

    @Column(name = "address_id")
    private long addressId;

    @Column(name = "capacity")
    private int capacity;

    @ManyToOne
    @JoinColumn(name = "host_email")
    private Host hEmail;
}
