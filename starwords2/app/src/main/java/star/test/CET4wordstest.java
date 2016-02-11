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
        //接收name值
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
 // 	text2.setText("adj. 普遍存在的；无所不在的");
 // 	text3.setText("Taking this one step further, is life also ubiquitous in the multiverse? There are both zero and infinite answers to that question.\n 由此更进一步说，生命在多元宇宙中也是普遍存在的吗？这一问题既没有答案，也有无穷多个答案。");
 // 	text4.setText("Ubiquitous computing \n普适计算 ; 泛在计算 ; 无所不在的计算 ; 无所不在的运算\n Ubiquitous Player\n 多功能播放器 ; 全能播放器 ; 无所不能播放器 ; 万能播放器");
      
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
					Toast.makeText(getApplicationContext(), "拼写正确", Toast.LENGTH_SHORT).show();
					text1.setText("");
					Cursor cursor2 = mydb.rawQuery("select * from " + TABLE_NAME + " where _id=?", new String[]{String.valueOf(wordid)});
					if(cursor2.moveToFirst()){
						meaning2 = cursor2.getString(cursor2.getColumnIndex("meaning"));
					}
					
					text2.setText(meaning2);	
					cursor2.close(); 
				} else{
					Toast.makeText(getApplicationContext(), "拼写错误", Toast.LENGTH_SHORT).show();
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
		Toast.makeText(getApplicationContext(), "添加成功", Toast.LENGTH_LONG).show();
			
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