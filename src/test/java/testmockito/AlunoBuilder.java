package testmockito;

import edu.uepb.web.biblioteca.model.Aluno;
import edu.uepb.web.biblioteca.model.Curso;

public class AlunoBuilder {

	private int _id;
	private String _matricula;
	private String _rg;
	private String _cpf;
	private String _nome;
	private String _nomeMae;
	private String _naturalidade;
	private String _endereco;
	private String _telefone;
	private Curso _curso;
	private String _ano;
	private String _periodoIngresso;
	private String _email;
	private String _senha;

	public AlunoBuilder(String _matricula, String _rg, String _cpf, String _nome, String _nomeMae, String _naturalidade,
			String _endereco, String _telefone, Curso _curso, String _ano, String _periodoIngresso, String _email,
			String _senha) {
		super();
		this._matricula = _matricula;
		this._rg = _rg;
		this._cpf = _cpf;
		this._nome = _nome;
		this._nomeMae = _nomeMae;
		this._naturalidade = _naturalidade;
		this._endereco = _endereco;
		this._telefone = _telefone;
		this._curso = _curso;
		this._ano = _ano;
		this._periodoIngresso = _periodoIngresso;
		this._email = _email;
		this._senha = _senha;
	}

	public Aluno build() {
		return new Aluno();
	}

	public AlunoBuilder() {
	}

	public AlunoBuilder gerarAlunoCompleto(String matricula, String rg, String cpf, String nome, String nomeMae,
			String naturalidade, String endereco, String telefone, Curso curso, String ano, String periodoIngresso,
			String email, String senha) {

		_matricula = matricula;
		_rg = rg;
		_cpf = cpf;
		_nome = nome;
		_nomeMae = nomeMae;
		_naturalidade = naturalidade;
		_endereco = endereco;
		_telefone = telefone;
		_curso = curso;
		_ano = ano;
		_periodoIngresso = periodoIngresso;
		_email = email;
		_senha = senha;

		return this;
	}
}
