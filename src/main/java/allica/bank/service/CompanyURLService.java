package allica.bank.service;

import allica.bank.entity.Company;
import allica.bank.http.CompanyHouseHttpClient;
import allica.bank.json.CompanyHouseJSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyURLService {
    private final CompanyHouseHttpClient client;
    private final CompanyHouseJSONParser parser;

    @Autowired
    public CompanyURLService(CompanyHouseHttpClient client, CompanyHouseJSONParser parser) {
        this.client = client;
        this.parser = parser;
    }

    public Company getCompanyById(long id) {
        String json = client.getCompanyById(id);
        Company result = parser.parseJSON(json);
        return result;
    }
}
