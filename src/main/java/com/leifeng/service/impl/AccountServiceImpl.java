package com.leifeng.service.impl;

import com.leifeng.dao.AccountDao;
import com.leifeng.domain.Account;
import com.leifeng.service.AccountService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    /*
        查询所有
         */
    @Override
    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    /*
    查询一个
     */
    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    /*
    添加
     */
    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    /*
    更新
     */
    @Override
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    /*
    删除
     */
    @Override
    public void deleteAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);
    }
}
