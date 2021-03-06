package appewtc.masterung.fetlqrcode;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by masterUNG on 5/18/2017 AD.
 */

public class MyAdapter extends BaseAdapter{

    private Context context;
    private String[] iconStrings, titleStrings, detailStrings;
    private ImageView imageView;
    private TextView titleTextView, detailTextView;
    private String detailShort;

    public MyAdapter(Context context,
                     String[] iconStrings,
                     String[] titleStrings,
                     String[] detailStrings) {
        this.context = context;
        this.iconStrings = iconStrings;
        this.titleStrings = titleStrings;
        this.detailStrings = detailStrings;
    }

    @Override
    public int getCount() {
        return titleStrings.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.listview_layout, viewGroup, false);

        //Initial View
        imageView = (ImageView) view1.findViewById(R.id.imvIcon);
        titleTextView = (TextView) view1.findViewById(R.id.txtTitle);
        detailTextView = (TextView) view1.findViewById(R.id.txtDetail);

        //Show Text
        titleTextView.setText(titleStrings[i]);

        if (detailStrings[i].length() > 30) {
            detailShort = detailStrings[i].substring(0, 30) + " ...";
        } else {
            detailShort = detailStrings[i];
        }
        detailTextView.setText(detailShort);

        //Show Image
        Picasso.with(context).load(iconStrings[i]).into(imageView);

        return view1;
    }
}   //Main Class
