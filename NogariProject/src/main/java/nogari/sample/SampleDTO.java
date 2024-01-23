package nogari.sample;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@ToString
public class SampleDTO {

    @NotNull(message = "ID is not valid")
    private String id;
    private String name;
    @Email(message = "not email")
    private String eMail;
}