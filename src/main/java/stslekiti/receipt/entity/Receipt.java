package stslekiti.receipt.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;
import java.time.LocalDate;

@Builder
@Entity
@Table(name = "invoice_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
//@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Receipt {

    @Id
    @EqualsAndHashCode.Include()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @JsonProperty("payerName")
    private String payerName;

    @JsonProperty("payerId")
    private String payerId;

    @JsonProperty("contactAddress")
    private String contactAddress;

    @JsonProperty("propertyAddress")
    private String propertyAddress;

    @JsonProperty("LGA")
    private String LGA;

    @JsonProperty("status")
    private String status;

    @JsonProperty("propertyClassification")
    private String propertyClassification;

    @JsonProperty("accessedValue")
    private BigInteger accessedValue;

    @JsonProperty("chargeRate")
    private Double chargeRate;

    @JsonProperty("lucAmount")
    private BigInteger lucAmount;

    @JsonProperty("amountPreviouslyOwed")
    private BigInteger amountPreviouslyOwed;

    @JsonProperty("noticeNumber")
    private BigInteger noticeNumber;

    @JsonProperty("bankPaymentCode")
    private BigInteger bankPaymentCode;

    @JsonProperty("noticeDate")
    private LocalDate noticeDate;

    @JsonProperty("printDate")
    private LocalDate printDate;

}
