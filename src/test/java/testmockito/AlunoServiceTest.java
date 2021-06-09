package testmockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import edu.uepb.web.biblioteca.dao.AlunoDAOImpl;
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
	
	@BeforeEach
	void setup() {
		alunoMock = Mockito.mock(Aluno.class);
		alunoDaoMock = Mockito.mock(AlunoDAOImpl.class);
		alunoService = new AlunoService(alunoDaoMock);
	}

	@Test
	@DisplayName("Teste do ExistException no cadastro de alunos.")
	public void testarCadastrarAlunoExistException() throws AutenticacaoException, ExistException {
		
		//aluno1 = new Aluno("", "435", "34331", "Lula", "Dina", "Brasil", "Sao Paulo", "9893434", null, "2016", "2", "dsenr", "senha");
		funcionario1 = new Funcionario("Cristiano", TipoFuncionario.OPERADOR, "5921", "1574", "Brasil", "Barra", "9073", "@email.com", "usuario", "senha");
		
		Mockito.when(alunoDaoMock.isExiste(alunoMock)).thenReturn(true);
		Mockito.when(alunoMock.getCurso()).thenReturn(new Curso("Testes", TipoNivel.GRADUACAO, "exatas"));
		Mockito.when(alunoMock.getAno()).thenReturn("2020");
		
		Assertions.assertThrows(ExistException.class, () -> alunoService.cadastrarAluno(funcionario1, alunoMock));
	}

}
