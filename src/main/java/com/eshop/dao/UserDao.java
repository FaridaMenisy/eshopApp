package com.eshop.dao;

import java.util.List;

import com.eshop.model.Phones;
import com.eshop.model.Users;

public interface UserDao {
	public Users checkUserExistance(String username, String password);
	public List getListUser();
	public List displayPhoneItems ();
	public void deletePhone(int id);
	public Phones findUserById(int id);
	public void saveOrUpdate(Phones phones);
	

}
