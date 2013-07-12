package sk.virtualvoid.tools;

import java.io.File;

import sk.virtualvoid.LibraryConstants;

import android.util.Log;

/**
 * 
 * @author suchan_j
 * 
 */
public final class FileDownloaderImpl extends FileDownloaderUtility implements FileDownloader {
	
	protected FileDownloaderImpl() {
	}

	@Override
	public File download(String sourceUrl) {
		File temp = getTempDirectory();
		File file = new File(temp, getFileNameFromUrl(sourceUrl));
		try {			
			if (!file.exists()) {
				downloadTo(sourceUrl, file);
			}			
		} catch (Throwable e) {
			Log.w(LibraryConstants.TAG, String.format("Unable (%s) to download: %s", e.getMessage(), sourceUrl));
		}
		return file;
	}
}
