package net.syarihu.test.listviewsample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;

/**
 * Created by usr0200500 on 2015/04/17.
 */
public class MyListAdapter extends ArrayAdapter<Weather.Detail> {
    Context mContext;
    ArrayList<Weather.Detail> mItems;
    LayoutInflater mInflater;
    RequestQueue queue;

    public MyListAdapter(Context context, int resource, ArrayList<Weather.Detail> objects, RequestQueue queue) {
        super(context, resource, objects);
        mInflater = LayoutInflater.from(context);
        mItems = objects;
        mContext = context;
        this.queue = queue;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Weather.Detail getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = mInflater.inflate(R.layout.list_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.item1 = (TextView) view.findViewById(R.id.list_item1);
            viewHolder.item2 = (TextView) view.findViewById(R.id.list_item2);
            viewHolder.bitmap = (NetworkImageView) view.findViewById(R.id.bitmap1);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.item1.setText("Date: " + mItems.get(position).getDt());
        viewHolder.item2.setText("Max: " + mItems.get(position).getTemp().getMax());

//        viewHolder.bitmap.setImageBitmap(BitmapFactory.decodeResource(mContext.getResources(), R.mipmap.ic_launcher));

        viewHolder.bitmap.setImageUrl(
                "http://openweathermap.org/img/w/"
                        + mItems.get(position).getWeather().get(0).getIcon() + ".png",
                new ImageLoader(queue, new LruCacheSample())
        );

//        ItemLayout view;
//        if(convertView == null) {
//            view = (ItemLayout) mInflator.inflate(R.layout.list_item, parent, false);
//        }else{
//            view = (ItemLayout)convertView;
//        }
//        view.bindView(mItems.get(position));
        return view;
    }

    static class ViewHolder {
        TextView item1;
        TextView item2;
        NetworkImageView bitmap;
    }
}
