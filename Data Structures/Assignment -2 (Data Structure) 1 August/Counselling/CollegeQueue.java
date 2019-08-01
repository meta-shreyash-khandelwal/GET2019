package varunk;
import java.io.IOException;
import java.util.*;
import java.io.File;
import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
public class CollegeQueue {
	static QueueString nameOfStudent;
	static List<QueueString> programOffered;
	static List<String> precedence;
	static List<String> nameOfProgram;
	public CollegeQueue() {
		nameOfStudent = new QueueString(34);
		programOffered = new ArrayList<QueueString>();;
		precedence = new ArrayList<String>();
		nameOfProgram = new ArrayList<String>();
	}
	private String inputFile;
	public void setInputFile(String inputFile) {
		this.inputFile = inputFile;
	}
/**
 * This method adds the program offered to each cell
 * It also adds the capacity to cells
 */
	public void read1() throws IOException {
		File inputWorkbook = new File(inputFile);
		Workbook w;
		try {
			w = Workbook.getWorkbook(inputWorkbook);
			Sheet sheet = w.getSheet(0);
			for (int j = 0; j < 2; j++) {
				for (int i = 1; i < sheet.getRows(); i++) {
					Cell cell = sheet.getCell(j, i);
					CellType type = cell.getType();
					if (type == CellType.NUMBER) {
						programOffered.add(new QueueString(
								Integer.parseInt(cell.getContents())));
					}
					if (type == CellType.LABEL) {
						nameOfProgram.add(cell.getContents());
					}
				}
			}
		} catch (BiffException e) {
			e.printStackTrace();
		}
	}
/**
 * This method does two things adding the names to queue as well as adding their precedence to list 	
 */
	public void read2() throws IOException {
		File inputWorkbook = new File(inputFile);
		Workbook w;
		try {
			w = Workbook.getWorkbook(inputWorkbook);
			// Get the first sheet
			Sheet sheet = w.getSheet(0);
			for (int i = 1; i < sheet.getRows(); i++) {
				Cell cell = sheet.getCell(0, i);
				CellType type = cell.getType();
				if (type == CellType.LABEL) {
					nameOfStudent.enQueue(cell.getContents());//Adding names of student into the file
				}

			}

			for (int j = 1; j < sheet.getRows(); j++) {
				Cell cell = sheet.getCell(1, j);
				CellType type = cell.getType();
				if (type == CellType.LABEL) {
					precedence.add(cell.getContents());// Adding precedence to the Excel sheet
				}
			}

		} catch (BiffException e) {
			e.printStackTrace();
		}
	}
/**
 * This method adds all the students to programs according to the precedence of their subjects
 */
	public void addToProgram() {
		String[] precedenceOrder = new String[5];
		//int counter = 0;
		int index = 0;
		while (nameOfStudent.peek() != "") {
			precedenceOrder = precedence.get(index++).split("\\,");//Getting all the precedence programs
			outer : for (int i = 0; i < 5; i++) {
				for (int k = 0; k < programOffered.size(); k++) {
					if (Integer.parseInt(precedenceOrder[i]) == (k + 1)) {
						if (programOffered.get(k).isQueueFull()) {
							continue outer;
						} else {
							programOffered.get(k).enQueue(nameOfStudent.peek());
							break outer;
						}
					}
				}
			}

			nameOfStudent.deQueue();//For removing the names FIFO order after processing
		}

	}
	/*
	  public static void main(String[] args) throws IOException { CollegeQueue
	  test = new CollegeQueue(); test.setInputFile("C:/Excel/first.xls");
	  test.read1(); test.setInputFile("C:/Excel/second.xls"); test.read2();
	  System.out.println(programOffered.get(0).size); //
	  test.setInputFile("C:/Excel/sec.xls"); // test.read();
	  System.out.println("! "+programOffered.get(1).size); //
	  nameOfStudent.display();
	  System.out.println("3.2 "+nameOfStudent.peek()); test.addToProgram();
	  for(int i=0;i<programOffered.size();i++) { System.out.print(i+1+ " ");
	  System.out.println(programOffered.get(i).display()); }
	    System.out.println(" "+precedence.get(1).length()); }
	 */
}
