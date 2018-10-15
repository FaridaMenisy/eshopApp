package com.eshop.controller;



import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.eshop.model.Tablets;
import com.eshop.service.tablets.TabletsService;

import sun.misc.BASE64Decoder;

@RestController
@RequestMapping(value="/tablets")
public class TabletsController {
	
	@Autowired TabletsService tabletsService;
	
    @RequestMapping(value="/listtablets", method=RequestMethod.GET)
	public ResponseEntity<List> displayTablets (){
		List l = tabletsService.displayTabletsItems();
		return new ResponseEntity<List>(l ,HttpStatus.OK);
	}
	
	
	 @RequestMapping(value="/deletetablet/{id}", method=RequestMethod.DELETE)
	 public @ResponseBody Tablets delete(@PathVariable("id") int id){
	  Tablets tablets = tabletsService.findTabletById(id);
	  tabletsService.deleteTablets(id);
	  
	  return tablets;
	 }
	 
	 
	 @RequestMapping(value="/addtablet/", method=RequestMethod.POST)
	 public @ResponseBody Tablets add(@RequestBody Tablets tablets){
		 String photo = tablets.getPhoto();
		 String filename = tablets.getImagename();
		 System.out.println(filename);
		 BufferedImage image = null;
		
		  byte[] imageByte;
		  
		  try {
			  BASE64Decoder decoder = new BASE64Decoder();
			imageByte = decoder.decodeBuffer(photo);
			ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
			image = ImageIO.read(bis);
			bis.close();
			//File outputfile  = new File("Desktop/image.jpg");
			String pathFile="D:/FinalOfFINAL/"+filename;
			FileOutputStream outputfile = new FileOutputStream(pathFile);
			ImageIO.write(image, "jpg", outputfile);
			
			/*if(outputfile.exists() && outputfile.isFile()){
				
				System.out.println(outputfile.getAbsolutePath());
			}*/
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 if(photo.length() > 100){
		  tablets.setPhoto("http://10.100.255.136:8080/firstapps/"+filename);
	  tabletsService.saveOrUpdate(tablets);
		 }
		 else{
			 tabletsService.saveOrUpdate(tablets);
		 }
	  return tablets;
	 }
	 
	 @RequestMapping(value="/update/{id}", method=RequestMethod.PUT)
	 public @ResponseBody Tablets update(@PathVariable("id") int id, @RequestBody Tablets tablets){
	  tablets.setId(id);
	  String photo = tablets.getPhoto();
		 String filename = tablets.getImagename();
		 System.out.println(filename);
		 BufferedImage image = null;
		
		  byte[] imageByte;
		  
		  try {
			  BASE64Decoder decoder = new BASE64Decoder();
			imageByte = decoder.decodeBuffer(photo);
			ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
			image = ImageIO.read(bis);
			bis.close();
			//File outputfile  = new File("Desktop/image.jpg");
			String pathFile="D:/FinalOfFINAL/"+filename;
			FileOutputStream outputfile = new FileOutputStream(pathFile);
			ImageIO.write(image, "jpg", outputfile);
			
			/*if(outputfile.exists() && outputfile.isFile()){
				
				System.out.println(outputfile.getAbsolutePath());
			}*/
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 if(photo.length() > 100){
		  tablets.setPhoto("http://10.100.255.136:8080/firstapps/"+filename);
	  tabletsService.saveOrUpdate(tablets);
		 }
		 else{
			 tabletsService.saveOrUpdate(tablets);
		 }
	  
	  return tablets;
	 }

}
