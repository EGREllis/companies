package allica.bank.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;


@Data
public class Company {
    @JsonProperty("company_number")
    private Long companyNumber;
    @JsonProperty("date_of_creation")
    private Date dateOfCreation;
    @JsonProperty("last_full_members_list_date")
    private Date lastFullMembersListDate;
    private String type;
    private String jurisdiction;
    @JsonProperty("company_name")
    private String companyName;

    @JsonProperty("registered_office_address")
    private Address registeredOfficeAddress;
    private Accounts accounts;
    @JsonProperty("sic_codes")
    private List<Long> sicCodes;
    @JsonProperty("undeliverable_registered_office_address")
    private boolean undeliverableRegisteredOfficeAddress;
    @JsonProperty("has_insolvency_history")
    private boolean hasInsolvencyHistory;
    @JsonProperty("company_status")
    private String companyStatus;
    private String etag;
    @JsonProperty("has_charges")
    private boolean hasCharges;
    @JsonProperty("registered_office_is_in_dispute")
    private boolean registeredOfficeIsInDispute;
    @JsonProperty("date_of_cessation")
    private Date dateOfCessation;
    @JsonProperty("can_file")
    private boolean canFile;
    private Links links;
}
