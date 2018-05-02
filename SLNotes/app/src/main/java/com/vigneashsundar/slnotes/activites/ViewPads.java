package com.vigneashsundar.slnotes.activites;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.vigneashsundar.slnotes.R;

public class ViewPads extends AppCompatActivity {

    FloatingActionMenu materialDesignFAM;
    FloatingActionButton ReminderButton, PictureButton, TextNoteButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pads);
        Toolbar toolbar = findViewById(R.id.viewpadsToolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("SLNotes");

        materialDesignFAM = (FloatingActionMenu) findViewById(R.id.material_design_android_floating_action_menu);
        ReminderButton = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item1);
        PictureButton = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item2);
        TextNoteButton = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item3);

        ReminderButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO something when floating action menu first item clicked

            }
        });
        PictureButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO something when floating action menu second item clicked

            }
        });
        TextNoteButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i =
            }
        });
    }

}
