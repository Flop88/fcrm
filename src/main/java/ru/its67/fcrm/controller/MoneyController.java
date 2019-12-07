package ru.its67.fcrm.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.its67.fcrm.domain.Balances;

@Controller
@RequestMapping("/balance")
@PreAuthorize("hasAuthority('ADMIN')")
public class MoneyController {

    @GetMapping
    public String balanceForm(@PathVariable Balances balances, Model model){
        model.addAttribute("balance", balances);

        return "balance";
    }
}
