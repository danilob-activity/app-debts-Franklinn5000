package com.example.danilo.appdebts.adapters;

/**
 * Created by aluno on 18/07/19.
 */

class Debt {
    private int mDescription;
    private Character mCategory;
    private int mPayDate;
    private int mPaymentDate;
    private double mValue;

    public int getDescription() {
        return mDescription;
    }

    public Character getCategory() {
        return mCategory;
    }

    public int getPayDate() {
        return mPayDate;
    }

    public int getPaymentDate() {
        return mPaymentDate;
    }

    public double getValue() {
        return mValue;
    }
}
