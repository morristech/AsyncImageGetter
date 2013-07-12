package sk.virtualvoid.tools.sample;

import java.util.ArrayList;

import sk.virtualvoid.html.ImageGetter;

import android.app.Activity;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class DemoEntityAdapter extends BaseAdapter {
	private Activity context;
	private ArrayList<DemoEntity> model;
	private ImageGetter imageGetter;
	
	public DemoEntityAdapter(Activity context, ArrayList<DemoEntity> model) {
		this.context = context;
		this.model = model;
		
		this.imageGetter = new ImageGetter(context);
	}

	@Override
	public int getCount() {
		return model.size();
	}

	@Override
	public Object getItem(int position) {
		return model.get(position);
	}

	@Override
	public long getItemId(int position) {
		return model.get(position).Id;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;
		ViewHolder holder = null;
		
		if (row == null) {
			row = context.getLayoutInflater().inflate(R.layout.row, parent, false);
			
			holder = new ViewHolder();
			holder.TextView = (TextView)row.findViewById(R.id.row_text);
			
			row.setTag(holder);
		} else {
			holder = (ViewHolder) row.getTag();
		}
		
		DemoEntity entity = (DemoEntity) getItem(position);
		
		// interesting part starts from here here:
		Html.ImageGetter ig = imageGetter.create(position, entity.Text, holder.TextView);
		
		holder.TextView.setTag(position);
		holder.TextView.setText(Html.fromHtml(entity.Text, ig, null));
		// and it ends here.
		
		return row;
	}
	
	static class ViewHolder {
		public TextView TextView;
	}
}
