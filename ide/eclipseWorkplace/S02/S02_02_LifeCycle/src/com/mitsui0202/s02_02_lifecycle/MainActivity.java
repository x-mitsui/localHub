package com.mitsui0202.s02_02_lifecycle;



import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

	private Button btn;
	//在Activity第一次被创建时调用
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);
        
        btn=(Button)findViewById(R.id.button1);
        
        
        OnclickListener onclickLisener =new OnclickListener();
        btn.setOnClickListener(onclickLisener);
        
        System.out.println("xxx___MainActivity onCreate !-->在Activity第一次被创建时");
        
        
    }
    
    //当Activity变得可见时调用这个函数
    @Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
        System.out.println("xxx___MainActivity onStart !-->当Activity变得可见时");

	}

    //当Activity准备与用户交互时调用这个函数
    @Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
        System.out.println("xxx___MainActivity onResume !-->当Activity准备与用户交互时");

	}

    //当系统即将启动另一个Activity时调用这个函数
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
        System.out.println("xxx___MainActivity onPause !-->当系统即将启动另一个Activity时");

	}

	//当前Activity变得不可见时调用这个函数
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
        System.out.println("xxx___MainActivity onStop !-->当前Activity变得不可见时");

	}

	//当前Activity被销毁之前调用这个函数
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
        System.out.println("xxx___MainActivity onDestroy !-->当前Activity被销毁之前");

	}
	
	//当这个Activity再次启用之前调用这个函数
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
        System.out.println("xxx___MainActivity onRestart !-->这个Activity再次启用");

	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

	
	 class OnclickListener implements OnClickListener
	    {
	    	@Override
	    	public void onClick(View v) {
	    		// TODO Auto-generated method stub
	    		Intent intent =new Intent();
	    		
	    		//intent.setClass(packageContext, cls)
	    		//参数一是Context类，Activity是Context类的子类
	    		//第一参数不能写this，因为它代表OnclickListener的对象
	    		intent.setClass(MainActivity.this, OtherActivity.class);
	    		startActivity(intent);
	    	}
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
