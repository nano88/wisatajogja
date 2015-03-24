package com.nano.nano;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

	private ImageView profile;
	private ImageView web, contact;
	private ImageView fb, twitter, gplus;

	public int currentimageindex = 0;

	ImageView slidingimage;

	private int[] IMAGE_IDS = { R.drawable.slide1, R.drawable.slide2,
			R.drawable.slide3 };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		TextView txt = (TextView) findViewById(R.id.jpTv);
		TextView menu = (TextView) findViewById(R.id.menuTv);

		Typeface font = Typeface.createFromAsset(getAssets(),
				"Fonts/Molle-Regular.ttf");
		txt.setTypeface(font);
		menu.setTypeface(font);

		profile = (ImageView) findViewById(R.id.profile);
		web = (ImageView) findViewById(R.id.web);
		contact = (ImageView) findViewById(R.id.contact);
		fb = (ImageView) findViewById(R.id.fb);
		twitter = (ImageView) findViewById(R.id.twitter);
		gplus = (ImageView) findViewById(R.id.gplus);

		profile.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent b = new Intent(MainActivity.this, Profiles.class);
				startActivity(b);
			}
		});

		web.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent s = new Intent(MainActivity.this, Web.class);
				startActivity(s);
			}
		});

		contact.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent d = new Intent(MainActivity.this, Contact.class);
				startActivity(d);
			}
		});

		fb.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent e = new Intent(MainActivity.this, Fb.class);
				startActivity(e);
			}
		});

		twitter.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent f = new Intent(MainActivity.this, Twitter.class);
				startActivity(f);
			}
		});

		gplus.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent g = new Intent(MainActivity.this, Gplus.class);
				startActivity(g);
			}
		});

		final Handler mHandler = new Handler();
		final Runnable mUpdateResults = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				AnimateandSlideShow();
			}
		};

		int delay = 2000;
		int period = 3000;
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				mHandler.post(mUpdateResults);
			}
		}, delay, period);
	}

	public void onClick(View v) {
		finish();
		android.os.Process.killProcess(android.os.Process.myPid());
	}

	/**
	 * Helper method untuk memulai animation pada splash screen
	 */
	private void AnimateandSlideShow() {

		slidingimage = (ImageView) findViewById(R.id.ImageView3_Left);
		slidingimage.setImageResource(IMAGE_IDS[currentimageindex
				% IMAGE_IDS.length]);

		currentimageindex++;

		Animation rotateimage = AnimationUtils.loadAnimation(this,
				R.anim.fade_in);

		slidingimage.startAnimation(rotateimage);

	}

	public void Profiles(View view) {
		Intent intent = new Intent(MainActivity.this, Profiles.class);
		startActivity(intent);
	}

	// menjadikan tombol back dalam activity ini mengakhiri aplikasi / exit
	public void onBackPressed() {
		Intent intent = new Intent(Intent.ACTION_MAIN);
		intent.addCategory(Intent.CATEGORY_HOME);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(intent);
	}

}
