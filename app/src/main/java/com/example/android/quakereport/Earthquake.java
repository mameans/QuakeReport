package com.example.android.quakereport;

import androidx.annotation.NonNull;

import java.text.DateFormat;
import java.util.Date;

class Earthquake {
    private Double mMagnitude;
    private String mLocation;
    private Date mDate;

    Earthquake(Double mMagnitude, String mLocation, Date mDate) {
        this.mMagnitude = mMagnitude;
        this.mLocation = mLocation;
        this.mDate = mDate;
    }

    String getMagnitude() {
        return mMagnitude.toString();
    }

    String getLocation() {
        return mLocation;
    }

    String getDate() {
        return DateFormat.getDateInstance().format(mDate);
    }

    @NonNull
    @Override
    public String toString() {
        return "Earthquake{" +
                "mMagnitude=" + mMagnitude +
                ", mLocation='" + mLocation + '\'' +
                ", mDate=" + mDate +
                '}';
    }
}

