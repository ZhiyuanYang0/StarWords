package star.service;



import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.http.util.EncodingUtils;

import star.main.MainActivity;
import star.main.R;
import star.main.booklistreview;


import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

public class addbookuser1 extends Activity {
	private SQLiteDatabase mydb=null;
	private final static String DATABASE_NAME="StarWords.db";
	private final static String TABLE_NAME="WordsBookuser1";
	private final static String TABLE_NAME2="WordsBookuser1list";	
	private final static String ID="_id";
	private final static String SPELLING="spelling";
	private final static String MEANING="meaning";	
	private final static String PHONETIC="phonetic";
	private final static String SENTENCE="sentence";
	private final static String DEMO="demo";	
	private final static String CREATE_TABLE="CREATE TABLE "+TABLE_NAME+" ("+ID+" INTEGER PRIMARY KEY,"+ SPELLING+" TEXT,"+MEANING+" TEXT,"+PHONETIC+" TEXT,"+SENTENCE+" TEXT,"+DEMO+" TEXT)";
	private final static String CREATE_TABLE2="CREATE TABLE "+TABLE_NAME2+" ("+ID+" INTEGER PRIMARY KEY,"+ SPELLING+" TEXT,"+MEANING+" TEXT,"+PHONETIC+" TEXT,"+SENTENCE+" TEXT,"+DEMO+" TEXT)";

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        
	    mydb=openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
	    try
	    {
	    	mydb.execSQL(CREATE_TABLE);
	    	mydb.execSQL(CREATE_TABLE2);
	    	
	    }
	    catch(Exception e)
	    {
	    }
	    
        
        String word1 = "";
        word1 = readFileData("user1.txt");
        int len = word1.length();

        int j = 0;
        int t1 = 0;
    	for(j=0;j<len;j++)
    	{
    		char c1 = word1.charAt(j);
    		if(c1==10){
    			for(int x=t1;x<j;x++)
    			{
    				char c2 = word1.charAt(x);
    				if(c2==32)
    				{    			
    					ContentValues cv=new ContentValues();
    					cv.put(SPELLING, word1.substring(t1,x));
    					String s2 = word1.substring(x+1,j);
    					cv.put(MEANING, s2);
    					mydb.insert(TABLE_NAME, null, cv);
    					break;
    				}
    			}
    			t1=j+1;    
    		}
    	}	    
    	
        Cursor cursor = mydb.rawQuery("select count(*) from WordsBookuser1", null);
    	cursor.moveToFirst();
    	long result = cursor.getLong(0);
    	cursor.close();
    	
        long listnumber = result/30+1;
      
        if(listnumber>1){
        for(int i=1;i<=listnumber;i++)
        {
        	  ContentValues values = new ContentValues();
        	  String t = "List" + String.valueOf(i);
        	  values.put("spelling", t);
        	  mydb.insert(TABLE_NAME2, null, values);
        }
      
       Toast.makeText(getApplicationContext(), "导入成功", Toast.LENGTH_LONG).show();
        }
		Intent intent=new Intent(addbookuser1.this,booklistreview.class);							//Intent对象
		startActivity(intent);								//启动

 //       writeFileData("CET4-2.txt", word1);
    }
    
    
	//读取文本文件中的内容
	   public String readFileData(String fileName){ 

	        String res=""; 

	        try{ 

	         FileInputStream fin = openFileInput(fileName); 

	         int length = fin.available(); 

	         byte [] buffer = new byte[length]; 

	         fin.read(buffer);     

	         res = EncodingUtils.getString(buffer, "UTF-8"); 

	         fin.close();     

	        } 

	        catch(Exception e){ 

	         e.printStackTrace(); 

	        } 

	        return res; 

	    }   
    
    public void writeFileData(String fileName,String message){ 

        try{ 

         FileOutputStream fout =openFileOutput(fileName, MODE_PRIVATE);

         byte [] bytes = message.getBytes(); 

         fout.write(bytes); 

          fout.close(); 

         } 

        catch(Exception e){ 

         e.printStackTrace(); 

        } 

    }
    

	
}
