package com.lti.controller;

import java.beans.PropertyEditorSupport;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.mail.Multipart;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lti.entity.Customer;
import com.lti.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	//what we want is when the form is submitted,
	//the data should automatically get stores in some object for us
	
	@RequestMapping(path = "/addCustomer.lti", method = RequestMethod.POST)
	public String add(Customer customer,@RequestParam("profilePic") MultipartFile profilePic) {
		
		String path = "d:/uploads/";
		String finalpath = path + profilePic.getOriginalFilename();
		
		try {
			profilePic.transferTo(new File(finalpath));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		customer.setProfilePicFileName(profilePic.getOriginalFilename());
		customerService.add(customer);
		
		
		return "confirmation.jsp";
	}
	
	@RequestMapping("/fetchAllCustomers.lti")
	public String fetchAllCustomers(ModelMap model,HttpServletRequest request) {
		
		String projpath = request.getServletContext().getRealPath("/");
		System.out.println(projpath);
		
		File profilePicFolder = new File(projpath + "profiles");
		if(!profilePicFolder.exists())
			profilePicFolder.mkdir();
		
		List<Customer> customers = customerService.fetchAll();
		for(Customer cust:customers) {
			if(cust.getProfilePicFileName()!=null) {
			File profilePicUploadedLocation = new File("d:/uploads/" + cust.getProfilePicFileName());
			File profilePicProjLocation = new File(profilePicFolder,cust.getProfilePicFileName());
			try {
				FileUtils.copyFile(profilePicUploadedLocation, profilePicProjLocation);
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			}
		}
		
		
		model.put("customersList", customers);
		
		return "displayAllCustomers.jsp";
	}
}


@ControllerAdvice
 class LocalDateControllerAdvice {
	 
	  @InitBinder
	  public void initBinder(WebDataBinder binder) {
	    binder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
	      @Override
	      public void setAsText(String text) throws IllegalArgumentException {
	        setValue(LocalDate.parse(text, DateTimeFormatter.ISO_DATE));
	      }
	    });
	  }
	}