package star.test;

import star.main.R;


import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CET4wordstest extends Activity{
	private final static String DATABASE_NAME="StarWords.db";
	private final static String TABLE_NAME="WordsBookCET4";
	private final static String TABLE_NAME2="WordsBook";
	private final static String ID="_id";
	private final static String SPELLING="spelling";
	private final static String MEANING="meaning";	
	private final static String PHONETIC="phonetic";
	private final static String SENTENCE="sentence";
	private final static String DEMO="demo";
	private final static String CREATE_TABLE="CREATE TABLE "+TABLE_NAME2+" ("+ID+" INTEGER PRIMARY KEY,"+ SPELLING+" TEXT,"+MEANING+" TEXT,"+PHONETIC+" TEXT,"+SENTENCE+" TEXT,"+DEMO+" TEXT)";
	private SQLiteDatabase mydb=null;
	private EditText text1 = null;
	private TextView text2 = null;
	private TextView text3 = null;
	private TextView text4 = null;
    String	spelling2 = null;
    String	meaning2 = null;
    int wordid = 1;
	
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.wordsbooktest);
	    
	    mydb=openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
	    try
	    {
	    	mydb.execSQL(CREATE_TABLE);
	    }
	    catch(Exception e)
	    {
	    }
	    Button btn1=(Button)findViewById(R.id.wordbutton1);
	    Button btn2=(Button)findViewById(R.id.wordbutton2);
	    Button btn3=(Button)findViewById(R.id.wordbutton3);	    
	    Button btn4=(Button)findViewById(R.id.submit);	
	    text1 = (EditText)findViewById(R.id.word1);
	    text2 = (TextView)findViewById(R.id.word2);	
		
	    Bundle bundle = this.getIntent().getExtras();
        //����nameֵ
        String name = bundle.getString("title");
       String content = bundle.getString("content");
      wordid = bundle.getInt("wordid");
      text1.setText("");

   
     
	Cursor cursor = mydb.rawQuery("select * from " + TABLE_NAME + " where _id=?", new String[]{String.valueOf(wordid)});
	if(cursor.moveToFirst()){
		meaning2 = cursor.getString(cursor.getColumnIndex("meaning"));
	}
	
	text2.setText(meaning2);	
	cursor.close(); 
	
// 	text1.setText("ubiquitous");
 // 	text2.setText("adj. �ձ���ڵģ��������ڵ�");
 // 	text3.setText("Taking this one step further, is life also ubiquitous in the multiverse? There are both zero and infinite answers to that question.\n �ɴ˸���һ��˵�������ڶ�Ԫ������Ҳ���ձ���ڵ�����һ�����û�д𰸣�Ҳ���������𰸡�");
 // 	text4.setText("Ubiquitous computing \n���ʼ��� ; ���ڼ��� ; �������ڵļ��� ; �������ڵ�����\n Ubiquitous Player\n �๦�ܲ����� ; ȫ�ܲ����� ; �������ܲ����� ; ���ܲ�����");
      
	  btn4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Cursor cursor = mydb.rawQuery("select * from " + TABLE_NAME + " where _id=?", new String[]{String.valueOf(wordid)});
				if(cursor.moveToFirst()){
			    	spelling2 = cursor.getString(cursor.getColumnIndex("spelling"));
					meaning2 = cursor.getString(cursor.getColumnIndex("meaning"));
				}
				
				String sp = text1.getText().toString();
				if(sp.equals(spelling2))
				{
					wordid = wordid + 1;
					Toast.makeText(getApplicationContext(), "ƴд��ȷ", Toast.LENGTH_SHORT).show();
					text1.setText("");
					Cursor cursor2 = mydb.rawQuery("select * from " + TABLE_NAME + " where _id=?", new String[]{String.valueOf(wordid)});
					if(cursor2.moveToFirst()){
						meaning2 = cursor2.getString(cursor2.getColumnIndex("meaning"));
					}
					
					text2.setText(meaning2);	
					cursor2.close(); 
				} else{
					Toast.makeText(getApplicationContext(), "ƴд����", Toast.LENGTH_SHORT).show();
				}
				
			}
		});
	         
    btn1.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			wordid = wordid -1;
			Cursor cursor = mydb.rawQuery("select * from " + TABLE_NAME + " where _id=?", new String[]{String.valueOf(wordid)});
			if(cursor.moveToFirst()){
				meaning2 = cursor.getString(cursor.getColumnIndex("meaning"));
			}

			text2.setText(meaning2);	
			cursor.close(); 
		}
	});
    
    
    btn2.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Cursor cursor = mydb.rawQuery("select * from " + TABLE_NAME + " where _id=?", new String[]{String.valueOf(wordid)});
			if(cursor.moveToFirst()){			 
			ContentValues cv=new ContentValues();
			cv.put(SPELLING, cursor.getString(cursor.getColumnIndex("spelling")));
			cv.put(MEANING, cursor.getString(cursor.getColumnIndex("meaning")));
			cv.put(PHONETIC, cursor.getString(cursor.getColumnIndex("phonetic")));
			cv.put(SENTENCE, cursor.getString(cursor.getColumnIndex("sentence")));
			cv.put(DEMO, cursor.getString(cursor.getColumnIndex("demo")));
			mydb.insert("wordsbook", null, cv);
			}
			cursor.close();
		Toast.makeText(getApplicationContext(), "��ӳɹ�", Toast.LENGTH_LONG).show();
			
		}
	});
    
    btn3.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			wordid = wordid + 1;
			Cursor cursor = mydb.rawQuery("select * from " + TABLE_NAME + " where _id=?", new String[]{String.valueOf(wordid)});
			if(cursor.moveToFirst()){
				meaning2 = cursor.getString(cursor.getColumnIndex("meaning"));
			}
			
			text2.setText(meaning2);	
			cursor.close(); 
		}
	});    
     }
	
	
}