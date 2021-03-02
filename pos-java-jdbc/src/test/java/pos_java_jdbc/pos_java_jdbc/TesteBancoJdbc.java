package pos_java_jdbc.pos_java_jdbc;

//import java.awt.List;

import java.sql.SQLException;

import java.util.List;

import org.junit.Test;

import dao.UserPosDAO;
import model.Telefone;
import model.Userposjava;

//New project -> Maven project ->||  Junit == Maven
/*<dependency>
<groupId>junit</groupId>
<artifactId>junit</artifactId>
<version>4.13</version>
<scope>test</scope>
</dependency>*/

public class TesteBancoJdbc {
//@test serve para testar o codigo atraveis do Junit 
	@Test
	public void initBanco() throws SQLException {
		UserPosDAO userPosDAO = new UserPosDAO();
		Userposjava userposjava = new Userposjava();

		userposjava.setNome("Giovanna");
		userposjava.setEmail("Giovanna@gmail.com");

		userPosDAO.salvar(userposjava);
	}

	@Test
	public void initListar() {
		UserPosDAO dao = new UserPosDAO();
		try {
			List<Userposjava> list = dao.listar();

			for (Userposjava userposjava : list) {
				System.out.println(userposjava);
				System.out.println("-------------------------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void initbuscar() {

		UserPosDAO dao = new UserPosDAO();

		try {
			Userposjava userposjava = dao.buscar(6L);

			System.out.println(userposjava);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void initAtualizar() { // metodo princial que chama o metedo atualizar na classe UserPosDAO
		try {

			UserPosDAO dao = new UserPosDAO();

			Userposjava objetoBanco = dao.buscar(5L);

			objetoBanco.setNome("Nome mudado com metodo atualizar");

			dao.atualizar(objetoBanco);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void initdeletar() { // metodo deletar

		try {
			UserPosDAO dao = new UserPosDAO(); // estanciando a clase "UserPosDAO"
			dao.deletar(1L); // Linha da tabela
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testeInsertTelefone() {
		Telefone telefone = new Telefone();
		telefone.setNumero("(11) 45454-4545");
		telefone.setTipo("casa1");
		telefone.setUsuario(3L);

		UserPosDAO dao = new UserPosDAO();
		dao.salvarTelefone(telefone);
	}

	@Test
	//JUnit é um framework que facilita o desenvolvimento e execução de testes unitários em código Java.
	public void testeDeleteUserFone() {

		UserPosDAO dao = new UserPosDAO();
		dao.deleteFonesPorUser(3L);

	}
}
