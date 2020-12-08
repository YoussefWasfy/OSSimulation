import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public class Processes extends OperatingSystem{
	
	public ProcessesState state;
	public int numbOfCycles;
	public int PID;
	protected static int Sum ;
	public double executionTime;
	
	public Processes(int PID) {
		this.PID = PID;
		this.state = ProcessesState.ready;
		if(PID==1)
			this.numbOfCycles = 1;
		else if(PID==2)
			this.numbOfCycles = 3;
		else if(PID ==3)
			this.numbOfCycles = 4;
		if(PID==1)
			this.executionTime = 1.448400 ;
		else if(PID == 2)
			this.executionTime =87.061800;
		else if(PID == 3)
			this.executionTime = 0.411800;
		else if(PID==4)
			this.executionTime = 1147.792000;
		else if(PID==5)
			this.executionTime = 35909.104000;

		
	}

	public static void main(String[] args) {
		OperatingSystem OS1 = new OperatingSystem();
		OS1.createProcess(1);
		OS1.createProcess(2);
		OS1.createProcess(3);
		//OS1.createProcess(4);
		//OS1.createProcess(5);
//		for(int i=0;i<5;i++) {
//			OS1.processesCreated.get(i).run(OS1.processesCreated.get(i));
//		}
		
		OS1.RR(OS1.processesCreated);
		
	
	}
	
	public void process1(int x, int y) {
		state = ProcessesState.running;
		String data = "";
		Sum = x+y;
		printData(Sum);
		Sum = Sum * 2;
		data = data + Sum;
		writeToFile("Output.txt", data);
		state = ProcessesState.terminated;
	}
	
	public void process2() {
		state = ProcessesState.running;
		String data = readFile("Read.txt");
		int iData = Integer.parseInt(data);
		iData = iData *2;
		printData(iData);
		state = ProcessesState.terminated;
	}
	
	public void process3() {
		state = ProcessesState.running;
		int Fib = GetFibonacci(10);
		printData(Fib);
		Sum += Fib;
		printData(Sum);
		state = ProcessesState.terminated;
	}
	
	public int GetFibonacci(int count) {
		int n1 =0;
		int n2 =1;
		int n3 =0;
		for(int i =2; i<count; i++) {
			n3 = n1 + n2;
			n1 = n2;
			n2 = n3;
		}
		return n3;
	}
	
	public void process4() {
		state = ProcessesState.running;
		System.out.println("Please type an Integer");
		String input = inputFromUser();
		int intInput = Integer.parseInt(input);
		Boolean f = checkPrime(intInput);
		if(f) {
			Sum += intInput;
		}
		else
			Sum = Sum - intInput;
		printData(Sum);
		state = ProcessesState.terminated;
	}
	public boolean checkPrime(int numb) {
		 if (numb <= 1) 
	            return false; 
	        for (int i = 2; i < numb; i++) 
	            if (numb % i == 0) 
	                return false; 
	  
	        return true; 
	}
	
	
	public void process5() {
		state = ProcessesState.running;
		String count2 = " ";
		System.out.println("Please enter a number");
		String in1 = inputFromUser();
		int input1 = Integer.parseInt(in1);
		System.out.println("Please enter a number higher than the one before");
		String in2 = inputFromUser();
		int input2 = Integer.parseInt(in2);
		for(int i =0; i<10;i++) {
		if(input1> input2) {
			System.out.println("Please enter a number higher than the one you enetered before");
			input2 = Integer.parseInt(inputFromUser());
		}
		if(input2>input1)
			break;
		}
		
		int count = input2 - input1;
		count2 = count2 + count;
		writeToFile("Output2.txt", count2);
		state = ProcessesState.terminated;
	}
	
	public void run(Processes P) {
		if(P.PID==1)
			process1(3,8);
		if(P.PID==2)
			process2();
		if(P.PID==3)
			process3();
		if(P.PID==4)
			process4();
		if(P.PID==5)
			process5();
	}
	
	
	
//	Instant start = Instant.now();
//	Instant finish = Instant.now();
//	long timeOfExec = Duration.between(start, finish).toNanos();
//	System.out.println(timeOfExec);
	
	
	
	
	
	
	
	
	
	
	
	
}
