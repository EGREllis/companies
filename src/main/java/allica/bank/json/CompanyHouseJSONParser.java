package allica.bank.json;

import allica.bank.entity.Company;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class CompanyHouseJSONParser {
    public Company parseJSON(String json) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Company company = mapper.readValue(json, Company.class);
            return company;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
