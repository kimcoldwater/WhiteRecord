package cs.projects.whiterecord.util;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


@Component
public class FileUtils {
	private static final String filePath = "C:\\mp\\whiteRecordImg\\"; // 파일이 메인 위치
	
	  public String uploadImg(MultipartHttpServletRequest mpRequest) throws Exception {
			   MultipartFile multipartFile = null;
			   String originalFileName = null;
			   String originalFileExtension = null;
			   String storedFileName = null;

			   File file = new File("C:\\mp\\tempImg\\"); //임시파일 위치
			   if (!file.exists()) {
				  file.mkdirs();
				      }
			     
			   multipartFile = mpRequest.getFile("upload");
			     
			   originalFileName = multipartFile.getOriginalFilename();
			   originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
			  storedFileName = String.valueOf(getRandomString()) + originalFileExtension;
			   file = new File("C:\\mp\\tempImg\\" + storedFileName);
			   multipartFile.transferTo(file);
			   
			   String imgPath = "/img/" + storedFileName;
			     
			
			 return imgPath;
			 }
	
	  public String memberImg(MultipartHttpServletRequest mpRequest) throws Exception {
		   MultipartFile multipartFile = null;
		   String originalFileName = null;
		   String originalFileExtension = null;
		   String storedFileName = null;

		   File file = new File(filePath);
		   if (!file.exists()) {
			  file.mkdirs();
			      }
		     
		   multipartFile = mpRequest.getFile("mimg");
		   originalFileName = multipartFile.getOriginalFilename();
		   originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
		  storedFileName = String.valueOf(getRandomString()) + originalFileExtension;
		   file = new File(filePath + storedFileName);
		   multipartFile.transferTo(file);
		   
		   String imgPath = "/image/" + storedFileName;
		     
		
		 return imgPath;
		 }
	  
	  
	  		public String moveImg(String content)throws Exception{
	  			
	  			 Pattern nonValidPattern = Pattern
	 			  		.compile("(?i)< *[IMG][^\\>]*[src] *= *[\"\']{0,1}([^\"\'\\ >]*)");
	 			  		Matcher matcher = nonValidPattern.matcher(content);
	 			  		String img = "";
	 			  		while (matcher.find()) {
	 			  			img = matcher.group(1);
	 			  			img = img.replace("/img", "");
	 			  			content = content.replace("/img", "/image");
	 			  			File file =new File("C:\\mp\\tempImg\\"+img);
	 			  			file.renameTo(new File(filePath+img));
	 			  			
	 			  		    }
	 			  		return content;
	 		}
	  		
	
	
	
	public static String getRandomString() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}