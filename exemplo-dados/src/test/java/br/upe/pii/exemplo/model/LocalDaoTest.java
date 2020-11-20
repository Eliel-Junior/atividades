package br.upe.pii.exemplo.model;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class LocalDaoTest {
	
	@Autowired
	private ILocalDAO dao;
	
	@Test
	public void testeIncluirComSucesso() {
		final Long existentes = dao.count();
		
		Local sala = new Local("Sala", "Cantinho perto da janela");
		Local jardim = new Local("Jardim", "Quintal");
		Local parque = new Local("Parque", "Parque");

		
		dao.saveAll(Arrays.asList(sala, jardim, parque));
		
		final List<Local> locaisInseridos = (List<Local>) dao.findAll();
		
		Long novaQuantidade = existentes + 3;
		
		assertThat(locaisInseridos.size(), is(equalTo(novaQuantidade)));
	}

	

}
