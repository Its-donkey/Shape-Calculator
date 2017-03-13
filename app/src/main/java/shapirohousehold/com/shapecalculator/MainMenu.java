package shapirohousehold.com.shapecalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainMenu extends AppCompatActivity {

    Button btnOpenRectangle;
    Button btnOpenCircle;
    Button btnOpenTriangle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Toast.makeText(getApplicationContext(),"Welcome to Shape Calculator!", Toast.LENGTH_SHORT).show();
    }

    public void openRectangleCalculator(View view) {
        btnOpenRectangle = (Button) findViewById(R.id.btnOpenRectangle);
        Intent rectangleCalcIntent = new Intent(this, RectangleCalculator.class);
        startActivity(rectangleCalcIntent);
    }

    public void openCircleCalculator(View view) {
        btnOpenCircle = (Button) findViewById(R.id.btnOpenCircle);
        Intent circleCalcIntent = new Intent(this, CircleCalculator.class);
        startActivity(circleCalcIntent);
    }


    public void openTriangleCalculator(View view) {
        btnOpenTriangle = (Button) findViewById(R.id.btnOpenTriangle);
        Intent triangleCalcIntent = new Intent(this, TriangleCalculator.class);
        startActivity(triangleCalcIntent);
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
