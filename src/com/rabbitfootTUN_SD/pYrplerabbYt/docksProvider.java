package com.rabbitfootTUN_SD.pYrplerabbYt;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import java.io.FileNotFoundException;
import java.util.List;

public class docksProvider extends ContentProvider
{
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }

  public String getType(Uri paramUri)
  {
    return "image/*";
  }

  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    return null;
  }

  public boolean onCreate()
  {
    return false;
  }

  public AssetFileDescriptor openAssetFile(Uri paramUri, String paramString)
    throws FileNotFoundException
  {
    if (paramUri.getPathSegments().size() > 0);
    while (true)
    {
      try
      {
        int i = Integer.valueOf((String)paramUri.getPathSegments().get(0)).intValue();
        localAssetFileDescriptor = getContext().getResources().openRawResourceFd(i);
        localAssetFileDescriptor = localAssetFileDescriptor;
        return localAssetFileDescriptor;
      }
      catch (Throwable localThrowable)
      {
        localAssetFileDescriptor = null;
        continue;
      }
      AssetFileDescriptor localAssetFileDescriptor = null;
    }
  }

  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    return null;
  }

  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}

/* Location:           C:\Users\speedy\Desktop\NEWapk\jd-gui-0.3.3.windows\classes_dex2jar.jar
 * Qualified Name:     com.rabbitfootTUN_SD.pYrplerabbYt.docksProvider
 * JD-Core Version:    0.6.0
 */