package com.alibaba.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.DAO.ProductDAO;
import com.alibaba.model.Product;

@Controller
public class AdminController {
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping("/admin")
	public ModelAndView admin()
	{
		System.out.println("In admin()");
		return new ModelAndView("admin");
	}
	@RequestMapping("/addProduct")
	public ModelAndView addProduct()
	{
		Product product=new Product();
		System.out.println("In addProduct()");
		return new ModelAndView("addProduct","pro",product);
	}
	@RequestMapping("/addTheProduct")
	public ModelAndView addTheProduct(@RequestParam("file") MultipartFile file,  @ModelAttribute("pro") Product product) throws IllegalStateException, IOException
	{
		productDAO.addProduct(product);
		System.out.println("is addTheProduct");
		MultipartFile f = file;
		System.out.println("file:"+f);
		Path path=Paths.get("C://Users//Sai Ganesh//Desktop//NIIT DT//"
				+ "Eclipse_Mars_Pracitce3//alibaba//src//main//webapp//resources//images//"+product.getProductId()+".jpg");
		if(f!=null)
		{
			f.transferTo(new File(path.toString()));
			System.out.println("Image Stored");
		}
		
		
		return new ModelAndView("viewProduct");
	}
	@RequestMapping("/viewProduct")
	public ModelAndView viewProduct() throws JsonGenerationException, JsonMappingException, IOException
	{
		List<Product> list=productDAO.viewProducts();
		System.out.println("list of products are:"+list);
		ObjectMapper objectMapper=new ObjectMapper();
		String jsondata=objectMapper.writeValueAsString(list);
		System.out.println("list of products are:"+jsondata);
 
		return new ModelAndView("viewProduct","json",jsondata);
	}
	@RequestMapping("/deleteProduct")
	public String deleteProduct(@RequestParam("id") int id)
	{
		System.out.println("id:"+id);
		productDAO.deleteProductById(id);
		return "redirect:/viewProduct"; 
	}
}
