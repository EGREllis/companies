package allica.bank.entity;

import lombok.Data;

@Data
public class Address {
    private String postal_code;
    private String address_line_1;
    private String address_line_2;
    private String locality;
    private String country;
}
