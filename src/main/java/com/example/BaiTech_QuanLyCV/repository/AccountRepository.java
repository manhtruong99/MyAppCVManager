package com.example.BaiTech_QuanLyCV.repository;

import com.example.BaiTech_QuanLyCV.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account,String> {

    @Query("SELECT ac FROM Account ac WHERE ac.ma = :ma")
    Account findByMaAccount(@Param("ma") String ma);

    Optional<Account> findByUsernameOrEmail(String username, String email);

}
