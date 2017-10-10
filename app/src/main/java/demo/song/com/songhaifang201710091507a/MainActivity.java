package demo.song.com.songhaifang201710091507a;

import android.animation.ValueAnimator;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    SuperCircleView mSuperCircleView;
    TextView textView;
    private ValueAnimator valueAnimator;
    int[] colors ={Color.RED,Color.RED,Color.RED};
    int[] colors2 ={Color.GRAY,Color.GRAY,Color.GRAY};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.tv);
        mSuperCircleView = (SuperCircleView) findViewById(R.id.superview);
        mSuperCircleView.setShowSelect(false);
        valueAnimator = ValueAnimator.ofInt(0, 100);
        valueAnimator.setTarget(textView);
        valueAnimator.setDuration(30000);
        textView.setText("78");
        valueAnimator.start();
    }
    public void but2(View v){
        valueAnimator.setDuration(30000);
        valueAnimator.start();
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int i = Integer.valueOf(String.valueOf(animation.getAnimatedValue()));
                textView.setText(i + "");
                mSuperCircleView.setSelect((int) (360 * (i / 100f)));
            }
        });
    }
    public void but3(View v){
        valueAnimator.end();
        textView.setText("0");
    }
    public void but1(View v){
        mSuperCircleView.setColor(colors);

    }
}
