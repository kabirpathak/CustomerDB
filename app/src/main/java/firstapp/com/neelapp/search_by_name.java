package firstapp.com.neelapp;

import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class search_by_name extends AppCompatActivity {
    DatabaseReference databaseReference;
    DatabaseHelperClass mydb;
    static String str;
    static EditText txt;


    ListView listNameView;
    List<Customer> customerList;





    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_by_name);
        txt = (EditText) findViewById(R.id.nameSearchText);
        mydb = new DatabaseHelperClass(this);


        listNameView = findViewById(R.id.listViewName);

        customerList = new ArrayList<>();

        //first query

        databaseReference = FirebaseDatabase.getInstance().getReference("customer");
        //databaseReference.addListenerForSingleValueEvent(valueEventListener);

    }

    public void searchByName(View v) {
        try {
            str = txt.getText().toString().toLowerCase().trim();
            System.out.println();
            //showNameData();
            loadNameResult();


        } catch (Exception e) {
            e.printStackTrace();
            printToastMessage();

        }

    }

    public void showNameData() {
        Cursor res = mydb.getNameData(str);

        if (res.getCount() == 0) {
            showMessage("error", "no data found.");
        } else {

            StringBuffer buffer = new StringBuffer();
            while (res.moveToNext()) {
                buffer.append("\n ID :" + res.getString(0) + "\n");
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

            showMessage("data", buffer.toString());
        }
    }


    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setCancelable(true);
        builder.show();
    }

    public void printToastMessage() {
        Toast.makeText(this, "Invalid Query", Toast.LENGTH_LONG).show();
    }

    public void loadNameResult() {
        Intent i = new Intent(this, ViewNameResult.class);
        startActivity(i);
    }



}