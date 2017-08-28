package navneet.com.materialui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView vibrate;
    private ArrayList<GymData> gymDataList = new ArrayList<>();
    private RecyclerView recyclerView;
    private DataAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.dumb);
        Drawable d = getResources().getDrawable(R.drawable.boy_work);
        getSupportActionBar().setBackgroundDrawable(d);

//        final Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
//        vibrate = (TextView) findViewById(R.id.req_ses);
//        vibrate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                vibe.vibrate(100);
//            }
//        });

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new DataAdapter(gymDataList,MainActivity.this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareGymData();
    }

    private void prepareGymData() {
        GymData gymData = new GymData("01 02 2017", "4:30 pm", "image1");
        gymDataList.add(gymData);

        gymData = new GymData("01 02 2017", "4:30 pm", "image2");
        gymDataList.add(gymData);

        gymData = new GymData("01 02 2017", "5:30 pm", "image3");
        gymDataList.add(gymData);

        gymData = new GymData("01 02 2017", "7:30 pm", "image4");
        gymDataList.add(gymData);

        gymData = new GymData("01 02 2017", "4:30 pm", "image5");
        gymDataList.add(gymData);

        gymData = new GymData("01 02 2017", "4:30 pm", "2015");
        gymDataList.add(gymData);

        gymData = new GymData("01 02 2017", "4:30 pm", "2009");
        gymDataList.add(gymData);

        gymData = new GymData("01 02 2017", "4:30 pm", "2009");
        gymDataList.add(gymData);

        gymData = new GymData("The LEGO GymData", "4:30 pm", "2014");
        gymDataList.add(gymData);


        mAdapter.notifyDataSetChanged();
    }
}
