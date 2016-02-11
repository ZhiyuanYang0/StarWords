package star.view;



import java.util.ArrayList;

import java.util.HashMap;


import star.main.MainActivity;
import star.main.R;
import android.app.ListActivity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class listview extends ListActivity {	
    long result;
	private final static String TABLE_NAME="cet4list";
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
    try
    {
    	mydb.execSQL(CREATE_TABLE);
    }
    catch(Exception e)
    {
    }
    
    
	Cursor cursor = mydb.query(ID, new String[]{"count(*)"}, null, null, null, null, null);
	cursor.moveToFirst();
	 result = cursor.getLong(0);
	cursor.close();
	System.out.println(result);
	
    
	ContentValues values = new ContentValues();
	values.put("spelling", "abandon");
	mydb.insert(TABLE_NAME, null, values);

	values.put("spelling", "List2");
	mydb.insert(TABLE_NAME, null, values);
	
	values.put("spelling", "List3");
	mydb.insert(TABLE_NAME, null, values);

	values.put("spelling", "List4");
	mydb.insert(TABLE_NAME, null, values);

	values.put("spelling", "List5");
	mydb.insert(TABLE_NAME, null, values);
	
	values.put("spelling", "List6");
	mydb.insert(TABLE_NAME, null, values);
	values.put("spelling", "List7");
	mydb.insert(TABLE_NAME, null, values);

	values.put("spelling", "List8");
	mydb.insert(TABLE_NAME, null, values);
	
	values.put("spelling", "List9");
	mydb.insert(TABLE_NAME, null, values);
	values.put("spelling", "List10");
	mydb.insert(TABLE_NAME, null, values);

	values.put("spelling", "List11");
	mydb.insert(TABLE_NAME, null, values);
	
	values.put("spelling", "List12");
	mydb.insert(TABLE_NAME, null, values);

  //  int lengh = bspelling.length;  
 //   for(int i =0; i < lengh; i++) {  
 //       Map<String,Object> item = new HashMap<String,Object>();  
 //       item.put("spelling", bspelling[i]);  
 //       item.put("meaning", bmeaning[i]);  
  //      mData.add((HashMap<String, Object>) item);         
 //   }  
    
  
		Cursor c = mydb.rawQuery("select * from " + TABLE_NAME, null);
		int columnsSize = c.getColumnCount();
		mData = new ArrayList<HashMap<String, Object>>();
		// 获取表的内容
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
      
        //添加点击事件   
        mListView.setOnItemClickListener(new OnItemClickListener(){   
            @Override   
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,   
                    long arg3) {   
                //获得选中项的HashMap对象  
                HashMap<String,String> map=(HashMap<String,String>)mListView.getItemAtPosition(arg2);   
                String title=map.get("spelling");   
     		
      
            }   
               
        }); 

    }  
} 