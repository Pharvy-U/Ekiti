package stslekiti.receipt.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Table(name = "property_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "structure")
    private String structure;

    @Column(name = "property_use")
    private String propertyUse;

    @Column(name = "address")
    private String address;

    @Column(name = "LGA")
    private String LGA;

    @Column(name = "land_size")
    private String landSize;

    @Column(name = "gps_coordinates")
    private String gpsCoordinates;

//    @ManyToOne(targetEntity = LandLord.class, fetch = FetchType.LAZY)
//    @JoinColumn(name = "owner_id")
//    private LandLord landLord;

}
