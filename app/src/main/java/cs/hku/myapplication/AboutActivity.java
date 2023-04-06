package cs.hku.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import cs.hku.myapplication.utils.FuncUnit;

public class AboutActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        TextView version=(TextView)findViewById(R.id.version);
        version.setText(getString(R.string.version)+ FuncUnit.getVersionName(FuncUnit.getBoxPackageName()));
    }
}
