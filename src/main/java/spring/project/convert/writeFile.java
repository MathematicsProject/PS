package spring.project.convert;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;

import java.util.Calendar;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;



public class writeFile {
	public String writeFile(String file, String savePath) throws Exception {
	      Calendar calendar = Calendar.getInstance();
	      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	      String time = dateFormat.format(calendar.getTime()).toString();
	      String n_photo_url = time+".jpg";
	      BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(savePath + n_photo_url));
	      bos.write(Base64.decode(file));
	      bos.flush();
	      bos.close();
	      return n_photo_url;
	   }
	
	public String writeFile2(String file, String savePath) throws Exception {
//        Calendar calendar = Calendar.getInstance();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
//        String time = dateFormat.format(calendar.getTime()).toString();
        String n_photo_url = savePath; //파일이름
//       
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(savePath /*파일저장경로*/));
        bos.write(Base64.decode(file)); //file이 안드로이드에서 보낸 파일 이미지 String
        bos.flush();
        bos.close();
        return n_photo_url; //경로에 사진 이름 반환. 경로는 savePath + n_photo_url
    }
}
