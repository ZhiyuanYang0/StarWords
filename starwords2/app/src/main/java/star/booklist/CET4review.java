package star.booklist;

import java.util.ArrayList;


import java.util.HashMap;

import star.main.MainActivity;
import star.main.booklist;
import star.view.WordsBookReview;
import star.view.WordsBookView;

import android.app.ListActivity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;


public class CET4review extends ListActivity {	

	private final static String TABLE_NAME="WordsBookCET4list";
	private final static String DATABASE_NAME="StarWords.db";
	private final static String ID="_id";
	private final static String SPELLING="spelling";
	private final static String MEANING="meaning";	
	private final static String PHONETIC="phonetic";
	private final static String SENTENCE="sentence";
	private final static String DEMO="demo";	
    private final static String CREATE_TABLE="CREATE TABLE "+TABLE_NAME+" ("+ID+" INTEGER PRIMARY KEY,"+ SPELLING+" TEXT,"+MEANING+" TEXT,"+PHONETIC+" TEXT,"+SENTENCE+" TEXT,"+DEMO+" TEXT)";
	private SQLiteDatabase mydb=null;
    ListView mListView = null;  
    ArrayList<HashMap<String, Object>> mData= new ArrayList<HashMap<String,Object>>();;  

 
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
    	super.onCreate(savedInstanceState);
    mListView = getListView();  
    mydb=openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);

		Cursor c = mydb.rawQuery("select * from " + TABLE_NAME, null);
		int columnsSize = c.getColumnCount();
		mData = new ArrayList<HashMap<String, Object>>();

		while (c.moveToNext()) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			for (int i = 0; i < columnsSize; i++) {
				map.put("id", c.getString(0));
				map.put("spelling", c.getString(1));
			}
			mData.add(map);
		}
  
		
    SimpleAdapter adapter = new SimpleAdapter(this,mData,android.R.layout.simple_list_item_1,  
        new String[]{"spelling"},new int[]{android.R.id.text1});  
        setListAdapter(adapter);  
      

        mListView.setOnItemClickListener(new OnItemClickListener(){   
            @Override   
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,   
                    long arg3) {   

                HashMap<String,String> map=(HashMap<String,String>)mListView.getItemAtPosition(arg2);   
                String title=map.get("spelling");   
     		
     
               
				Intent intent=new Intent(CET4review.this,WordsBookReview.class);	//Intent����
				Bundle bundle=new Bundle(); 	    
	     	    bundle.putInt("List", arg2+1);
	     	    intent.putExtras(bundle);
				startActivity(intent);	
                         
            }   
               
        }); 

    }  
} 