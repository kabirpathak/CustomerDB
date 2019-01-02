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

public class ViewIdResult extends AppCompatActivity {

    DatabaseReference databaseCustomers;
    ListView listViewId;
    List<Customer> customerList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_id_result);
        databaseCustomers = FirebaseDatabase.getInstance().getReference("customer");

        listViewId = findViewById(R.id.listViewId);
        customerList = new ArrayList<>();

        //Query query = FirebaseDatabase.getInstance().getReference("customer").orderByChild("id")
          //      .equalTo(SearchById.txt.getText().toString().trim());
    }

    public void onStart() {

        super.onStart();

        databaseCustomers.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                customerList.clear();

                Query queryRef = FirebaseDatabase.getInstance().getReference("customer").orderByChild("id").equalTo(SearchById.str);
                queryRef.addListenerForSingleValueEvent(this);


                for (DataSnapshot customerSnapshot : dataSnapshot.getChildren()) {
                    Customer customer = customerSnapshot.getValue(Customer.class);

                    customerList.add(customer);
                }

                CustomerList adapter = new CustomerList(ViewIdResult.this, customerList);
                listViewId.setAdapter(adapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
