package com.apress.prospringmvc.bookstore.web.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apress.prospringmvc.bookstore.domain.Account;
import com.apress.prospringmvc.bookstore.service.AccountService;

/**
 * Controller to handle the registration of a new {@link Account}
 * @author marten
 *
 */
@Controller
@RequestMapping("/customer/register")
public class RegistrationController extends AbstractCustomerController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(method = RequestMethod.GET)
    @ModelAttribute
    public Account register(Locale currentLocale) {
        Account account = new Account();
        account.getAddress().setCountry(currentLocale.getCountry());
        return account;
    }

    @RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT })
    public String handleRegistration(@ModelAttribute Account account, BindingResult result) {
        if (result.hasErrors()) {
            return "customer/register";
        }
        this.accountService.save(account);
        return "redirect:/customer/account";
    }
}