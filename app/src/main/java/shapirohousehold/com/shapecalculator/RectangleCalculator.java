package shapirohousehold.com.shapecalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class RectangleCalculator extends AppCompatActivity {

    private EditText txtWidth;
    private EditText txtHeight;
    private TextView lblPerimeter;
    private TextView lblArea;
    private Spinner unitsSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangle_calculator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lblPerimeter = (TextView) findViewById(R.id.lblPermimeter);
        lblArea = (TextView) findViewById(R.id.lblArea);

        unitsSpinner = (Spinner) findViewById(R.id.spinner_units);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //add parent arrow

        //Add text Change watcher for height and width EditText
        txtWidth = (EditText) findViewById(R.id.txtWidth);
        txtHeight = (EditText) findViewById(R.id.txtHeight);
        txtWidth.addTextChangedListener(textWatcher);
        txtHeight.addTextChangedListener(textWatcher);
        unitsSpinner.setOnItemSelectedListener(spinnerWatch);
    }

    private void calcRectangle() {

        try {
            float rectangleWidth = Float.valueOf(txtWidth.getText().toString());
            float rectangleHeight = Float.valueOf(txtHeight.getText().toString());

            float perimeter = (2 * rectangleWidth) + (2 * rectangleHeight);
            lblPerimeter.setText("Perimeter " + String.format("%.2f", perimeter) + unitsSpinner.getSelectedItem().toString());

            lblArea.setText("Area " + String.format("%.2f", (rectangleHeight * rectangleWidth)) + unitsSpinner.getSelectedItem().toString() + "\u00B2");
        } catch (NumberFormatException e){

        }
    }

    private final TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
                calcRectangle();
        }
    };

    private final AdapterView.OnItemSelectedListener spinnerWatch = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            calcRectangle();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };
}
