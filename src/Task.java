pckage hw03;
public class Task{
	public int ID;
	public int [][]life;
	public Task(int ID, int resources){
		this.ID=ID;
		//creates an array that represents the task's claim and current amount of resources held
		//life[][0] represents the claim, life[][1] represents amount of resourse currently held
		this.life=new int[resources][2];
	}
	//method removes x amount of resource
	public int deallocate(int resource,int x){
		this.life[resource][1]-=x;
		return x;
	} 
	//method adds successful claim to Task
	public int allocate(int resource,int x){
		this.life[resource][1]+=x;
		return x;
	}
	//method sets claim for task
	public int claim(int resource,int claim){
		this.life[resource][0]=claim;
		return claim;
	}
}
