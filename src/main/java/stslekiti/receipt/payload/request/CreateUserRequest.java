package stslekiti.receipt.payload.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import stslekiti.receipt.enums.UserAuthorities;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateUserRequest {

    @JsonProperty("firstName")
    @NotBlank(message = "partner first name field cannot be empty")
    private String firstName;

    @JsonProperty("lastName")
    @NotBlank(message = "partner last name field cannot be empty")
    private String lastName;

    @JsonProperty("userName")
    @NotBlank(message = "partner last name field cannot be empty")
    private String userName;

    @JsonProperty("password")
    @NotBlank(message = "please enter a password")
    private String password;

    @JsonProperty("email")
    @Email
//    @NotBlank(message = "please enter an email")
    private String email;

    @JsonProperty("phone")
    @NotBlank(message = "please enter a phone number")
    private String phone;

    @JsonProperty("role")
//    @NotNull(message = "partnerName field cannot be empty")
    private UserAuthorities role;

    @JsonProperty("active")
    private Boolean active;
}
