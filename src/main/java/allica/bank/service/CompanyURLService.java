package allica.bank.service;

import allica.bank.entity.Company;
import allica.bank.http.CompanyHouseHttpClient;
import allica.bank.json.CompanyHouseJSONParser;
import allica.bank.repo.CompanyJDBCRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CompanyURLService {
    private final CompanyHouseHttpClient client;
    private final CompanyHouseJSONParser parser;
    private final CompanyJDBCRepository repository;

    @Autowired
    public CompanyURLService(CompanyHouseHttpClient client, CompanyHouseJSONParser parser, CompanyJDBCRepository repository) {
        this.client = client;
        this.parser = parser;
        this.repository = repository;
    }

    public Company getCompanyById(long id) {
        log.info("Fetching from database company with id {}", id);
        Company result = repository.getCompanyById(id);

        if (result == null) {
            log.info("Fetching from URL company with id {}", id);
            String json = client.getCompanyById(id);
            result = parser.parseJSON(json);
            repository.save(result);
        }
        return result;
    }
}
