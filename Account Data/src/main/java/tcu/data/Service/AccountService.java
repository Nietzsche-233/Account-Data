package tcu.data.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tcu.data.AccountRepository;
import tcu.data.Main.Account;

@Service
@Transactional  //ACID

public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Iterable<Account> listALL() {
        return this.accountRepository.findAll();
    }

    public void add(Account account) {
        this.accountRepository.save(account);
    }

    public void removeById(String id) {
        this.accountRepository.deleteById(id);
    }

    public void toggleById(String id,String title,double money){
        Account account = this.accountRepository.findById(id).orElse(null);//Optional 可选的
        if(account == null){
            throw new RuntimeException("NOT FOUND");
        }
        account.setTitle(title);
        account.setMoney(money);
        this.accountRepository.save(account);
    }
}
