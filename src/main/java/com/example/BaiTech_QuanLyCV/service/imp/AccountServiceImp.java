package com.example.BaiTech_QuanLyCV.service.imp;

import com.example.BaiTech_QuanLyCV.dto.AccountDTO;
import com.example.BaiTech_QuanLyCV.repository.AccountRepository;
import com.example.BaiTech_QuanLyCV.service.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImp implements AccountService {

    private AccountRepository accountRepository;

    private ModelMapper modelMapper;

    @Autowired
    public AccountServiceImp(AccountRepository accountRepository, ModelMapper modelMapper) {
        this.accountRepository = accountRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<AccountDTO> getAll() {
        return accountRepository.findAll().stream().map((account) -> modelMapper.map(account,AccountDTO.class)).collect(Collectors.toList());
    }

    @Override
    public AccountDTO getOne(Integer id) {
        return null;
    }

    @Override
    public AccountDTO save(AccountDTO accountDTO) {
        return null;
    }

    @Override
    public AccountDTO update(AccountDTO accountDTO, Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
