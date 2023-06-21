package br.edu.ifms.p1.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifms.p1.dao.util.Conexao;
import br.edu.ifms.p1.model.Cachorro;


public class CachorroDAO {
	
	private Connection connection;
	
	private void conectar() throws SQLException {
		if (connection == null || connection.isClosed()) {
			connection = Conexao.getConexao();
		}
	}

	private void desconectar() throws SQLException {
		if (connection != null && !connection.isClosed()) {
			connection.close();
		}
	}
		
	public Cachorro inserirCachorro(Cachorro cachorro) throws SQLException {
		String sql = "INSERT INTO Cachorro (raca, tamanho, idade)"
				+ " VALUES (?, ?, ?)";		    
		
		conectar();

		PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, cachorro.getRaca());
		statement.setInt(2, cachorro.getTamanho());
		statement.setInt(3, cachorro.getIdade());
		
		statement.executeUpdate();
		
		ResultSet resultSet = statement.getGeneratedKeys();
		long id = 0;
		if(resultSet.next())
			id = resultSet.getInt("id");
		statement.close();

		desconectar();

		cachorro.setId(id);
		return cachorro;
	}
	
	public List<Cachorro> listarTodosCachorros() throws SQLException {
		
		String sql = "SELECT * FROM Cachorro";

		conectar();		
		List<Cachorro> listaCachorros = new ArrayList<Cachorro>();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);			

		while (resultSet.next()) {
			long id = resultSet.getLong("id");
			String raca = resultSet.getString("raca");
			int tamanho = resultSet.getInt("tamanho"); 
			int idade = resultSet.getInt("idade");
			
			Cachorro cachorro = new Cachorro(raca, tamanho, idade);
			cachorro.setId(id);
			listaCachorros.add(cachorro);
		}
		resultSet.close();
		statement.close();
		desconectar();
		return listaCachorros;
	}

	public void deletarCachorro(long id) throws SQLException {
		String sql = "DELETE FROM Cachorro where id = ?";

		conectar();

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, id);

		statement.executeUpdate();
		statement.close();
		desconectar();
	}

	public void atualizarCachorro(Cachorro cachorro) throws SQLException {
		String sql = "UPDATE Cachorro SET raca = ?, tamanho = ?, idade = ? WHERE id = ?";

		conectar();

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, cachorro.getRaca());
		statement.setInt(2, cachorro.getTamanho());
		statement.setInt(3, cachorro.getIdade());
		statement.setLong(4, cachorro.getId());

		statement.executeUpdate();
		statement.close();
		desconectar();
	}

	public Cachorro buscarPorId(long id) throws SQLException {
		String sql = "SELECT * FROM Cachorro WHERE id = ?";

		conectar();

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, id);

		ResultSet resultSet = statement.executeQuery();

		Cachorro cachorro = null;

		if (resultSet.next()) {
			String raca = resultSet.getString("raca");
			int tamanho = resultSet.getInt("tamanho");
			int idade = resultSet.getInt("idade");

			cachorro = new Cachorro(raca, tamanho, idade);
			cachorro.setId(id);
		}

		resultSet.close();
		statement.close();

		desconectar();

		return cachorro;
	}

}

