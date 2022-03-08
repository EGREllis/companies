package allica.bank.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Links {
    private String self;
    @JsonProperty("filing_history")
    private String filingHistory;
    private String officers;
    private String charges;
}
