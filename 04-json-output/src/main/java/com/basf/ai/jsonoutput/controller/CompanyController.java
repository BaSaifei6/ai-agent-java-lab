package com.basf.ai.jsonoutput.controller;

import com.basf.ai.jsonoutput.entity.CompanyInfo;
import com.basf.ai.jsonoutput.entity.CompanyRecommend;
import com.basf.ai.jsonoutput.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/recommend")
    public CompanyRecommend company(String message){
        return companyService.analyze(message);

    }
}
