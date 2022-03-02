package allica.bank.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;


@Data
public class Company {

    private Long company_number;
    private Date date_of_creation;
    private Date last_full_members_list_date;
    private String type;
    private String jurisdiction;
    private String company_name;

    private Address registered_office_address;
    private Accounts accounts;
    private List<Long> sic_codes;
    private boolean undeliverable_registered_office_address;
    private boolean has_insolvency_history;
    private String company_status;
    private String etag;
    private boolean has_charges;
    private boolean registered_office_is_in_dispute;
    private Date date_of_cessation;
    private boolean can_file;
    private Links links;
}
