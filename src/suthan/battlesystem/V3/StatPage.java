package suthan.battlesystem.V3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StatPage extends Activity{
	TextView Win, Lose, Draw;
	Button resetB;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.stats);
		
		//Declare each button + textview, and set each text's value
        Win = (TextView) findViewById(R.id.tWin);
        Win.setText("Wins: " + BattleSystemV3Activity.WinCount);
        Lose = (TextView) findViewById(R.id.tLose);
        Lose.setText("Losses: " + BattleSystemV3Activity.LoseCount);
        Draw = (TextView) findViewById(R.id.tDraw);
        Draw.setText("Draws: " + BattleSystemV3Activity.DrawCount);
        
        resetB = (Button) findViewById(R.id.bReset);
        
        //RESET STATS
        resetB.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				BattleSystemV3Activity.WinCount = 0;
				BattleSystemV3Activity.LoseCount = 0;
				BattleSystemV3Activity.DrawCount = 0;
		        Win.setText("Wins: " + BattleSystemV3Activity.WinCount);
		        Lose.setText("Losses: " + BattleSystemV3Activity.LoseCount);
		        Draw.setText("Draws: " + BattleSystemV3Activity.DrawCount);
			}
		}); 	
		
	}

}
