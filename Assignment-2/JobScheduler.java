import java.util.*;
class Process {
/**
 * This method finds the completion time of all the processes
 * @param timeArray is the 2D array containing arrival time and burst time of all processes 
 * @param numberOfProcess is the total number of processes
 * @return the array containing completion time of all the processes
 */
	public int[] completionTime(int timeArray[][], int numberOfProcess) {
		int completionArray[] = new int[numberOfProcess];
		completionArray[0] = timeArray[0][0] + timeArray[0][1];
		for (int i = 1; i < numberOfProcess; i++) {
			if (timeArray[i][0] < timeArray[i - 1][1]) {
				completionArray[i] = completionArray[i - 1] + timeArray[i][1];
			} else

			{
				completionArray[i] = timeArray[i][0] + timeArray[i][1];
			}

		}
	return completionArray;
	}
/**
 * This method calculates the turn around time of all process turn around time = completion time-arrival time 
 * @param completionTimeArray contains the completion time of all the processes
 * timeArray is the 2D array containing arrival time and burst time of all process 
 * @param numberOfProcess is the total number of process
 * @return the array containing turn around time of all the processes
 */
	public int[] turnAroundTime(int completionTimeArray[], int timeArray[][],
			int numberOfProcess) {
		int turnaroundArray[] = new int[numberOfProcess];
		for (int j = 0; j < numberOfProcess; j++) {
			turnaroundArray[j] = completionTimeArray[j] - timeArray[j][0];
		}
		return turnaroundArray;
	}
/**
 * This method returns the waiting time of all processes using waiting time = turn around time-completion time
 * @param turnAroundTimeArray contains an array of turn around time of all processes
 * @param timeArray is the 2D array containing arrival time and burst time of all process 
 * @param numberOfProcess is the total number of process
 * @return an array containing waiting times of all the processes
*/
	public int[] waitingTime(int turnAroundTimeArray[], int timeArray[][],
			int numberOfProcess) {

		int waitingArray[] = new int[numberOfProcess];
		for (int j = 0; j < numberOfProcess; j++) {
			waitingArray[j] = turnAroundTimeArray[j] - timeArray[j][1];
		}

		return waitingArray;
	}
/**
 * This method calculates the average of waiting time of all the processes
 * @param waitingArray contains the waiting times of all processes
 * @param numberOfProcess is the total number of process
 * @return a double average value of waiting time in millisecond of all the processes
 */
	public double averageWaitingTime(int waitingArray[], int numberOfProcess) {
		double average = 0.0;
		for (int k = 0; k < numberOfProcess; k++) {
			average = waitingArray[k] + average;
		}
		return average/numberOfProcess;
	}
/**
 * This method calculates the maximum waiting time out of all process
 * @param waitingArray contains the waiting times of all processes
 * @param numberOfProcess is the total number of process
 * @return a integer value which is maximum waiting time in millisecond
 */
	public int maximumWaitingTime(int waitingArray[], int numberOfProcess) {
		int maximum = 0;
		for (int i = 0; i < numberOfProcess; i++) {
			if (waitingArray[i] > maximum) {
				maximum = waitingArray[i];
			}

		}
		return maximum;
	}
}
public class JobScheduler {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numberOfProcess = 0;
		System.out.println("Enter the number of process ");
		numberOfProcess = in.nextInt();
		Process object = new Process();
		int completionTimeArray[] = new int[numberOfProcess];
		int turnAroundTimeArray[] = new int[numberOfProcess];
		int waitingTimeArray[] = new int[numberOfProcess];
		int maximumWaitingTimeSolution = 0;
		double averageWaitingTimeSolution = 0;
		int timeArray[][] = new int[numberOfProcess][2];
		// System.out.println("HI"+numberOfProcess);
		System.out.println("Please Enter the arrival time in increasing order ");
		for (int i = 0; i < numberOfProcess; i++) {
			System.out.println("Enter Arrival Time and Burst Time of Process in millisec"
							+ (i + 1) + " ");
			for (int j = 0; j < 2; j++) {
				timeArray[i][j] = in.nextInt();
			}
		}
		completionTimeArray = object.completionTime(timeArray, numberOfProcess);
		turnAroundTimeArray = object.turnAroundTime(completionTimeArray,
				timeArray, numberOfProcess);
		waitingTimeArray = object.waitingTime(turnAroundTimeArray, timeArray,
				numberOfProcess);
		maximumWaitingTimeSolution = object.maximumWaitingTime(
				waitingTimeArray, numberOfProcess);
		averageWaitingTimeSolution = object.averageWaitingTime(
				waitingTimeArray, numberOfProcess);
		System.out.println("Completion time \t"+"TurnAround Time \t \t"+"Waiting Time");		
		for (int x = 0; x < numberOfProcess; x++) {
			System.out.println(completionTimeArray[x] + "\t \t \t \t"
					+ turnAroundTimeArray[x] + "\t \t \t \t" + waitingTimeArray[x]);
		}
		System.out.println("The average waiting time is " + averageWaitingTimeSolution+" milliseconds");
		System.out.println("The maximum value of waiting time is " + maximumWaitingTimeSolution+" milliseconds");
	}
}
