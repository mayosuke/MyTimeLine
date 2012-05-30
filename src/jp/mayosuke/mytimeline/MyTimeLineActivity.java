package jp.mayosuke.mytimeline;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;

public class MyTimeLineActivity extends Activity {

    private EditText mStartTime;
    private EditText mEndTime;
    private EditText mWhat;
    private EditText mWhere;
    private EditText mNotes;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mStartTime = (EditText) findViewById(R.id.startTime);
        mEndTime = (EditText) findViewById(R.id.endTime);
        mWhat = (EditText) findViewById(R.id.what);
        mWhere = (EditText) findViewById(R.id.where);
        mNotes = (EditText) findViewById(R.id.notes);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }
}