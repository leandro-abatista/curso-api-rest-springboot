package br.com.cursoapirestsb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cursoapirestsb.model.Usuario;
import br.com.cursoapirestsb.repository.UsuarioRepository;

@RestController/*Arquitetura Restfull*/
@RequestMapping(value = "/usuario")/*isso aparece depois da porta 8080*/
public class UsuarioController {
	
	@Autowired/*Injeção de dependência CDI*/
	private UsuarioRepository usuarioRepository;
	
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
	
	/*Serviço Restfull - Passando parâmetros
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
		*/
	
	/*Serviço Restfull - relatório
	@RequestMapping(method = RequestMethod.GET, value = "/{codigo}/relatoriopdf", produces = "application/json")
	public ResponseEntity<Usuario> relatorio(@PathVariable (value = "codigo") Long codigo) {
		
		Optional<Usuario> usuario = usuarioRepository.findById(codigo);
		
		return new ResponseEntity(usuario.get(), HttpStatus.OK);
	}
	*/
	
	/*Serviço Restfull - passando dois ou mais parâmetros
	@RequestMapping(method = RequestMethod.GET, value = "/{codigo}/codigovenda/{venda}", produces = "application/json")
	public ResponseEntity<Usuario> relatorio(@PathVariable (value = "codigo") Long codigo,
											 @PathVariable (value = "codigovenda") Long codigovenda) {
		
		Optional<Usuario> usuario = usuarioRepository.findById(codigo);
		
		return new ResponseEntity(usuario.get(), HttpStatus.OK);
	}
	*/
	
	/*Serviço Restfull - consultando pelo código do usuario*/
	@RequestMapping(method = RequestMethod.GET, value = "/{codigo}", produces = "application/json")
	public ResponseEntity<Usuario> init(@PathVariable (value = "codigo") Long codigo) {
		
		Optional<Usuario> usuario = usuarioRepository.findById(codigo);
		
		return new ResponseEntity(usuario.get(), HttpStatus.OK);
	}
	
	/**
	 * Lista todos os usuários
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/", produces = "application/json")
	public ResponseEntity<List<Usuario>> listaUsers() {
		
		List<Usuario> list = (List<Usuario>) usuarioRepository.findAll();
		
		return new ResponseEntity<List<Usuario>>(list, HttpStatus.OK);
	}
	
	/**
	 * Cadastrando um usuário
	 * @param usuario
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/", produces = "application/json")
	public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario){
		
		Usuario usuarioCadastrar = usuarioRepository.save(usuario);
		
		return new ResponseEntity<Usuario>(usuarioCadastrar, HttpStatus.OK);
	}
	
	/**
	 * Atualizando um usuário
	 * @param codigo
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/atualizar/{codigo}", produces = "application/json")
	public ResponseEntity<Usuario> atualizarUsuario(@PathVariable ("codigo") Long codigo, @RequestBody Usuario usuario){
		
		return usuarioRepository.findById(codigo)
				.map(record -> {
					record.setLogin(usuario.getLogin());
					record.setSenha(usuario.getSenha());
					record.setNome(usuario.getNome());
					record.setCpf(usuario.getCpf());
					record.setTelefone(usuario.getTelefone());
					record.setEmail(usuario.getEmail());
					
					Usuario user = usuarioRepository.save(record);/*Esse save salva e atualiza*/
					
					return ResponseEntity.ok().body(user);
					
				}).orElse(ResponseEntity.notFound().build());
	}
	
	/**
	 * Atualizando um usuário
	 * @param codigo
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/", produces = "application/json")
	public ResponseEntity<Usuario> atualizarUser(@RequestBody Usuario usuario){
		
		Usuario usuarioAtualizar = usuarioRepository.save(usuario);
		
		return new ResponseEntity<Usuario>(usuarioAtualizar, HttpStatus.OK);
	}
	
	/**
	 * excluindo um usuário
	 * @param codigo
	 * @return
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/{codigo}", produces = "application/text")
	public ResponseEntity excluirUsuario(@PathVariable ("codigo") Long codigo){
		
		return usuarioRepository.findById(codigo)
				.map(record -> {
					
					usuarioRepository.deleteById(codigo);
					
					return ResponseEntity.ok().build();
					
				}).orElse(ResponseEntity.notFound().build());
		
	}
	
	/**
	 * excluindo um usuário
	 * @param codigo
	 * @return
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/excluir/{codigo}", produces = "application/text")
	public ResponseEntity excluirUser(@PathVariable ("codigo") Long codigo){
		
		usuarioRepository.deleteById(codigo);
		return ResponseEntity.ok().build();
		
	}
	
	/*se fosse uma venda
	@RequestMapping(method = RequestMethod.POST, value = "/vendausuario", produces = "application/json")
	public ResponseEntity<Usuario> cadastrarVenda(@RequestBody Usuario usuario){
		
		/*Aqui seria o processo de venda
		Usuario usuarioCadastrar = usuarioRepository.save(usuario);
		
		return new ResponseEntity<Usuario>(usuarioCadastrar, HttpStatus.OK);
	}
	*/
	
	
	
}
