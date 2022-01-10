package cs.projects.whiterecord.util;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


@Component
public class FileUtils {
	private static final String filePath = "C:\\mp\\whiteRecordImg\\"; // 파일이 저장될 위치
	
	  public String uploadImg(MultipartHttpServletRequest mpRequest) throws Exception {
			   MultipartFile multipartFile = null;
			   String originalFileName = null;
			   String originalFileExtension = null;
			   String storedFileName = null;
			     
			     
			     
			     
			   File file = new File("C:\\mp\\whiteRecordImg\\");
			   if (!file.exists()) {
				  file.mkdirs();
				      }
			     
			   multipartFile = mpRequest.getFile("upload");
			     
			   originalFileName = multipartFile.getOriginalFilename();
			   originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
			  storedFileName = String.valueOf(getRandomString()) + originalFileExtension;
			   file = new File("C:\\mp\\whiteRecordImg\\" + storedFileName);
			   multipartFile.transferTo(file);
			   
			   String imgPath = "/img/" + storedFileName;
			     
			
			 return imgPath;
			 }
	
	
	
	
	
	public static String getRandomString() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}