package br.com.cursoapirestsb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableAutoConfiguration/*o spring configura todo o projeto automaticamente*/
@RestController
@EnableWebMvc
@EnableTransactionManagement/*transações com o banco de dados*/
@EnableJpaRepositories(basePackages = {"br.com.cursoapirestsb.repository"})/*repositorio que interage com o banco de dados*/
@ComponentScan(basePackages = {"br.com.cursoapirestsb.*"})/*injeção de dependência do spring*/
@EntityScan(basePackages = {"br.com.cursoapirestsb.model"})/*pacote das classes de modelo*/
@SpringBootApplication/*Configuração padrão após o projeto ser criado*/
public class CursoApiRestSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursoApiRestSpringbootApplication.class, args);
	}

}
