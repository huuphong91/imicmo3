package com.phongtoanhuu.hhh.imicmo3.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.phongtoanhuu.hhh.imicmo3.Adapters.VideoAdapter;
import com.phongtoanhuu.hhh.imicmo3.Entities.VideoYouTubeEntity;
import com.phongtoanhuu.hhh.imicmo3.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class VideoActivity extends AppCompatActivity {
    public static String KEY = "AIzaSyB1vTBdStFevc-b8dkLV5F95YnoILsej1E";
    int MAX_RESULTS_PERPAGE = 20;



    //KEY:  API KEY, tạo trên trang: https://console.developers.google.com/
    //LIST:  playlist id trên youtube
    //MAX_RESULTS_PERPAGE: số kết quả tối đa trên mỗi trang

    RecyclerView recyclerView;
    ArrayList<VideoYouTubeEntity> arrayList;
    VideoAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        initControl();
        getJSonYoutube(changeLIST());

    }

    private void getJSonYoutube(final String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonItems = response.getJSONArray("items");
                    String title = "";
                    String url = "";
                    String idVideo = "";
                    for (int i = 0; i < jsonItems.length(); i++) {
                        JSONObject jsonItem = jsonItems.getJSONObject(i);

                        JSONObject jsonSnippet = jsonItem.getJSONObject("snippet");

                        title = jsonSnippet.getString("title");

                        JSONObject jsonThumbnail = jsonSnippet.getJSONObject("thumbnails");
                        JSONObject jsonMedium = jsonThumbnail.getJSONObject("medium");
                        url = jsonMedium.getString("url");

                        JSONObject jsonResourceId = jsonSnippet.getJSONObject("resourceId");
                        idVideo = jsonResourceId.getString("videoId");

                        arrayList.add(new VideoYouTubeEntity(title, url, idVideo));
                    }
                    adapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(VideoActivity.this, "Error", Toast.LENGTH_SHORT).show();

                    }
                }
        );
        requestQueue.add(jsonObjectRequest);
    }

    private String changeLIST() {
        String javaLIST = "PLzrVYRai0riRyY7p2G3eFKIZa7HvB-fnn";
        String androidLIST = "PLzrVYRai0riSRJ3M3bifVWWRq5eJMu6tv";
        String phpLIST = "PLzrVYRai0riSPsyn0sIbGK1NQxhjNFXlp";
        Intent intent = getIntent();
        String temp;
        temp = intent.getStringExtra("VGroupId");
        String LIST = "";
        if (temp.equals("1"))
            LIST = javaLIST;
        if (temp.equals("2"))
            LIST = androidLIST;
        if (temp.equals("3"))
            LIST = phpLIST;

        return "https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&maxResults=" + MAX_RESULTS_PERPAGE + "&playlistId=" +
                LIST + "&key=" + KEY;
    }

    private void initControl() {
        recyclerView = findViewById(R.id.recyclerview_video);
        recyclerView.setLayoutManager(new GridLayoutManager(VideoActivity.this, 2));
        recyclerView.setHasFixedSize(true);
        arrayList = new ArrayList<>();
        adapter = new VideoAdapter(VideoActivity.this, arrayList);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new VideoAdapter.ItemClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Intent intent = new Intent(VideoActivity.this, PlayActivity.class);
                intent.putExtra("idVideoYoutube", arrayList.get(position).getIdVideo());
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(int position, View v) {
                Intent intent = new Intent(VideoActivity.this, PlayActivity.class);
                intent.putExtra("idVideoYoutube", arrayList.get(position).getIdVideo());
                startActivity(intent);
            }
        });

    }
}
