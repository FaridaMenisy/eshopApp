package com.eshop.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eshop.model.Phones;
import com.eshop.model.Users;



@Repository
public class UserDaoImpl implements UserDao {
 
 @Autowired
 private SessionFactory sessionFactory;
 
 protected Session getSession(){
  return sessionFactory.getCurrentSession();
 }

 @SuppressWarnings("unchecked")
 public List getListUser() {
  Criteria criteria = getSession().createCriteria(Users.class);
   return (List) criteria.list();
 }


public Users checkUserExistance(String username, String password) {
	// TODO Auto-generated method stub
	
	Criteria cr = getSession().createCriteria(Users.class);
	
	Criterion name = Restrictions.eq("username",username);
	Criterion pw = Restrictions.eq("password",password);
     
	// To get records matching with AND conditions
	LogicalExpression andExp = Restrictions.and(name, pw);
	
	cr.add(andExp);
//	
//	Users  u  = (Users)cr.list().get(0);
//	String user = u.getUsername();
//	String pass = u.getPassword();
//	
//	if(user != username || pass!= password)
//	{
//		System.out.println("nulls object");
//		return null;
//	}
//
//   // String s =  cr.toString();
//    //System.out.println(s);
//	else
    return (Users)cr.list().get(0);
}

public List displayPhoneItems() {
	// TODO Auto-generated method stub
	 Criteria criteria = getSession().createCriteria(Phones.class);
	   return (List) criteria.list();
}


public void deletePhone(int id) {
	  Phones phones = (Phones) getSession().get(Phones.class, id);
	  getSession().delete(phones);
	 }

	 public Phones findUserById(int id) {
	  return (Phones) getSession().get(Phones.class, id);
	 }

	public void saveOrUpdate(Phones phones) {
		getSession().saveOrUpdate(phones);
		
	}
	
	
	
	
	

}

//@Repository
//public class UserDaoImpl  implements UserDao {
//	
//	
//	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
//	 
//	 @Autowired
//	 public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
//	  this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
//	 }
//
//
//	public Users checkUserExistance(String username, String password) {
//		 String sql = "Select * From user WHERE  username=:username, password=:password";
//		 
//	    Users users = (Users) namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(username,password), new UserMapper());
//		if(users!= null){
//			return users;
//		}
//		else
//	    return null;
//	}
//	
//	//hena b3ml binding mben l queryl fadya wl data eli fl dbase
//	private SqlParameterSource getSqlParameterByModel(String username , String password){
//		  MapSqlParameterSource parameterSource = new MapSqlParameterSource();
//		  if(username != null && password!= null){
//		  
//		   parameterSource.addValue("username",username);
//		   parameterSource.addValue("password",password);
//		 
//		  }
//		  return parameterSource;
//		 }
//	
//	
//	//hena b3mel el3ks ba bind eli  rg3 ml dbase  b el model eli3ndi
//	 private static final class UserMapper implements RowMapper{
//
//		  public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
//		   Users user = new Users();
//		   user.setId(rs.getInt("id"));
//		   user.setUsername(rs.getString("userame"));
//		   user.setPassword(rs.getString("password"));
//		 
//		   
//		   return user;
//		  }
//		  
//		 }
//
//}
