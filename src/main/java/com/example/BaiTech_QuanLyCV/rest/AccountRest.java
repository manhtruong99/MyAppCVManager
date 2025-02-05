package com.example.BaiTech_QuanLyCV.rest;

import com.example.BaiTech_QuanLyCV.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("account")
public class AccountRest {

    private AccountService accountService;

    @Autowired
    public AccountRest(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("hien-thi")
    public ResponseEntity<List> getAll(){
        return ResponseEntity.ok(accountService.getAll());
    }
}
