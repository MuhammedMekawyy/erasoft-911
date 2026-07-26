package service;

import model.Account;

public interface AccountService {

	boolean createAccount(Account account);
	boolean accountExist(Account account);
	boolean accountExistsByUsername(String username);
	boolean deleteAccountByUsername(String username);
	boolean updateAccountPassword(String username , String newPassword); 
	Account login(Account account);
}