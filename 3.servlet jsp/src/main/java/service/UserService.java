package service;

import model.Users;

public interface UserService {
	
	
	boolean createUser(Users user);
	boolean userExist(Users user);
	boolean userExistsByUsername(String username);
	boolean deleteUserByUsername(String username);
	boolean updateUserPassword(String username , String newPassword); 
	


}
