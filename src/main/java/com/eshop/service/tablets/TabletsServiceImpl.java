package com.eshop.service.tablets;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshop.dao.tablets.TabletsDao;
import com.eshop.model.Tablets;



@Service
public class TabletsServiceImpl implements TabletsService{
	
	@Autowired private TabletsDao tabletsDao;

	public List displayTabletsItems() {
		// TODO Auto-generated method stub
		
		return tabletsDao.displayTabletsItems();
	}
	public void deleteTablets(int id) {
		// TODO Auto-generated method stub
		tabletsDao.deleteTablets(id);
		
	}

	public Tablets findTabletById(int id) {
		// TODO Auto-generated method stub
		return tabletsDao.findTabletById(id);
	}

	public void saveOrUpdate(Tablets tablets) {
		// TODO Auto-generated method stub
		tabletsDao.saveOrUpdate(tablets);
		
	}

}
