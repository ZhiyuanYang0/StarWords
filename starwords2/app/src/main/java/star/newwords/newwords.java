package star.newwords;

import star.main.MainActivity;
import star.main.R;
import star.main.booklist;
import star.service.addbookuser1;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class newwords extends Activity{
	private final static String DATABASE_NAME="StarWords.db";
	private final static String TABLE_NAME="WordsBook";
	private final static String ID="_id";
	private final static String SPELLING="spelling";
	private final static String MEANING="meaning";	
	private final static String PHONETIC="phonetic";
	private final static String SENTENCE="sentence";
	private final static String DEMO="demo";
	private SQLiteDatabase mydb=null;
	private TextView text1 = null;
	private TextView text2 = null;
	private TextView text3 = null;
	private TextView text4 = null;
    String	spelling2 = null;
    String	meaning2 = null;
    String	meaning3 = null;
    int wordid = 1;
	
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.wordsbookview);
	    
	    
	    mydb=openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);

	    Button btn1=(Button)findViewById(R.id.wordbutton1);
	    Button btn2=(Button)findViewById(R.id.wordbutton2);
	    Button btn3=(Button)findViewById(R.id.wordbutton3);	    
	    text1 = (TextView)findViewById(R.id.word1);
	    text2 = (TextView)findViewById(R.id.word2);	
	    text3 = (TextView)findViewById(R.id.word3);
	    text4 = (TextView)findViewById(R.id.word4);			
	    Bundle bundle = this.getIntent().getExtras();

        String name = bundle.getString("title");
       String content = bundle.getString("content");
      wordid = bundle.getInt("wordid");


   
     
	Cursor cursor = mydb.rawQuery("select * from " + TABLE_NAME + " where _id=?", new String[]{String.valueOf(wordid)});
	if(cursor.moveToFirst()){
    	spelling2 = cursor.getString(cursor.getColumnIndex("spelling"));
		meaning2 = cursor.getString(cursor.getColumnIndex("meaning"));
		meaning3 = cursor.getString(cursor.getColumnIndex(SENTENCE));
	}
	
	text1.setText(spelling2);
	text2.setText(meaning2);
	text3.setText(meaning3);
	cursor.close(); 

    btn1.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			wordid = wordid -1;
			Cursor cursor = mydb.rawQuery("select * from " + TABLE_NAME + " where _id=?", new String[]{String.valueOf(wordid)});
			if(cursor.moveToFirst()){
		    	spelling2 = cursor.getString(cursor.getColumnIndex("spelling"));
				meaning2 = cursor.getString(cursor.getColumnIndex("meaning"));
				meaning3 = cursor.getString(cursor.getColumnIndex(SENTENCE));
			}
			
			text1.setText(spelling2);
			text2.setText(meaning2);
			text3.setText(meaning3);
			cursor.close(); 
		}
	});
    
    
    btn2.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Cursor cursor = mydb.rawQuery("select * from " + TABLE_NAME + " where _id=?", new String[]{String.valueOf(wordid)});
			mydb.delete("WordsBook", "_id=?", new String[]{String.valueOf(wordid)});
			cursor.close();
			Toast.makeText(getApplicationContext(), "Context", Toast.LENGTH_LONG).show();
			Intent intent=new Intent(newwords.this,newwordslist.class);
			startActivity(intent);
		}
	});
    
    btn3.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			wordid = wordid + 1;
			Cursor cursor = mydb.rawQuery("select * from " + TABLE_NAME + " where _id=?", new String[]{String.valueOf(wordid)});
			if(cursor.moveToFirst()){
		    	spelling2 = cursor.getString(cursor.getColumnIndex("spelling"));
				meaning2 = cursor.getString(cursor.getColumnIndex("meaning"));
				meaning3 = cursor.getString(cursor.getColumnIndex(SENTENCE));
			}
			
			text1.setText(spelling2);
			text2.setText(meaning2);
			text3.setText(meaning3);
			cursor.close(); 
		}
	});    
     }
	
    public boolean onCreateOptionsMenu(Menu menu) {			//����onCreateOptionsMenu����
    	// TODO Auto-generated method stub
    	menu.add(0,1,1,"��������");								//��Ӳ˵�1
    	menu.add(0,2,2,"��ʾ����");								//��Ӳ˵�2
    	return super.onCreateOptionsMenu(menu);
    }
    
	public boolean onOptionsItemSelected(MenuItem item) {			//����onOptionsItemSelected����
		// TODO Auto-generated method stub
		
		if(item.getItemId()==1)								//���itemIdΪ1
		{
				text2.setVisibility(View.INVISIBLE);
				text3.setVisibility(View.INVISIBLE);
			    Toast.makeText(getApplicationContext(), "����������", Toast.LENGTH_LONG).show();
		}
		else if(item.getItemId()==2)							//���itemIdΪ2
		{
                text2.setVisibility(View.VISIBLE);
                text3.setVisibility(View.VISIBLE);
                Toast.makeText(getApplicationContext(), "����ʾ����", Toast.LENGTH_LONG).show();
		}
		return super.onOptionsItemSelected(item);
	}
}