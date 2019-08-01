package varunk;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.*;
import jxl.CellView;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.UnderlineStyle;
import jxl.write.Formula;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class WriteExcel {
	static CollegeQueue test = new CollegeQueue();
	private WritableCellFormat timesBoldUnderline;
	private WritableCellFormat times;
	private String inputFile;
/**
 * This method sets the output file to the input file
 * @param inputFile is the File in String format
 */
	public void setOutputFile(String inputFile) {
		this.inputFile = inputFile;
	}
/**
 * This method reads the file "first.xls" and "second.xls" and finally write the answer to "result.xls"
 */
	public void write() throws IOException, WriteException {
		File file = new File(inputFile);
		WorkbookSettings wbSettings = new WorkbookSettings();
		wbSettings.setLocale(new Locale("en", "EN"));
		WritableWorkbook workbook = Workbook.createWorkbook(file, wbSettings);
		workbook.createSheet("Report", 0);
		WritableSheet excelSheet = workbook.getSheet(0);
		test.setInputFile("C:/Excel/first.xls");//Reading first file
		test.read1();
		test.setInputFile("C:/Excel/second.xls");//Reading second file
		test.read2();
		test.addToProgram();
		createLabel(excelSheet);
		createContent(excelSheet);
		workbook.write();
		workbook.close();
	}

	private void createLabel(WritableSheet sheet) throws WriteException {
		// Lets create a times font
		WritableFont times10pt = new WritableFont(WritableFont.TIMES, 10);
		// Define the cell format
		times = new WritableCellFormat(times10pt);
		// Lets automatically wrap the cells
		times.setWrap(true);

		// create create a bold font with underlines
		WritableFont times10ptBoldUnderline = new WritableFont(
				WritableFont.TIMES, 10, WritableFont.BOLD, false,
				UnderlineStyle.SINGLE);
		timesBoldUnderline = new WritableCellFormat(times10ptBoldUnderline);
		// Lets automatically wrap the cells
		timesBoldUnderline.setWrap(true);

		CellView cv = new CellView();
		cv.setFormat(times);
		cv.setFormat(timesBoldUnderline);
		cv.setAutosize(true);
		addCaption(sheet, 0, 0, "Program");//Adding captions 
		addCaption(sheet, 1, 0, "Capacity");
		addCaption(sheet, 2, 0, "Names");
	}
/**
 * This method write into the file according to requirements	
 * @param sheet is the excel sheet on which writing is to be done
 */
	private void createContent(WritableSheet sheet)
			throws WriteException, RowsExceededException {
		int index = 0;
		for (int i = 0; i < CollegeQueue.nameOfProgram.size(); i++) {
			// First column
			addLabel(sheet, 0, i + 1, CollegeQueue.nameOfProgram.get(i));
			// Second column
		}
		index = 0;
		// Capacity
		for (int i = 0; i < CollegeQueue.nameOfProgram.size(); i++) {
			addNumber(sheet, 1, i + 1, CollegeQueue.programOffered.get(i).size);
		}

		for (int i = 0; i < CollegeQueue.nameOfProgram.size(); i++) {
			addLabel(sheet, 2, i + 1,
					CollegeQueue.programOffered.get(i).display());
		}

	}
/**
 * This method adds the captions to the excel sheet
 * @param sheet is the excel sheet
 * @param column is the no of column
 * @param row is the no of rows
 * @param caption is the string to be written on excel
 */
	private void addCaption(WritableSheet sheet, int column, int row, String caption)
			throws RowsExceededException, WriteException {
		Label label;
		label = new Label(column, row, caption, timesBoldUnderline);
		sheet.addCell(label);
	}
/**
 * This method adds the captions to the excel sheet
 * @param sheet is the excel sheet
 * @param column is the no of column
 * @param row is the no of rows
 * @param integer is the integer to be written on excel
 */
	private void addNumber(WritableSheet sheet, int column, int row,
			Integer integer) throws WriteException, RowsExceededException {
		Number number;
		number = new Number(column, row, integer, times);
		sheet.addCell(number);
	}
/**
 * This method adds the captions to the excel sheet
 * @param sheet is the excel sheet
 * @param column is the no of column
 * @param row is the no of rows
 * @param element is the integer to be written on excel
 */
	private void addLabel(WritableSheet sheet, int column, int row, String element)
			throws WriteException, RowsExceededException {
		Label label;
		label = new Label(column, row, element, times);
		sheet.addCell(label);
	}

	public static void main(String[] args) throws WriteException, IOException {

		test.addToProgram();
		for (int i = 0; i < CollegeQueue.programOffered.size(); i++) {
			System.out.print((i + 1) + " ");

			System.out.println(CollegeQueue.programOffered.get(i).display());
		}
		// System.out.println(" "+precedence.get(1).length());
		WriteExcel test1 = new WriteExcel();
		test1.setOutputFile("c:/Excel/result.xls");
		test1.write();
		System.out.println("Please check the result file under C:/Excel/result.xls ");

	}

}