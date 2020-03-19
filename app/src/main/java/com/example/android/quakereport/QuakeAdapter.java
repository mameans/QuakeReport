/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

/**
 * {@link QuakeAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Earthquake} objects.
 */
public class QuakeAdapter extends ArrayAdapter<Earthquake>  {

    /**
     * Create a new {@link QuakeAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param quakes is the list of {@link Earthquake}s to be displayed.
     */
    QuakeAdapter(Context context, ArrayList<Earthquake> quakes) {
        super(context, 0, quakes);
        // mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) listItemView = LayoutInflater.from(getContext()).inflate(
                R.layout.quakes_list_item, parent, false);

        // Get the {@link Earthquake} object located at this position in the list
        Earthquake currentQuake = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID miwok_text_view.
        TextView magnitudeTextView = listItemView.findViewById(R.id.magnitude_text_view);
        // Get the Earth translation from the currentQuake object and set this text on
        // the Miwok TextView.
        assert currentQuake != null;
        magnitudeTextView.setText(currentQuake.getMagnitude());

        TextView locationTextView = listItemView.findViewById(R.id.location_text_view);
        // Get the location from the currentQuake object and set this text on
        // the location TextView.
        locationTextView.setText(currentQuake.getLocation());

        TextView dateTextView = listItemView.findViewById(R.id.date_text_view);
        // Get the location from the currentQuake object and set this text on
        // the location TextView.
        dateTextView.setText(currentQuake.getDate());


//        // Set the theme color for the list item
//        View textContainer = listItemView.findViewById(R.id.text_container);
//        // Find the color that the resource ID maps to
//        int color = ContextCompat.getColor(getContext(), mColorResourceId);
//        // Set the background color of the text container View
//        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}
