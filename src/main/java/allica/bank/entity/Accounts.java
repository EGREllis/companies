package allica.bank.entity;

import lombok.Data;

@Data
public class Accounts {
    private AccountingReferenceDate accounting_reference_date;
    private LastAccounts last_accounts;
}
