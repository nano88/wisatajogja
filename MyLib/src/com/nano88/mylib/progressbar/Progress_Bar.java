package com.nano88.mylib.progressbar;


import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;

import com.nano88.mylib.R;

public class Progress_Bar extends Activity {

   private ProgressDialog progress;
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_progress_bar);
      progress = new ProgressDialog(this);
   }


   public void open(View view){
      progress.setMessage("Downloading Music :) ");
      progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
      progress.setIndeterminate(true);
      progress.show();

   final int totalProgressTime = 100;

   final Thread t = new Thread(){

   @Override
   public void run(){
 
      int jumpTime = 0;
      while(jumpTime < totalProgressTime){
         try {
            sleep(200);
            jumpTime += 50;
            progress.setProgress(jumpTime);
         } catch (InterruptedException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
         }

      }

   }
   };
   t.start();

   }
}