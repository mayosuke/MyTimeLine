package jp.mayosuke.mytimeline;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case R.id.action_finish:
            Intent intent = new Intent(this, MyTimeLineListActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}