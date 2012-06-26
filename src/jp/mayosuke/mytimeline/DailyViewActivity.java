package jp.mayosuke.mytimeline;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class DailyViewActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main);
        final ListFragment fragment = new ListFragment();
        fragment.setListAdapter(new MyAdapter());
        getFragmentManager().beginTransaction().add(android.R.id.content, fragment).commit();
        
        getActionBar().setTitle("2012年6月25日(月）");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.daily_view, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case R.id.action_previous_day: {
            return true;
        }
        case R.id.action_next_day: {
            return true;
        }
        }
        return super.onOptionsItemSelected(item);
    }

    private long mCurrentId = 0L;
    private List<String> mData = new ArrayList<String>();

    private void initializeData() {
    	mData.add("0:00");
    	mData.add("1:00");
    	mData.add("2:00");
    	mData.add("3:00");
    	mData.add("4:00");
    	mData.add("5:00");
    	mData.add("6:00");
    	mData.add("7:00");
    	mData.add("8:00");
    	mData.add("9:00");
    	mData.add("10:00");
    	mData.add("11:00");
    	mData.add("12:00");
    	mData.add("13:00");
    	mData.add("14:00");
    	mData.add("15:00");
    	mData.add("16:00");
    	mData.add("17:00");
    	mData.add("18:00");
    	mData.add("19:00");
    	mData.add("20:00");
    	mData.add("21:00");
    	mData.add("22:00");
    	mData.add("23:00");
    }

    private class MyAdapter extends BaseAdapter {

    	private MyAdapter() {
    		initializeData();
    	}

		@Override
		public int getCount() {
			return mData.size();
		}

		@Override
		public Object getItem(int position) {
			return mData.get(position);
		}

		@Override
		public long getItemId(int position) {
			return mData.get(position).hashCode();
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			final View view;
			if (convertView == null) {
				view = View.inflate(DailyViewActivity.this, android.R.layout.simple_list_item_1, null);
			} else {
				view = convertView;
			}
			
			final TextView text1 = (TextView) view;
			text1.setText(mData.get(position));
			
			return view;
		}
    }
}