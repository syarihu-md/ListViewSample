package net.syarihu.test.listviewsample;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.format.Time;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity implements ItemFragment.OnFragmentInteractionListener {
    private final String URL = "http://api.openweathermap.org/data/2.5/forecast/daily?lat=35.656470&lon=139.699470&mode=json&cnt=14";
    private RequestQueue mQueue;
    ArrayList<Weather.Detail> mList;
    MyListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager manager = getFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        final ItemFragment fragment = ItemFragment.newInstance("", "");
        mList = new ArrayList<>();
        mQueue = Volley.newRequestQueue(this);
        mAdapter = new MyListAdapter(this, R.layout.list_item, mList, mQueue);
//        ArrayAdapter<String> items = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, android.R.id.text1, list);
        ft.replace(R.id.content, fragment);
        ft.commit();

        mQueue.add(new JsonObjectRequest(Request.Method.GET, URL,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // JSONObjectのパース、List、Viewへの追加等
                        Gson gson = new Gson();
                        Weather weather = gson.fromJson(response.toString(), Weather.class);
                        Log.v("test", "CityName: " + weather.getCity().getName());
                        List<Weather.Detail> list = weather.getList();
                        for(int i = 0;i < list.size();i++) {
                            mList.add(weather.list.get(i));
                            Time time = new Time();
                            time.set(Long.valueOf(list.get(i).getDt()));
                            Log.v("test", "Dt: " + time.hour + ":" + time.minute);
                            Log.v("test", "Temp: " + list.get(i).getTemp().getMax());
                            List<Weather.Detail.WeatherDetail> details = list.get(i).getWeather();
                            for(int j = 0; j < details.size();j++) {
                                Log.v("test", "Icon: " + list.get(i).getWeather().get(j).getIcon());
                            }
                        }
                        fragment.setListAdapter(mAdapter);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // エラー処理 error.networkResponseで確認
                        // エラー表示など
                        if(error != null) {
                            Log.e("ErrorResponse", error.getMessage());
                        }else {
                            Log.e("ErrorResponse", "null");
                        }
                    }
                }));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
    }
}
