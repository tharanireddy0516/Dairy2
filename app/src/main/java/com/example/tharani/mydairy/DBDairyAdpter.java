package com.example.tharani.mydairy;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import static com.example.tharani.mydairy.DairyAdapter.WRAP_CONTENT_LENGTH;

/**
 * Created by Tharani on 2/16/2018.
 */

public class DBDairyAdpter extends ArrayAdapter<Dairy> {

    Context context;
    int resource;
    List<Dairy>dairyList;
    public DBDairyAdpter(@NonNull Context context, int resource, @NonNull List<Dairy> objects) {
        super(context, resource, objects);
        this.context =context;
        this.resource =resource;
        this.dairyList = objects;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null) {//taking convertView is null
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.view_db_diary_data, null);
            //inflate or filling  the layout file for the dairy
        }

        Dairy notes = dairyList.get(position);//gets item from position from Dairy

        if(notes != null) {//if notes is not null
            //starts building the listView here
            //taking reference to three textviews
            TextView title =  convertView.findViewById(R.id.dblist_note_title);
            TextView date =  convertView.findViewById(R.id.dblist_note_date);
            TextView content =  convertView.findViewById(R.id.dblist_note_content_preview);

            title.setText(notes.getTitle());//sets title text and gets title
            /*.getDateTimeFormatted() method from Dairy class which gets date format in dd/MM/yyyy HH:mm:ss
            * .getContext() method  returns the context the view is currently running in activity*/
            date.setText(notes.getDbdate());
            //correctly show preview of the content (not more than 50 char or more than one line!)

                    content.setText(notes.getContent());
        }

        return convertView;

    }
}
