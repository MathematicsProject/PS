package spring.project.convert;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Controller;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import com.wolfram.jlink.KernelLink;
import com.wolfram.jlink.MathLinkException;
import com.wolfram.jlink.MathLinkFactory;

@Controller
public class MathematicaConvert {
	private String expr,encoded,encoded2,equation;
	private byte[] img, img2;
	private BufferedImage im, im2;
	public MathematicaConvert() {

	}
	public void setequation(String equation)
	{
		this.equation = equation;
	}
	public String getexpr()
	{
		return expr;
	}
	public String getencoded()
	{
		return encoded;
	}
	public String getencoded2()
	{
		return encoded2;
	}
	
	public void calcMathematica() {
		KernelLink ml = null;
		
		try {
			ml = MathLinkFactory.createKernelLink(
					"-linkmode launch -linkname '/opt/Wolfram/WolframEngine/10.3/Executables/MathKernel'");
			ml.discardAnswer();
			// expr = ml.evaluateToOutputForm("Sum[k^2, {k,1,11}]", 0); //
			// sample
			expr = ml.evaluateToOutputForm(equation, 0);

			ml.evaluateToOutputForm("$DefaultImageFormat = \"JPEG\"", 0);

			byte[] img = ml.evaluateToImage("Integrate[Cos[x]^4, x]", 200, 200);
			java.awt.Image im = java.awt.Toolkit.getDefaultToolkit().createImage(img);

			encoded=Base64.encode(img);
			//String encodedString = new String(encoded);

			byte[] img2 = ml.evaluateToImage("Plot[Evaluate[Integrate[Cos[x]^4, x], {x,-14,14}]]", 200, 200);
			java.awt.Image im2 = java.awt.Toolkit.getDefaultToolkit().createImage(img2);

			encoded2=Base64.encode(img2);
			//String encodedString2 = new String(encoded2);

			ml.close();
			//
			//return expr;
		} catch (MathLinkException e) {
			expr = "Fatal error opening link: " + e.getMessage();

			//return expr;
		}
	}
}
