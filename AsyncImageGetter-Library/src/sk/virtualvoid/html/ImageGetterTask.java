package sk.virtualvoid.html;

import java.io.File;

import sk.virtualvoid.LibraryConstants;
import sk.virtualvoid.tools.BitmapUtility;
import sk.virtualvoid.tools.FileDownloader;
import sk.virtualvoid.tools.FileDownloaderFactory;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Log;

/**
 * 
 * @author suchan_j
 *
 */
public class ImageGetterTask extends AsyncTask<Void, Void, Drawable> {
	private Resources resources;
	private ImageGetterTaskListener taskListener;
	private ImageGetterTaskData taskData;
	
	private ImageGetterTask() {		
	}
	
	public static ImageGetterTask create(Resources resources, ImageGetterTaskListener taskListener, ImageGetterTaskData taskData) {
		ImageGetterTask task = new ImageGetterTask();
		
		task.resources = resources;
		task.taskListener = taskListener;
		task.taskData = taskData;
		
		return task;
	}
	
	@Override
	protected Drawable doInBackground(Void... params) {
		try {
			FileDownloader fileDownloader = FileDownloaderFactory.get();
			File file = fileDownloader.download(taskData.getSourceUrl());
			if (file == null) {
				return null;
			}
			
			Bitmap bitmap = BitmapUtility.getBitmapFromFile(file);
			if (bitmap == null) {
				return null;
			}
			
			Drawable resultDrawable = new BitmapDrawable(resources, bitmap);
			resultDrawable.setBounds(0, 0, resultDrawable.getIntrinsicWidth(), resultDrawable.getIntrinsicHeight());
			return resultDrawable;
		} catch (Throwable e) {
			Log.e(LibraryConstants.TAG, String.format("Unable to obtain drawable: %s", e.getMessage()));
		}
		return null;
	}
	
	@Override
	protected void onPostExecute(Drawable resultDrawable) {
		if (resultDrawable == null) {
			taskListener.onFailed(taskData);
		} else {
			taskListener.onSuccess(taskData, resultDrawable);
		}
	}
}
