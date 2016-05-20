package spring.project.convert;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;

import java.util.Calendar;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;



public class writeFile {
	public String writeFile(String file, String savePath, int n_num, int i) throws Exception {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String time = dateFormat.format(calendar.getTime()).toString();
        String n_photo_url = n_num + "_" + i +"_"+ time+".jpg"; //�����̸�
       
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(savePath + n_photo_url/*����������*/));
        bos.write(Base64.decode(file)); //file�� �ȵ���̵忡�� ���� ���� �̹��� String
        bos.flush();
        bos.close();
        return n_photo_url; //��ο� ���� �̸� ��ȯ. ��δ� savePath + n_photo_url
    }
}
