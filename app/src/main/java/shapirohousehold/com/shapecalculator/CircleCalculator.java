package shapirohousehold.com.shapecalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class CircleCalculator extends AppCompatActivity {

    private EditText txtCircleRadius;
    private TextView txtCircleCircumference;
    private TextView txtCircleArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_calculator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtCircleCircumference = (TextView) findViewById(R.id.txtCircleCircumference);
        txtCircleArea = (TextView) findViewById(R.id.txtCircleArea);
        txtCircleRadius = (EditText) findViewById(R.id.txtCircleRadius);

//        Add text watcher for radius
        txtCircleRadius.addTextChangedListener(radiusTextWatcher);
        txtCircleCircumference.addTextChangedListener(circumferenceTextWatcher);
        txtCircleArea.addTextChangedListener(areaTextWatcher);
    }

    private void circleRadiusActions() {
        try {
            float circleRadius = Float.valueOf(txtCircleRadius.getText().toString());
            double circumference = 2 * Math.PI * circleRadius;
            double area = Math.PI * (circleRadius * circleRadius);

            txtCircleCircumference.setText(String.format("%.2f", circumference));
            txtCircleArea.setText(String.format("%.2f", area));
        } catch (NumberFormatException e){
//            Toast.makeText(getApplicationContext(),"Enter the values to calculate", Toast.LENGTH_SHORT).show();
        }
    }
    private void circleCircumferenceActions() {
        try {
            float circleCircumference = Float.valueOf(txtCircleCircumference.getText().toString());
            double radius = circleCircumference / (Math.PI * 2);
            txtCircleRadius.setText(String.format("%.2f", radius));

            double area = Math.PI * (radius * radius);
            txtCircleArea.setText(String.format("%.2f", area));
        } catch (NumberFormatException e) {

        }
    }
    private void circleAreaActions() {
        try {
            float circleArea = Float.valueOf(txtCircleArea.getText().toString());
            double radius = Math.sqrt(circleArea/Math.PI);
            txtCircleRadius.setText(String.format("%.2f", radius));

            double circumference = 2 * Math.PI * radius;
            txtCircleCircumference.setText(String.format("%.2f", circumference));

        } catch (NumberFormatException e) {

        }
    }

    private final TextWatcher radiusTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//            Toast.makeText(getApplicationContext(),"Its Empty", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
//            Toast.makeText(getApplicationContext(),"You changed it ", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void afterTextChanged(Editable s) {
            if (s != null) {
                txtCircleCircumference.removeTextChangedListener(circumferenceTextWatcher);
                txtCircleArea.removeTextChangedListener(areaTextWatcher);
                circleRadiusActions();
                txtCircleCircumference.addTextChangedListener(circumferenceTextWatcher);
                txtCircleArea.addTextChangedListener(areaTextWatcher);
            }
        }
    };
    private final TextWatcher circumferenceTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (s != null) {
                txtCircleRadius.removeTextChangedListener(radiusTextWatcher);
                txtCircleArea.removeTextChangedListener(areaTextWatcher);
                circleCircumferenceActions();
                txtCircleRadius.addTextChangedListener(radiusTextWatcher);
                txtCircleArea.addTextChangedListener(areaTextWatcher);
            }
        }
    };
    private final TextWatcher areaTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (s != null) {
                txtCircleCircumference.removeTextChangedListener(circumferenceTextWatcher);
                txtCircleRadius.removeTextChangedListener(radiusTextWatcher);
                circleAreaActions();
                txtCircleCircumference.addTextChangedListener(circumferenceTextWatcher);
                txtCircleRadius.addTextChangedListener(radiusTextWatcher);
            }
        }
    };

}
