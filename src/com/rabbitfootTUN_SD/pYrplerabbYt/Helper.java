package com.rabbitfootTUN_SD.pYrplerabbYt;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Helper extends Activity
{
  private Button adwtheme;
  private Button cmtheme;
  private Button email;
  private Button marketinfo;
  private Button wallpaper;

  public void makeToast(String paramString)
  {
    Toast.makeText(getApplicationContext(), paramString, 1).show();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(167968768);
    this.cmtheme = ((Button)findViewById(168296452));
    this.cmtheme.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramView)
      {
        try
        {
          localObject = new Intent("android.intent.action.MAIN");
          ((Intent)localObject).setComponent(new ComponentName("com.tmobile.themechooser", "com.tmobile.themechooser.ThemeChooser"));
          Helper.this.startActivity((Intent)localObject);
          return;
        }
        catch (ActivityNotFoundException localActivityNotFoundException)
        {
          while (true)
          {
            Object localObject = new AlertDialog.Builder(Helper.this);
            ((AlertDialog.Builder)localObject).setTitle("App Not Found");
            ((AlertDialog.Builder)localObject).setMessage("This feature requires a custom ROM like Cyanogen Mod! Do you want to visit Cyanogen Mod webpage for more info?");
            ((AlertDialog.Builder)localObject).setIcon(167907917);
            ((AlertDialog.Builder)localObject).setPositiveButton("Yes", new DialogInterface.OnClickListener()
            {
              public void onClick(DialogInterface paramDialogInterface, int paramInt)
              {
                Intent localIntent = new Intent("android.intent.action.VIEW").setData(Uri.parse("http://www.cyanogenmod.com/"));
                Helper.this.startActivity(localIntent);
              }
            });
            ((AlertDialog.Builder)localObject).setNegativeButton("No", new DialogInterface.OnClickListener()
            {
              public void onClick(DialogInterface paramDialogInterface, int paramInt)
              {
                Toast.makeText(Helper.this, "wtf?!?", 0).show();
              }
            });
            ((AlertDialog.Builder)localObject).show();
          }
        }
      }
    });
    this.adwtheme = ((Button)findViewById(168296453));
    this.adwtheme.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramView)
      {
        try
        {
          localObject = new Intent("org.adw.launcher.SET_THEME");
          ((Intent)localObject).putExtra("org.adw.launcher.theme.NAME", "com.rabbitfootTUN_SD.pYrplerabbYt");
          Helper.this.startActivity(Intent.createChooser((Intent)localObject, "ADW Not Installed"));
          return;
        }
        catch (ActivityNotFoundException localActivityNotFoundException)
        {
          while (true)
          {
            Object localObject = new AlertDialog.Builder(Helper.this);
            ((AlertDialog.Builder)localObject).setTitle("ADW Not Found");
            ((AlertDialog.Builder)localObject).setMessage("Do you want to vist the ADW Launcher Android Market page?");
            ((AlertDialog.Builder)localObject).setIcon(167903233);
            ((AlertDialog.Builder)localObject).setPositiveButton("Yes", new DialogInterface.OnClickListener()
            {
              public void onClick(DialogInterface paramDialogInterface, int paramInt)
              {
                Intent localIntent = new Intent("android.intent.action.VIEW").setData(Uri.parse("market://details?id=org.adwfreak.launcher"));
                Helper.this.startActivity(localIntent);
              }
            });
            ((AlertDialog.Builder)localObject).setNegativeButton("No", new DialogInterface.OnClickListener()
            {
              public void onClick(DialogInterface paramDialogInterface, int paramInt)
              {
                Toast.makeText(Helper.this, "There's too many shortcuts anyway...", 0).show();
              }
            });
            ((AlertDialog.Builder)localObject).show();
          }
        }
      }
    });
    this.wallpaper = ((Button)findViewById(168296451));
    this.wallpaper.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramView)
      {
        try
        {
          Intent localIntent = new Intent("android.intent.action.MAIN");
          localIntent.setComponent(new ComponentName("com.rabbitfootTUN_SD.pYrplerabbYt", "com.rabbitfootTUN_SD.pYrplerabbYt.wallpaper"));
          Helper.this.startActivity(localIntent);
          return;
        }
        catch (RuntimeException localRuntimeException)
        {
          while (true)
            Helper.this.makeToast("If you see this then its being worked on!");
        }
      }
    });
    this.email = ((Button)findViewById(168296455));
    this.email.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramView)
      {
        Intent localIntent = new Intent("android.intent.action.SENDTO").setData(Uri.parse("mailto:speedy.daniel77@gmail.com"));
        Helper.this.startActivity(localIntent);
      }
    });
    this.marketinfo = ((Button)findViewById(168296456));
    this.marketinfo.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramView)
      {
        Intent localIntent = new Intent("android.intent.action.VIEW").setData(Uri.parse("market://details?id=com.rabbitfootTUN_SD.pYrplerabbYt"));
        Helper.this.startActivity(localIntent);
      }
    });
  }
}

/* Location:           C:\Users\speedy\Desktop\NEWapk\jd-gui-0.3.3.windows\classes_dex2jar.jar
 * Qualified Name:     com.rabbitfootTUN_SD.pYrplerabbYt.Helper
 * JD-Core Version:    0.6.0
 */