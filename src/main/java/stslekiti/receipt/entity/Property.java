package stslekiti.receipt.entity;

import jakarta.persistence.*;
@Table(name = "property_table")
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

    @ManyToOne(targetEntity = LandLord.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private LandLord landLord;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getPropertyUse() {
        return propertyUse;
    }

    public void setPropertyUse(String propertyUse) {
        this.propertyUse = propertyUse;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLGA() {
        return LGA;
    }

    public void setLGA(String LGA) {
        this.LGA = LGA;
    }

    public String getLandSize() {
        return landSize;
    }

    public void setLandSize(String landSize) {
        this.landSize = landSize;
    }

    public String getGpsCoordinates() {
        return gpsCoordinates;
    }

    public void setGpsCoordinates(String gpsCoordinates) {
        this.gpsCoordinates = gpsCoordinates;
    }

    public LandLord getLandLord() {
        return landLord;
    }

    public void setLandLord(LandLord landLord) {
        this.landLord = landLord;
    }
}
