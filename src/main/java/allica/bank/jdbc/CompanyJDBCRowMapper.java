package allica.bank.jdbc;

import allica.bank.entity.*;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CompanyJDBCRowMapper implements RowMapper<Company> {
    @Override
    public Company mapRow(ResultSet resultSet, int i) throws SQLException {
        Company company = new Company();

        company.setCompanyNumber(resultSet.getLong("company_number"));
        company.setDateOfCreation(resultSet.getDate("date_of_creation"));
        company.setLastFullMembersListDate(resultSet.getDate("last_full_members_list_date"));
        company.setType(resultSet.getString("company_type"));
        company.setJurisdiction(resultSet.getString("jurisdiction"));
        company.setCompanyName(resultSet.getString("company_name"));

        Address address = new Address();
        address.setPostalCode(resultSet.getString("postal_code"));
        address.setAddressLine1(resultSet.getString("address_line_1"));
        address.setAddressLine2(resultSet.getString("address_line_2"));
        address.setLocality(resultSet.getString("locality"));
        address.setCountry(resultSet.getString("country"));
        company.setRegisteredOfficeAddress(address);

        Accounts accounts = new Accounts();
        AccountingReferenceDate accountingReferenceDate = new AccountingReferenceDate();
        accountingReferenceDate.setMonth(resultSet.getInt("month_"));
        accountingReferenceDate.setDay(resultSet.getInt("day_"));
        accounts.setAccountingReferenceDate(accountingReferenceDate);
        LastAccounts lastAccounts = new LastAccounts();
        lastAccounts.setMadeUpTo(resultSet.getDate("made_up_to"));
        lastAccounts.setType(resultSet.getString("accounts_type"));
        lastAccounts.setPeriodEndOn(resultSet.getDate("period_end_on"));
        accounts.setLastAccounts(lastAccounts);
        company.setAccounts(accounts);

        //sic_code_set_id INTEGER,
        company.setUndeliverableRegisteredOfficeAddress(Boolean.parseBoolean(resultSet.getString("undeliverable_registered_office_address")));
        company.setHasInsolvencyHistory(Boolean.parseBoolean(resultSet.getString("has_insolvency_history")));
        company.setCompanyStatus(resultSet.getString("company_status"));
        company.setEtag(resultSet.getString("etag"));
        company.setHasCharges(Boolean.parseBoolean(resultSet.getString("has_charges")));
        company.setRegisteredOfficeIsInDispute(Boolean.parseBoolean(resultSet.getString("registered_office_is_in_dispute")));
        company.setDateOfCessation(resultSet.getDate("date_of_cessation"));
        company.setCanFile(Boolean.parseBoolean(resultSet.getString("can_file")));

        Links links = new Links();
        links.setSelf(resultSet.getString("self"));
        links.setFilingHistory(resultSet.getString("filing_history"));
        links.setOfficers(resultSet.getString("officers"));
        links.setCharges(resultSet.getString("charges"));
        company.setLinks(links);

        return company;
    }
}
