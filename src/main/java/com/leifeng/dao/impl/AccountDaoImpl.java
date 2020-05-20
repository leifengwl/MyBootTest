package com.leifeng.dao.impl;

import com.leifeng.dao.AccountDao;
import com.leifeng.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao {

    private QueryRunner runner;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    /*
    查询所有
     */
    @Override
    public List<Account> findAllAccount() {
        try {
            return runner.query("select * from account2",new BeanListHandler<>(Account.class));
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    /*
    查询一个
     */
    @Override
    public Account findAccountById(Integer accountId) {
        try {
            return runner.query("select * from account2 where id=?",new BeanHandler<>(Account.class),accountId);
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    /*
    添加
     */
    @Override
    public void saveAccount(Account account) {
        try {
            runner.update("insert into account2(name,money) values(?, ?)",account.getName(),account.getMoney());
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    /*
    更新
     */
    @Override
    public void updateAccount(Account account) {
        try {
            runner.update("update account2 set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    /*
    删除
     */
    @Override
    public void deleteAccount(Integer accountId) {
        try {
            runner.update("delete from account2 where id=?",accountId);
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }
}
