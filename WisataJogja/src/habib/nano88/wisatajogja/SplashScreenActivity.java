package habib.nano88.wisatajogja;

import habib.nano88.wisatajogja.model.Lokasi;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

public class SplashScreenActivity extends Activity {
	
	public static ArrayList<Lokasi> data; // agar data dapat diakses di class lain harus public static
	/** Called when the activity is first created. */
	private final Handler mHandler = new Handler();
	private static final int duration = 5 * 1000;	

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_splash_screen);

		mHandler.postDelayed(mPendingLauncherRunnable,
				SplashScreenActivity.duration);
		
	}

	@Override
	protected void onPause() {
		super.onPause();
		mHandler.removeCallbacks(mPendingLauncherRunnable);
	}

	private final Runnable mPendingLauncherRunnable = new Runnable() {

		public void run() {
			final Intent intent = new Intent(SplashScreenActivity.this,
					MainActivity.class);
			
			startActivity(intent);
			finish();
		}
	};
	
	
	
}
