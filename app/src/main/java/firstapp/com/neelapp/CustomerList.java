package firstapp.com.neelapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomerList extends ArrayAdapter<Customer> {
    private Activity context;
    private List<Customer> customerList;

    public CustomerList(Activity context, List<Customer> customerList){
        super(context, R.layout.list_layout, customerList);
        this.context  = context;
        this.customerList = customerList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_layout, null, true);
        Customer customer = customerList.get(position);
        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName);
        TextView textViewId = (TextView) listViewItem.findViewById(R.id.textViewId);
        TextView textViewLoanno = (TextView) listViewItem.findViewById(R.id.textViewLoanno);
        TextView textViewVehicleNo = (TextView) listViewItem.findViewById(R.id.textViewVehicleNo);
        TextView textViewVehname = (TextView) listViewItem.findViewById(R.id.textViewVehname);
        TextView textViewVehicleChasis = (TextView) listViewItem.findViewById(R.id.textViewVehicleChasis);
        TextView textViewEngineno = (TextView) listViewItem.findViewById(R.id.textViewEngineNo);
        TextView textViewLoanAmt = (TextView) listViewItem.findViewById(R.id.textViewLoanAmt);
        TextView textViewMonthlyEmi = (TextView) listViewItem.findViewById(R.id.textViewMonthlyEmi);
        TextView textViewDueDate = (TextView) listViewItem.findViewById(R.id.textViewDueDate);
        TextView textViewStatus = (TextView) listViewItem.findViewById(R.id.textViewStatus);

        textViewName.setText(customer.getName());
        textViewId.setText(customer.getId());
        textViewLoanno.setText(customer.getLoanno());
        textViewVehicleNo.setText(customer.getVehno());
        textViewVehname.setText(customer.getVehname());
        textViewVehicleChasis.setText(customer.getVehicleChasis());
        textViewEngineno.setText(customer.getEngineNumber());
        textViewLoanAmt.setText(customer.getLoanAmount());
        textViewMonthlyEmi.setText(customer.getMonthlyEmi());
        textViewDueDate.setText(customer.getDueDate());
        textViewStatus.setText(customer.getStatus());


        return listViewItem;


    }





    }
