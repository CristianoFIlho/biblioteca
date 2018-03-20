package edu.uepb.web.biblioteca.model;

import java.util.List;

import edu.uepb.web.biblioteca.enums.TipoTrabalhoConclusao;

/**
 * @autor geovanniovinhas <vinhasgeovannio@gmail.com
 *
 *
 */
public class TrabalhoConclusao implements Item {

	private int id;
	private String titulo;
	private Autor autor;
	private TipoTrabalhoConclusao tipo;
	private List<Orientador> listaorientadores;
	private String anoDefesa;
	private String local;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public TipoTrabalhoConclusao getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = TipoTrabalhoConclusao.valueOf(tipo);
	}

	public List<Orientador> getListaorientadores() {
		return listaorientadores;
	}

	public void setListaorientadores(List<Orientador> listaorientadores) {
		this.listaorientadores = listaorientadores;
	}

	public String getAnoDefesa() {
		return anoDefesa;
	}

	public void setAnoDefesa(String anoDefesa) {
		this.anoDefesa = anoDefesa;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}
}
