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
        
        
	    Button btn1=(Button)findViewById(R.id.button1);				//����ѧϰactivity
	    btn1.setOnClickListener(new View.OnClickListener() {			//���ü�����			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			//	ComponentName componentName=new ComponentName("star.services","star.services.wordslist");			//�������
				Intent intent=new Intent(testbooklist.this,CET4test.class);							//Intent����
				startActivity(intent);								//����
			}
		});
	    
	    
	    Button btn2=(Button)findViewById(R.id.button2);				//���ʸ�ϰactivity
	    btn2.setOnClickListener(new View.OnClickListener() {			//���ü�����			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			//	ComponentName componentName=new ComponentName("star.services","star.services.wordslist");			//�������
				Intent intent=new Intent(testbooklist.this,CET4test.class);							//Intent����
				startActivity(intent);								//����
			}
		});
	    
        
        
        
	    Button btn3=(Button)findViewById(R.id.button3);				//���ʲ���activity
	    btn3.setOnClickListener(new View.OnClickListener() {			//���ü�����			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			//	ComponentName componentName=new ComponentName("star.services","star.services.wordslist");			//�������
				Intent intent=new Intent(testbooklist.this,CET4test.class);							//Intent����
				startActivity(intent);								//����
			}
		});
	    
	    Button btn4=(Button)findViewById(R.id.button4);				//���ʱ�activity
	    btn4.setOnClickListener(new View.OnClickListener() {			//���ü�����			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			//	ComponentName componentName=new ComponentName("star.services","star.services.wordslist");			//�������
				Intent intent=new Intent(testbooklist.this,CET4test.class);							//Intent����
				startActivity(intent);								//����
			}
		});
	    
	    Button btn5=(Button)findViewById(R.id.button5);				//����ѧϰactivity
	    btn5.setOnClickListener(new View.OnClickListener() {			//���ü�����			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			//	ComponentName componentName=new ComponentName("star.services","star.services.wordslist");			//�������
				Intent intent=new Intent(testbooklist.this,CET4test.class);							//Intent����
				startActivity(intent);								//����
			}
		});
	    
	    Button btn6=(Button)findViewById(R.id.button6);				//����ѧϰactivity
	    btn6.setOnClickListener(new View.OnClickListener() {			//���ü�����			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			//	ComponentName componentName=new ComponentName("star.services","star.services.wordslist");			//�������
				Intent intent=new Intent(testbooklist.this,CET4test.class);							//Intent����
				startActivity(intent);								//����
			}
		});    
	    
}   	
}