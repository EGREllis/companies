package allica.bank.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class LastAccounts {
    @JsonProperty("made_up_to")
    private Date madeUpTo;
    private String type;
    @JsonProperty("period_end_on")
    private Date periodEndOn;
}
