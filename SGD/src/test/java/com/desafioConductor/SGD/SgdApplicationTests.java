package com.desafioConductor.SGD;

import com.desafioConductor.SGD.Controllers.*;
import com.desafioConductor.SGD.Entities.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.List;

@RunWith(SpringRunner.class)
@SqlGroup({
	@Sql(
		executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD,
		scripts = "classpath:test-clean.sql"
	),
	@Sql(
			config=@SqlConfig(transactionMode = SqlConfig.TransactionMode.ISOLATED),
			scripts = "classpath:test-create-tables.sql"
	),
	@Sql(
			config=@SqlConfig(transactionMode = SqlConfig.TransactionMode.ISOLATED),
			scripts = "classpath:test-insert-data.sql"
	)
})
@SpringBootTest
public class SgdApplicationTests {

	@Autowired
	private ContatoController contatoController;

	@Autowired
	private GrupoInfoController grupoInfoController;

	@Autowired
	private CaixaController caixaController;

	@Autowired
	private TelefoneController telefoneController;

	@Autowired
	private GruposController gruposController;

	@Test
	public void test1() {
		Assert.assertEquals(contatoController.get().size(), 10);
	}

	@Test
	public void test2() {
		Assert.assertEquals(grupoInfoController.get().size(), 3);
	}

	@Test
	public void test3() {
		Assert.assertEquals(caixaController.get().size(), 27);
	}

	@Test
	public void test4() {
		Assert.assertEquals(telefoneController.get().size(), 11);
	}

	@Test
	public void test5() {
		Assert.assertEquals(gruposController.get().size(), 10);
	}

	@Test
	public void test6() {
		List<Contato> contatos = contatoController.findByParam( "Oswald", null, null, null);
		Assert.assertEquals(contatos.size(), 1);
	}

	@Test
	public void test7() {
		List<Contato> contatos = contatoController.findByParam( null, "10.11.282.676-54", null, null);
		Assert.assertEquals(contatos.size(), 1);
	}

	@Test
	public void test8() {
		List<Contato> contatos = contatoController.findByParam( null, null, 56, null);
		Assert.assertEquals(contatos.size(), 1);
	}

	@Test
	public void test9() {
		List<Contato> contatos = contatoController.findByParam( null, null, null, "RUA JOAQUIM BORBA FILHO");
		Assert.assertEquals(contatos.size(), 1);
	}

	@Test
	public void test10() {
		Contato novo = new Contato(null, "Felipe", "097.114.778-13", 31, "R SAO JOSE");
		Long id_atualizar = 1L;
		contatoController.update(id_atualizar, novo.getNome(), novo.getCpf(), novo.getIdade(), novo.getEndereco());
		Assert.assertEquals(contatoController.get(id_atualizar).getCpf(), novo.getCpf());
	}

	@Test
	public void test11() {
		GrupoInfo grupoInfo = new GrupoInfo(null, "Churrasco", "Amigos do churrasco");
		Long id_atualizar = 1L;
		grupoInfoController.update(id_atualizar, grupoInfo.getTitulo(), grupoInfo.getDescricao());
		Assert.assertEquals(grupoInfoController.get(id_atualizar).getDescricao(), grupoInfo.getDescricao());
	}

	@Test
	public void test12() {
		Long id_atualizar = 1L;
		Grupos grupos = new Grupos(null, 1L, 1L);
		gruposController.update(id_atualizar, grupos.getIdGrupo(), grupos.getIdContato());
		Assert.assertEquals(gruposController.get(id_atualizar).getIdContato(), grupos.getIdContato());
	}

	@Test
	public void test13() {
		Long id_atualizar = 1L;
		Caixa caixa = new Caixa(null, 1L, 100.0, Calendar.getInstance().getTime(), "Sapato", "Venda de sapato");
		caixaController.update(id_atualizar, caixa.getIdContato(), caixa.getValor(), caixa.getData(), caixa.getTitulo(), caixa.getDescricao());
		Assert.assertEquals(caixaController.get(id_atualizar).getIdContato(), caixa.getIdContato());
	}

	@Test
	public void test14() {
		Long id_atualizar = 1L;
		Telefone telefone = new Telefone(null, 1L, "5550225");
		telefoneController.update(id_atualizar, telefone.getIdContato(), telefone.getNumero());
		Assert.assertEquals(telefoneController.get(id_atualizar).getNumero(), telefone.getNumero());
	}

	@Test
	public void test15() {
		Long id_delete = 1L;
		contatoController.delete(id_delete);
		Assert.assertNull(contatoController.get(id_delete).getId());
		Assert.assertEquals(gruposController.getAllByUserId(id_delete).size(), 0);
		Assert.assertEquals(caixaController.getAllByUserId(id_delete).size(), 0);
		Assert.assertEquals(telefoneController.getAllByUserId(id_delete).size(), 0);
	}
}
