package star.db;


import star.main.R;
import star.newwords.newwordslist;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class dbhelper extends Activity {
	private SQLiteDatabase mydb=null;
	private final static String DATABASE_NAME="StarWords.db";
	private final static String TABLE_NAME="WordsBook";
	private final static String ID="_id";
	private final static String SPELLING="spelling";
	private final static String MEANING="meaning";	
	private final static String PHONETIC="phonetic";
	private final static String SENTENCE="sentence";
	private final static String DEMO="demo";	
	private final static String CREATE_TABLE="CREATE TABLE "+TABLE_NAME+" ("+ID+" INTEGER PRIMARY KEY,"+ SPELLING+" TEXT,"+MEANING+" TEXT,"+PHONETIC+" TEXT,"+SENTENCE+" TEXT,"+DEMO+" TEXT)";
//	private EditText editText=null;
	private EditText edit1=null;
	private EditText edit2=null;
	private EditText edit3=null;
	private EditText edit4=null;
	private EditText edit5=null;
	
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.wordsbook);


	    Button btn1=(Button)findViewById(R.id.button1);

//	    editText=(EditText)findViewById(R.id.editText1);
	    edit1=(EditText)findViewById(R.id.edit1);
	    edit2=(EditText)findViewById(R.id.edit2);
	    edit3=(EditText)findViewById(R.id.edit3);
	    edit4=(EditText)findViewById(R.id.edit4);
	    edit5=(EditText)findViewById(R.id.edit5);
	    
	    
	    
	    edit1.setText("");
	    edit2.setText("");
	    edit3.setText("");
	    edit4.setText("");
	    edit5.setText("");

	    mydb=openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
	    try
	    {
	    	mydb.execSQL(CREATE_TABLE);
	    }
	    catch(Exception e)
	    {
	    }
	    
	//    showData();
	    
	    mydb.close();
	    
	    btn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mydb=openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
				ContentValues cv=new ContentValues();
				cv.put(SPELLING, edit1.getText().toString());
				cv.put(PHONETIC, edit2.getText().toString());
				cv.put(MEANING, edit3.getText().toString());
				cv.put(SENTENCE, edit4.getText().toString());
				cv.put(DEMO, edit5.getText().toString());
				mydb.insert(TABLE_NAME, null, cv);
	//			showData();
				mydb.close();
			    Toast.makeText(getApplicationContext(), "Length", Toast.LENGTH_LONG).show();
				Intent intent=new Intent(dbhelper.this,newwordslist.class);							//Intent����
				startActivity(intent);								//����
			}
		});
	    
	
	}

/*	public void showData()
	{
	    editText.setText("���ݿ����ݣ�\n");
	    editText.append("����\t\t����\t\t����\t\t����\t\t����\n");
	   
	    Cursor cur=mydb.query(TABLE_NAME, new String[] {ID,SPELLING,MEANING,PHONETIC,SENTENCE,DEMO}, null, null, null, null, null);
	    int count=cur.getCount();
	    if(cur!=null && count>=0)
	    {
	    	if(cur.moveToFirst())
	    	{
	    		do
	    		{
	    			String name=cur.getString(1);
	    			String age=cur.getString(2);
	    			String home=cur.getString(3);
	    			String sentence=cur.getString(4);
	    			String demo=cur.getString(5);	    			
	    			editText.append(""+name+"\t\t"+age+"\t\t"+home+"\t\t"+sentence+"\t\t"+demo+"\n");
	    		}while(cur.moveToNext());
	    	}	
	    }
	}*/


	}