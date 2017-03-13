package shapirohousehold.com.shapecalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TriangleCalculator extends AppCompatActivity {

    EditText txtTriangleSideA;
    EditText txtTriangleSideB;
    EditText txtTriangleSideC;

    TextView lblTriangleArea;
    TextView lblTrianglePerimeter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle_calculator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtTriangleSideA = (EditText) findViewById(R.id.txtTriangleSideA);
        txtTriangleSideB = (EditText) findViewById(R.id.txtTriangleSideB);
        txtTriangleSideC = (EditText) findViewById(R.id.txtTriangleSideC);
        txtTriangleSideA.addTextChangedListener(triangleTextListener);
        txtTriangleSideB.addTextChangedListener(triangleTextListener);
        txtTriangleSideC.addTextChangedListener(triangleTextListener);
        lblTriangleArea = (TextView) findViewById(R.id.lblTriangleArea);
        lblTrianglePerimeter = (TextView) findViewById(R.id.lblTrianglePerimeter);
    }

    private void calcTriangle() {
        try {
            float sideA = Float.valueOf(txtTriangleSideA.getText().toString());
            float sideB = Float.valueOf(txtTriangleSideB.getText().toString());
            float sideC = Float.valueOf(txtTriangleSideC.getText().toString());

            double triangleS = (sideA + sideB + sideC) / 2;
            double triangleArea = Math.sqrt(triangleS*(triangleS - sideA)*(triangleS - sideB)*(triangleS - sideC));
            if (Double.isNaN(triangleArea)) {
                Toast.makeText(getApplicationContext(),"The sizes entered are not a possible triangle size", Toast.LENGTH_SHORT).show();
                lblTriangleArea.setText("");
                lblTrianglePerimeter.setText("");
                return;
            }
            lblTriangleArea.setText("Area " + String.format("%.2f", triangleArea));

            double trianglePerimeter = sideA + sideB + sideC;
            lblTrianglePerimeter.setText("Perimeter " + String.format("%.2f", trianglePerimeter));
        } catch (NumberFormatException e){

        }
    }

    private final TextWatcher triangleTextListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
                calcTriangle();
        }
    };


}
