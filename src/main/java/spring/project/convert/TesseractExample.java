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
		// 이미지 전처리
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String time = dateFormat.format(calendar.getTime()).toString();
		String n_photo_url = time + "_1.jpg";
		Op.OCR_prepocess(imapath, n_photo_url, outputpath);
		// String resizeimageFile =
		// 전처리된 이미지파일 값 넣어주기
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
			String result = instance.doOCR(resizeimageFile); // 처음값
			String result2 = result; // 결과값
			 // System.out.print(result);
            //test4.jpg 야매
            if (result.indexOf("0π")>=0){ 
            result2=result.replace("0π","");
            result2=result2.replace(result2,result2+"0 to π"); }
            //test3.jpg x^2,3,4~일때
            if(result.indexOf("x2")>=0){
          	 result2=result2.replace("x2","x²");
            }
            if(result.indexOf("x3")>=0){
             	 result2=result2.replace("x3","x³");
             	if(result.indexOf("x2")>=0){
                 	 result2=result2.replace("x2","x²");
                   } }
            if(result.indexOf("x4")>=0){
            	 result2=result2.replace("x4","x⁴");
            	 if(result.indexOf("x3")>=0){
                 	 result2=result2.replace("x3","x³");
                 	if(result.indexOf("x2")>=0){
                     	 result2=result2.replace("x2","x²");
                       } } }
           for(i=5; i<100; i++){
            	if(result.indexOf("x"+i)>=0){
            		result2=result2.replace("x"+i,"x^"+i);
            	}  }
           //y^n방정식5
           if(result.indexOf("y2")>=0){
            	 result2=result2.replace("y2","y²");   }
              if(result.indexOf("y3")>=0){
               	 result2=result2.replace("y3","y³");
               	if(result.indexOf("y2"+2)>=0){
               	 result2=result2.replace("y2","y²"); }}
              if(result.indexOf("y4")>=0){
              	 result2=result2.replace("y4","y⁴");
              	if(result.indexOf("y3")>=0){
                  	 result2=result2.replace("y3","y³");
                  	if(result.indexOf("y2")>=0){
                  	 result2=result2.replace("y2","y²");
                  	                }}   }
              for(i=5; i<100; i++){
              	if(result.indexOf("y"+i)>=0){
              		result2=result2.replace("y"+i,"y^"+i);
              	} }
           //cos,sin,tan(n)일때 뒤에 ˚ 붙여주기6
              for(i=1; i<100; i++){
              if(result.indexOf("sin"+i+"o")>=0){
               	 result2=result.replace("sin"+i+"o","sin"+i+"˚");
                 }
               if(result.indexOf("cos"+i+"o")>=0){
                   	 result2=result2.replace("cos"+i+"o","cos"+i+"˚");
                     }
               if(result.indexOf("tan"+i+"o")>=0){
                   	 result2=result2.replace("tan"+i+"o","tan"+i+"˚");
                     }}
           //log7
              if(result.indexOf("log"+2)>=0){
                	 result2=result.replace("log"+2,"log"+"₂");
                  }
              if(result.indexOf("log"+3)>=0){
             	 result2=result.replace("log"+3,"log"+"₃");
               }
              if(result.indexOf("log"+4)>=0){
              	 result2=result2.replace("log"+4,"log"+"₄");
                }
              if(result.indexOf("x/")>=0){
               	 result2=result2.replace("x/","√");
                 }          
              //16^x,5^x방정식8
              if(result.indexOf("16x")>=0){
                	 result2=result.replace("16x","16^x");
                  } 
              if(result.indexOf("5x")>=0){
             	 result2=result2.replace("5x","5^x");
               } 
              //n^2방정식9
              if(result.indexOf("n2")>=0){
             	 result2=result.replace("n2","n²");
               } 
              //rn=m
              if(result.indexOf("rn")>=0){
              	 result2=result2.replace("rn","m");
                } 
              //11번
              if (result.indexOf("0∞")>=0){ 
                  result2=result2.replace("0∞","");
                  result2=result2.replace(result2,result2+"0 to ∞"+")²");
                  if(result.indexOf(")2")>=0){
                 	 result2=result2.replace(")2","");
                   }}
              if(result.indexOf("e.x")>=0){
               	 result2=result2.replace("e.x","e^-x");
                 } 
              //구의방정식
              if(result.indexOf(")2")>=0){
              	 result2=result2.replace(")2",")²");
                }
              if(result.indexOf("z2")>=0){
               	 result2=result2.replace("z2","z²");
                 }
              //!팩토리얼
              for(i=0; i<100; i++)
              if(result.indexOf(i+"l")>=0){
                	 result2=result2.replace(i+"l",i+"!");
                  }
              
           // test3.jpg
