package com.eshop.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
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

import com.eshop.model.Phones;
import com.eshop.service.UserService;

//import javax.ws.rs.Consumes;
//
//import org.apache.cxf.jaxrs.ext.multipart.MultipartBody;
import sun.misc.BASE64Decoder;

@RestController
@RequestMapping(value="/items")
public class ItemsController {

	@Autowired private UserService userService;
	@RequestMapping(value = "/phones" , method=RequestMethod.GET )
	public ResponseEntity<List> displayPhones (){
		
		
		List l = userService.displayPhoneItems();
		
		return new ResponseEntity<List>(l ,HttpStatus.OK);
	}
	
	 @RequestMapping(value="/deletephones/{id}", method=RequestMethod.DELETE)
	 public @ResponseBody Phones delete(@PathVariable("id") int id){
	  Phones phones = userService.findUserById(id);
	  userService.deletePhone(id);
	  
	  return phones;
	 }
	 
	 
	 @RequestMapping(value="/addphone/", method=RequestMethod.POST)
	 public @ResponseBody Phones add(@RequestBody Phones phones){
		 String photo = phones.getPhoto();
		 String filename = phones.getImageName();
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
		  phones.setPhoto("http://10.100.255.136:8080/firstapps/"+filename);
	  userService.saveOrUpdate(phones);
		 }
		 else{
			 userService.saveOrUpdate(phones);
		 }
	  return phones;
	 }
	 
	 @RequestMapping(value="/update/{id}", method=RequestMethod.PUT)
	 public @ResponseBody Phones update(@PathVariable("id") int id, @RequestBody Phones phone){
	  phone.setId(id);
		 String photo = phone.getPhoto();
		 String filename = phone.getImageName();
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
		  phone.setPhoto("http://10.100.255.136:8080/firstapps/"+filename);
	  userService.saveOrUpdate(phone);
		 }
		 else{
	 
	  userService.saveOrUpdate(phone);
		 }
	  return phone;
	 }
	 
//	 private Bitmap decodeFromBase64ToBitmap(String encodedImage)
//	 
//	 {
//	  
//	     byte[] decodedString = Base64.decode(encodedImage, Base64.DEFAULT);
//	  
//	     Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
//	  
//	     return decodedByte;
//	  
//	     }
	// @Consumes(MediaType.MULTIPART_FORM_DATA)
//	 @RequestMapping(value = "/save", method = RequestMethod.POST )
//	public @ResponseBody void addPhoto(@RequestBody  MultipartFile uploadedFile ) {
//       
//		 
//		if( uploadedFile.isEmpty()){
//			
//			System.out.println("wronggggg");
//		}
//		
//		else{
//			System.out.println("righttttt");
//		
//		}
//	 }
}

