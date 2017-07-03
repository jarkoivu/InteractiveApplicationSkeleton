package com.example.jari.interactiveappskeleton;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,
            GestureDetector.OnDoubleTapListener
{

    private TextView editText;
    private GestureDetectorCompat gestureDetectorCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button enterButton = (Button)findViewById(R.id.enterButton);
        editText = (TextView)findViewById(R.id.editText);
        // detect gestures
        this.gestureDetectorCompat = new GestureDetectorCompat(this,this);
        // detect also double taps
        gestureDetectorCompat.setOnDoubleTapListener(this);

        //Tap click listener
        enterButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        //editText = (TextView)findViewById(R.id.editText);
                        editText.setText("Good job me!");
                    }
                }
        );

        // Long click listener
        enterButton.setOnLongClickListener(
                new Button.OnLongClickListener(){
                    public boolean onLongClick(View v){
                        //editText = (TextView)findViewById(R.id.editText);
                        editText.setText("Good long job me!");
                        return true;
                    }
                }
        );

    }

    ////////////////////// Begin Gestures //////////////////////

    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        editText.setText("onSingleTapConfirmed");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        editText.setText("onDoubleTap");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        editText.setText("onDoubleTapEvent");
        return true;
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        editText.setText("onDown");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {
        editText.setText("onShowPress");

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        editText.setText("onSingleTapUp");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        editText.setText("onScroll");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {
        editText.setText("onLongPress");
    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        editText.setText("onFling");
        return true;
    }

    ////////////////////// End Gestures //////////////////////


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetectorCompat.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}
