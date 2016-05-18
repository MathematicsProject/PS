package spring.project.convert;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.wolfram.jlink.*;

@Controller
public class MathematicaConvert {
	private String equation;

	public MathematicaConvert() {

	}

	public String getEquation() {
		return equation;
	}

	public void setEquation(String equation) {
		this.equation = equation;
	}

	
	public String calcMathematica() {
		KernelLink ml = null;
		String expr;
		try {
			ml = MathLinkFactory.createKernelLink("-linkmode launch -linkname '/opt/Wolfram/WolframEngine/10.3/Executables/MathKernel'");
			ml.discardAnswer();
			expr = ml.evaluateToOutputForm("Sum[k^2, {k,1,11}]", 0); // sample
			ml.close();
			//
			return expr; 
		} catch (MathLinkException e) {
			expr = "Fatal error opening link: " + e.getMessage();
			
			return expr;
		}
	}
}
