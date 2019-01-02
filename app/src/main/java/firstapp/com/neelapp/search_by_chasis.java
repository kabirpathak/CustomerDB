package firstapp.com.neelapp;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.database.Cursor;

public class search_by_chasis extends AppCompatActivity {
    static EditText txt;
    static String str;
    DatabaseHelperClass mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_by_chasis);
        txt = (EditText)findViewById(R.id.searchTextChasis);
        mydb = new DatabaseHelperClass(this);
    }

    public void searchByChasis(View v){

        try {
            str = txt.getText().toString();
            //showData();
            viewChasisResult();


        }catch(Exception e){
            e.printStackTrace();
            search_by_name x = new search_by_name();
            x.printToastMessage();
        }
    }

    public void showData(){
        Cursor res = mydb.getChasisData(str);
        if(res.getCount() == 0){
            //show error message
            showMessage("error", "no data found.");
        }else{
            StringBuffer buffer = new StringBuffer();
            while(res.moveToNext()){
                buffer.append("\n ID :" + res.getString(0)+"\n");
                buffer.append("Name :" + res.getString(1) + "\n");
                buffer.append("Loanno." + res.getString(2) + "\n");
                buffer.append("Vehno :" + res.getString(3) + "\n");
                buffer.append("Vehname : " + res.getString(4) + "\n");
                buffer.append("Chasis : " + res.getString(5) + "\n");
                buffer.append("Engine no : " + res.getString(6) + "\n");
                buffer.append("Loan amount : " + res.getString(7) + "\n");
                buffer.append("EMI : " + res.getString(8) + "\n");
                buffer.append("Due Date : " + res.getString(9) + "\n");
                buffer.append("Status : " + res.getString(10) + "\n");
            }

            showMessage("Data", buffer.toString());
        }
    }

    public static String getStr(){
        return str;
    }
    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setCancelable(true);
        builder.show();
    }

    public void viewChasisResult(){
        Intent intent = new Intent(this, ViewChasisResult.class);
        startActivity(intent);
    }
}
