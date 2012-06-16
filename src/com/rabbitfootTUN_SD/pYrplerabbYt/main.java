package com.rabbitfootTUN_SD.pYrplerabbYt;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import java.util.ArrayList;

public class main extends Activity
  implements AdapterView.OnItemClickListener
{
  private boolean mPickerMode = false;

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    int i = getResources().getDimensionPixelSize(17104896);
    setContentView(167968769);
    GridView localGridView = (GridView)findViewById(168296462);
    localGridView.setNumColumns(-1);
    localGridView.setColumnWidth(i);
    localGridView.setStretchMode(3);
    localGridView.setVerticalSpacing(i / 3);
    localGridView.setOnItemClickListener(this);
    localGridView.setAdapter(new IconsAdapter(this, i));
    if (getIntent().getAction().equals("org.adw.launcher.icons.ACTION_PICK_ICON"))
      this.mPickerMode = true;
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Intent localIntent;
    Bitmap localBitmap;
    if (this.mPickerMode)
    {
      localIntent = new Intent();
      localBitmap = null;
    }
    try
    {
      localBitmap = (Bitmap)paramAdapterView.getAdapter().getItem(paramInt);
      label34: if (localBitmap != null)
      {
        localIntent.putExtra("icon", localBitmap);
        setResult(-1, localIntent);
      }
      while (true)
      {
        finish();
        return;
        setResult(0, localIntent);
      }
    }
    catch (Exception localException)
    {
      break label34;
    }
  }

  private class IconsAdapter extends BaseAdapter
  {
    private Context mContext;
    private int mIconSize;
    private ArrayList<Integer> mThumbs;

    public IconsAdapter(Context paramInt, int arg3)
    {
      this.mContext = paramInt;
      int i;
      this.mIconSize = i;
      loadIcons();
    }

    private void addIcons(Resources paramResources, String paramString, int paramInt)
    {
      String[] arrayOfString = paramResources.getStringArray(paramInt);
      int j = arrayOfString.length;
      for (int i = 0; ; i++)
      {
        if (i >= j)
          return;
        String str = arrayOfString[i];
        if (paramResources.getIdentifier(str, "drawable", paramString) == 0)
          continue;
        int k = paramResources.getIdentifier(str, "drawable", paramString);
        if (k == 0)
          continue;
        this.mThumbs.add(Integer.valueOf(k));
      }
    }

    private void loadIcons()
    {
      this.mThumbs = new ArrayList();
      addIcons(main.this.getResources(), main.this.getApplication().getPackageName(), 168230914);
    }

    public int getCount()
    {
      return this.mThumbs.size();
    }

    public Object getItem(int paramInt)
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
      return BitmapFactory.decodeResource(this.mContext.getResources(), ((Integer)this.mThumbs.get(paramInt)).intValue(), localOptions);
    }

    public long getItemId(int paramInt)
    {
      return paramInt;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      ImageView localImageView;
      if (paramView != null)
      {
        localImageView = (ImageView)paramView;
      }
      else
      {
        localImageView = new ImageView(this.mContext);
        localImageView.setLayoutParams(new AbsListView.LayoutParams(this.mIconSize, this.mIconSize));
      }
      localImageView.setImageResource(((Integer)this.mThumbs.get(paramInt)).intValue());
      return localImageView;
    }
  }
}

/* Location:           C:\Users\speedy\Desktop\NEWapk\jd-gui-0.3.3.windows\classes_dex2jar.jar
 * Qualified Name:     com.rabbitfootTUN_SD.pYrplerabbYt.main
 * JD-Core Version:    0.6.0
 */