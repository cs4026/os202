package hw03;
public class Resource{
	//Total amount of Resourse
	public int amount;
	//Current amount of Resource available
	public int available;
	//Resource ID
	public int ID;
	//initializes Resource
	public Resource(int index,int num){
		this.amount=num;
		this.available=num;
		this.ID=index;
	}
	//If recourses are still available gives them
	public int send(int x){this.available-=x; return x;}
	//Accepts x amount of resource back
	public int recieve(int x){this. available+=x; return x;}
	//string representation of resource
	public void tostring(){System.out.printf("Resource#: %d\nTotal: %d\nAvailable: %d\n",this.ID,this.available,this.amount);}
	
}
