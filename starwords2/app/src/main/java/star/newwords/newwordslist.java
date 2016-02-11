package star.newwords;




import java.util.ArrayList;


import java.util.HashMap;


import star.db.dbhelper;
import star.main.MainActivity;
import star.main.R;
import star.main.booklist;
import star.service.addbookuser1;
import android.R.integer;
import android.app.ListActivity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class newwordslist extends ListActivity {	
    int List;
	private final static String TABLE_NAME="WordsBook";
	private final static String DATABASE_NAME="StarWords.db";
	private final static String ID="_id";
	private final static String SPELLING="spelling";
	private final static String MEANING="meaning";	
	private final static String PHONETIC="phonetic";
	private final static String SENTENCE="sentence";
	private final static String DEMO="demo";	
    private final static String CREATE_TABLE="CREATE TABLE "+TABLE_NAME+"" +
    		" ("+ID+" INTEGER PRIMARY KEY,"+ SPELLING+" TEXT,"+MEANING+"" +
    				" TEXT,"+PHONETIC+" TEXT,"+SENTENCE+" TEXT,"+DEMO+" TEXT)";
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
    
    

  
		Cursor c = mydb.rawQuery("select * from " + TABLE_NAME, null);
		int columnsSize = c.getColumnCount();
		mData = new ArrayList<HashMap<String, Object>>();

		while (c.moveToNext()) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			for (int i = 0; i < columnsSize; i++) {
				map.put("id", c.getString(0));
				map.put("spelling", c.getString(1));
				map.put("meaning", c.getString(2));
				map.put("sentence", c.getString(3));
			}
		    
			mData.add(map);

		}
	
   
		
    SimpleAdapter adapter = new SimpleAdapter(this,mData,android.R.layout.simple_list_item_2,  
        new String[]{"spelling","meaning"},new int[]{android.R.id.text1,android.R.id.text2});  
        setListAdapter(adapter);  
      

        mListView.setOnItemClickListener(new OnItemClickListener(){   
            @Override   
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,   
                    long arg3) {   

                HashMap<String,String> map=(HashMap<String,String>)mListView.getItemAtPosition(arg2);   
                String title=map.get("spelling");   
                String content=map.get("meaning");  

           		
       
            Intent intent=new Intent(newwordslist.this,newwords.class);
      	    Bundle bundle=new Bundle(); 	    
    	    bundle.putString("title", title);
     	    bundle.putString("content", content);
     	    bundle.putInt("wordid", arg2+1);
     	    intent.putExtras(bundle);
            startActivity(intent);	
               
            }   
               
        }); 
    }  
    
    
    public boolean onCreateOptionsMenu(Menu menu) {
    	// TODO Auto-generated method stub
    	menu.add(0,1,1,"new");
    	return super.onCreateOptionsMenu(menu);
    }
    
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		if(item.getItemId()==1)
		{
			Intent intent=new Intent(newwordslist.this,dbhelper.class);
			startActivity(intent);
		}

		return super.onOptionsItemSelected(item);
	}
} 