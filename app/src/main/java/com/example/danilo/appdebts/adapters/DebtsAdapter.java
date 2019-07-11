package com.example.danilo.appdebts.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.danilo.appdebts.R;
import com.example.danilo.appdebts.classes.Debts;

import org.w3c.dom.Text;

import java.util.List;

public class DebtsAdapter extends RecyclerView.Adapter<DebtsAdapter.ViewHolderDebts> {
    private List<Debts> mData;
    public DebtsAdapter(List<Debts> data) {
        mData = data;
    }
    @NonNull
    @Override
    public DebtsAdapter.ViewHolderDebts onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_view_debts, parent, false);
        ViewHolderDebts holderDebts = new ViewHolderDebts(view);
        return holderDebts;
    }

    //adiciona os dados
    @Override
    public void onBindViewHolder(@NonNull ViewHolderDebts holder, int position) {
        if (mData != null && mData.size() > 0) {
            Debts debt = mData.get(position);
            holder.mCategoy.setText(debt.getCategory().getType());
            holder.mDescription.setText(debt.getDescription());
            holder.mPaymentdate.setText(debt.getPaymentDate());
            holder.mPaydate.setText(debt.getPayDate());
            holder.mValue.setText(Float.toString(debt.getValue()));

        }
    }
    @Override
    public int getItemCount() {
        return mData.size();
    }

    //configurar os links e ações pela interface
    public class ViewHolderDebts extends RecyclerView.ViewHolder {

        public TextView mDescription;
        public TextView mCategoy;
        public TextView mPaymentdate;
        public TextView mPaydate;
        public TextView mValue;
        public ImageButton mImagePay;
        public ImageButton mImageRenew;
        public ImageButton mImageDelete;

        public ViewHolderDebts(View itemView) {
            super(itemView);
            mDescription = itemView.findViewById(R.id.textViewDescription);
            mCategoy = itemView.findViewById(R.id.textViewCategory);
            mPaymentdate = itemView.findViewById(R.id.textviewPaymentdate);
            mPaydate = itemView.findViewById(R.id.textviewPaydate);
            mValue = itemView.findViewById(R.id.textviewValue);
            mImagePay = itemView.findViewById(R.id.ImageButtonPay);
            mImageRenew = itemView.findViewById(R.id.ImageButtonRenew);
            mImageDelete = itemView.findViewById(R.id.ImageButtonDelete);




        }
    }
}
