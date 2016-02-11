package star.main;

import star.booklist.CET4;

import star.booklist.CET4review;
import star.booklist.USER1;
import star.service.addbookuser1;
import star.view.WordsBookView;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class booklistreview extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booklist);
        
        
	    Button btn1=(Button)findViewById(R.id.button1);
	    btn1.setOnClickListener(new View.OnClickListener() {			//���ü�����			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			//	ComponentName componentName=new ComponentName("star.services","star.services.wordslist");
				Intent intent=new Intent(booklistreview.this,CET4review.class);
				startActivity(intent);
			}
		});
	    
	    
	    Button btn2=(Button)findViewById(R.id.button2);
	    btn2.setOnClickListener(new View.OnClickListener() {			//���ü�����			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			//	ComponentName componentName=new ComponentName("star.services","star.services.wordslist");
				Intent intent=new Intent(booklistreview.this,CET4review.class);
				startActivity(intent);
			}
		});
	    
        
        
        
	    Button btn3=(Button)findViewById(R.id.button3);
	    btn3.setOnClickListener(new View.OnClickListener() {			//���ü�����			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			//	ComponentName componentName=new ComponentName("star.services","star.services.wordslist");
				Intent intent=new Intent(booklistreview.this,CET4review.class);
				startActivity(intent);
			}
		});
	    
	    Button btn4=(Button)findViewById(R.id.button4);
	    btn4.setOnClickListener(new View.OnClickListener() {			//���ü�����			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			//	ComponentName componentName=new ComponentName("star.services","star.services.wordslist");
				Intent intent=new Intent(booklistreview.this,CET4review.class);
				startActivity(intent);
			}
		});
	    
	    Button btn5=(Button)findViewById(R.id.button5);
	    btn5.setOnClickListener(new View.OnClickListener() {			//���ü�����			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			//	ComponentName componentName=new ComponentName("star.services","star.services.wordslist");
				Intent intent=new Intent(booklistreview.this,CET4review.class);
				startActivity(intent);
			}
		});
	    
	    Button btn6=(Button)findViewById(R.id.button6);
	    btn6.setOnClickListener(new View.OnClickListener() {			//���ü�����			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			//	ComponentName componentName=new ComponentName("star.services","star.services.wordslist");
				Intent intent=new Intent(booklistreview.this,CET4review.class);
				startActivity(intent);
			}
		});    
	    
}   	
}
