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
public class TollDetailsController {

	public static void main(String[] args) {
		new TollDetailsController().export();
	}

	@GetMapping("/downloadTollDetailsAdmin")
	public String export() {
		String jdbcURL = "jdbc:mysql://localhost:3306/cts";
		String username = "root";
		String password = "691523";

		String excelFilePath = "D:\\CTS\\tollDetails.xlsx";
		try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
			String sql = "SELECT * FROM toll_details";

			Statement statement = connection.createStatement();

			ResultSet result = statement.executeQuery(sql);

			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("Toll Details");

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
		return "redirect:/addTollDetailsDownloadMsg";
	}

	private void writeHeaderLine(XSSFSheet sheet) {

		Row headerRow = sheet.createRow(0);

		Cell headerCell = headerRow.createCell(0);
		headerCell.setCellValue("Slno");

		headerCell = headerRow.createCell(1);
		headerCell.setCellValue("Fee");

		headerCell = headerRow.createCell(2);
		headerCell.setCellValue("From Location");

		headerCell = headerRow.createCell(3);
		headerCell.setCellValue("Approval Status");

		headerCell = headerRow.createCell(4);
		headerCell.setCellValue("To Location");

		headerCell = headerRow.createCell(5);
		headerCell.setCellValue("Vehicle Type");

	}

	private void writeDataLines(ResultSet result, XSSFWorkbook workbook, XSSFSheet sheet) throws SQLException {
		int rowCount = 1;

		while (result.next()) {
			String tid = result.getString("tid");
			String fee = result.getString("fee");
			String from_location = result.getString("from_location");
			String tapproval = result.getString("tapproval");
			String to_location = result.getString("to_location");
			String vechtype = result.getString("vechtype");

			Row row = sheet.createRow(rowCount++);

			int columnCount = 0;
			Cell cell = row.createCell(columnCount++);
			cell.setCellValue(tid);

			cell = row.createCell(columnCount++);
			cell.setCellValue(fee);

			cell = row.createCell(columnCount++);
			cell.setCellValue(from_location);

			cell = row.createCell(columnCount++);
			cell.setCellValue(tapproval);

			cell = row.createCell(columnCount++);
			cell.setCellValue(to_location);

			cell = row.createCell(columnCount++);
			cell.setCellValue(vechtype);

		}
	}
}