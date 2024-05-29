package br.com.erudio;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	
	private static final String template = "Palavra chave correta! ";
	private static final String templateDefault = "Olá, ";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/greeting")
	public Greeting greeting(
			@RequestParam
			(value ="name", defaultValue = "Word")String name) {
//		if (name.equals("")) {
//			return new Greeting(counter.incrementAndGet(), String.format(template, name));
//		}
		
		String nomeChave = "testeRequest";
		
		Map<String, String> nomeParam = new HashMap<>();
		nomeParam.put(name, template + name);
		
		
		return new Greeting(counter.incrementAndGet(),
				nomeParam.getOrDefault(nomeChave, templateDefault + name));
	}
	
}
