package firstapp.com.neelapp;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DatabaseHelperClass extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "customer.db";
    public static final String TABLE_NAME = "customer_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "Name";
    public static final String COL_3 = "Loanno";
    public static final String COL_4 = "VehicleNo";
    public static final String COL_5 = "VehicleName";
    public static final String COL_6 = "VehicleChasis";
    public static final String COL_7 = "EngineNumber";
    public static final String COL_8 = "LoanAmount";
    public static final String COL_9 = "MonthlyEMI";
    public static final String COL_10 = "DueDate";
    public static final String COL_11 = "Status";

    static String ids= "";
    static String names = "";
    static String loannos = "";
    static String vehnos = "";
    static String vehnames = "";


    public DatabaseHelperClass(Context context){
        super(context,DATABASE_NAME, null, 1);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" ( ID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT, Loanno TEXT, VehicleNo TEXT, VehicleName TEXT, VehicleChasis TEXT, EngineNumber TEXT, LoanAmount TEXT, MonthlyEMI TEXT, DueDate TEXT, Status TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    public Boolean insertData(String vehiclechasis, String engineNumber, String loanAmount, String monthlyEmi, String dueDate, String status){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, ids);
        contentValues.put(COL_2, names.toUpperCase());
        contentValues.put(COL_3, loannos);
        contentValues.put(COL_4, vehnos);
        contentValues.put(COL_5, vehnames);
        contentValues.put(COL_6, vehiclechasis);
        contentValues.put(COL_7, engineNumber);
        contentValues.put(COL_8, loanAmount);
        contentValues.put(COL_9, monthlyEmi);
        contentValues.put(COL_10, dueDate);
        contentValues.put(COL_11, status);
        long result = db.insert(TABLE_NAME, null,contentValues);

        if(result == -1)return false;
        else return true;
    }

    //for viewing details..
    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }

    public Cursor getIDdata(String searchId){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME+ " where " + COL_1 + " = " + Integer.parseInt(searchId), null);
        return res;
    }

    public Cursor getNameData(String searchName){
        String tempName = searchName.toUpperCase();
        SQLiteDatabase db = this.getReadableDatabase();
         String queryString = "select * from " + TABLE_NAME + " where " + COL_2 + " = \"" + tempName + "\"";
        Cursor res = db.rawQuery("select * from " + TABLE_NAME+ " where " + COL_2 + " = \"" + tempName + "\"", null);
       // printMessage(queryString);
        return res;
    }

    public Cursor getChasisData(String searchChasis){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME + " where " + COL_6 + " = \"" + searchChasis + "\"", null);
        return res;
    }


    public Boolean temporarilyStoreData(String id, String name, String loanno, String vehno, String vehname){
        ids = id;
        names = name;
        loannos = loanno;
        vehnos = vehno;
        vehnames = vehname;

        if(ids != "")return true;
        else return false;
    }



    }

