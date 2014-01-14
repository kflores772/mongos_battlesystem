package suthan.battlesystem.V3;

public class Player {

	public float HP;
	public float ATK;
	public float DEF;
	public float LVL;
	public float CHG;
	public float EXP;
		
	public Player(){
		HP = 0;  
		ATK = 0;
		DEF = 0;
		LVL = 0;
		CHG = 1;
	}
	
	public void Statset(int a, int b, int c, int d){
		this.HP=a;
		this.ATK=b;
		this.DEF=c;
		this.LVL=d;
	}
}

