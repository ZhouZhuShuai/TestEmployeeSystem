package service;

import java.util.List;

import Entity.Product;
import Entity.User;


public interface UserService {


	public boolean searchByUserNameAndPassword(String username, String password);

	public User searchByusername(String username);

}
