package firstapp.com.neelapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewResult extends AppCompatActivity {

    DatabaseReference databaseCustomers = FirebaseDatabase.getInstance().getReference("customer");
    ListView listViewTotal;
    List<Customer> customerList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_result);

        listViewTotal = findViewById(R.id.listViewTotal);
        customerList = new ArrayList<>();
    }

    public void onStart() {

        super.onStart();

        databaseCustomers.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                customerList.clear();

                for (DataSnapshot customerSnapshot : dataSnapshot.getChildren()) {
                    Customer customer = customerSnapshot.getValue(Customer.class);

                    customerList.add(customer);
                }

                CustomerList adapter = new CustomerList(ViewResult.this, customerList);
                listViewTotal.setAdapter(adapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}

