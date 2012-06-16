package com.rabbitfootTUN_SD.pYrplerabbYt;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import java.util.ArrayList;

public class docks extends Activity
  implements AdapterView.OnItemClickListener
{
  public Uri CONTENT_URI;

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ListView localListView = new ListView(this);
    localListView.setAdapter(new DocksAdapter(this));
    localListView.setOnItemClickListener(this);
    setContentView(localListView);
    this.CONTENT_URI = Uri.parse("content://" + docksProvider.class.getCanonicalName());
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    String str = paramAdapterView.getItemAtPosition(paramInt).toString();
    setResult(-1, new Intent(null, Uri.withAppendedPath(this.CONTENT_URI, str)));
    finish();
  }

  private class DocksAdapter extends BaseAdapter
  {
    private Context mContext;
    private ArrayList<Integer> mThumbs;

    public DocksAdapter(Context arg2)
    {
      Object localObject;
      this.mContext = localObject;
      loadDocks();
    }

    private void addDocks(Resources paramResources, String paramString, int paramInt)
    {
      String[] arrayOfString = paramResources.getStringArray(paramInt);
      int i = arrayOfString.length;
      for (int j = 0; ; j++)
      {
        if (j >= i)
          return;
        String str = arrayOfString[j];
        if (paramResources.getIdentifier(str, "drawable", paramString) == 0)
          continue;
        int k = paramResources.getIdentifier(str, "drawable", paramString);
        if (k == 0)
          continue;
        this.mThumbs.add(Integer.valueOf(k));
      }
    }

    private void loadDocks()
    {
      this.mThumbs = new ArrayList();
      addDocks(docks.this.getResources(), docks.this.getApplication().getPackageName(), 168230912);
    }

    public int getCount()
    {
      return this.mThumbs.size();
    }

    public Object getItem(int paramInt)
    {
      return this.mThumbs.get(paramInt);
    }

    public long getItemId(int paramInt)
    {
      return paramInt;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = new ImageView(docks.this);
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      }
      ((ImageView)paramView).setImageResource(((Integer)this.mThumbs.get(paramInt)).intValue());
      return paramView;
    }
  }
}

/* Location:           C:\Users\speedy\Desktop\NEWapk\jd-gui-0.3.3.windows\classes_dex2jar.jar
 * Qualified Name:     com.rabbitfootTUN_SD.pYrplerabbYt.docks
 * JD-Core Version:    0.6.0
 */