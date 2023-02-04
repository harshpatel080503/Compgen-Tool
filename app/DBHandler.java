
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DBHandler {
    private static final String DB_NAME = "Compgen";
    //Compgen - Database name
    private static final int DB_VERSION = 1;
    //database version 1
    private static final String TABLE_NAME = "product1";
    //product1 - table name
    private static final String ID_COL = "id";
    //for id column
    private static final String NAME_COL = "name";
    //for product name column
    private static final String Processor_Col = "Processor";
    //for processor column
    private static final String Storage_Col = "Storage";
    //for storage processor
    public DBHandler(@Nullable Context context){
        super(context,"DB_NAME",null,DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        String query = "CREATE TABLE " + TABLE_NAME + "(" + ID_COL + "INTEGER PRIMARY KEY AUTOINCREMENT," + NAME_COL + "TEXT" + RAM_COl + "TEXT" + Processor_Col + "TEXT" + Storage_Col + "TEXT)";
        db.execSQL(query);
    }

    public void addproductname(String Name , String Ram , String Processor , String Storage  ) {
        SQLiteDatabase db = this.getWriteableDatabase();
        ContentValues values = new ContentValues();

        values.put(NAME_COL, Name);
        values.put(RAM_COl, Ram);
        values.put(Processor_Col, Processor);
        values.put(Storage_Col, Storage);
        db.insert(TABLE_NAME, null, values);
        db.close();
    }


    @Override
    public void onUpgrade(SQLiteDatabase db , int oldVersion , int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }
}
