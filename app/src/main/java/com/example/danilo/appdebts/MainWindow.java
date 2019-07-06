package com.example.danilo.appdebts;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.danilo.appdebts.adapters.DebtsAdapter;
import com.example.danilo.appdebts.classes.Category;
import com.example.danilo.appdebts.classes.Debts;
import com.example.danilo.appdebts.dao.CategoryDAO;
import com.example.danilo.appdebts.dao.DebtsDAO;
import com.example.danilo.appdebts.database.DatabaseHelper;

public class MainWindow extends AppCompatActivity {

    RecyclerView mListDebts;
    DebtsAdapter mDebtsAdapter;
    DebtsDAO mDebtsDAO;
    CategoryDAO mCategoryDAO;
    private ConstraintLayout mLayout;

    private SQLiteDatabase mConection;
    private DatabaseHelper mDataHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_window);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        mListDebts = findViewById(R.id.recycler_view_debts);
        mLayout = findViewById(R.id.layout);
        createConnection();
//        Category cat = mCategoryDAO.insert(new Category("Lanche"));
//        mDebtsDAO.insert(new Debts(cat,(float) 4.5,"Coxinha","30/07/2019",""));
//        mDebtsDAO.insert(new Debts(cat,(float) 7.5,"Coxinha e suco","30/07/2019",""));
//
//        mDebtsDAO.insert(new Debts(cat,(float) 1.5,"Café","30/07/2019","06/07/2019"));
//        mDebtsDAO.insert(new Debts(cat,(float) 14.5,"Pratinho","30/07/2019",""));
//        mDebtsDAO.insert(new Debts(cat,(float) 2.0,"Fatia de Bolo","30/07/2019","04/07/2019"));
//

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager( this);
        mListDebts.setLayoutManager(linearLayoutManager);
        mDebtsAdapter = new DebtsAdapter(mDebtsDAO.listDebts());
        mListDebts.setAdapter(mDebtsAdapter);
        mListDebts.setHasFixedSize(true);

    }

    private void createConnection() {
        try {
            mDataHelper = new DatabaseHelper(this);
            mConection = mDataHelper.getWritableDatabase();
            mDebtsDAO = new DebtsDAO(mConection);
            mCategoryDAO = new CategoryDAO(mConection);
            Snackbar.make(mLayout, R.string.sucess_conection, Snackbar.LENGTH_LONG).show();
        } catch (SQLException e) {
            Snackbar.make(mLayout, e.toString(), Snackbar. LENGTH_LONG).show();
        }
    }

}
