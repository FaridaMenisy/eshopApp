package com.eshop.service.tablets;


import java.util.List;

import com.eshop.model.Tablets;


public interface TabletsService {
	
	public List displayTabletsItems ();
	public void deleteTablets(int id);
	public Tablets findTabletById(int id);
	public void saveOrUpdate(Tablets tablets);

}
