package com.cts.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FeedbackController {

	public static void main(String[] args) {
		new FeedbackController().export();
	}

	@GetMapping("/downloadUserFeedbackAdmin")
	public String export() {
		String jdbcURL = "jdbc:mysql://localhost:3306/cts";
		String username = "root";
		String password = "691523";

		String excelFilePath = "D:\\CTS\\userFeedback.xlsx";
		try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
			String sql = "SELECT * FROM userfeedback_details";

			Statement statement = connection.createStatement();

			ResultSet result = statement.executeQuery(sql);

			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("User Feedback");

			writeHeaderLine(sheet);

			writeDataLines(result, workbook, sheet);

			FileOutputStream outputStream = new FileOutputStream(excelFilePath);
			workbook.write(outputStream);
			workbook.close();

			statement.close();

		} catch (SQLException e) {
			System.out.println("Datababse error:");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("File IO error:");
			e.printStackTrace();
		}
		return "redirect:/addFeedbackDownloadMsg";
	}

	private void writeHeaderLine(XSSFSheet sheet) {

		Row headerRow = sheet.createRow(0);

		Cell headerCell = headerRow.createCell(0);
		headerCell.setCellValue("Slno");

		headerCell = headerRow.createCell(1);
		headerCell.setCellValue("Response_01");

		headerCell = headerRow.createCell(2);
		headerCell.setCellValue("Response_02");

		headerCell = headerRow.createCell(3);
		headerCell.setCellValue("Response_03");

		headerCell = headerRow.createCell(4);
		headerCell.setCellValue("Response_04");

		headerCell = headerRow.createCell(5);
		headerCell.setCellValue("Response_05");

		headerCell = headerRow.createCell(6);
		headerCell.setCellValue("User_FullName");

		headerCell = headerRow.createCell(7);
		headerCell.setCellValue("User_ID");
	}

	private void writeDataLines(ResultSet result, XSSFWorkbook workbook, XSSFSheet sheet) throws SQLException {
		int rowCount = 1;

		while (result.next()) {
			String fid = result.getString("fid");
			String resp01 = result.getString("resp01");
			String resp02 = result.getString("resp02");
			String resp03 = result.getString("resp03");
			String resp04 = result.getString("resp04");
			String resp05 = result.getString("resp05");
			String ufull_name = result.getString("ufull_name");
			String uid = result.getString("uid");

			Row row = sheet.createRow(rowCount++);

			int columnCount = 0;
			Cell cell = row.createCell(columnCount++);
			cell.setCellValue(fid);

			cell = row.createCell(columnCount++);
			cell.setCellValue(resp01);

			cell = row.createCell(columnCount++);
			cell.setCellValue(resp02);

			cell = row.createCell(columnCount++);
			cell.setCellValue(resp03);

			cell = row.createCell(columnCount++);
			cell.setCellValue(resp04);

			cell = row.createCell(columnCount++);
			cell.setCellValue(resp05);

			cell = row.createCell(columnCount++);
			cell.setCellValue(ufull_name);

			cell = row.createCell(columnCount++);
			cell.setCellValue(uid);

		}
	}
}