package spring.project.convert;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.stereotype.Controller;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

@Controller
public class TesseractExample {
	

	public TesseractExample() {
	}

	public String ocr(String PJpath, String imapath, String outputpath) {
		// File imageFile = new File("samples/phonetest6.png");
		OCR_prepocess Op = new OCR_prepocess();
		// �̹��� ��ó��
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String time = dateFormat.format(calendar.getTime()).toString();
		String n_photo_url = time + "_1.jpg";
		Op.OCR_prepocess(imapath, n_photo_url, outputpath);
		// String resizeimageFile =
		// ��ó���� �̹������� �� �־��ֱ�
		File resizeimageFile = new File(outputpath+n_photo_url); /////////
		Tesseract instance = Tesseract.getInstance(); // JNA Interface Mapping
		instance.setDatapath(PJpath); /////////
		instance.setLanguage("arial");
		// String x[]={"1x","2x","3x","4x"};

		// instance.setLanguage("o");
		// Tesseract1 instance = new Tesseract1(); // JNA Direct Mapping
		System.out.println(resizeimageFile.canRead());
		try {
			int i, j;
			char c;
			String result = instance.doOCR(resizeimageFile); // ó����
			String result2 = result; // �����
			 // System.out.print(result);
            //test4.jpg �߸�
            if (result.indexOf("0��")>=0){ 
            result2=result.replace("0��","");
            result2=result2.replace(result2,result2+"0 to ��"); }
            //test3.jpg x^2,3,4~�϶�
            if(result.indexOf("x2")>=0){
          	 result2=result2.replace("x2","x��");
            }
            if(result.indexOf("x3")>=0){
             	 result2=result2.replace("x3","x��");
             	if(result.indexOf("x2")>=0){
                 	 result2=result2.replace("x2","x��");
                   } }
            if(result.indexOf("x4")>=0){
            	 result2=result2.replace("x4","x��");
            	 if(result.indexOf("x3")>=0){
                 	 result2=result2.replace("x3","x��");
                 	if(result.indexOf("x2")>=0){
                     	 result2=result2.replace("x2","x��");
                       } } }
           for(i=5; i<100; i++){
            	if(result.indexOf("x"+i)>=0){
            		result2=result2.replace("x"+i,"x^"+i);
            	}  }
           //y^n������5
           if(result.indexOf("y2")>=0){
            	 result2=result2.replace("y2","y��");   }
              if(result.indexOf("y3")>=0){
               	 result2=result2.replace("y3","y��");
               	if(result.indexOf("y2"+2)>=0){
               	 result2=result2.replace("y2","y��"); }}
              if(result.indexOf("y4")>=0){
              	 result2=result2.replace("y4","y��");
              	if(result.indexOf("y3")>=0){
                  	 result2=result2.replace("y3","y��");
                  	if(result.indexOf("y2")>=0){
                  	 result2=result2.replace("y2","y��");
                  	                }}   }
              for(i=5; i<100; i++){
              	if(result.indexOf("y"+i)>=0){
              		result2=result2.replace("y"+i,"y^"+i);
              	} }
           //cos,sin,tan(n)�϶� �ڿ� �� �ٿ��ֱ�6
              for(i=1; i<100; i++){
              if(result.indexOf("sin"+i+"o")>=0){
               	 result2=result.replace("sin"+i+"o","sin"+i+"��");
                 }
               if(result.indexOf("cos"+i+"o")>=0){
                   	 result2=result2.replace("cos"+i+"o","cos"+i+"��");
                     }
               if(result.indexOf("tan"+i+"o")>=0){
                   	 result2=result2.replace("tan"+i+"o","tan"+i+"��");
                     }}
           //log7
              if(result.indexOf("log"+2)>=0){
                	 result2=result.replace("log"+2,"log"+"��");
                  }
              if(result.indexOf("log"+3)>=0){
             	 result2=result.replace("log"+3,"log"+"��");
               }
              if(result.indexOf("log"+4)>=0){
              	 result2=result2.replace("log"+4,"log"+"��");
                }
              if(result.indexOf("x/")>=0){
               	 result2=result2.replace("x/","��");
                 }          
              //16^x,5^x������8
              if(result.indexOf("16x")>=0){
                	 result2=result.replace("16x","16^x");
                  } 
              if(result.indexOf("5x")>=0){
             	 result2=result2.replace("5x","5^x");
               } 
              //n^2������9
              if(result.indexOf("n2")>=0){
             	 result2=result.replace("n2","n��");
               } 
              //rn=m
              if(result.indexOf("rn")>=0){
              	 result2=result2.replace("rn","m");
                } 
              //11��
              if (result.indexOf("0��")>=0){ 
                  result2=result2.replace("0��","");
                  result2=result2.replace(result2,result2+"0 to ��"+")��");
                  if(result.indexOf(")2")>=0){
                 	 result2=result2.replace(")2","");
                   }}
              if(result.indexOf("e.x")>=0){
               	 result2=result2.replace("e.x","e^-x");
                 } 
              //���ǹ�����
              if(result.indexOf(")2")>=0){
              	 result2=result2.replace(")2",")��");
                }
              if(result.indexOf("z2")>=0){
               	 result2=result2.replace("z2","z��");
                 }
              //!���丮��
              for(i=0; i<100; i++)
              if(result.indexOf(i+"l")>=0){
                	 result2=result2.replace(i+"l",i+"!");
                  }
              
           // test3.jpg
//            for(i=2; i<100; i++){ 
//           	if(result.indexOf("x"+i)>=0){
//               	 result2=result.replace("x"+i,"x^"+i);
//           	}}
            
//          //�����Ⱑ z�γ��ͼ� /�� ġȯ
//           if (result.indexOf("z")>=0){ 
//            	result= result.replace("z","/");}
//           //x���ִ� �����ĵ��� solve ���ֱ�
//             if(result.indexOf("x")>=0){
//            	 result2=result.replace("=","==");
//              	 result2=result.replace(result,"Solve"+"["+result2+","+"x"+"]"); 
//               }
//             //x^n�� ������ solve
//             for(i=2; i<100; i++){ 
//            	if(result.indexOf("x"+i)>=0){
//                	 result2=result.replace("x"+i,"x^"+i);
//                     result2=result2.replace("=","==");
//                  	 result2=result.replace(result,"Solve"+"["+result2+","+"x"+"]"); 
//            	    	}
//                 	}
//            //sinx �����ĵ� solve
//             if(result.indexOf("sinx")>=0){
//            	 result2=result.replace("=","==");
//              	 result2=result.replace(result,"Solve"+"["+result2+","+"sinx"+"]"); 
//               }
//             //cosx ������ solve
//             if(result.indexOf("cosx")>=0){
//            	 result2=result.replace("=","==");
//              	 result2=result.replace(result,"Solve"+"["+result2+","+"cosx"+"]"); 
//               }
//             //tanx ������ solve
//             if(result.indexOf("tanx")>=0){
//            	 result2=result.replace("=","==");
//              	 result2=result.replace(result,"Solve"+"["+result2+","+"tanx"+"]"); 
//               }
//             
//             //Integrate // dx��  //��������
//                 if(result.indexOf("Integrate")>=0){
//            	 result2=result.replace("Integrate","Integrate[");
//            	 if (result2.indexOf("dx")>=0){ //dx�� ������ dx�� ]�� ġȯ�ض�
//                 	result2= result2.replace("dx",","+"x"+"]");}
//            	//sin(x)�ϰ��
//                 if(result.indexOf("sin(x)")>=0){
//                	 result2=result2.replace("sin(x)","Sin[x]");
//                  	                }
//                //cos(x)�ϰ��
//                 if(result.indexOf("cos(x)")>=0){
//                	 result2=result2.replace("cos(x)","Cos[x]");
//                  	                }
//                 //tan(x)�ϰ��
//                 if(result.indexOf("tan(x)")>=0){
//                	 result2=result2.replace("tan(x)","Tan[x]");
//                  	                }
//            	 //���� ���� ���~
//            	  for(j=-100;j<100; j++){
//            		 for(i=-100;i<100; i++){
//            			 if(result2.indexOf("]"+"\n"+j)>=0 && result2.indexOf(i+"\n"+"Integrate")>=0)
//            			 { result2=result2.replace(i+"\n"+"Integrate","Integrate");
//                    	   result2=result2.replace("]"+"\n"+j,"]");
//                    	   result2=result2.replace(",x",","+"{x,"+j+","+i+"}");
//                    		 }
//                 	 	}
//            	 }
//            	 
//            	 
//             }
             //������ Integrate ��  ��  dx �������ڿ�
             //if(result.indexOf("^4")>=0){ 
           // 	 result2=result.replace("^4","4��");}//������ �׳��غ���
            // if(result.indexOf("Integrate")>=0){
            //	 result2=result.replace("Integrate","integrate[");  }
             
           //  for(i=0; i<100; i++){ // 1x~100x�ΰ͵� (1x)~(100x)�� ġȯ
           //  if(result.indexOf(i+"x")>=0){
           // 	 result2=result.replace(i+"x","("+i+"x)"); 
            // }
            // }
                     //��Ģã��

			// System.out.print(result2);
			return result2;
		} catch (TesseractException e) {
			return e.getMessage();
		}
	}
}
