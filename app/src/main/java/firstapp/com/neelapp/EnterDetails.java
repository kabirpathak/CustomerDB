package firstapp.com.neelapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class EnterDetails extends AppCompatActivity {

    Button theBut;
    DatabaseHelperClass mydb;
    EditText txt_id, txt_name, txt_loann, txt_vehno, txt_vehname;
    EditText chasis_no, engine_no, loan_amount, monthly_emi, due_date, status;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("customer");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_details);
        mydb = new DatabaseHelperClass(this);






        //Boolean datastored = mydb.temporarilyStoreData(txt_id.getText().toString(), txt_name.getText().toString().toUpperCase(), txt_loann.getText().toString(), txt_vehno.getText().toString(), txt_vehname.getText().toString());

    }

    public void addUserData(View v){
        txt_id = (EditText) findViewById(R.id.edittext1);
        txt_name = (EditText) findViewById(R.id.edittext2);
        txt_loann = (EditText) findViewById(R.id.edittext3);
        txt_vehno = (EditText) findViewById(R.id.edittext4);
        txt_vehname = (EditText) findViewById(R.id.edittext5);
        chasis_no = (EditText) findViewById(R.id.edittext6);
        engine_no = (EditText) findViewById(R.id.edittext7);
        loan_amount = (EditText) findViewById(R.id.edittext8);
        monthly_emi = (EditText) findViewById(R.id.edittext9);
        due_date = (EditText) findViewById(R.id.edittext10);
        status = (EditText) findViewById(R.id.edittext11);

        addCustomer();
    }

    public void addCustomer(){
        try {
            String name = txt_name.getText().toString().trim();
            String id = txt_id.getText().toString().trim();
            String loanno = txt_loann.getText().toString().trim();
            String vehno = txt_vehno.getText().toString().trim();
            String vehname = txt_vehname.getText().toString().trim();
            String chasisNumber = chasis_no.getText().toString().trim();
            String engineNumber = engine_no.getText().toString().trim();
            String loanAmount = loan_amount.getText().toString().trim();
            String monthlyEmi = monthly_emi.getText().toString().trim();
            String dueDate = due_date.getText().toString().trim();
            String status_1 = status.getText().toString().trim();

            Customer customer = new Customer(name, id, loanno, vehno, vehname, chasisNumber, engineNumber, loanAmount, monthlyEmi, dueDate, status_1);
            databaseReference.child(name).setValue(customer);
            Toast.makeText(this, "Customer added.", Toast.LENGTH_LONG).show();
        }catch(Exception e){
            e.printStackTrace();
            Toast.makeText(this, "Error", Toast.LENGTH_LONG).show();
        }
    }


}