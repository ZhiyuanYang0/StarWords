package star.main;

import android.app.Activity;


import android.os.Bundle;




import star.db.dbhelper;
import star.newwords.newwordslist;
import star.service.addbook;
import star.test.testbooklist;
import star.view.WordsBookView;
import star.view.listview;
import star.view.word;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        
	    Button btn1=(Button)findViewById(R.id.button1);
	    btn1.setOnClickListener(new View.OnClickListener() {			//���ü�����			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			//	ComponentName componentName=new ComponentName("star.services","star.services.wordslist");
				Intent intent=new Intent(MainActivity.this,booklist.class);
				startActivity(intent);
			}
		});
	    
	    
	    Button btn2=(Button)findViewById(R.id.button2);
	    btn2.setOnClickListener(new View.OnClickListener() {			//���ü�����			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			//	ComponentName componentName=new ComponentName("star.services","star.services.wordslist");
				Intent intent=new Intent(MainActivity.this,booklistreview.class);
				startActivity(intent);
			}
		});
	     
        
        
        
	    Button btn3=(Button)findViewById(R.id.button3);
	    btn3.setOnClickListener(new View.OnClickListener() {			//���ü�����			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			//	ComponentName componentName=new ComponentName("star.services","star.services.wordslist");
				Intent intent=new Intent(MainActivity.this,testbooklist.class);
				startActivity(intent);
			}
		});
	    
	    Button btn4=(Button)findViewById(R.id.button4);
	    btn4.setOnClickListener(new View.OnClickListener() {			//���ü�����			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			//	ComponentName componentName=new ComponentName("star.services","star.services.wordslist");
				Intent intent=new Intent(MainActivity.this,newwordslist.class);
				startActivity(intent);
			}
		});
}
}