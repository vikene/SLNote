package com.vigneashsundar.slnotes.activites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.vigneashsundar.slnotes.R;

import jp.wasabeef.richeditor.RichEditor;

public class TextNote extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_note);
        RichEditor meditor = findViewById(R.id.richTextEditor);
        meditor.setFontSize(12);
    }
}
