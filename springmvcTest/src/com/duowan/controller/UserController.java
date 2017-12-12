package com.duowan.controller;

import java.io.File;


import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.duowan.controller.FileUploadController.ProcessInfo;
import com.duowan.pojo.User;
import com.duowan.service.UserService;

/*
@Controller  
@RequestMapping("mydemo")  
public class UserController {  
    @RequestMapping(value="/getUserInfo")  
    public String getUserInfo(HttpServletRequest request){  
        String currentUser = (String)request.getSession().getAttribute("currentUser");  
        System.out.println("当前登录的用户为[" + currentUser + "]");  
        request.setAttribute("currUser", currentUser);  
        return "/user/info";  
    }  
}  */
@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("login")
	public String login(Model model,HttpServletRequest req,HttpServletResponse resp){
		return "login";
		
	}
	

/*	@RequestMapping("success")
	public String success(Model model,HttpServletRequest req,HttpServletResponse resp,String username,String password){
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		req.setAttribute("user", user);
		return "login";
		
	}*/
	
/*	@RequestMapping("up")
	public String index(Model model,HttpServletRequest req,HttpServletResponse resp){
		return "ind";
		
	}

	
	@RequestMapping("demo")
	public String demo(Model model,HttpServletRequest req,HttpServletResponse resp){
		return "demo";	
	}

	    @RequestMapping(value = "upload")  
	    public ModelAndView upload(HttpServletRequest request,  
	            HttpServletResponse response) throws Exception {  
	        final HttpSession hs = request.getSession();  
	        ModelAndView mv = new ModelAndView();  
	        boolean isMultipart = ServletFileUpload.isMultipartContent(request);  
	        if(!isMultipart){  
	            return null;  
	        }  
	        // Create a factory for disk-based file items  
	        FileItemFactory factory = new DiskFileItemFactory();  
	   
	        // Create a new file upload handler  
	        ServletFileUpload upload = new ServletFileUpload(factory);  
	        upload.setProgressListener(new ProgressListener(){  
	               public void update(long pBytesRead, long pContentLength, int pItems) {  
	                   ProcessInfo pri = new ProcessInfo();  
	                   pri.itemNum = pItems;  
	                   pri.readSize = pBytesRead;  
	                   pri.totalSize = pContentLength;  
	                   pri.show = pBytesRead+"/"+pContentLength+" byte";  
	                   pri.rate = Math.round(new Float(pBytesRead) / new Float(pContentLength)*100);  
	                   hs.setAttribute("proInfo", pri);  
	               }  
	            });  
	        List items = upload.parseRequest(request);  
	        // Parse the request  
	        // Process the uploaded items  
	      Iterator iter = items.iterator();  
	      while (iter.hasNext()) {  
	          FileItem item = (FileItem) iter.next();  
	          if (item.isFormField()) {  
	              String name = item.getFieldName();  
	              String value = item.getString();  
	              System.out.println("this is common feild!"+name+"="+value);  
	          } else {  
	              System.out.println("this is file feild!");  
	               String fieldName = item.getFieldName();  
	                  String fileName = item.getName();  
	                  String contentType = item.getContentType();  
	                  boolean isInMemory = item.isInMemory();  
	                  long sizeInBytes = item.getSize(); 
	                  System.out.println("E:\\acd\\"+fileName);
	                  File uploadedFile = new File("E:\\acd\\"+fileName);  
	                  item.write(uploadedFile);  
	          }  
	      }  
	        return null;  
	    }  
	       
	       
	    *//** 
	     * process 获取进度 
	     * @param request 
	     * @param response 
	     * @return 
	     * @throws Exception 
	     *//*  
	    @RequestMapping(value = "process")  
	    @ResponseBody  
	    public Object process(HttpServletRequest request,  
	            HttpServletResponse response) throws Exception {  
	        return ( ProcessInfo)request.getSession().getAttribute("proInfo");  
	    }  
	       
	    class ProcessInfo{  
	        public long totalSize = 1;  
	        public long readSize = 0;  
	        public String show = "";  
	        public int itemNum = 0;  
	        public int rate = 0;  
	    }  */
	       

}
