package service;

public interface WalletService {
	
	boolean DepositMoney(double money , int id); 
	boolean WithdrawMoney(double money , int id); 
	boolean transferMoney(double money , int id , String receiverUsername);
	

}
