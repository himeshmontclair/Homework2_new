package com.example.homework2;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView showAverage, showGPA;
    EditText grade1, grade2, grade3, grade4, grade5, grade6;
    Button button;
    LinearLayout top, middle, bottom;
    ScrollView layout_bg;
    float sum = 0;
    float averageGrade;
    int numOfCourse = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        findViewes();
        setInputFilter();
    }

    private void findViewes() {
        showAverage = findViewById(R.id.showAverage);
        showGPA = findViewById(R.id.showGPA);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
        grade1 = findViewById(R.id.grade1);
        grade2 = findViewById(R.id.grade2);
        grade3 = findViewById(R.id.grade3);
        grade4 = findViewById(R.id.grade4);
        grade5 = findViewById(R.id.grade5);
        grade6 = findViewById(R.id.grade6);
        top = findViewById(R.id.top);
        middle = findViewById(R.id.middle);
        bottom = findViewById(R.id.bottom);
        layout_bg = findViewById(R.id.layout_bg);
        textWatcher();
    }

    private void textWatcher() {
        grade1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                layout_bg.setBackgroundResource(R.color.sky_blue);
                button.setBackgroundResource(R.drawable.round_btn_white_bg);
                button.setText(R.string.Calculate);
            }
        });

        grade2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                layout_bg.setBackgroundResource(R.color.sky_blue);
                button.setBackgroundResource(R.drawable.round_btn_white_bg);
                button.setText(R.string.Calculate);
            }
        });

        grade3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                layout_bg.setBackgroundResource(R.color.sky_blue);
                button.setBackgroundResource(R.drawable.round_btn_white_bg);
                button.setText(R.string.Calculate);
            }
        });

        grade4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                layout_bg.setBackgroundResource(R.color.sky_blue);
                button.setBackgroundResource(R.drawable.round_btn_white_bg);
                button.setText(R.string.Calculate);
            }
        });

        grade5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                layout_bg.setBackgroundResource(R.color.sky_blue);
                button.setBackgroundResource(R.drawable.round_btn_white_bg);
                button.setText(R.string.Calculate);
            }
        });

        grade6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                layout_bg.setBackgroundResource(R.color.sky_blue);
                button.setBackgroundResource(R.drawable.round_btn_white_bg);
                button.setText(R.string.Calculate);
            }
        });
    }

    private void checkFunction() {
        try {
            String[] grade = new String[]{grade1.getText().toString(), grade2.getText().toString(),
                    grade3.getText().toString(), grade4.getText().toString(),
                    grade5.getText().toString(), grade6.getText().toString()};
            for (String s : grade) {
                if (!s.equals("0")) {
                    sum += Float.valueOf(s);
                } else {
                    numOfCourse--;
                }
            }
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "Enter all feilds, Enter Zero if absent", Toast.LENGTH_SHORT).show();
            sum = 0;
            showAverage.setText(R.string.DefaultGrade);
            showGPA.setText(R.string.DefaultGPA);
            return;
        }
        setGrade();
    }

    private void setInputFilter() {
        grade1.setFilters(new InputFilter[]{new MinMaxFilter("0", "100"), new InputFilter.LengthFilter(5)});
        grade2.setFilters(new InputFilter[]{new MinMaxFilter("0", "100"), new InputFilter.LengthFilter(5)});
        grade3.setFilters(new InputFilter[]{new MinMaxFilter("0", "100"), new InputFilter.LengthFilter(5)});
        grade4.setFilters(new InputFilter[]{new MinMaxFilter("0", "100"), new InputFilter.LengthFilter(5)});
        grade5.setFilters(new InputFilter[]{new MinMaxFilter("0", "100"), new InputFilter.LengthFilter(5)});
        grade6.setFilters(new InputFilter[]{new MinMaxFilter("0", "100"), new InputFilter.LengthFilter(5)});
    }

    private void setGrade() {
        averageGrade = sum / numOfCourse;
        if (numOfCourse == 0) {
            Toast.makeText(MainActivity.this, R.string.Doge, Toast.LENGTH_SHORT).show();
            showGPA.setText(R.string.Doge);
            showAverage.setText(R.string.Doge);
            button.setText(R.string.Doge);
            return;

        } else if (averageGrade >= 80 && averageGrade <= 100) {
            layout_bg.setBackgroundResource(R.color.colorGreen);
            button.setBackgroundResource(R.drawable.round_btn_red_bg);
            button.setText(R.string.Calculate);
            Toast.makeText(MainActivity.this, R.string.Keep, Toast.LENGTH_SHORT).show();
            button.setText(R.string.Clear);

        } else if (averageGrade >= 61 && averageGrade < 80) {
            layout_bg.setBackgroundResource(R.color.colorYellow);
            button.setBackgroundResource(R.drawable.round_btn_pink_bg);
            Toast.makeText(MainActivity.this, R.string.AlmostA, Toast.LENGTH_SHORT).show();
            button.setText(R.string.Clear);

        } else {
            layout_bg.setBackgroundResource(R.color.colorRed);
            button.setBackgroundResource(R.drawable.round_btn_yellow_bg);
            Toast.makeText(MainActivity.this, R.string.WorkHard, Toast.LENGTH_SHORT).show();
            button.setText(R.string.Clear);

        }
        if (averageGrade >= 90 && averageGrade <= 100) {
            showGPA.setText(R.string.A);
        } else if (averageGrade >= 80 && averageGrade < 90) {
            showGPA.setText(R.string.B);
        } else if (averageGrade >= 70 && averageGrade < 80) {
            showGPA.setText(R.string.C);
        } else if (averageGrade >= 60 && averageGrade < 70) {
            showGPA.setText(R.string.D);
        } else {
            showGPA.setText(R.string.F);
        }
        showAverage.setText(Float.toString(averageGrade));
        numOfCourse = 6;
        sum = 0;
        averageGrade = 0;
    }

    public void clean() {
        grade1.setText("");
        grade2.setText("");
        grade3.setText("");
        grade4.setText("");
        grade5.setText("");
        grade6.setText("");

        sum = 0;
        showAverage.setText(R.string.DefaultGrade);
        showGPA.setText(R.string.DefaultGPA);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.button:
                String word = button.getText().toString();
                switch (word.toUpperCase()) {
                    case "COMPUTE GPA":
                        checkFunction();
                        break;

                    case "CLEAR ALL":
                        clean();
                        layout_bg.setBackgroundResource(R.color.sky_blue);
                        button.setBackgroundResource(R.drawable.round_btn_white_bg);
                        button.setText(R.string.Calculate);
                        break;

                    case "ZERO":
                        clean();
                        layout_bg.setBackgroundResource(R.color.sky_blue);
                        button.setBackgroundResource(R.drawable.round_btn_white_bg);
                        button.setText(R.string.Calculate);
                        break;
                }
                break;
        }
    }

    public class MinMaxFilter implements InputFilter {

        private float Min, Max;

        public MinMaxFilter(String minValue, String maxValue) {
            this.Min = Float.parseFloat(minValue);
            this.Max = Float.parseFloat(maxValue);
        }

        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            try {
                Float input = Float.parseFloat(dest.toString() + source.toString());
                if (isInRange(Min, Max, input))
                    return null;
            } catch (NumberFormatException nfe) {
            }
            return "";
        }

        private boolean isInRange(float a, float b, float c) {
            return c <= b && c >= a;
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("CurrentGrade", showAverage.getText().toString());
        outState.putString("GPA", showGPA.getText().toString());
        outState.putString("Sum", String.valueOf(sum));
        outState.putString("NumberOfCourse", String.valueOf(numOfCourse));
        outState.putString("Average", String.valueOf(averageGrade));
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onRestoreInstanceState(savedInstanceState);
        String currentGrade = savedInstanceState.getString("CurrentGrade");
        String GPA = savedInstanceState.getString("GPA");
        sum = Float.parseFloat(savedInstanceState.getString("Sum"));
        numOfCourse = Integer.parseInt(savedInstanceState.getString("NumberOfCourse"));

        showAverage.setText(currentGrade);
        showGPA.setText(GPA);
        checkFunction();
    }
}
