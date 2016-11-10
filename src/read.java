import java.util.*;
import java.io.*;
public class read{
	//Stores amount of tasks
	int numTasks;
	//stores amount of resources
	int numResources;
	//int array which will be initialized to [number of resources][2],
	//first coloumn(0) will be the initialized amount of recources 
	//second column will be the amount currently not in use
	int [][] aR;
	//String array holding file representation
	String[] input;
	
	public static void main(String[] args){
		File f= new File("../input1.txt");
		read r=new read();
		try{r.read(f);}
		catch(Exception e){System.out.println("ERROR WITH FILE");}
		
		System.out.printf("# tasks: %d\n# Recources: %d\n",r.numTasks,r.numResources);	
		
		for(int i=0;i<r.numResources;i++){
			System.out.printf("Recourse #: %d Recourse Amount: %d\n",i+1,r.aR[i][0]);
		}
		int numLines=r.numLine(f);
		System.out.printf("Num Lines: %d\n",numLines);
		System.out.printf("Remaining lines in file:\n");
		for(int i=0;i<numLines;i++){System.out.println(i+": "+r.input[i]);}
	}
	//method for reading file
	public void read(File f) throws Exception{
		try{
			BufferedReader br= new BufferedReader(new FileReader(f));
			/**int c;
			c=br.read();
			this.numTasks= Character.getNumericValue(c);
			br.read();
			c=br.read();
			this.numResources=Character.getNumericValue(c);
			this.aR= new int[this.numResources][2];

			for(int i=0;i<this.numResources;i++){
				br.read();
				this.aR[i][0]=Character.getNumericValue(br.read());
				this.aR[i][1]=this.aR[i][0];	
			}*/
			int numLines=this.numLine(f);
			input=new String[numLines];
			int g=0;
			for(int i=0;i<numLines;i++){
				String next=br.readLine();	
				while(next.isEmpty()){next=br.readLine();g++;}
				input[i]=next;
				g++;
				if(g==numLines) break;
			}	
		}
		catch(Exception e){
			System.out.println("ERROR FILE UNABLE TO OPEN");
		}
		
	}
	//reads amount of lines in file
	public int numLine(File f){
		try{
			BufferedReader reader = new BufferedReader(new FileReader(f));
			int lines = 0;
			while (reader.readLine() != null) lines++;
			reader.close();
			return lines; 
		}
		catch(Exception e){System.out.println("ERROR WITH READING FILE LINES");return -1;}
		}
}
