package com.course.example.clockflipper;

//ViewFlipper with animation

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ToggleButton;
import android.widget.ViewFlipper;

public class MainActivity extends Activity implements OnClickListener{

    private ToggleButton myToggleButton;
    private Button previousView, nextView;
    private Animation slide_in_left, slide_in_right, slide_out_left, slide_out_right;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get references to our buttons and toogle button
        myToggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        previousView = (Button) findViewById(R.id.previousView);
        nextView = (Button) findViewById(R.id.nextView);

        //attach onClick listeners to the buttons
        myToggleButton.setOnClickListener(this);
        previousView.setOnClickListener(this);
        nextView.setOnClickListener(this);

        //create animations
        slide_in_left = AnimationUtils.loadAnimation(this, R.anim.slide_in_left);
        slide_in_right = AnimationUtils.loadAnimation(this, R.anim.slide_in_right);
        slide_out_left = AnimationUtils.loadAnimation(this, R.anim.slide_out_left);
        slide_out_right = AnimationUtils.loadAnimation(this, R.anim.slide_out_right);

    }

    @Override
    public void onClick(View v) {

        //get reference to the view flipper
        ViewFlipper myViewFlipper = (ViewFlipper) findViewById(R.id.myViewFlipper);
        //set the animation for the view that enters the screen
        myViewFlipper.setInAnimation(slide_in_right);
        //set the animation for the view leaving th screen
        myViewFlipper.setOutAnimation(slide_out_left);

        switch (v.getId()) {
            case R.id.nextView:
                //show the next view
                myViewFlipper.showNext();
                break;

            case R.id.previousView:
                //show the next view
                myViewFlipper.setInAnimation(slide_in_left);
                myViewFlipper.setOutAnimation(slide_out_right);
                myViewFlipper.showNext();
                break;

            case R.id.toggleButton:

                if(myToggleButton.isChecked()){
                    //set flipper interval
                    myViewFlipper.setFlipInterval(6000);
                    //start flipping the views
                    myViewFlipper.startFlipping();
                }
                else{
                    //stop flipping the views
                    myViewFlipper.stopFlipping();
                }
                break;

        }
    }

}