//            for(i=2; i<100; i++){ 
//           	if(result.indexOf("x"+i)>=0){
//               	 result2=result.replace("x"+i,"x^"+i);
//           	}}
            
//          //나누기가 z로나와서 /로 치환
//           if (result.indexOf("z")>=0){ 
//            	result= result.replace("z","/");}
//           //x가있는 방정식들을 solve 해주기
//             if(result.indexOf("x")>=0){
//            	 result2=result.replace("=","==");
//              	 result2=result.replace(result,"Solve"+"["+result2+","+"x"+"]"); 
//               }
//             //x^n인 방정식 solve
//             for(i=2; i<100; i++){ 
//            	if(result.indexOf("x"+i)>=0){
//                	 result2=result.replace("x"+i,"x^"+i);
//                     result2=result2.replace("=","==");
//                  	 result2=result.replace(result,"Solve"+"["+result2+","+"x"+"]"); 
//            	    	}
//                 	}
//            //sinx 방적식들 solve
//             if(result.indexOf("sinx")>=0){
//            	 result2=result.replace("=","==");
//              	 result2=result.replace(result,"Solve"+"["+result2+","+"sinx"+"]"); 
//               }
//             //cosx 방정식 solve
//             if(result.indexOf("cosx")>=0){
//            	 result2=result.replace("=","==");
//              	 result2=result.replace(result,"Solve"+"["+result2+","+"cosx"+"]"); 
//               }
//             //tanx 방정식 solve
//             if(result.indexOf("tanx")>=0){
//            	 result2=result.replace("=","==");
//              	 result2=result.replace(result,"Solve"+"["+result2+","+"tanx"+"]"); 
//               }
//             
//             //Integrate // dx로  //범위포함
//                 if(result.indexOf("Integrate")>=0){
//            	 result2=result.replace("Integrate","Integrate[");
//            	 if (result2.indexOf("dx")>=0){ //dx가 있으면 dx를 ]로 치환해라
//                 	result2= result2.replace("dx",","+"x"+"]");}
//            	//sin(x)일경우
//                 if(result.indexOf("sin(x)")>=0){
//                	 result2=result2.replace("sin(x)","Sin[x]");
//                  	                }
//                //cos(x)일경우
//                 if(result.indexOf("cos(x)")>=0){
//                	 result2=result2.replace("cos(x)","Cos[x]");
//                  	                }
//                 //tan(x)일경우
//                 if(result.indexOf("tan(x)")>=0){
//                	 result2=result2.replace("tan(x)","Tan[x]");
//                  	                }
//            	 //범위 있을 경우~
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
             //범위는 Integrate 앞  과  dx 마지막뒤에
             //if(result.indexOf("^4")>=0){ 
           // 	 result2=result.replace("^4","4승");}//지수승 그냥해본거
            // if(result.indexOf("Integrate")>=0){
            //	 result2=result.replace("Integrate","integrate[");  }
             
           //  for(i=0; i<100; i++){ // 1x~100x인것들 (1x)~(100x)로 치환
           //  if(result.indexOf(i+"x")>=0){
           // 	 result2=result.replace(i+"x","("+i+"x)"); 
            // }
            // }
                     //규칙찾기

			// System.out.print(result2);
			return result2;
		} catch (TesseractException e) {
			return e.getMessage();
		}
	}
}
