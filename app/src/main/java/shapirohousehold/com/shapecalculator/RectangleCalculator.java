package shapirohousehold.com.shapecalculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

public class RectangleCalculator extends AppCompatActivity {

    private EditText txtWidth;
    private EditText txtHeight;
    private TextView lblPerimeterValue;
    private TextView lblAreaValue;
    private Spinner unitsSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangle_calculator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcRectangle();
            }
        });

        Toast.makeText(getApplicationContext(),"Welcome to Rectangle Calculator!", Toast.LENGTH_SHORT).show();

        lblPerimeterValue = (TextView) findViewById(R.id.lblPermimeterValue);
        lblAreaValue = (TextView) findViewById(R.id.lblAreaValue);

        unitsSpinner = (Spinner) findViewById(R.id.spinner_units);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.unit_type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        unitsSpinner.setAdapter(adapter);



    }

    private void calcRectangle() {
        txtWidth = (EditText) findViewById(R.id.txtWidth);
        txtHeight = (EditText) findViewById(R.id.txtHeight);

        try {
            float rectangleWidth = Float.valueOf(txtWidth.getText().toString());
            float rectangleHeight = Float.valueOf(txtHeight.getText().toString());

            float perimeter = (2 * rectangleWidth) + (2 * rectangleHeight);
            lblPerimeterValue.setText(String.format("%.2f", perimeter) + unitsSpinner.getSelectedItem().toString());

            String area = String.format("%.2f", (rectangleHeight * rectangleWidth)) + unitsSpinner.getSelectedItem().toString() + "\u00B2";
    //        float area = rectangleHeight * rectangleWidth;
            lblAreaValue.setText(area);
        } catch (NumberFormatException e){
            Toast.makeText(getApplicationContext(),"Enter the values to calculate", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_rectangle_calculator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
