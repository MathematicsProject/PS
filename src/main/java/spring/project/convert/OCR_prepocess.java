package spring.project.convert;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

import org.springframework.stereotype.Controller;


@Controller
public class OCR_prepocess
{
	
	public void OCR_prepocess(String input, String output, String outputpath){
	{	//¿Œ«≤, æ∆øÙ«≤ 
		//String[] args1 = {"-binarize", "phonetest5.jpg","bitest5","-start" }; /////////input output
		String[] args1 = {"-binarize", input, output,"-start" };
		if(args1.length == 0)
		{
			System.out.println("Not enough parameters");
			return;
		}
		
		
		if(args1[0].equals("-binarize"))
		{
			System.out.println("Otsu binarization selected");
			String inputFile = "";
			String outputPrefix = "";
			int granularity_start = -1, granularity_end = -1; 
			for(int i=1; i < args1.length; i++)
			{
				if(args1[i].charAt(0) != '-')
				{
					if(inputFile.equals("")){ inputFile = args1[i]; continue; }
					if(outputPrefix.equals("")){ outputPrefix = args1[i]; continue; }
				}
				else
				{
					if(args1[i].equals("-start") && i+1<args1.length)
					{
						granularity_start = new Integer(args1[i+1]);
						i++;
						continue; 
					}
					if(args1[i].equals("-end") && i+1<args1.length)
					{
						granularity_end = new Integer(args1[i+1]);
						i++;
						continue;
					}
				}
				System.out.println("Unknown parameter: " + args1[i]);
			}
			if(inputFile.equals("")){ inputFile = "image.jpg"; }
			if(outputPrefix.equals("")){ outputPrefix = "out_"; }
			if(granularity_start < 1){ granularity_start = 1; }
			if(granularity_end <= granularity_start){ granularity_end = granularity_start + 1; }
			OtsuTreshouter.exec(inputFile, outputPrefix, granularity_start, granularity_end, outputpath);
			}
		
		}
	}
}
