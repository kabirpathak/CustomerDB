package firstapp.com.neelapp;

import android.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.content.Intent;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SearchById extends AppCompatActivity {
    Button idSearchButton; static String str;

    static EditText txt;

    DatabaseHelperClass mydb;
    ListView listViewCustomers;
    List<Customer> customerList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_by_id);


        //listViewCustomers = findViewById(R.id.listViewCustomers);
        //customerList = new ArrayList<>();
        idSearchButton = (Button)findViewById(R.id.searchIdButton);
        txt = (EditText)findViewById(R.id.textSearchId);
        mydb = new DatabaseHelperClass(this);
        idSearchButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){


               try {
                   if (txt.getText().toString() == null || txt.getText().toString() == "") {

                       printToastMessage();
                   } else {
                       str = txt.getText().toString();

                       txt.setText("");
                       openViewId();
                       //showData();
                   }
               }catch(Exception e){
                   e.printStackTrace();
                   printToastMessage();
               }
            }
        });
    }

    public void showData(){
        Cursor res = mydb.getIDdata(str);
        if(res.getCount() == 0){
            //show error message
            showMessage("error", "no data found");
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

            //show message..
            showMessage("data ;", buffer.toString());
        }

    }

    public String getstr(){
        return str;
    }

    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public void printToastMessage(){
        Toast.makeText(this, "Invalid query.", Toast.LENGTH_LONG).show();

    }

    public void openViewId( ){
        Intent intent = new Intent(this, ViewIdResult.class);
        startActivity(intent);
    }

}
