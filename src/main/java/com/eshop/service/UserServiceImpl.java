package com.eshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eshop.dao.UserDao;
import com.eshop.model.Phones;
import com.eshop.model.Users;

@Service
@Transactional
public class UserServiceImpl  implements UserService{
	
	
	@Autowired private UserDao userDao;

	public Users validateUser(String username, String password) {
		// TODO Auto-generated method stub
		return userDao.checkUserExistance(username, password);
	}
	
	
	 public List getListUser() {
		  return userDao.getListUser();
		 }


	public List displayPhoneItems() {
		// TODO Auto-generated method stub
		return userDao.displayPhoneItems();
	}


	public void deletePhone(int id) {
		userDao.deletePhone(id);
		
	}


	public Phones findUserById(int id) {
		// TODO Auto-generated method stub
		return userDao.findUserById(id);
	
}
	
	 public void saveOrUpdate(Phones phones) {
		  userDao.saveOrUpdate(phones);
		 }

}
