package br.com.conexaobanco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.conexaobanco.ConexaoMySQL;

public class ConexaoMySQL {
	public static Connection getConexaoMySQL() {
		try {
			String driverName = "com.mysql.jdbc.Driver";
			Class.forName(driverName);
			String serverName = "localhost";
			String mydatabase = "";
			String url = "jdbc:mysql://" + serverName + ":3306/" + mydatabase;
			String username = "";
			String password = "";
			Connection connection = DriverManager.getConnection(url, username,
					password);
			return connection;
		} catch (ClassNotFoundException e) {
			System.out.println("O driver expecificado nao foi encontrado.");
			return null;
		} catch (SQLException e) {
			System.out.println("Nao foi possivel conectar ao Banco de Dados.");
			return null;
		}
	}

	public static void main(String arg[]) {
		DadosMySQL dadosMySQL = new DadosMySQL();
		String insert = "", update = "", delete = "", deseja = "s";

		insert = JOptionPane
				.showInputDialog("Você deseja fazer um Insert: (S/N)");

		if (insert.equals("S") || insert.equals("s")) {
			do {
				dadosMySQL.Insert();
				dadosMySQL.Select();

				deseja = JOptionPane
						.showInputDialog("Você deseja continuar: (S/N)");
			} while (deseja.equals("S") || deseja.equals("s"));
		}

		update = JOptionPane
				.showInputDialog("Você deseja fazer um Update: (S/N)");

		if (update.equals("S") || update.equals("s")) {
			do {
				dadosMySQL.Update();
				dadosMySQL.Select();

				deseja = JOptionPane
						.showInputDialog("Você deseja continuar: (S/N)");
			} while (deseja.equals("S") || deseja.equals("s"));
		}

		delete = JOptionPane
				.showInputDialog("Você deseja fazer um Delete: (S/N)");
		if (delete.equals("S") || delete.equals("s")) {
			do {
				dadosMySQL.Delete();
				dadosMySQL.Select();

				deseja = JOptionPane
						.showInputDialog("Você deseja continuar: (S/N)");
			} while (deseja.equals("S") || deseja.equals("s"));
		}
	}
}
