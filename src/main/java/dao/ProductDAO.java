package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.ConnectionMySQL;
import model.Product;

public class ProductDAO {
	public boolean insertProduct(Product product) {
		 {
				
				Connection connection = ConnectionMySQL.init_connection();
				PreparedStatement stmt = null;
				try {
					stmt = connection.prepareStatement("INSERT INTO `senai`.`product` (`name`, `quantidade`, `valor`, `linkimg`) VALUES (?, ?, ?, ?)");
					stmt.setString(1, product.getName());
					stmt.setInt(2, product.getQuantidade());
					stmt.setDouble(3, product.getValor());
					stmt.setString(4, product.getLinkImg());
					stmt.executeUpdate();
					return true;
				} catch (SQLException e) {
					System.out.println();
					e.printStackTrace();

				} finally {
					ConnectionMySQL.stopConnection(connection, stmt);
				}
				return false;
			}
	}
	public Product searchForId(int id){
		Connection connection = ConnectionMySQL.init_connection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Product product = new Product();
		try {
			stmt = connection.prepareStatement("SELECT * FROM `senai`.`product` WHERE idproduct=?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if(rs.next()) {
			product.setIdProduto(id);
			product.setName(rs.getString("name"));
			product.setValor(rs.getDouble("valor"));
			product.setQuantidade(rs.getInt("quantidade"));
			product.setLinkImg(rs.getString("linkimg"));
			}
			return product;
		} catch (SQLException e) {
			System.out.println();
			e.printStackTrace();
			return product;
			
		} finally {
			ConnectionMySQL.stopConnection(connection, stmt);
		}
	}
	
	public boolean updateProduct(Product product) {
		Connection connection = ConnectionMySQL.init_connection();
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("UPDATE `senai`.`product` SET `name` = ?, `quantidade` = ?, `valor` = ? , `linkimg` = ? WHERE (`idproduct` = ?)");
            stmt.setString(1, product.getName());
            stmt.setInt(2, product.getQuantidade());
            stmt.setDouble(3, product.getValor());
            stmt.setString(4, product.getLinkImg());
            stmt.setInt(5, product.getIdProduto());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            ConnectionMySQL.stopConnection(connection, stmt);
        }
    }
	public boolean deleteProduct(int id) {
		Connection connection = ConnectionMySQL.init_connection();
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("DELETE FROM `senai`.`product` WHERE (`idproduct` = ?)");
            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            ConnectionMySQL.stopConnection(connection, stmt);
        }
	}

	 public ArrayList<Product> readProducts() {
	        Connection connection = ConnectionMySQL.init_connection();
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        ArrayList<Product> products = new ArrayList<Product>();
	        try {
	            stmt = connection.prepareStatement("SELECT * FROM senai.product");
	            rs = stmt.executeQuery();

	            while (rs.next()) {
	            	Product product = new Product();
	            	product.setIdProduto(rs.getInt("idproduct"));
	            	product.setName(rs.getString("name"));
	    			product.setValor(rs.getDouble("valor"));
	    			product.setQuantidade(rs.getInt("quantidade"));
	    			product.setLinkImg(rs.getString("linkimg"));
	    			products.add(product);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            ConnectionMySQL.stopConnection(connection, stmt, rs);
	        }

	        return products;
	    }
}
