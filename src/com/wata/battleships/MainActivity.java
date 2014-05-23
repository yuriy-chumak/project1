package com.wata.battleships;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	BaseLogic logic = new BaseLogic();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		((Button)findViewById(R.id.button1)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				logic.Send(new UIMessage(MainActivity.this) {
					@Override
					public void HandleResult() {
				    	((TextView)findViewById(R.id.textView1)).setText("asasas");
					}
				});
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}