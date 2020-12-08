
import java.util.*;

import com.sun.jdi.DoubleValue;

import java.io.FileWriter; 
import java.io.IOException;
import java.io.File; 
import java.io.FileNotFoundException;
public class OperatingSystem {
	
	ArrayList<Processes> processesCreated = new ArrayList<>();

	public OperatingSystem() {
		
	}
	
	public static void writeToFile(String FileName, String data) {
		try {
			FileWriter myWriter = new FileWriter("/Users/ahmedwasfy/Documents/College/OS Project/OSSim/src/Files/"+ FileName);
			myWriter.write(data);
			myWriter.close();
			System.out.println("Date written succesfully to "+ FileName);
		}
		catch(IOException e){
			System.out.println("an error occured");
			e.printStackTrace();
			
		}
	}
	public String readFile(String FileName) {
			String data ="";
			try {
				File myObj = new File("/Users/ahmedwasfy/Documents/College/OS Project/OSSim/src/Files/" + FileName);
				Scanner myReader;
				myReader = new Scanner(myObj);
				while(myReader.hasNextLine()) {
					data = myReader.nextLine();
					
				}
				myReader.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			return data;
	}
	public static void printData(int Data) {
		System.out.println(Data);
		
	}
	
	public String inputFromUser() {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		//sc.close();
		return input;
	}
	public void createProcess(int id) {
		Processes P = new Processes(id);
		processesCreated.add(P);
		System.out.println(processesCreated.get(id-1).PID);
	}
	public static void main(String[] args) {
		
	
	
	
	}
	
	public void SJF(ArrayList<Processes> createdProcesses) {
		int count = 0;
		//ArrayList<Processes> sorted = new ArrayList<>();
		Collections.sort(createdProcesses, new Comparator<Processes>() {

			@Override
			public int compare(Processes o1, Processes o2) {
				return Double.valueOf(o1.executionTime).compareTo(o2.executionTime);
				}
			});
		for(int i=0; i<createdProcesses.size();i++) {
			createdProcesses.get(i).run(createdProcesses.get(i));
		}

	}	
	
	public void RR(ArrayList<Processes> createdProcesses) {
		int c =0;
		while(!createdProcesses.isEmpty()) {
			if(createdProcesses.get(c).PID==1 && createdProcesses.get(c).numbOfCycles!=0) {
				createdProcesses.get(c).run(createdProcesses.get(c));
				createdProcesses.get(c).numbOfCycles --;
				createdProcesses.remove(c);
				
				
			}
			else if(createdProcesses.get(c).PID==2 && createdProcesses.get(c).numbOfCycles!=0) {
				createdProcesses.get(c).run(createdProcesses.get(c));
				createdProcesses.get(c).numbOfCycles --;
				if(createdProcesses.get(c).numbOfCycles==0) {
					createdProcesses.remove(c);
					
			}}
			else if(createdProcesses.get(c).PID==3 && createdProcesses.get(c).numbOfCycles!=0) {
				createdProcesses.get(c).run(createdProcesses.get(c));
				createdProcesses.get(c).numbOfCycles --;
				if(createdProcesses.get(c).numbOfCycles==0) {
					createdProcesses.remove(c);
					
			}}
			if(c>=(createdProcesses.size()-1))
				c = 0;
			else 
				c++;
				
				
		}
		
	}
	
	
	
	
}
