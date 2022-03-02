package allica.bank.http;


import allica.bank.entity.Company;
import org.junit.Test;

public class CompanyHouseHttpClientTest {
    @Test
    public void endToEndTest() {
        CompanyHouseHttpClient client = new CompanyHouseHttpClient();
        String companyJSON = client.getCompanyById(6);
        assert companyJSON.length() > 0;
    }
}
