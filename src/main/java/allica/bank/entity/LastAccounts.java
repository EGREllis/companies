package allica.bank.entity;

import lombok.Data;

import java.util.Date;

@Data
public class LastAccounts {
    private Date made_up_to;
    private String type;
    private Date period_end_on;
}
