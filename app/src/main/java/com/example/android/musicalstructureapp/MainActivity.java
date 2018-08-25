package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * {@link MainActivity} shows a list of songs.
 * For each song, display the song name, the artist name, and image.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create an ArrayList of songs objects
        final ArrayList<songs> Song = new ArrayList<>();
        Song.add(new songs("All Eyez On Me", "Tupac", R.drawable.alleyezonme));
        Song.add(new songs("Set Me Free", "MarryJBlige", R.drawable.setmefree));
        Song.add(new songs("Shape Of You", "Ed Sheeran", R.drawable.shapeofyou));
        Song.add(new songs("Work", "Rihanna", R.drawable.work));
        Song.add(new songs("Happy", "Pharrell Williams", R.drawable.happy));
        Song.add(new songs("Symphony", "Clean Bandit", R.drawable.symphony));

        // Create an {@link songsAdapter}, whose data source is a list of
        // {@link song}s. The adapter knows how to create list item views for each item
        // in the list.
        SongAdapter songAdapter = new SongAdapter(this, Song);

        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(songAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this, CollectionActivity.class);
                intent.putExtra("collection", songs.class);
                startActivity(intent);

                // Get the current song
                songs songs = Song.get(position);

                // Make a toast but not showing yet
                Toast toast = Toast.makeText(MainActivity.this, "Now playing: " + songs.getSongName() + " By " + songs.getArtistName(), Toast.LENGTH_SHORT);

                // Create a toast's view so we can change its properties
                View toastView = toast.getView();

                // Change the background to white color and using PorterDuff with SRC_IN mode
                toastView.getBackground().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);

                // Get a toast's text view
                TextView textView = toastView.findViewById(android.R.id.message);

                // Change its shadow layer to transparent
                textView.setShadowLayer(0, 0, 0, Color.TRANSPARENT);

                // Set the text to dark-gray color
                textView.setTextColor(Color.DKGRAY);

                // Now, display the toast message
                toast.show();


            }
        });


    }
}
