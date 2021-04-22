package br.com.cursoapirestsb.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

@RestController/*Arquitetura Restfull*/
@RequestMapping(value = "/usuario")/*isso aparece depois da porta 8080*/
public class IndexController {
	
	/*Serviço Restfull
	@RequestMapping(method = RequestMethod.GET, value = "/", produces = "application/json")
	public ResponseEntity init() {
		
		return new ResponseEntity("Olá Rest Spring boot!!!!", HttpStatus.OK);
	}
	*/
	
	/*Serviço Restfull - Passando parâmetros*/
	@RequestMapping(method = RequestMethod.GET, value = "/", produces = "application/json")
	public ResponseEntity init(@RequestParam (value = "nome", required = true, defaultValue = "Nome não infomardo!") String nome,
								@RequestParam (value = "cpf", required = true, defaultValue = "000.000.000-00") String cpf) {
		
		System.out.println("Parâmetro sendo recebido = " + nome);
		return new ResponseEntity("Olá Rest Spring boot!!!!\n Seu nome é: " + nome + " CPF: " + cpf, HttpStatus.OK);
	}
}
