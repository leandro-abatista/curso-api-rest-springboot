package br.com.cursoapirestsb.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/usuario")/*isso aparece depois da porta 8080*/
public class IndexController {

	@RequestMapping(method = RequestMethod.GET, value = "/", produces = "application/json")
	public ResponseEntity init() {
		
		return new ResponseEntity("Olá Rest Spring boot!!!!", HttpStatus.OK);
	}
}
