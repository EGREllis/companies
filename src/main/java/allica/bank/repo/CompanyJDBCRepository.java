package allica.bank.repo;

import allica.bank.entity.Company;
import allica.bank.jdbc.CompanyJDBCRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@Repository
public class CompanyJDBCRepository {
    private static final DateFormat ISO_DATE_FORMAT = new SimpleDateFormat("yyyyMMdd");
    private static final String GET_COMPANY_QUERY_TEMPLATE = "SELECT * FROM company_house_response WHERE company_number = %1$d";
    private static final String INSERT_COMPANY_HEADER_TEMPLATE = "INSERT INTO company_house_response (company_number,\n" +
            "    date_of_creation,\n" +
            "    last_full_members_list_date,\n" +
            "    company_type,\n" +
            "    jurisdiction,\n" +
            "    company_name,\n" +
            "        postal_code,\n" +
            "        address_line_1,\n" +
            "        address_line_2,\n" +
            "        locality,\n" +
            "        country,\n" +
            "        month_,\n" +
            "        day_,\n" +
            "        made_up_to,\n" +
            "        accounts_type,\n" +
            "        period_end_on,\n" +
            "    sic_code_set_id,\n" +
            "    undeliverable_registered_office_address,\n" +
            "    has_insolvency_history,\n" +
            "    company_status,\n" +
            "    etag,\n" +
            "    has_charges,\n" +
            "    registered_office_is_in_dispute,\n" +
            "    date_of_cessation,\n" +
            "    can_file,\n" +
            "        self,\n" +
            "        filing_history,\n" +
            "        officers,\n" +
            "        charges\n" +
            ") VALUES (\n" +
            "%1$d,\n" +
            "'%2$s',\n" +
            "'%3$s',\n" +
            "'%4$s',\n" +
            "'%5$s',\n" +
            "'%6$s',\n" +
            "'%7$s',\n" +
            "'%8$s',\n" +
            "        address_line_2 VARCHAR(120),\n" +
            "        locality VARCHAR(120),\n" +
            "        country VARCHAR(120),\n" +
            "\n" +
            "        month_ INTEGER,\n" +
            "        day_ INTEGER,\n" +
            "\n" +
            "        made_up_to DATE,\n" +
            "        accounts_type VARCHAR(120),\n" +
            "        period_end_on DATE,\n" +
            "\n" +
            "    sic_code_set_id INTEGER,\n" +
            "    undeliverable_registered_office_address VARCHAR(5),\n" +
            "    has_insolvency_history VARCHAR(5),\n" +
            "    company_status VARCHAR(120),\n" +
            "    etag VARCHAR(120),\n" +
            "    has_charges VARCHAR(5),\n" +
            "    registered_office_is_in_dispute VARCHAR(5),\n" +
            "    date_of_cessation DATE,\n" +
            "    can_file VARCHAR(5),\n" +
            "\n" +
            "        self VARCHAR(120),\n" +
            "        filing_history VARCHAR(120),\n" +
            "        officers VARCHAR(120),\n" +
            "        charges VARCHAR(120)";
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CompanyJDBCRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Company getCompanyById(long id) {
        String query = String.format(GET_COMPANY_QUERY_TEMPLATE, id);
        List<Company> company = jdbcTemplate.query(query, new CompanyJDBCRowMapper());
        if (company.size() <= 0) {
            return null;
        } else {
            return company.get(0);
        }
    }

    public void save(Company company) {
        //TODO: Implement this
    }
}
