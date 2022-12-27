package com.sevenseven.cashloansystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PageController {

    @GetMapping("/all")
    public String forAll() {
        return "forAll/page1";
    }

    @GetMapping("/manager")
    public String forManager() {
        return "forAuthenticated/page2";
    }

    @GetMapping("/admin")
    public String forAdmin() {
        return "forAuthenticated/page3";
    }

    @GetMapping("/lender")
    public String forLender() {
        return "forAuthenticated/page4";
    }
    @GetMapping("/borrower")
    public String forBorrower() {
        return "forAuthenticated/page5";
    }
    @GetMapping("/teller-list")
    public String forTellerList() {
        return "forAuthenticated/teller-list";
    }
    @GetMapping("/borrower-list")
    public String forBorrowerList() {
        return "forAuthenticated/borrower-list";
    }
    @GetMapping("/official-list")
    public String forOfficialList() {
        return "forAuthenticated/official-list";
    }
    @GetMapping("/edit-borrower")
    public String forBorrowerEdit() {
        return "forAuthenticated/edit-borrower";
    }
    @GetMapping("/create-borrower")
    public String forBorrowerCreate() {
        return "forAuthenticated/edit-borrower";
    }
    @GetMapping("/add-teller")
    public String forAddTeller() {
        return "forAuthenticated/add-teller";
    }
    @GetMapping("/edit-teller")
    public String forEditTeller() {
        return "forAuthenticated/edit-teller";
    }
    @GetMapping("/add-official")
    public String forAddOfficial() {
        return "forAuthenticated/add-official";
    }
    @GetMapping("/disable-official")
    public String forDisableOfficial() {
        return "forAuthenticated/disable-official";
    }
    @GetMapping("/current-interest-rate")
    public String forCurrentRate() {
        return "forAuthenticated/current-interest-rate";
    }
    @GetMapping("/approve-loan-request")
    public String forApprovedLoan() {
        return "forAuthenticated/approve-loan-request";
    }
    @GetMapping("/disapproved-loan-request")
    public String forDisapprovedLoan() {
        return "forAuthenticated/disapproved-loan-request";

    }
    @GetMapping("/view-request")
    public String forViewRequest() {
        return "forAuthenticated/view-request";

    }
    @GetMapping("/edit-request")
    public String forEditRequest() {
        return "forAuthenticated/edit-request";

    }
    @GetMapping("/delete-request")
    public String forDeleteRequest() {
        return "forAuthenticated/delete-request";

    }
    @GetMapping("/loan-request")
    public String forLoanRequest() {
        return "forAuthenticated/loan-request";

    }
    @GetMapping("/borrowers-record")
    public String forBorrowersRecord() {
        return "forAuthenticated/borrowers-record";

    }
    @GetMapping("/review-loan")
    public String forReviewLoan() {
        return "forAuthenticated/review-loan";


    }
    @GetMapping("/update-loan")
    public String forUpdateLoan() {
        return "forAuthenticated/update-loan";

    }
    @GetMapping("/submit-loan")
    public String forSubmitLoan() {
        return "forAuthenticated/submit-loan";

    }
    @GetMapping("/register")
    public String forRegister() {
        return "forAuthenticated/register";

    }
    @GetMapping("/edit-info")
    public String forEditInfo() {
        return "forAuthenticated/edit-info";

    }
    @GetMapping("/cancel-request")
    public String forCancelRequest() {
        return "forAuthenticated/cancel-request";

    }
    @GetMapping("/edit-loan-request")
    public String forEditLoanRequest() {
        return "forAuthenticated/edit-loan-request";

    }
    @GetMapping("/current-request")
    public String forCurrentRequest() {
        return "forAuthenticated/current-request";

    }
    @GetMapping("/old-request")
    public String forOldRequest() {
        return "forAuthenticated/old-request";

    }



}

