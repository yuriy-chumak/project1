package com.wata.battleships;

import android.app.Activity;

public abstract class UIMessage implements Message
{
	private Activity activity;
	public UIMessage(Activity activity)
	{
		this.activity = activity;
	}
	
	public void Handle()
	{
		activity.runOnUiThread(new Runnable(){
		    public void run(){
		    	HandleResult();
		    }
		});
	}
	
	public abstract void HandleResult();
}