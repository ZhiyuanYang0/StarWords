package star.main;

import star.booklist.CET4;
import star.booklist.USER1;
import star.service.addbook;
import star.service.addbookuser1;
import star.view.WordsBookView;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class booklist extends Activity {
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
				Intent intent=new Intent(booklist.this,CET4.class);
				startActivity(intent);
			}
		});
	    
	    
	    Button btn2=(Button)findViewById(R.id.button2);
	    btn2.setOnClickListener(new View.OnClickListener() {			//���ü�����			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			//	ComponentName componentName=new ComponentName("star.services","star.services.wordslist");
				Intent intent=new Intent(booklist.this,CET4.class);
				startActivity(intent);
			}
		});
	    
        
        
        
	    Button btn3=(Button)findViewById(R.id.button3);
	    btn3.setOnClickListener(new View.OnClickListener() {			//���ü�����			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			//	ComponentName componentName=new ComponentName("star.services","star.services.wordslist");
				Intent intent=new Intent(booklist.this,CET4.class);
				startActivity(intent);
			}
		});
	    
	    Button btn4=(Button)findViewById(R.id.button4);
	    btn4.setOnClickListener(new View.OnClickListener() {			//���ü�����			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			//	ComponentName componentName=new ComponentName("star.services","star.services.wordslist");			//�������
				Intent intent=new Intent(booklist.this,CET4.class);							//Intent����
				startActivity(intent);
			}
		});
	    
	    Button btn5=(Button)findViewById(R.id.button5);
	    btn5.setOnClickListener(new View.OnClickListener() {			//���ü�����			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			//	ComponentName componentName=new ComponentName("star.services","star.services.wordslist");			//�������
				Intent intent=new Intent(booklist.this,USER1.class);							//Intent����
				startActivity(intent);
			}
		});
	    
	    Button btn6=(Button)findViewById(R.id.button6);
	    btn6.setOnClickListener(new View.OnClickListener() {			//���ü�����			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			//	ComponentName componentName=new ComponentName("star.services","star.services.wordslist");			//�������
				Intent intent=new Intent(booklist.this,WordsBookView.class);							//Intent����
				startActivity(intent);
			}
		});    
	    
}
    
    public boolean onCreateOptionsMenu(Menu menu) {
    	// TODO Auto-generated method stub
    	menu.add(0,1,1,"����û��ʱ�1");
    	menu.add(0,2,2,"����û��ʱ�2");
    	return super.onCreateOptionsMenu(menu);
    }
    
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		if(item.getItemId()==1)
		{
			Intent intent=new Intent(booklist.this,addbookuser1.class);
			startActivity(intent);
		}
		else if(item.getItemId()==2)
		{
			Intent intent=new Intent(booklist.this,addbook.class);
			startActivity(intent);
		}
		return super.onOptionsItemSelected(item);
	}
	
}
