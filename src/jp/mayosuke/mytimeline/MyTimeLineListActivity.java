package jp.mayosuke.mytimeline;

import java.util.List;

import jp.mayosuke.mytimeline.MyTimeLine.TimeLine;
import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

public class MyTimeLineListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ListFragment listFragment = new ListFragment();
        listFragment.setListAdapter(new MyListAdapter(this, R.layout.list_item, MyTimeLine.getInstance().getTimeLines()));
        getFragmentManager().
                beginTransaction().
                add(android.R.id.content, listFragment).
                commit();
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

    private static class MyListAdapter extends ArrayAdapter<TimeLine> {

        private MyListAdapter(Context context, int textViewResourceId, List<TimeLine> objects) {
            super(context, textViewResourceId, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final View view;
            if (convertView == null) {
                view = View.inflate(getContext(), R.layout.list_item, null);
            } else {
                view = convertView;
            }

            final TimeLine item = getItem(position);
            if (item != null) {
                TextView startTime = (TextView) view.findViewById(R.id.startTime);
                TextView endTime = (TextView) view.findViewById(R.id.endTime);
                TextView what = (TextView) view.findViewById(R.id.what);
                TextView where = (TextView) view.findViewById(R.id.where);
            }

            return view;
        }
        
    }
}