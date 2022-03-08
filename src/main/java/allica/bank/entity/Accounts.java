package allica.bank.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Accounts {
    @JsonProperty("accounting_reference_date")
    private AccountingReferenceDate accountingReferenceDate;
    @JsonProperty("last_accounts")
    private LastAccounts lastAccounts;
}
