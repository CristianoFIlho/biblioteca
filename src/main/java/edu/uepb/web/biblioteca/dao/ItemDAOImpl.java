package edu.uepb.web.biblioteca.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.mysql.cj.jdbc.PreparedStatement;

import edu.uepb.web.biblioteca.exception.DAOException;
import edu.uepb.web.biblioteca.model.Item;

/**
 * @autor geovanniovinhas <vinhasgeovannio@gmail.com
 *
 */
public class ItemDAOImpl implements DAO<Item> {
	private static final int FAKE_ID = -1;
	private Item item;
	private Connection connection;
	private PreparedStatement statement;
	private ResultSet resultSet;
	
	private static Logger logger = Logger.getLogger(ItemDAOImpl.class);

	/**
	 * @throws DAOException
	 * @see {@link DAO#get(int)}
	 */
	@Override
	public Item get(int id) throws DAOException {
		logger.info("Executar o metodo 'get' do item" + id);
		connection = new Conexao().getConexao();
		String sql = "SELECT * FROM item WHERE item.id = ?";

		try {
			statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				item = new Item();
				item.setId(resultSet.getInt(1));
				item.setTipoItem(resultSet.getString(2));
				item.setIsbn(resultSet.getString(3));
				item.setTitulo(resultSet.getString(4));
				item.setTipoAnais(resultSet.getString(5));
				item.setTipoMidia(resultSet.getString(6));
				item.setTipoTrabalho(resultSet.getString(7));
				item.setAutor(resultSet.getString(8));
				item.setCongresso(resultSet.getString(9));
				item.setAnoPublicacao(resultSet.getString(10));
				item.setLocal(resultSet.getString(11));
				item.setEditora(resultSet.getString(12));
				item.setEdicao(resultSet.getString(13));
				item.setNumeroPagina(resultSet.getInt(14));
				item.setArea(resultSet.getString(15));
				item.setTema(resultSet.getString(16));
				item.setDataGravacao(resultSet.getString(17));
				item.setOrientador(resultSet.getString(18));
				item.setData(resultSet.getString(19));
			}
			statement.close();
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
		logger.info("O item foi selecionado: " + item);
		return item;
	}

	/**
	 * @throws DAOException
	 * @see {@link DAO#getLista()}
	 */
	@Override
	public List<Item> getLista() throws DAOException {
		logger.info("Executar o metodo 'getLista' do item");
		connection = new Conexao().getConexao();
		List<Item> listaAcervo = new ArrayList<>();
		String sql = "SELECT * FROM item";
		try {
			statement = (PreparedStatement) connection.prepareStatement(sql);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				item = new Item();
				item.setId(resultSet.getInt(1));
				item.setTipoItem(resultSet.getString(2));
				item.setIsbn(resultSet.getString(3));
				item.setTitulo(resultSet.getString(4));
				item.setTipoAnais(resultSet.getString(5));
				item.setTipoMidia(resultSet.getString(6));
				item.setTipoTrabalho(resultSet.getString(7));
				item.setAutor(resultSet.getString(8));
				item.setCongresso(resultSet.getString(9));
				item.setAnoPublicacao(resultSet.getString(10));
				item.setLocal(resultSet.getString(11));
				item.setEditora(resultSet.getString(12));
				item.setEdicao(resultSet.getString(13));
				item.setNumeroPagina(resultSet.getInt(14));
				item.setArea(resultSet.getString(15));
				item.setTema(resultSet.getString(16));
				item.setDataGravacao(resultSet.getString(17));
				item.setOrientador(resultSet.getString(18));
				item.setData(resultSet.getString(19));
				listaAcervo.add(item);
			}
			statement.close();
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
		logger.info("Pegar os itens: " + listaAcervo.toString());
		return listaAcervo;
	}

