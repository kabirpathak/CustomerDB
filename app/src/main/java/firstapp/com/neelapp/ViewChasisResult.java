package firstapp.com.neelapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewChasisResult extends AppCompatActivity {

    DatabaseReference databaseCustomers;
    ListView listViewChasis;
    List<Customer> customerList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_chasis_result);
        databaseCustomers = FirebaseDatabase.getInstance().getReference("customer");

        listViewChasis = findViewById(R.id.listViewChasis);
        customerList = new ArrayList<>();

        Query queryRef = FirebaseDatabase.getInstance().getReference("customer").orderByChild("vehicleChasis")
                .equalTo(search_by_chasis.txt.getText().toString().trim());
        queryRef.addListenerForSingleValueEvent(valueEventListener);
    }



       ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                customerList.clear();

                Query queryRef = FirebaseDatabase.getInstance().getReference("customer").orderByChild("vehicleChasis")
                        .equalTo(search_by_chasis.txt.getText().toString().trim());

                for (DataSnapshot customerSnapshot : dataSnapshot.getChildren()) {
                    Customer customer = customerSnapshot.getValue(Customer.class);

                    customerList.add(customer);
                }

                CustomerList adapter = new CustomerList(ViewChasisResult.this, customerList);
                listViewChasis.setAdapter(adapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };



}
