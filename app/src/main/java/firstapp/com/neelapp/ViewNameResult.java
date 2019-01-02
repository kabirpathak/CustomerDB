package firstapp.com.neelapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewNameResult extends AppCompatActivity {

    DatabaseReference databaseCustomers;
    ListView listViewName;
    List<Customer> customerList;
    TextView txt;
    search_by_name se = new search_by_name();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_name_result);
        databaseCustomers = FirebaseDatabase.getInstance().getReference("customer");
        txt = (TextView)findViewById(R.id.txt1);

        listViewName = findViewById(R.id.listViewName);
        customerList = new ArrayList<>();

        Query queryRef = FirebaseDatabase.getInstance().getReference("customer").orderByChild("name")
                .equalTo(search_by_name.str);

    }

    public void onStart() {

        super.onStart();
        //txt.setText(Customer.names);
        databaseCustomers.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                customerList.clear();

                Query queryRef = FirebaseDatabase.getInstance().getReference("customer").orderByChild("name")
                        .equalTo(search_by_name.str);
                queryRef.addListenerForSingleValueEvent(this);


                for (DataSnapshot customerSnapshot : dataSnapshot.getChildren()) {
                    Customer customer = customerSnapshot.getValue(Customer.class);
                    txt.setText(search_by_name.str);

                    customerList.add(customer);
                }

                CustomerList adapter = new CustomerList(ViewNameResult.this, customerList);
                listViewName.setAdapter(adapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
