package stslekiti.receipt.payload.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddPropertyRequest {

    @JsonProperty("structure")
    private String structure;

    @JsonProperty("propertyUse")
    private String propertyUse;

    @JsonProperty("address")
    private String address;

    @JsonProperty("LGA")
    private String LGA;

    @JsonProperty("landSize")
    private String landSize;

    @JsonProperty("gpsCoordinates")
    private String gpsCoordinates;

    @JsonProperty("ownerId")
    private Long landLord_id;
}
