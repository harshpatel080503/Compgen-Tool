package com.example.hackinfinity30;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.bargraph.R;

public class input extends AppCompatActivity {

    private EditText courseNameEdt;
    private Button addCourseBtn;
    private DBHandler dbHandler;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        courseNameEdt = findViewById(R.id.idEdtCourseName);
        addCourseBtn = findViewById(R.id.idBtnAddCourse);
        dbHandler = new DBHandler(input.this);
        addCourseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String courseName = courseNameEdt.getText().toString();
                if (courseName.isEmpty()) {
                    Toast.makeText(input.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                dbHandler.addNewCourse(courseName);
                Toast.makeText(input.this, "Course has been added.", Toast.LENGTH_SHORT).show();
                courseNameEdt.setText("");
            }
        });
    }
}
