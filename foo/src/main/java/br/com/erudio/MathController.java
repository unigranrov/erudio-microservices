package br.com.erudio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.com.util.MathUtil;
import br.com.erudio.exception.UnsuportedMathOperationException;

@RestController
public class MathController {
	
	//Fiz a injeção de dependencia aqui com @Autowired
	//Com isso, posso utilizar mathUtil sem precisar ficar instanciando na classe.
	//Na classe MathUtil, utilizei o @Component para que funcione a injeção de dependencia.
	//Importante, para que funcione corretamente, os pacotes precisam estar dentro da mesa raiz. /src
	@Autowired
	MathUtil mathUtil;

	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
			throws Exception {
		if (!mathUtil.isNumeric(numberOne) || !mathUtil.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Favor, informar apenas valores numericos");
		}
		Double sum = mathUtil.convertToDouble(numberOne) + mathUtil.convertToDouble(numberTwo);
		return sum;
	}

	@RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sub(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
			throws Exception {
		if (!mathUtil.isNumeric(numberOne) || !mathUtil.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Favor, informar apenas valores numericos");
		}
		Double sub = mathUtil.convertToDouble(numberOne) - mathUtil.convertToDouble(numberTwo);
		return sub;
	}

	@RequestMapping(value = "/mult/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double mult(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
			throws Exception {
		if (!mathUtil.isNumeric(numberOne) || !mathUtil.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Favor, informar apenas valores numericos");
		}
		Double mult = mathUtil.convertToDouble(numberOne) * mathUtil.convertToDouble(numberTwo);
		return mult;
	}

	@RequestMapping(value = "/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double div(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
			throws Exception {
		if (!mathUtil.isNumeric(numberOne) || !mathUtil.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Favor, informar apenas valores numericos");
		}
		Double div = mathUtil.convertToDouble(numberOne) / mathUtil.convertToDouble(numberTwo);
		return div;
	}

	@RequestMapping(value = "/med/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double med(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
			throws Exception {
		if (!mathUtil.isNumeric(numberOne) || !mathUtil.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Favor, informar apenas valores numericos");
		}
		Double result = null;
		int rule = 2;
		Double med = mathUtil.convertToDouble(numberOne) + mathUtil.convertToDouble(numberTwo);
		result = med / rule;
		return result;
	}

	@RequestMapping(value = "/squareRoot/{number}", method = RequestMethod.GET)
	public Double squareRoot(@PathVariable("number") String number) throws Exception {
		if (!mathUtil.isNumeric(number)) {
			throw new UnsuportedMathOperationException("Favor, informar apenas valores numericos");
		}
		Double source = Math.sqrt(mathUtil.convertToDouble(number));
		return source;
	}

	public Double testaConversao() {
		String valor = "64.00";

		if (!mathUtil.isNumeric(valor)) {
			Double valorConvertido = mathUtil.convertToDouble(valor);
				return valorConvertido;
		}
		throw new UnsuportedMathOperationException(valor + "Falhou");
	}

}
