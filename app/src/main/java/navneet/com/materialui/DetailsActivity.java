package navneet.com.materialui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static android.R.attr.bitmap;

public class DetailsActivity extends AppCompatActivity {
    private static final String IMAGE_EXTRA = "imagex";
    private ImageView imageView;
//    RelativeLayout relativeLayout;
//    Paint paint;
//    View view;
//    Path path2;
//    Bitmap bitmap;
//    Canvas canvas;
//    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        imageView=(ImageView) findViewById(R.id.workout);
        String image=getIntent().getStringExtra(IMAGE_EXTRA);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.drawable.dumb);
        Drawable d;
//        if (image.equals("image1")) {
//            d = getResources().getDrawable(R.drawable.boy_work);
//        } else if (image.equals("image1")){
//           d = getResources().getDrawable(R.drawable.boy_work);
//        }
//        else if (image.equals("image1")){
//           d = getResources().getDrawable(R.drawable.boy_work);
//        }else if (image.equals("image1")){
//           d = getResources().getDrawable(R.drawable.boy_work);
//        }else {
             d = getResources().getDrawable(R.drawable.boy_work);
//        }
        getSupportActionBar().setBackgroundDrawable(d);


        if (image.equals("image1")){
            Picasso.with(this).load(R.drawable.boy_workout).into(imageView);
        } else if (image.equals("image2")){
            Picasso.with(this).load(R.drawable.girl_workout).into(imageView);
        } else if (image.equals("image3")) {
            Picasso.with(this).load(R.drawable.dumbbell_workout).into(imageView);
        }else if (image.equals("image4")) {
            Picasso.with(this).load(R.drawable.yoga_workout).into(imageView);
        }else  {
            Picasso.with(this).load(R.drawable.biceps_workouts).into(imageView);
        }


//        relativeLayout = (RelativeLayout) findViewById(R.id.wrapLayout);
//
//        button = (Button)findViewById(R.id.button);
//
//        view = new SketchSheetView(DetailsActivity.this);
//
//        paint = new Paint();
//
//        path2 = new Path();
//
//        relativeLayout.addView(view, new ActionBar.LayoutParams(
//                RelativeLayout.LayoutParams.MATCH_PARENT,
//                RelativeLayout.LayoutParams.MATCH_PARENT));
//
//        paint.setDither(true);
//
//        paint.setColor(Color.parseColor("#000000"));
//
//        paint.setStyle(Paint.Style.STROKE);
//
//        paint.setStrokeJoin(Paint.Join.ROUND);
//
//        paint.setStrokeCap(Paint.Cap.ROUND);
//
//        paint.setStrokeWidth(2);
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                path2.reset();
//            }
//        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


//    class SketchSheetView extends View {
//
//        public SketchSheetView(Context context) {
//
//            super(context);
//
//            bitmap = Bitmap.createBitmap(820, 480, Bitmap.Config.ARGB_4444);
//
//            canvas = new Canvas(bitmap);
//
//            this.setBackgroundColor(Color.WHITE);
//        }
//
//        private ArrayList<DrawingClass> DrawingClassArrayList = new ArrayList<DrawingClass>();
//
//        @Override
//        public boolean onTouchEvent(MotionEvent event) {
//
//            DrawingClass pathWithPaint = new DrawingClass();
//
//            canvas.drawPath(path2, paint);
//
//            if (event.getAction() == MotionEvent.ACTION_DOWN) {
//
//                path2.moveTo(event.getX(), event.getY());
//
//                path2.lineTo(event.getX(), event.getY());
//            }
//            else if (event.getAction() == MotionEvent.ACTION_MOVE) {
//
//                path2.lineTo(event.getX(), event.getY());
//
//                pathWithPaint.setPath(path2);
//
//                pathWithPaint.setPaint(paint);
//
//                DrawingClassArrayList.add(pathWithPaint);
//            }
//
//            invalidate();
//            return true;
//        }
//
//        @Override
//        protected void onDraw(Canvas canvas) {
//            super.onDraw(canvas);
//            if (DrawingClassArrayList.size() > 0) {
//
//                canvas.drawPath(
//                        DrawingClassArrayList.get(DrawingClassArrayList.size() - 1).getPath(),
//
//                        DrawingClassArrayList.get(DrawingClassArrayList.size() - 1).getPaint());
//            }
//        }
//    }
//
//    public class DrawingClass {
//
//        Path DrawingClassPath;
//        Paint DrawingClassPaint;
//
//        public Path getPath() {
//            return DrawingClassPath;
//        }
//
//        public void setPath(Path path) {
//            this.DrawingClassPath = path;
//        }
//
//
//        public Paint getPaint() {
//            return DrawingClassPaint;
//        }
//
//        public void setPaint(Paint paint) {
//            this.DrawingClassPaint = paint;
//        }
//    }

}
