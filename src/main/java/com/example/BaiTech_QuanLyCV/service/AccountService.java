package com.example.BaiTech_QuanLyCV.service;

import com.example.BaiTech_QuanLyCV.dto.AccountDTO;

import java.util.List;

public interface AccountService {

    List<AccountDTO> getAll();

    AccountDTO getOne(Integer id);

    AccountDTO save(AccountDTO accountDTO);

    AccountDTO update(AccountDTO accountDTO,Integer id);

    void delete(Integer id);
}
