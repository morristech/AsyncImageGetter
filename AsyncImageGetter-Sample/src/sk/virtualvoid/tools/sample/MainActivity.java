package sk.virtualvoid.tools.sample;

import java.util.ArrayList;
import java.util.Arrays;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.view.Menu;

/**
 * 
 * @author suchan_j
 * 
 */
public class MainActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);

		// images are from: http://imgur.com/gallery/ZiCJd and
		// http://imgur.com/gallery/1AtIj
		ArrayList<DemoEntity> model = new ArrayList<DemoEntity>();
		model.add(new DemoEntity(1, "<b>lorem ipsum</b><br /><img src='http://i.imgur.com/0goe7p2.jpg'>"));
		model.add(new DemoEntity(2, "dolor sit amet<br /><img src='http://i.imgur.com/6d9J7cq.jpg'>"));
		model.add(new DemoEntity(3, "<i>consectetur adipisicing elit</i><br /><img src='http://i.imgur.com/6vyRVTw.jpg'>"));
		model.add(new DemoEntity(4, "lorem ipsum<br /><img src='http://i.imgur.com/VRK4zEv.jpg'>"));
		model.add(new DemoEntity(5, "lorem ipsum<br /><img src='http://i.imgur.com/5gXEJYC.jpg?1'>"));
		model.add(new DemoEntity(6, "lorem ipsum"));
		model.add(new DemoEntity(7, "lorem ipsum"));
		model.add(new DemoEntity(8, "lorem ipsum"));
		model.add(new DemoEntity(9, "lorem ipsum<br /><img src='http://i.imgur.com/AzTkzD4.jpg'>"));
		model.add(new DemoEntity(10, "lorem ipsum<br /><img src='http://i.imgur.com/k2XRFq5.jpg'>"));
		model.add(new DemoEntity(11, "<u>lorem ipsum</u><br /><img src='http://i.imgur.com/8NgPJIz.jpg'>"));
		model.add(new DemoEntity(12, "lorem ipsum<br /><img src='http://i.imgur.com/NfR1KER.jpg'>"));
		model.add(new DemoEntity(13, "lorem ipsum<br /><img src='http://i.imgur.com/uqXqN8u.jpg'>"));
		model.add(new DemoEntity(14, "lorem ipsum<br /><img src='http://i.imgur.com/ENOb9vQ.jpg'>"));
		model.add(new DemoEntity(15, "lorem ipsum<br /><img src='http://i.imgur.com/XKCWuLW.jpg'>"));

		setListAdapter(new DemoEntityAdapter(this, model));
	}
}
