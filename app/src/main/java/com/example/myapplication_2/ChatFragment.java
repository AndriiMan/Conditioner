package com.example.myapplication_2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.myapplication_2.MainActivity.room1;


public class ChatFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_chat, container, false);
        setHasOptionsMenu(true);
        TextView textView = v.findViewById(R.id.text_chat);

        textView.setText("Temperature in this room is "+room1.x+" degree");

        return v;

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_chats, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_chat) {
            Toast.makeText(getActivity(), "Condecioner in " + item.getTitle()+" will be cleaned", Toast.LENGTH_SHORT)
                    .show();

        }
        return true;
    }
}