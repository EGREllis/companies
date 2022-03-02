package allica.bank.web.controller;

import allica.bank.entity.Company;
import allica.bank.entity.User;
import allica.bank.http.CompanyHouseHttpClient;
import allica.bank.service.CompanyURLService;
import allica.bank.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
public class UserController {

    private final UserService userService;
    private final CompanyURLService companyUrlService;

    @Autowired
    public UserController(UserService userService, CompanyURLService service) {
        this.userService = userService;
        this.companyUrlService = service;
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id) {
        log.info("process=get-user, user_id={}", id);
        User user = userService.getUserById(id);
        return user;
    }

    @GetMapping("/company/{id}")
    public Company getCompany(@PathVariable Long id) {
        log.info("process=get-company, user_id={}", id);
        Company result = companyUrlService.getCompanyById(id);
        return result;
    }
}
