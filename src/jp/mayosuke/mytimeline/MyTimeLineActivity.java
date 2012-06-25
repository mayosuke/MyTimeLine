package jp.mayosuke.mytimeline;

import jp.mayosuke.mytimeline.MyTimeLine.TimeLine;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MyTimeLineActivity extends Activity {

    private static class ViewHolder {
        private EditText mStartTime;
        private EditText mEndTime;
        private EditText mWhat;
        private EditText mWhere;
        private EditText mNotes;
    }
    private final ViewHolder mViewHolder = new ViewHolder();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mViewHolder.mStartTime = (EditText) findViewById(R.id.startTime);
        mViewHolder.mEndTime = (EditText) findViewById(R.id.endTime);
        mViewHolder.mWhat = (EditText) findViewById(R.id.what);
        mViewHolder.mWhere = (EditText) findViewById(R.id.where);
        mViewHolder.mNotes = (EditText) findViewById(R.id.notes);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case R.id.action_finish: {
            saveTimeLine(mViewHolder);

            Intent intent = new Intent(this, MyTimeLineListActivity.class);
            startActivity(intent);

            return true;
        }
        case R.id.action_daily_view: {
            Intent intent = new Intent(this, DailyViewActivity.class);
            startActivity(intent);

            return true;
        }
        }
        return super.onOptionsItemSelected(item);
    }

    private void saveTimeLine(ViewHolder viewHolder) {
        MyTimeLine.getInstance().insertTimeLine(createTimeLine(viewHolder));
    }

    private TimeLine createTimeLine(ViewHolder viewHolder) {
        final long startTime = Long.valueOf(mViewHolder.mStartTime.getText().toString());
        final long endTime = Long.valueOf(mViewHolder.mEndTime.getText().toString());
        final String what = mViewHolder.mWhat.getText().toString();
        final String where = mViewHolder.mWhere.getText().toString();
        final String notes = mViewHolder.mNotes.getText().toString();
        final TimeLine timeLine = new TimeLine(startTime, endTime, what, where, notes);
        return timeLine;
    }
}