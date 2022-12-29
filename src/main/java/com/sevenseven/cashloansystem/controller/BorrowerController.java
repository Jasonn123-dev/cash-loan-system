package com.sevenseven.cashloansystem.controller;

import com.sevenseven.cashloansystem.repository.BorrowerRepo;
import com.sevenseven.cashloansystem.repository.OfficialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/borrower")
public class BorrowerController {

    @Autowired
    private BorrowerRepo repo;

    @GetMapping("/list")
    public ModelAndView getAllBorrowers() {
        ModelAndView mav = new ModelAndView("forAuthenticated/borrower-list");
        mav.addObject("borrowers", repo.findAll());
        return mav;
    }
}