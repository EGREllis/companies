package allica.bank.http;

import allica.bank.entity.Company;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
@Slf4j
public class CompanyHouseHttpClient {
    private static final String REQUEST_TEMPLATE = "https://api.company-information.service.gov.uk/company/%1$8d";
    private static final String AUTHENTICATION_TEMPLATE = "Basic %1$s";
    private static final String API_KEY = "ad7f2431-9c4a-4066-9fdb-c0c107e966e2";
    private static final String ENCODING = "UTF-8";

    public String getCompanyById(long id) {
        String request = String.format(REQUEST_TEMPLATE, id);
        request = request.replace(' ','0'); //Padded with spaces but we need zeros
        log.info("get company by id, id={}", id);
        log.info("GET URL={}", request);

        try {
            URL url = new URL(request);
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
            urlConnection.setRequestMethod("GET");

            urlConnection.setRequestProperty(HttpHeaders.ACCEPT_CHARSET, ENCODING);

            String encoded = API_KEY + ":";
            encoded = Base64.getEncoder().encodeToString(encoded.getBytes(StandardCharsets.UTF_8));
            String authentication = String.format(AUTHENTICATION_TEMPLATE, encoded);
            log.info("Company house authorization: {}", authentication);
            urlConnection.setRequestProperty(HttpHeaders.AUTHORIZATION, authentication);

            int responseCode = urlConnection.getResponseCode();
            log.info("Response code was: {}", responseCode);

            if (responseCode >= 200 && responseCode <= 299) {
                StringBuilder message = new StringBuilder();
                log.info("Response message: {}",urlConnection.getResponseMessage());
                BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                String line = reader.readLine();
                log.info("Line: {}", line);
                return line;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return "";
    }
}
