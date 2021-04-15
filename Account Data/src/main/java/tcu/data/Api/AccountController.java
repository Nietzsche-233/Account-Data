package tcu.data.Api;

import org.springframework.web.bind.annotation.*;
import tcu.data.Main.Account;
import tcu.data.Service.AccountService;

@CrossOrigin("http://localhost:8081")
@RestController                                 //REST API  接口开发

//REST API需要:
//	url         (描述资源的地址）
//	HTTP METHOD:
// 		GET：   只从服务器读取资源
// 		POST：  往服务器添加资源
// 		PUT：   修改服务器上的资源
// 		DELETE：删除服务器上的资源
//	REQUEST PARAMETER  (请求参数）
// 		url   参数 （地址栏）
//		body  参数 （post 方法的表单）
//	Request   内容类型
//	Response （响应+Status Code状态码）
//	Response  内容类型

public class AccountController {                //与浏览器通信
//  private List<Account> accounts;             //将所有条目储存在内存中
    private final AccountService accountService;
    public AccountController(AccountService service) {
//      accounts = new ArrayList<>();           //初始化
        this.accountService = service;
    }

    @GetMapping("/API/Account")
    public Iterable<Account> listALL() {             //返回所有的Account
        return this.accountService.listALL();
    }

    @PostMapping("/API/Account")
    public Account create(@RequestBody Account account) {
//        account.setId(UUID.randomUUID().toString());
//        account.setEditable(false);
//        return account;
        accountService.add(account);
        return account;
    }

    @DeleteMapping("/API/Account/{id}")
    public void removeById(@PathVariable String id) {
        accountService.removeById(id);
    }
    @PutMapping("/API/Account/{id}/{title}/{money}")
    public void change(@PathVariable String id,@PathVariable String title,@PathVariable double money){
        accountService.toggleById(id,title,money);
    }
//    public void Change(@RequestBody Account account) {        //内存
//        this.accounts.forEach(account1 -> {
//            if (account1.getId().equals(account.getId())) {
//                account1.setType(account.getType());
//                account1.setMoney(account.getMoney());
//                account1.setTitle(account.getTitle());
//            }
//        });
//    }
}
