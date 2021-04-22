package br.com.cursoapirestsb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

import br.com.cursoapirestsb.model.Usuario;

@RestController/*Arquitetura Restfull*/
@RequestMapping(value = "/usuario")/*isso aparece depois da porta 8080*/
public class IndexController {
	
	/*Serviço Restfull
	@RequestMapping(method = RequestMethod.GET, value = "/", produces = "application/json")
	public ResponseEntity init() {
		
		return new ResponseEntity("Olá Rest Spring boot!!!!", HttpStatus.OK);
	}
	*/
	
	/*Serviço Restfull - Passando parâmetros
	@RequestMapping(method = RequestMethod.GET, value = "/", produces = "application/json")
	public ResponseEntity init(@RequestParam (value = "nome", required = true, defaultValue = "Nome não infomardo!") String nome,
								@RequestParam (value = "cpf", required = true, defaultValue = "000.000.000-00") String cpf) {
		
		System.out.println("Parâmetro sendo recebido = " + nome);
		return new ResponseEntity("Olá Rest Spring boot!!!!\n Seu nome é: " + nome + " CPF: " + cpf, HttpStatus.OK);
	}
	*/
	
	/*Serviço Restfull - Passando parâmetros*/
	@RequestMapping(method = RequestMethod.GET, value = "/", produces = "application/json")
	public ResponseEntity init() {
		
		Usuario usuario = new Usuario();
		usuario.setCodigo(1L);
		usuario.setLogin("leandro@gmail.com");
		usuario.setSenha("123");
		
		Usuario usuario1 = new Usuario();
		usuario1.setCodigo(2L);
		usuario1.setLogin("jose@gmail.com");
		usuario1.setSenha("456");
		
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(usuario);
		usuarios.add(usuario1);
		
		return new ResponseEntity(usuarios, HttpStatus.OK);
	}
}
