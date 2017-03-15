package example.com.card2d;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
        private ImageView iva,ivb;
        private ScaleAnimation sa0=new ScaleAnimation
                (1,0,1,1, Animation.RELATIVE_TO_PARENT,0.5f,Animation.RELATIVE_TO_PARENT,0.5f);
        private ScaleAnimation sa1=new ScaleAnimation
                (0,1,1,1, Animation.RELATIVE_TO_PARENT,0.5f,Animation.RELATIVE_TO_PARENT,0.5f);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iva= (ImageView) findViewById(R.id.iva);
        ivb= (ImageView) findViewById(R.id.ivb);
        initView();
        findViewById(R.id.activity_main).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iva.getVisibility()==View.VISIBLE){
                    iva.startAnimation(sa0);
                }else {
                    ivb.startAnimation(sa0);
                }
            }
        });
    }
    private void showiva(){
        iva.setVisibility(View.VISIBLE);
        ivb.setVisibility(View.INVISIBLE);
    }
    private void showivb(){
        iva.setVisibility(View.INVISIBLE);
        ivb.setVisibility(View.VISIBLE);
    }
    private void initView(){
        showiva();
        sa0.setDuration(500);
        sa1.setDuration(500);
        sa0.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                    if (iva.getVisibility()==View.VISIBLE){
                        iva.setAnimation(null);
                        showivb();
                        ivb.startAnimation(sa1);
                    }else {
                        ivb.setAnimation(null);
                        showiva();
                        iva.startAnimation(sa1);
                    }
            }
            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

}
