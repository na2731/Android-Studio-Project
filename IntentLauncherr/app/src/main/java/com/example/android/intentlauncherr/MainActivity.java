package com.example.android.intentlauncherr;

import android.content.Intent;
import android.hardware.Camera;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "Button1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void AnotherActivity(View view){
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
        boolean hascheckBox = checkBox.isChecked();
        if(!hascheckBox){
            Intent intent=new Intent(this,InclassAssignment.class);
            EditText editText=(EditText)findViewById(R.id.Message);
            String message=editText.getText().toString();
            intent.putExtra(EXTRA_MESSAGE,message);
            startActivity(intent);
        }
        else{
            Intent intent=new Intent(this,InclassAssignment.class);
            EditText editText=(EditText)findViewById(R.id.Message);
            String message = "";
            intent.putExtra(EXTRA_MESSAGE,message);
            startActivity(intent);
        }

    }

    static final int REQUEST_IMAGE_CAPTURE = 1;

//    public void dispatchTakePictureIntent() {
//        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
//            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
//        }
//    }

//    private boolean safeCameraOpen(int id) {
//        boolean qOpened = false;
//
//        try {
//            releaseCameraAndPreview();
//            Camera mCamera = Camera.open(id);
//            qOpened = (mCamera != null);
//        } catch (Exception e) {
//            Log.e(getString(R.string.app_name), "failed to open Camera");
//            e.printStackTrace();
//        }
//
//        return qOpened;
//    }
//
//    private void releaseCameraAndPreview() {
//        mPreview.setCamera(null);
//        if (mCamera != null) {
//            mCamera.release();
//            mCamera = null;
//        }
//    }

     public void openCamera(View view){

         Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

         if (intent.resolveActivity(getPackageManager()) != null) {
             startActivity(intent);
         }


//         Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
//         startActivity(intent);
     }


     public void sendEmail(View view) {
         CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
         boolean hascheckBox = checkBox.isChecked();
         if (hascheckBox) {
             EditText title = (EditText) findViewById(R.id.Edit_text);
             EditText meSsage = (EditText) findViewById(R.id.Message);
             String titleText = title.getText().toString() + meSsage.getText().toString();
             Intent intent = new Intent(Intent.ACTION_SENDTO);
             intent.setData(Uri.parse("mailto:"));
             intent.putExtra(getIntent().EXTRA_SUBJECT, title.getText().toString());

             if (intent.resolveActivity(getPackageManager()) != null) {
                 startActivity(intent);
             }
         }
         if(!hascheckBox){
             EditText title = (EditText) findViewById(R.id.Edit_text);
            EditText meSsage = (EditText) findViewById(R.id.Message);
             String titleText = title.getText().toString() + meSsage.getText().toString();

            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:"));
             intent.putExtra(getIntent().EXTRA_SUBJECT, title.getText().toString());
             intent.putExtra(getIntent().EXTRA_TEXT, meSsage.getText().toString());


             if (intent.resolveActivity(getPackageManager()) != null) {
                 startActivity(intent);
             }

         }
     }


}