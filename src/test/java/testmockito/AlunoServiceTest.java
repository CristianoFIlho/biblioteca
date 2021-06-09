package testmockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import edu.uepb.web.biblioteca.dao.AlunoDAOImpl;
import edu.uepb.web.biblioteca.dao.CursoDAOImpl;
import edu.uepb.web.biblioteca.enums.TipoFuncionario;
import edu.uepb.web.biblioteca.enums.TipoNivel;
import edu.uepb.web.biblioteca.exception.AutenticacaoException;
import edu.uepb.web.biblioteca.exception.ExistException;
import edu.uepb.web.biblioteca.model.Aluno;
import edu.uepb.web.biblioteca.model.Curso;
import edu.uepb.web.biblioteca.model.Funcionario;
import edu.uepb.web.biblioteca.service.AlunoService;

public class AlunoServiceTest {

	Aluno alunoMock;
	Funcionario funcionario1;
	AlunoService alunoService;
	AlunoDAOImpl alunoDaoMock;
	AlunoBuilder alunoBuilder;

	@BeforeEach
	void setup() {
		alunoBuilder = new AlunoBuilder();
		alunoMock = Mockito.mock(Aluno.class);
		alunoDaoMock = Mockito.mock(AlunoDAOImpl.class);
		alunoService = new AlunoService(alunoDaoMock);
	}

	@Test
	@DisplayName("Teste do ExistException no cadastro de alunos.")
	public void testarCadastrarAlunoExistException() throws AutenticacaoException, ExistException {

		CursoDAOImpl cursoDAO = new CursoDAOImpl();
		Curso curso1 = new Curso("Testes", TipoNivel.GRADUACAO, "exatas");
		cursoDAO.inserir(curso1);
		funcionario1 = new Funcionario("Cristiano", TipoFuncionario.OPERADOR, "5921", "1574", "Brasil", "Barra", "9073", "@email.com", "usuario", "senha");
		
		Mockito.when(alunoMock.getCurso()).thenReturn(curso1);
		Mockito.when(alunoMock.getNome()).thenReturn("Samir");
		Mockito.when(alunoMock.getNomeMae()).thenReturn("Samira");
		Mockito.when(alunoMock.getAno()).thenReturn("2020");
		Mockito.when(alunoMock.getMatricula()).thenReturn("12313");
		Mockito.when(alunoMock.getRg()).thenReturn("321654");
		Mockito.when(alunoMock.getCpf()).thenReturn("987654321");
		Mockito.when(alunoMock.getPeriodoIngresso()).thenReturn("2019");
		Mockito.when(alunoMock.getTelefone()).thenReturn("78676546126321");
		Mockito.when(alunoMock.getEndereco()).thenReturn("Pituba");
		Mockito.when(alunoMock.getEmail()).thenReturn("@teste.com");
		Mockito.when(alunoMock.getSenha()).thenReturn("askfu");

		Mockito.when(alunoDaoMock.isExiste(alunoMock)).thenReturn(true);

		Assertions.assertThrows(ExistException.class, () -> alunoService.cadastrarAluno(funcionario1, alunoMock));
	}

}