	/**
	 * @throws DAOException
	 * @see {@link DAO#inserir(Object)}
	 */
	@Override
	public int inserir(Item obj) throws DAOException {
		logger.info("Executar o metodo 'inserir' do item" + obj);
		int id = ItemDAOImpl.FAKE_ID;
		if (obj != null) {
			connection = new Conexao().getConexao();
			String sql = "INSERT INTO item" + "(tipo_item, isbn, titulo, tipo_anais, "
					+ "tipo_midia, tipo_trabalho_conclusao, autor, congresso, ano_publicacao, local, editora, "
					+ "edicao, numero_pagina, area, tema, data_gravacao, orientador, data) "
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			try {
				statement = (PreparedStatement) connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				statement.setString(1, obj.getTipoItem().name());
				statement.setString(2, obj.getIsbn());
				statement.setString(3, obj.getTitulo());
				statement.setString(4, obj.getTipoAnais().toString());
				statement.setString(5, obj.getTipoMidia().toString());
				statement.setString(6, obj.getTipoTrabalho().toString());
				statement.setString(7, obj.getAutor());
				statement.setString(8, obj.getCongresso());
				statement.setString(9, obj.getAnoPublicacao());
				statement.setString(10, obj.getLocal());
				statement.setString(11, obj.getEditora());
				statement.setString(12, obj.getEdicao());
				statement.setInt(13, obj.getNumeroPagina());
				statement.setString(14, obj.getArea());
				statement.setString(15, obj.getTema());
				statement.setString(16, obj.getDataGravacao());
				statement.setString(17, obj.getOrientador());
				statement.setString(18, obj.getData());

				statement.execute();
				resultSet = statement.getGeneratedKeys();

				if (resultSet.next()) {
					id = resultSet.getInt(1);
					obj.setId(id);
				}
				statement.close();
			} catch (SQLException e) {
				throw new DAOException(e.getMessage());
			}
		}
		logger.info("O item foi inserido: " + obj);
		return id;
	}

	/**
	 * @throws DAOException
	 * @see {@link DAO#remover(Object)}
	 */
	@Override
	public void remover(Item obj) throws DAOException {
		logger.info("Executar o metodo 'remover' do item" + obj);
		if (obj != null) {
			connection = new Conexao().getConexao();
			String sql = "DELETE FROM item WHERE item.id = ?";

			try {
				statement = (PreparedStatement) connection.prepareStatement(sql);
				statement.setInt(1, obj.getId());
				statement.execute();
				
				statement.close();
				logger.info("O item foi removido" + obj);
			} catch (SQLException e) {
				throw new DAOException(e.getMessage());
			}
		}
	}

	/**
	 * @throws DAOException
	 * @see {@link DAO#atualizar(Object)}
	 */
	@Override
	public void atualizar(Item obj) throws DAOException {
		logger.info("Executar metodo 'atualizar' do Item: " + obj);
		if (obj != null) {
			connection = new Conexao().getConexao();
			String sql = "UPDATE item SET tipo_item = ?, isbn = ?, titulo = ?, tipo_anais = ?, "
					+ "tipo_midia = ?, tipo_trabalho_conclusao = ?, autor = ?, congresso = ?, ano_publicacao = ?, local = ?, editora = ?, "
					+ "edicao = ?, numero_pagina = ?, area = ?, tema = ?, data_gravacao = ?, orientador = ? , data = ?"
					+ "WHERE id = ?";

			try {
				statement = (PreparedStatement) connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				statement.setString(1, obj.getTipoItem().name());
				statement.setString(2, obj.getIsbn());
				statement.setString(3, obj.getTitulo());
				statement.setString(4, obj.getTipoAnais().name());
				statement.setString(5, obj.getTipoMidia().name());
				statement.setString(6, obj.getTipoTrabalho().name());
				statement.setString(7, obj.getAutor());
				statement.setString(8, obj.getCongresso());
				statement.setString(9, obj.getAnoPublicacao());
				statement.setString(10, obj.getLocal());
				statement.setString(11, obj.getEditora());
				statement.setString(12, obj.getEdicao());
				statement.setInt(13, obj.getNumeroPagina());
				statement.setString(14, obj.getArea());
				statement.setString(15, obj.getTema());
				statement.setString(16, obj.getDataGravacao());
				statement.setString(17, obj.getOrientador());
				statement.setString(18, obj.getData());

				statement.setInt(19, obj.getId());

				statement.execute();
				
				connection.close();
				logger.info("O item foi atualizado: " + obj);
			} catch (SQLException e) {
				throw new DAOException(e.getMessage());
			}
		}
	}

	/**
	 * @throws DAOException
	 * @see {@link DAO#isExiste(Object)}
	 */
	@Override
	public boolean isExiste(Item obj) throws DAOException {
		logger.info("Executar metodo 'isExiste' do Item: " + obj);
		if (obj != null) {
			connection = new Conexao().getConexao();
			String sql = "SELECT * FROM item WHERE titulo = ?";

			try {
				statement = (PreparedStatement) connection.prepareStatement(sql);
				statement.setString(1, obj.getTitulo());
				resultSet = statement.executeQuery();

				if (resultSet.next()) {
					statement.close();
					logger.info("Esse item ja existe no banco: " + obj);
					return true;
				}
				statement.close();
				logger.info("Esse item nao existe no banco: " + obj);
				return false;
			} catch (SQLException e) {
				throw new DAOException(e.getMessage());
			}
		}
		logger.warn("O objeto item e invalido/null: " + obj);
		return false;
	}

}
