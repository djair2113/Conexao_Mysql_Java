package eteczl.BancoDados;


import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Pessoa;
import persistence.Conexao;



/**
 
 *
 */
public class App {
    public static void main( String[] args ){
    	
    	Conexao fabricaDeConexao = new Conexao("localhost","3306","sala","root","");
    	Connection connection = fabricaDeConexao.getConnection();
    	
    	ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
    	
    	try {
    		PreparedStatement statementSql =  connection.prepareStatement("Select * from alunos");
			ResultSet rs = statementSql.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				
				Pessoa p = new Pessoa(nome);
				p.setId(id);
				pessoas.add(p);
			};
    	}catch (SQLException e) {
    		e.printStackTrace();
			}
    	for(Pessoa p : pessoas) {
    		System.out.print(p.getNome());
    	}
    	
       
    }
}
