package hw03;
import java.io.*;
import java.util.*;
public class Main{
	public static Resource[] rs;
	public static Task[] tasks;
	public static String input[];

	public static void main(String [] args){
		
		File f= new File("input1.txt");
		read r=new read();
		try{r.read(f);}
		catch(Exception e){System.out.println("ERROR WITH FILE");}	
		input=r.input;
		System.out.printf("# tasks: %c\n# Recources: %c\n",input[0].charAt(0),input[0].charAt(2));	
		
		for(int i=0;i<r.numResources;i++){
			System.out.printf("Recourse #: %d Recourse Amount: %d\n",i+1,r.aR[i][0]);
		}
		int numLines=r.numLine(f);
		System.out.printf("Num Lines: %d\n",numLines);
		System.out.printf("Remaining lines in file:\n");
		initiate();		
		
		for(int i=0;i<rs.length;i++){ System.out.printf("Resource %d Amount %d Available %d\n",rs[i].ID,rs[i].amount,rs[i].available);
		for(int j=0;j<tasks.length;j++) System.out.printf("Task %d Resource %d:\nClaim %d available\n",tasks[j].ID,i,tasks[j].life[i][0],tasks[j].life[i][1]);
		}
	}
	//method intiates tasks and resources as well as their respective holder arrays
	public static int initiate(){
		String start=input[0];
		tasks=new Task[Character.getNumericValue(start.charAt(0))];
		rs=new Resource[Character.getNumericValue(start.charAt(2))];	
		int q=4;
		for(int i=0;i<rs.length;i++){
			rs[i]=new Resource(i+1,Character.getNumericValue(start.charAt(q)));
			q+=2;
		}
		int c=0;
		for(int i=2; i<input.length;i++){
			if(input[i]==null) break;
			else if(input[i].isEmpty()) i++;
			else{
				if(input[i].substring(0,8).equals("initiate")){
					tasks[c]=new Task(Character.getNumericValue(input[i].charAt(10)),rs.length);
					tasks[c].claim(Character.getNumericValue(input[i].charAt(12))-1,Character.getNumericValue(input[i].charAt(14)));		
					c++;
				}
			}
		}
		return 1;
	}
}
