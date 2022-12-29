package com.sevenseven.cashloansystem.controller;

import java.util.List;

import com.sevenseven.cashloansystem.model.Teller;
import com.sevenseven.cashloansystem.service.TellerService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class TellerController {

    @Autowired
    private TellerService tellerService;

    // display list of tellers
    @GetMapping("/")
    public String viewHomePage(Model model) {
        return findPaginated(1, "firstName", "asc", model);
    }

    @GetMapping("/showNewTellerForm")
    public String showNewTellerForm(Model model) {
        // create model attribute to bind form data
        Teller teller = new Teller();
        model.addAttribute("teller", teller);
        return "new_teller";
    }

    @PostMapping("/saveTeller")
    public String saveTeller(@ModelAttribute("teller") Teller teller) {
        // save employee to database
        tellerService.saveTeller(teller);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {

        // get teller from the service
        Teller teller = tellerService.getTellerById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("teller", teller);
        return "update_teller";
    }

    @GetMapping("/deleteTeller/{id}")
    public String deleteTeller(@PathVariable (value = "id") long id) {

        // call delete employee method
        this.tellerService.deleteTellerById(id);
        return "redirect:/";
    }


    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page<Teller> page = tellerService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Teller> listTellers = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listTellers", listTellers);
        return "index";
    }
}