package com.rabbitfootTUN_SD.pYrplerabbYt;

import android.app.Activity;
import android.app.Application;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import java.io.IOException;
import java.util.ArrayList;

public class wallpaper extends Activity
  implements View.OnClickListener, AdapterView.OnItemSelectedListener
{
  private Bitmap mBitmap;
  private Gallery mGallery;
  private ImageView mImageView;
  private ArrayList<Integer> mImages;
  private boolean mIsWallpaperSet;
  private WallpaperLoader mLoader;
  private ArrayList<Integer> mThumbs;

  private void addWallpapers(Resources paramResources, String paramString, int paramInt)
  {
    String[] arrayOfString = paramResources.getStringArray(paramInt);
    int i = arrayOfString.length;
    for (int k = 0; ; k++)
    {
      if (k >= i)
        return;
      String str = arrayOfString[k];
      int j = paramResources.getIdentifier(str, "drawable", paramString);
      if (j == 0)
        continue;
      int m = paramResources.getIdentifier(str + "_small", "drawable", paramString);
      if (m == 0)
        continue;
      this.mThumbs.add(Integer.valueOf(m));
      this.mImages.add(Integer.valueOf(j));
    }
  }

  private void findWallpapers()
  {
    this.mThumbs = new ArrayList(24);
    this.mImages = new ArrayList(24);
    Resources localResources = getResources();
    String str = getApplication().getPackageName();
    addWallpapers(localResources, str, 168230915);
    addWallpapers(localResources, str, 168230913);
  }

  private void selectWallpaper(int paramInt)
  {
    if (this.mIsWallpaperSet);
    while (true)
    {
      return;
      this.mIsWallpaperSet = true;
      try
      {
        setWallpaper(getResources().openRawResource(((Integer)this.mImages.get(paramInt)).intValue()));
        setResult(-1);
        finish();
      }
      catch (IOException localIOException)
      {
        Log.e("Paperless System", "Failed to set wallpaper: " + localIOException);
      }
    }
  }

  public void onClick(View paramView)
  {
    selectWallpaper(this.mGallery.getSelectedItemPosition());
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    findWallpapers();
    setContentView(167968770);
    this.mGallery = ((Gallery)findViewById(168296463));
    this.mGallery.setAdapter(new ImageAdapter(this));
    this.mGallery.setOnItemSelectedListener(this);
    this.mGallery.setCallbackDuringFling(false);
    findViewById(168296464).setOnClickListener(this);
    this.mImageView = ((ImageView)findViewById(168296451));
  }

  protected void onDestroy()
  {
    super.onDestroy();
    if ((this.mLoader != null) && (this.mLoader.getStatus() != AsyncTask.Status.FINISHED))
    {
      this.mLoader.cancel(true);
      this.mLoader = null;
    }
  }

  public void onItemSelected(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((this.mLoader != null) && (this.mLoader.getStatus() != AsyncTask.Status.FINISHED))
      this.mLoader.cancel();
    WallpaperLoader localWallpaperLoader = new WallpaperLoader();
    Integer[] arrayOfInteger = new Integer[1];
    arrayOfInteger[0] = Integer.valueOf(paramInt);
    this.mLoader = ((WallpaperLoader)localWallpaperLoader.execute(arrayOfInteger));
  }

  public void onNothingSelected(AdapterView paramAdapterView)
  {
  }

  protected void onResume()
  {
    super.onResume();
    this.mIsWallpaperSet = false;
  }

  class WallpaperLoader extends AsyncTask<Integer, Void, Bitmap>
  {
    BitmapFactory.Options mOptions = new BitmapFactory.Options();

    WallpaperLoader()
    {
      this.mOptions.inDither = false;
      this.mOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
    }

    void cancel()
    {
      this.mOptions.requestCancelDecode();
      super.cancel(true);
    }

    protected Bitmap doInBackground(Integer[] paramArrayOfInteger)
    {
      Bitmap localBitmap;
      if (isCancelled())
        localBitmap = null;
      while (true)
      {
        return localBitmap;
        try
        {
          localBitmap = BitmapFactory.decodeResource(wallpaper.this.getResources(), ((Integer)wallpaper.this.mImages.get(paramArrayOfInteger[0].intValue())).intValue(), this.mOptions);
          localBitmap = localBitmap;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          localBitmap = null;
        }
      }
    }

    protected void onPostExecute(Bitmap paramBitmap)
    {
      if (paramBitmap != null)
        if ((isCancelled()) || (this.mOptions.mCancel))
        {
          paramBitmap.recycle();
        }
        else
        {
          if (wallpaper.this.mBitmap != null)
            wallpaper.this.mBitmap.recycle();
          ImageView localImageView = wallpaper.this.mImageView;
          localImageView.setImageBitmap(paramBitmap);
          wallpaper.access$202(wallpaper.this, paramBitmap);
          Drawable localDrawable = localImageView.getDrawable();
          localDrawable.setFilterBitmap(true);
          localDrawable.setDither(true);
          localImageView.postInvalidate();
          wallpaper.access$402(wallpaper.this, null);
        }
    }
  }

  private class ImageAdapter extends BaseAdapter
  {
    private LayoutInflater mLayoutInflater;

    ImageAdapter(wallpaper arg2)
    {
      Object localObject;
      this.mLayoutInflater = localObject.getLayoutInflater();
    }

    public int getCount()
    {
      return wallpaper.this.mThumbs.size();
    }

    public Object getItem(int paramInt)
    {
      return Integer.valueOf(paramInt);
    }

    public long getItemId(int paramInt)
    {
      return paramInt;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      ImageView localImageView;
      if (paramView != null)
        localImageView = (ImageView)paramView;
      else
        localImageView = (ImageView)this.mLayoutInflater.inflate(167968771, paramViewGroup, false);
      int i = ((Integer)wallpaper.this.mThumbs.get(paramInt)).intValue();
      localImageView.setImageResource(i);
      Object localObject = localImageView.getDrawable();
      if (localObject == null)
      {
        localObject = new Object[2];
        localObject[0] = Integer.valueOf(i);
        localObject[1] = Integer.valueOf(paramInt);
        Log.e("Paperless System", String.format("Error decoding thumbnail resId=%d for wallpaper #%d", localObject));
      }
      else
      {
        ((Drawable)localObject).setDither(true);
      }
      return (View)localImageView;
    }
  }
}

/* Location:           C:\Users\speedy\Desktop\NEWapk\jd-gui-0.3.3.windows\classes_dex2jar.jar
 * Qualified Name:     com.rabbitfootTUN_SD.pYrplerabbYt.wallpaper
 * JD-Core Version:    0.6.0
 */