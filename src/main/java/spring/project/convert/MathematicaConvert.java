package spring.project.convert;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.wolfram.jlink.*;

@Controller
public class MathematicaConvert {

	public MathematicaConvert() {

	}

	public String calcMathematica(String equation) {
		KernelLink ml = null;
		String expr;
		try {
			ml = MathLinkFactory.createKernelLink("-linkmode launch -linkname '/opt/Wolfram/WolframEngine/10.3/Executables/MathKernel'");
			ml.discardAnswer();
			//expr = ml.evaluateToOutputForm("Sum[k^2, {k,1,11}]", 0); // sample
			expr = ml.evaluateToOutputForm(equation, 0);
			ml.close();
			//
			return expr; 
		} catch (MathLinkException e) {
			expr = "Fatal error opening link: " + e.getMessage();
			
			return expr;
		}
	}
}
