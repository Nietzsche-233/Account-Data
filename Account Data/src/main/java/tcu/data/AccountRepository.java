package tcu.data;

import org.springframework.data.repository.CrudRepository;
import tcu.data.Main.Account;

public interface AccountRepository extends CrudRepository<Account, String> {
}
