package firstapp.com.neelapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ViewDetails extends AppCompatActivity {
    DatabaseHelperClass mydb;

    Button viewAll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details);
        mydb = new DatabaseHelperClass(this);
        viewAll = (Button)findViewById(R.id.buttonall);

        viewAll.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                //viewAll();
                openAllActivity();
            }
        });
    }

    public void viewAll(){
        Cursor res = mydb.getAllData();
        if(res.getCount() == 0){
            //show message
            showMessage("Error", "No data found");
            return;
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
            //message
            showMessage("Data", buffer.toString());

        }
    }

    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public void openSearchIdActivity(View v){
        Intent i = new Intent(this, SearchById.class);
        startActivity(i);
    }

    public void openSearchNameActivity(View v){
        Intent i = new Intent(this, search_by_name.class);
        startActivity(i);
    }

    public void openSearchChasisActivity(View v){
        Intent i = new Intent(this, search_by_chasis.class);
        startActivity(i);
    }

    public void openAllActivity(){
        Intent i = new Intent(this, ViewResult.class);
        startActivity(i);
    }
}
