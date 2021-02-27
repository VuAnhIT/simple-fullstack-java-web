package com.theanh.fullstack.web.controller;

import com.theanh.fullstack.web.dao.ClientSubmissionRepository;
import com.theanh.fullstack.web.dao.MachineRepository;
import com.theanh.fullstack.web.entity.ClientSubmission;
import com.theanh.fullstack.web.entity.Machine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    MachineRepository machineRepository;

    @Autowired
    ClientSubmissionRepository clientSubmissionRepository;

    //region home page
    @GetMapping("/")
    String goToFrontPage(Model theModel) {
        theModel.addAttribute("isOnHomePage", true);
        List<Machine> machines = machineRepository.findAllRemainedByOrderByPublishedDateAsc();
        theModel.addAttribute("machines", machines);
        return "home-page";
    }
    //endregion home page

    //region machines for sale
    @GetMapping("/machines-for-sale")
    String goToMachinesForSalePage(Model theModel) {
        theModel.addAttribute("isOnMachinesForSalePage", true);
        List<Machine> machines = machineRepository.findAllByOrderByPublishedDateAsc();
        theModel.addAttribute("machines", machines);
        return "machines-for-sale-page";
    }
    //endregion machines for sale

    //region machines for sale
    @GetMapping("/about-our-company")
    String goToAboutOurCompanyPage(Model theModel) {
        theModel.addAttribute("isOnAboutOurCompanyPage", true);
        return "about-our-company-page";
    }
    //endregion machines for sale

    //region contact page
    @GetMapping("/contact")
    String getContactPage(Model theModel) {
        theModel.addAttribute("isOnContactPage", true);
        theModel.addAttribute("clientSubmission", new ClientSubmission());
        return "contact-page";
    }

    @PostMapping("/save-submit")
    String saveClientSubmission(@Valid @ModelAttribute("clientSubmission") ClientSubmission clientSubmission,
                                BindingResult bindingResult,
                                Model theModel) {
        theModel.addAttribute("isOnContactPage", true);
        if (!bindingResult.hasErrors()) {
            clientSubmission.setSubmitDateTime(LocalDateTime.now());
            clientSubmissionRepository.save(clientSubmission);
            theModel.addAttribute("submitSuccess", true);
            return "contact-page";
        }
        return "contact-page";
    }
    //endregion contact page

    @GetMapping("/error")
    String returnToFrontPage() {
        return "error";
    }

}
