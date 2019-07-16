import java.util.*;
public class Marksheet {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int noOfStudents = 0;
		try
		{
		System.out.println("Enter the total number of students ");
		noOfStudents = in.nextInt();
		if(noOfStudents<=0)
		{
			System.out.println("The number of students cannot be negative or zero");
			throw new Exception("Invalid Number");
		}
		float gradesOfStudent[] = new float[noOfStudents];
		System.out.println("Enter the grades of " + noOfStudents
				+ " students between 0 to 100 ");
		for (int i = 0; i < noOfStudents; i++) {
			gradesOfStudent[i] = in.nextFloat();
			if(gradesOfStudent[i]<0 || gradesOfStudent[i]>100)
			{
				System.out.println("The grade should be between 0 to 100 only");
				throw new Exception("Invalid input Entered !! ");
			}
		}
		Student object = new Student();
		System.out.printf("The average of all the grades is %.2f",
				object.averageOfAll(gradesOfStudent));
		System.out.println();
		System.out.printf("The maximum grade out of all the grades is %.2f",
				object.maximumOfAllGrades(gradesOfStudent));
		System.out.println();
		System.out.printf("The minimum grade out of all the grades is %.2f",
				object.minimumOfAllGrades(gradesOfStudent));
		System.out.println();
		System.out.printf("The percentage of students passed is %.2f",
				object.percentageStudentsPassed(gradesOfStudent));
		System.out.println();
	}
	catch(Exception e)
	{
		System.out.println("Invalid input entered !! Try Again ");
		main(args);
	}

}}
class Student {
/**
 * This method calculates the total average grades of all Students
 * @param gradesOfStudent contains the grades of all the students
 * @return the total average grade obtained by the students
 */
	public float averageOfAll(float gradesOfStudent[]) {
		float sum = 0;
		for (int i = 0; i < gradesOfStudent.length; i++) {
			sum += gradesOfStudent[i];
		}
		return (sum / gradesOfStudent.length);

	}
/**
 * This method calculates the maximum grade obtained 
 * @param gradesOfStudent contains the grades of all the students
 * @return float value having the maximum grade out of all grades
 */
	public float maximumOfAllGrades(float gradesOfStudent[]) {
		float maximumGrade = -1;
		for (int j = 0; j < gradesOfStudent.length; j++) {
			if (gradesOfStudent[j] > maximumGrade) {
				maximumGrade = gradesOfStudent[j];
			}
		}
		return maximumGrade;
	}
/**
 * This method calculates the minimum grade obtained 
 * @param gradesOfStudent contains the grades of all the students
 * @return float value having the minimum grade value
 */
	public float minimumOfAllGrades(float gradesOfStudent[]) {
		float minimumGrade = 101;
		for (int k = 0; k < gradesOfStudent.length; k++) {
			if (gradesOfStudent[k] < minimumGrade) {
				minimumGrade = gradesOfStudent[k];
			}
		}
		return minimumGrade;
	}
/**
 * This method calculates the total percentage of students passed
 * @param gradesOfStudent contains the grades of all the students 
 * @return the float value containing percentage of passes students
 */
	public float percentageStudentsPassed(float gradesOfStudent[]) {
		int passedStudents = 0;
		for (int i = 0; i < gradesOfStudent.length; i++) {
			if (gradesOfStudent[i] >= 40) {
				passedStudents++;
			}

		}
		//System.out.println("PASSS "+passedStudents);
		//System.out.println("Total "+((float) passedStudents / (float) gradesOfStudent.length));
		return ((float) passedStudents / (float) gradesOfStudent.length) * 100;

	}

}
