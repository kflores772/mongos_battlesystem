/*NEW UPDATES for V4
 *	statpage
 *	savedstats (win, loss, draw record)*/

package suthan.battlesystem.V3;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class BattleSystemV3Activity extends Activity {

	/* Storage Variables */
	public static int WinCount, LoseCount, DrawCount;
	public static final String FileName = "SavedBattleStats";
	private SharedPreferences BattleData;
	
	/* two opponents */
	Player owner = new Player();
	Player sprite = new Player();
	int p1_input= 0;
	int p2_input = 0;
	int rand_find = 0;
	int battle_int;
	TextView sHP, oHP, sMOVE, oMOVE;
	Button attkB, defB, chgB, statB;
	
	//OPPONENT move selections
	int [] BATTLE_1 = {3, 3, 3, 3, 3, 1, 1, 1, 2, 2};
	int [] BATTLE_2 = {3, 3, 3, 3, 1, 1, 1, 1, 2, 2};
	int [] BATTLE_3 = {3, 3, 3, 1, 1, 1, 1, 1, 2, 2};
	int [] BATTLE_4 = {3, 3, 1, 1, 1, 1, 1, 2, 2, 2};
	int [] BATTLE_5 = {3, 1, 1, 1, 1, 1, 2, 2, 2, 2};
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //RETREIVE SAVED DATA
        BattleData = getSharedPreferences(FileName, 0);
        WinCount = BattleData.getInt("Wins", 0);
		LoseCount = BattleData.getInt("Losses", 0);
		DrawCount = BattleData.getInt("Draws", 0);
        
        
        //WELCOME MESSAGE
        Toast t = new Toast(this);
        t = Toast.makeText(this, "Choose your move!", Toast.LENGTH_SHORT);
        t.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        t.show();
        
        //Declare each button + textview
        sHP = (TextView) findViewById(R.id.spriteHP);
        sMOVE = (TextView) findViewById(R.id.spriteMove);
        oHP = (TextView) findViewById(R.id.ownerHP);
        oMOVE = (TextView) findViewById(R.id.ownerMove);
        
        attkB = (Button) findViewById(R.id.attackButton);
        defB = (Button) findViewById(R.id.defendButton);
        chgB = (Button) findViewById(R.id.chargeButton);
        statB = (Button) findViewById(R.id.statsButton);
        //IF PLAYER WANT TO CHECK HIS STATS
        statB.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent i = new Intent(BattleSystemV3Activity.this, StatPage.class);
				startActivity(i);
			}
		});
        //END STAT CHECK
        
        //initialize player stats
        owner.HP = 10;
    	owner.ATK = 2;
    	owner.DEF = 3;
    	owner.LVL = 1;
    	owner.CHG = 1;
    	
    	sprite.HP = 10;
    	sprite.ATK = 2;
    	sprite.DEF = 3;
    	sprite.LVL = 1;
    	sprite.CHG = 1; 
    	//Display Current stats
		sHP.setText("Sprite HP: " + sprite.HP);
		oHP.setText("Player HP: " + owner.HP);
		
    	
    	//            START CODE FOR EACH PLAYER MOVE
    	
    	//Owner Presses Attack
    	attkB.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if (owner.CHG == 0){					
					oMOVE.setText("Charge before Attack!");
				}
				else {
					oMOVE.setText("Attack");
					owner.CHG--;
					p1_input=1;
					DecideSpriteMove();
					//Display new stats
					sHP.setText("Sprite HP: " + sprite.HP);
					oHP.setText("Player HP: " + owner.HP);
				}
			}
		}); 	
    	
    	//Owner Presses Defend
    	defB.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
					oMOVE.setText("Defend");
					p1_input=2;
					DecideSpriteMove();
					//Display new stats
					sHP.setText("Sprite HP: " + sprite.HP);
					oHP.setText("Player HP: " + owner.HP);
			}
		}); 
    	
    	//Owner Presses Charge
    	chgB.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
					oMOVE.setText("Charge");
					p1_input=3;
					owner.CHG++;
					DecideSpriteMove();
					//Display new stats
					sHP.setText("Sprite HP: " + sprite.HP);
					oHP.setText("Player HP: " + owner.HP);
			}
		}); 
    }
    
    public void DecideSpriteMove(){
    	
    	//                    SPRITE RESPONSE
		/* NOTE: 1 is to attack, 2 is to defend, 3 is to charge */ 
    	
    	//START GENERATE SPRITE MOVE
		if (owner.LVL > 0 && owner.LVL <= 5){
			rand_find = (int) ((Math.random())*9);
			p2_input = BATTLE_1[rand_find];
			
			if(p2_input == 1 && sprite.CHG == 0){
				while(p2_input == 1){
					rand_find = (int) ((Math.random())*9);
					p2_input = BATTLE_1[rand_find];
				}
			}
		}
		
		else if (owner.LVL > 5 && owner.LVL <= 10){
			rand_find = (int) ((Math.random())*9);
			p2_input = BATTLE_2[rand_find];
			
			if(p2_input == 1 && sprite.CHG == 0){
				while(p2_input == 1){
					rand_find = (int) ((Math.random())*9);
					p2_input = BATTLE_2[rand_find];
				}
			}
		}
		
		else if (owner.LVL > 10 && owner.LVL <= 20){
			rand_find = (int) ((Math.random())*9);
			p2_input = BATTLE_3[rand_find];
			
			if(p2_input == 1 && sprite.CHG == 0){
				while(p2_input == 1){
					rand_find = (int) ((Math.random())*9);
					p2_input = BATTLE_3[rand_find];
				}
			}
		}
		
		else if (owner.LVL > 20 && owner.LVL <= 40){
			rand_find = (int) ((Math.random())*9) ;
			p2_input = BATTLE_4[rand_find];
			
			if(p2_input == 1 && sprite.CHG == 0){
				while(p2_input == 1){
					rand_find = (int) ((Math.random())*9);
					p2_input = BATTLE_4[rand_find];
				}
			}
		}
		
		else if (owner.LVL > 40 && owner.LVL <= 80){
			rand_find = (int) ((Math.random())*9) ;
			p2_input = BATTLE_5[rand_find];
			
			if(p2_input == 1 && sprite.CHG == 0){
				while(p2_input == 1){
					rand_find = (int) ((Math.random())*9);
					p2_input = BATTLE_5[rand_find];
				}
			}
		}
    	//FINISH GENERATE SPRITE MOVE
		
		//START DISPLAY SPRITE MOVE
		if (p2_input==1){
			sMOVE.setText("Attack");
		}
		else if (p2_input==2){
			sMOVE.setText("Defend");
		}
		else if (p2_input==3){
			sMOVE.setText("Charge");
		}
		//FINISH DISPLAY SPRITE MOVE
		
		//START ALGORITHMS FOR EACH BATTLE SITUATION
		
		if (p1_input == 1){ /*if player 1 wants to attack */ 
			if (p2_input == 1){/* if player 2 wants to attack */
				sprite.HP = sprite.HP - owner.ATK;
				owner.HP = owner.HP - sprite.ATK;
			}
			
			else if (p2_input == 2){ /*if player 2 wants to defend */
				if(owner.ATK <= sprite.DEF){ /*if owner ATK is less than sprite DEF or are the same */
					; //no effect
				}
				else if(owner.ATK > sprite.DEF){ /*if ATK of owner is greater than DEF of sprite*/
					sprite.HP = sprite.HP - (owner.ATK-sprite.DEF);
				}
			}
			
			else if (p2_input == 3){ /*if player 2 wants to charge */
				sprite.CHG++;
				sprite.HP = sprite.HP-owner.ATK;
			}
		}
		
		else if (p1_input == 2){ /*if player 1 wants to defend */
			if(p2_input == 1){ /*if player 2 wants to attack the defending owner */
				if(owner.DEF < sprite.ATK){ //owner defence is less than sprite attack
					owner.HP = owner.HP - (sprite.ATK - owner.DEF);
				}
				if(owner.DEF >= sprite.ATK){ // owner defence is greater than or equal to sprite attack
					; //no effect
				}
			}
			else if(p2_input ==2){/*both parties are defending */
				; //no effect
			}
			else if(p2_input == 3){/*DEF and CHG = same case as previous */
				sprite.CHG++;
			}
		}
		
		else if (p1_input == 3){ //owner wants to charge
			if(p2_input == 1){ //sprite wants to attack
				owner.HP= owner.HP - sprite.ATK;
			}
			if(p2_input == 2){ //sprite wants to defend
				; //no effect
			}
			if(p2_input == 3){ //sprite charges
				sprite.CHG++;
			}
		}
		
		//FINISH ALGORITHMS FOR EACH BATTLE SITUATION
		
		//CHECK IF BATTLE FINISHED
		if(sprite.HP<=0 && owner.HP>0){ //sprite health less than or equal to zero, owner health greater than zero
			Toast.makeText(this, "WINNER!", Toast.LENGTH_SHORT).show();
			WinCount++;
			//RESET STATS
	        owner.HP = 10; 
	    	owner.ATK = 2;
	    	owner.DEF = 3;
	    	owner.LVL = 1;
	    	owner.CHG = 1;
	    	
	    	sprite.HP = 10;
	    	sprite.ATK = 2;
	    	sprite.DEF = 3;
	    	sprite.LVL = 1;
	    	sprite.CHG = 1; 
		}
		else if(sprite.HP>0 && owner.HP<=0){ //sprite health greater than zero and owner health less than or equal to zero
			Toast.makeText(this, "LOSER!", Toast.LENGTH_SHORT).show();
			LoseCount++;
			//RESET STATS
	        owner.HP = 10;
	    	owner.ATK = 2;
	    	owner.DEF = 3;
	    	owner.LVL = 1;
	    	owner.CHG = 1;
	    	
	    	sprite.HP = 10;
	    	sprite.ATK = 2;
	    	sprite.DEF = 3;
	    	sprite.LVL = 1;
	    	sprite.CHG = 1; 
		}
		else if(sprite.HP<=0 && owner.HP<=0){ // owner and sprite health less than and equal to zero
			Toast.makeText(this, "DRAW", Toast.LENGTH_SHORT).show();
			DrawCount++;
			//RESET STATS
	        owner.HP = 10;
	    	owner.ATK = 2;
	    	owner.DEF = 3;
	    	owner.LVL = 1;
	    	owner.CHG = 1;
	    	
	    	sprite.HP = 10;
	    	sprite.ATK = 2;
	    	sprite.DEF = 3;
	    	sprite.LVL = 1;
	    	sprite.CHG = 1; 
		}
    }
    
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		//SAVE DATA
		SharedPreferences.Editor editor = BattleData.edit();
		editor.putInt("Wins", WinCount);
		editor.putInt("Losses", LoseCount);
		editor.putInt("Draws", DrawCount);
		editor.commit();
		
		
	}
}