package com.tigerit.TestProjectByTreena.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.tigerit.TestProjectByTreena.DTO.FlightFinderDTO;
import com.tigerit.TestProjectByTreena.DTO.LoginDTO;
import com.tigerit.TestProjectByTreena.Utils.ExcelUtils;

public class ExcelUtils {
	private static FileInputStream inputStream = null;
	private static Workbook workbook = null;

	private static Sheet getSheet(int sheetNo) throws IOException {
		// change the file location as per your computer
		File f = new File("src/main/java");
		File fs = new File(f, "data.xlsx");
		inputStream = new FileInputStream(new File(fs.getAbsolutePath()));
		workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheetAt(sheetNo);
		return sheet;
	}
	
//manage sheet inputs
	public static List<LoginDTO> getLoginData() throws IOException {
		List<LoginDTO> logindata = new ArrayList<LoginDTO>();
		DataFormatter formatter = new DataFormatter();
		// login is the first sheet in excel so getSheet parameter set to 0
		Iterator<Row> iterator = ExcelUtils.getSheet(0).iterator();
		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator(); //goto next cell
			LoginDTO login = new LoginDTO();
			byte cellCounter = 0;
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				switch (cellCounter) {
				case 0:
					login.setUsername(formatter.formatCellValue(cell));
					cellCounter++;
					break;
				case 1:
					login.setPassword(formatter.formatCellValue(cell));
					break;
				default:
					break;
				}

			}
			logindata.add(login);
		}
		close();
		return logindata;
	}
	
	
	
	//flight finder page
	public static List<FlightFinderDTO> getflightFinderData() throws IOException {
		List<FlightFinderDTO> flightfinderdata = new ArrayList<FlightFinderDTO>();
		DataFormatter formatter = new DataFormatter();
		
		Iterator<Row> iterator = ExcelUtils.getSheet(1).iterator();
		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator(); //goto next cell
			FlightFinderDTO flightfinder = new FlightFinderDTO();
			byte cellCounter = 0;
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				switch (cellCounter) {
				case 0:
					flightfinder.setPassenger(formatter.formatCellValue(cell));
					cellCounter++;
					break;
					
				case 1:
					flightfinder.setDepart(formatter.formatCellValue(cell));
					break;
				default:
					break;
				}

			}
			flightfinderdata.add(flightfinder);
		}
		close();
		return flightfinderdata;
	}

	
	
	
	private static void close() throws IOException{
		workbook.close();
		inputStream.close();
		
	}

}
