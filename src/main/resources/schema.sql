CREATE TABLE company_house_response (
    company_number NUMERIC(8,0),
    date_of_creation DATE,
    last_full_members_list_date DATE,
    company_type VARCHAR(60),
    jurisdiction VARCHAR(60),
    company_name VARCHAR(120),

        postal_code VARCHAR(8),
        address_line_1 VARCHAR(120),
        address_line_2 VARCHAR(120),
        locality VARCHAR(120),
        country VARCHAR(120),

        month_ INTEGER,
        day_ INTEGER,

        made_up_to DATE,
        accounts_type VARCHAR(120),
        period_end_on DATE,

    sic_code_set_id INTEGER,
    undeliverable_registered_office_address VARCHAR(5),
    has_insolvency_history VARCHAR(5),
    company_status VARCHAR(120),
    etag VARCHAR(120),
    has_charges VARCHAR(5),
    registered_office_is_in_dispute VARCHAR(5),
    date_of_cessation DATE,
    can_file VARCHAR(5),

        self VARCHAR(120),
        filing_history VARCHAR(120),
        officers VARCHAR(120),
        charges VARCHAR(120)
);

CREATE TABLE sic_code_set (
    sic_code_set_id INTEGER,
    sic_code INTEGER
);