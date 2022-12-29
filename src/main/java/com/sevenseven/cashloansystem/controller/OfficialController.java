package com.sevenseven.cashloansystem.controller;


import com.sevenseven.cashloansystem.repository.OfficialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/official")
public class OfficialController {

    @Autowired
    private OfficialRepo repo;

    @GetMapping("/list")
    public ModelAndView getAllOfficials() {
        ModelAndView mav = new ModelAndView("forAuthenticated/official-list");
        mav.addObject("officials", repo.findAll());
        return mav;
    }
}