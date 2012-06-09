package jp.mayosuke.mytimeline;

import jp.mayosuke.mytimeline.MyTimeLine.TimeLine;
import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

public class MyTimeLineListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        final ListFragment listFragment = new ListFragment();
        final ListAdapter adapter = new ArrayAdapter<TimeLine>(this, android.R.layout.simple_list_item_1, MyTimeLine.getInstance().getTimeLines());
        listFragment.setListAdapter(adapter);
        
        getFragmentManager().beginTransaction().add(android.R.id.content, listFragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.list, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case R.id.action_finish:
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}