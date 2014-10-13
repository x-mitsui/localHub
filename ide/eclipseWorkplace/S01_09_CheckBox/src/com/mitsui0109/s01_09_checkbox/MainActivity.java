package com.mitsui0109.s01_09_checkbox;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;


public class MainActivity extends ActionBarActivity {

	private CheckBox EatBox;
	private CheckBox SleepBox;
	private CheckBox DotaBox;
	private CheckBox AllBox;
	private boolean AllChecked;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        AllChecked = false;
        		
        EatBox = (CheckBox)findViewById(R.id.EAT_ID);
        SleepBox = (CheckBox)findViewById(R.id.SLEEP_ID);
        DotaBox = (CheckBox)findViewById(R.id.DOTA_ID);
        AllBox = (CheckBox)findViewById(R.id.ALL_ID);
        
        OnCheckBoxClickListener onCheckBoxClickListener = new OnCheckBoxClickListener();
        EatBox.setOnCheckedChangeListener(onCheckBoxClickListener);
        SleepBox.setOnCheckedChangeListener(onCheckBoxClickListener);
        DotaBox.setOnCheckedChangeListener(onCheckBoxClickListener);
        AllBox.setOnCheckedChangeListener(onCheckBoxClickListener);
        
 /*     //OnClickListener的使用方法
        OnBoxClickListener onBoxClickListener = new OnBoxClickListener();
        EatBox.setOnClickListener(onBoxClickListener);
        SleepBox.setOnClickListener(onBoxClickListener);
        DotaBox.setOnClickListener(onBoxClickListener);*/

    }

    class OnCheckBoxClickListener implements OnCheckedChangeListener
    {
    	@Override
    	public void onCheckedChanged(CompoundButton buttonView,//CheckBox是CompoundButton子类
    			boolean isChecked) {
    		
    		CheckBox box = (CheckBox)buttonView;
    		switch(box.getId())
    		{
    		case R.id.EAT_ID:
    			System.out.println("吃饭");
    			
    			break;
    		case R.id.SLEEP_ID:
    			System.out.println("睡觉");
    			
    			break;
    		case R.id.DOTA_ID:
    			System.out.println("Dota");
    			break;
    		case R.id.ALL_ID:
    			
    			EatBox.setChecked(isChecked);
    			SleepBox.setChecked(isChecked);
    			DotaBox.setChecked(isChecked);
    				
    			System.out.println("All");
    			break;
    		default:
    			
    		}
    		if(isChecked)
    			System.out.println("按下");
    		else
    		{
    			System.out.println("取消");
    		}
    	}
    }
    
/*  //OnClickListener的使用方法
    class OnBoxClickListener implements OnClickListener
    {
    	@Override
    	public void onClick(View v) {
    		// TODO Auto-generated method stub
    		CheckBox Box = (CheckBox)v;
    		System.out.println(Box.getText());//也可以通过View.getID() switch判断
    		if(Box.isChecked())
    			System.out.println("被选中了");
    		else
    		{
    			System.out.println("取消选中");
    		}
    	}
    }*/
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
