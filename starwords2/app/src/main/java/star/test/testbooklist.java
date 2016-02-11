package star.test;

import star.booklist.CET4;

import star.booklist.CET4review;
import star.booklist.CET4test;
import star.booklist.USER1;
import star.main.R;
import star.service.addbookuser1;
import star.view.WordsBookView;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class testbooklist extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booklist);
        
        
	    Button btn1=(Button)findViewById(R.id.button1);				//单词学习activity
	    btn1.setOnClickListener(new View.OnClickListener() {			//设置监听器			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			//	ComponentName componentName=new ComponentName("star.services","star.services.wordslist");			//组件名称
				Intent intent=new Intent(testbooklist.this,CET4test.class);							//Intent对象
				startActivity(intent);								//启动
			}
		});
	    
	    
	    Button btn2=(Button)findViewById(R.id.button2);				//单词复习activity
	    btn2.setOnClickListener(new View.OnClickListener() {			//设置监听器			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			//	ComponentName componentName=new ComponentName("star.services","star.services.wordslist");			//组件名称
				Intent intent=new Intent(testbooklist.this,CET4test.class);							//Intent对象
				startActivity(intent);								//启动
			}
		});
	    
        
        
        
	    Button btn3=(Button)findViewById(R.id.button3);				//单词测试activity
	    btn3.setOnClickListener(new View.OnClickListener() {			//设置监听器			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			//	ComponentName componentName=new ComponentName("star.services","star.services.wordslist");			//组件名称
				Intent intent=new Intent(testbooklist.this,CET4test.class);							//Intent对象
				startActivity(intent);								//启动
			}
		});
	    
	    Button btn4=(Button)findViewById(R.id.button4);				//生词本activity
	    btn4.setOnClickListener(new View.OnClickListener() {			//设置监听器			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			//	ComponentName componentName=new ComponentName("star.services","star.services.wordslist");			//组件名称
				Intent intent=new Intent(testbooklist.this,CET4test.class);							//Intent对象
				startActivity(intent);								//启动
			}
		});
	    
	    Button btn5=(Button)findViewById(R.id.button5);				//单词学习activity
	    btn5.setOnClickListener(new View.OnClickListener() {			//设置监听器			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			//	ComponentName componentName=new ComponentName("star.services","star.services.wordslist");			//组件名称
				Intent intent=new Intent(testbooklist.this,CET4test.class);							//Intent对象
				startActivity(intent);								//启动
			}
		});
	    
	    Button btn6=(Button)findViewById(R.id.button6);				//单词学习activity
	    btn6.setOnClickListener(new View.OnClickListener() {			//设置监听器			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			//	ComponentName componentName=new ComponentName("star.services","star.services.wordslist");			//组件名称
				Intent intent=new Intent(testbooklist.this,CET4test.class);							//Intent对象
				startActivity(intent);								//启动
			}
		});    
	    
}   	
}