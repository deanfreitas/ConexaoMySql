package br.com.conexaobanco;

import java.sql.*;

import javax.swing.JOptionPane;

public class DadosMySQL {

	private ConexaoMySQL conexaoMySQL;
	private Connection con = conexaoMySQL.getConexaoMySQL();

	public void Insert() {
		String nome, idade, rg, cpf, empresa, cnpj, data_do_aniversario, sexo, email, cnh;

		nome = JOptionPane.showInputDialog("Escreva seu nome: ");
		idade = JOptionPane.showInputDialog("Escreva sua idade: ");
		rg = JOptionPane.showInputDialog("Escreva seu RG: ");
		cpf = JOptionPane.showInputDialog("Escreva seu CPF: ");
		empresa = JOptionPane.showInputDialog("Escreva sua Empresa: ");
		cnpj = JOptionPane.showInputDialog("Escreva seu CNPJ: ");
		data_do_aniversario = JOptionPane
				.showInputDialog("Escreva sua Data do aniversario: ");
		sexo = JOptionPane.showInputDialog("Escreva seu Sexo: ");
		email = JOptionPane.showInputDialog("Escreva seu Email: ");
		cnh = JOptionPane.showInputDialog("Escreva seu CNH: ");

		try {
			Statement st = con.createStatement();
			String sql = "Insert formulario (nome, idade, rg, cpf, empresa, cnpj, data_do_aniversario, sexo, email, cnh) "
					+ "Values ('"
					+ nome
					+ "', '"
					+ idade
					+ "', '"
					+ rg
					+ "', '"
					+ cpf
					+ "', '"
					+ empresa
					+ "', '"
					+ cnpj
					+ "', '"
					+ data_do_aniversario
					+ "', '"
					+ sexo
					+ "', '"
					+ email
					+ "', '" + cnh + "')";
			st.executeUpdate(sql);
		}

		catch (SQLException sqlex) {
			System.out.println("erro sql " + sqlex);
			sqlex.printStackTrace();
		}

	}

	public void Update() {
		String coluna, id_form, mudar;

		coluna = JOptionPane
				.showInputDialog("Escreva a coluna a ser alterada: ");
		mudar = JOptionPane
				.showInputDialog("Escreva o elemento a ser colocado: ");
		id_form = JOptionPane.showInputDialog("Escreva o numero do Id: ");

		try {
			Statement stmt = con.createStatement();
			String sql = "Update formulario" + "\n Set " + coluna + " = '"
					+ mudar + "' where id_form = " + id_form;
			stmt.executeUpdate(sql);
		} catch (SQLException sqlex) {
			System.out.println("erro sql " + sqlex);
			sqlex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void Delete() {
		String id_form;

		id_form = JOptionPane
				.showInputDialog("Escreva o numero do Id que deseja deletar: ");

		try {
			Statement stmt = con.createStatement();
			String sql = "Delete from formulario" + "\n where id_form = "
					+ id_form;
			stmt.executeUpdate(sql);
		} catch (SQLException sqlex) {
			System.out.println("erro sql " + sqlex);
			sqlex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void Select() {
		try {
			Statement stmt = con.createStatement();
			String sql = "select * from formulario";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int id_form = rs.getInt("id_form");
				String nome = rs.getString("nome");
				int idade = rs.getInt("idade");
				String rg = rs.getString("rg");
				String empresa = rs.getString("empresa");
				String cnpj = rs.getString("cnpj");
				String data_do_aniversario = rs
						.getString("data_do_aniversario");
				String sexo = rs.getString("sexo");
				String email = rs.getString("email");
				String cnh = rs.getString("cnh");

				System.out.print("\n Id: " + id_form);
				System.out.print(",  Nome: " + nome);
				System.out.print(",  Idade: " + idade);
				System.out.print(",  RG: " + rg);
				System.out.print(",  Empresa: " + empresa);
				System.out.print(",  CNPJ: " + cnpj);
				System.out.print(",  Data do aniversario: "
						+ data_do_aniversario);
				System.out.print(",  Sexo: " + sexo);
				System.out.print(",  Email: " + email);
				System.out.print(",  CNH: " + cnh);

			}

			rs.close();
		}

		catch (SQLException sqlex) {
			System.out.println("erro sql " + sqlex);
			sqlex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
