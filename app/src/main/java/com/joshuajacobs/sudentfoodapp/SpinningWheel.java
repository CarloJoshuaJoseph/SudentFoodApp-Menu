package com.joshuajacobs.sudentfoodapp;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class SpinningWheel extends AppCompatActivity {

    private ImageView wheelImage;
    private Button spinButton;
    private TextView resultText;
    private Random random;

    private static final int[] sectors = {50, 150, 0, 0, 2, 500, 1000, 1};
    private static final float[] sectorAngles = {45f, 135f, 225f, 315f, 405f, 495f, 585f, 675f};
    private static final String[] sectorMessages = {"Congratulations, you won 50 credits!",
            "Congratulations, you won 150 credits!",
            "Congratulations, you won a free drink!",
            "Congratulations, you won a free meal!",
            "Congratulations, you won double credits!",
            "Congratulations, you won 500 credits!",
            "Congratulations, you won 1000 credits!",
            "Congratulations, you won a reward selector!"};

    private static final int ANIMATION_DURATION = 3000;
    private static final int ANIMATION_DELAY = 500;

    private boolean spinning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinning_wheel);

        wheelImage = findViewById(R.id.imageWheel);
        spinButton = findViewById(R.id.buttonSpin);
        resultText = findViewById(R.id.result_text);
        random = new Random();

        spinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!spinning) {
                    int randomSector = spinWheel();
                    int degrees = (int) (randomSector * 45f) + random.nextInt(45);
                    rotateWheel(degrees);
                    resultText.setText(sectorMessages[randomSector]);
                    spinButton.setText("Spin Again");
                }
            }
        });
    }

    private int spinWheel() {
        return random.nextInt(sectors.length);
    }

    private void rotateWheel(int degrees) {
        RotateAnimation rotateAnimation = new RotateAnimation(0, degrees + 360 * 5, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(ANIMATION_DURATION);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setInterpolator(new DecelerateInterpolator());

        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                spinning = true;
                spinButton.setEnabled(false);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                spinning = false;
                spinButton.setEnabled(true);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        wheelImage.startAnimation(rotateAnimation);
    }
}
