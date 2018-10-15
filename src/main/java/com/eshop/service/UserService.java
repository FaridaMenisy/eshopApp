package com.eshop.service;

import java.util.List;

import com.eshop.model.Phones;
import com.eshop.model.Users;

public interface UserService {

	public Users validateUser(String username , String password);
	 public List getListUser();
	 public List displayPhoneItems ();
	 public void deletePhone(int id);
	 public Phones findUserById(int id);
	 public void saveOrUpdate(Phones phones);
}
