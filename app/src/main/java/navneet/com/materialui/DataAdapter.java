package navneet.com.materialui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
/**
 * Created by Sree on 16-12-2016.
 */
public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private static final String IMAGE_EXTRA = "imagex";
    private ArrayList<GymData> records;
//    private ArrayList<RedRecords> mArrayList;
    private Context context;
    private final static int FADE_DURATION = 1000; // in milliseconds


    public DataAdapter(ArrayList<GymData> records, Context context) {
        this.context=context;
//        this.mArrayList=records;
        this.records=records;}

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final DataAdapter.ViewHolder holder, int position) {
        final String date,time,image;
        date=records.get(position).getDate();
        time=records.get(position).getTime();
        image=records.get(position).getImage();
        holder.date.setText(date);
        holder.time.setText(time);
        if (image.equals("image1")){
            Picasso.with(context).load(R.drawable.boy_workout).into(holder.img);
        } else if (image.equals("image2")){
            Picasso.with(context).load(R.drawable.girl_workout).into(holder.img);
        } else if (image.equals("image3")) {
            Picasso.with(context).load(R.drawable.dumbbell_workout).into(holder.img);
        }else if (image.equals("image4")) {
            Picasso.with(context).load(R.drawable.yoga_workout).into(holder.img);
        }else  {
            Picasso.with(context).load(R.drawable.biceps_workouts).into(holder.img);
        }
//        setFadeAnimation(holder.itemView);
        setScaleAnimation(holder.itemView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsActivity.class);
// Pass data object in the bundle and populate details activity.

                Pair<View, String> p1 = Pair.create((View) holder.img, "profile");
                Pair<View, String> p2 = Pair.create((View)holder.date, "date");
                Pair<View, String> p3 = Pair.create((View)holder.time, "time");
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation((Activity) context,p1,p2,p3);
                intent.putExtra(IMAGE_EXTRA,image);
                context.startActivity(intent, options.toBundle());
            }
        });

//        city=records.get(position).getCity();
//        district=records.get(position).getDistrict();
//        state=records.get(position).getState();
//        if (!hpName.equals("NA")) {
//            holder.tv_name.setVisibility(View.VISIBLE);
//            holder.tv_name.setText(hpName);
//        }
//        if (!address.equals("NA")) {
//            holder.tv_version.setVisibility(View.VISIBLE);
//            holder.tv_version.setText(address);
//        }
//        if (!phNo.equals("NA")) {
//            holder.tv_api_level.setVisibility(View.VISIBLE);
//            holder.tv_api_level.setText(phNo);
//        }
//        if (!city.equals("NA")) {
//            holder.city.setVisibility(View.VISIBLE);
//            holder.city.setText(city);
//        }
//        if (!district.equals("NA")) {
//            holder.district.setVisibility(View.VISIBLE);
//            holder.district.setText(district);
//        }
//        if (!state.equals("NA")) {
//            holder.state.setVisibility(View.VISIBLE);
//            holder.state.setText(state);
//        }
    }

    private void setFadeAnimation(View view) {
        AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(FADE_DURATION);
        view.startAnimation(anim);
    }
    private void setScaleAnimation(View view) {
        ScaleAnimation anim = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        anim.setDuration(FADE_DURATION);
        view.startAnimation(anim);
    }

    @Override
    public int getItemCount() {
        return records.size();
    }

//    @Override
//    public Filter getFilter() {
//
//        return new Filter() {
//            @Override
//            protected FilterResults performFiltering(CharSequence charSequence) {
//
//                String charString = charSequence.toString();
//
//                if (charString.isEmpty()) {
//
//                    records = mArrayList;
//                } else {
//
//                    ArrayList<RedRecords> filteredList = new ArrayList<>();
//
//                    for (RedRecords redRecords : mArrayList) {
//
//                        if (redRecords.getCity().toLowerCase().contains(charString) || redRecords.getDistrict().toLowerCase().contains(charString) || redRecords.getState().toLowerCase().contains(charString)) {
//
//                            filteredList.add(redRecords);
//                        }
//                    }
//
//                    records = filteredList;
//                }
//
//                FilterResults filterResults = new FilterResults();
//                filterResults.values = records;
//                return filterResults;
//            }
//
//            @Override
//            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
//                records = (ArrayList<RedRecords>) filterResults.values;
//                notifyDataSetChanged();
//            }
//        };
//    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView date,time;
        private RelativeLayout wrapL;
        private ImageView img;
        public ViewHolder(View view) {
            super(view);

            date = (TextView)view.findViewById(R.id.label1);
            time = (TextView)view.findViewById(R.id.label3);
            img=(ImageView)view.findViewById(R.id.workout);
            wrapL=(RelativeLayout)view.findViewById(R.id.wrapLayout);


        }
    }


}
