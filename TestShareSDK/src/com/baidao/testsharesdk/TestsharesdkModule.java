/**
 * This file was auto-generated by the Titanium Module SDK helper for Android
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2013 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 */
package com.baidao.testsharesdk;

import java.util.HashMap;

import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.annotations.Kroll;

import org.appcelerator.titanium.TiApplication;
import org.appcelerator.titanium.util.TiRHelper;
import org.appcelerator.titanium.util.TiRHelper.ResourceNotFoundException;
import org.appcelerator.kroll.common.Log;

import android.app.Activity;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

@Kroll.module(name="Testsharesdk", id="com.baidao.testsharesdk")
public class TestsharesdkModule extends KrollModule
{

	// Standard Debugging variables
	private static final String TAG = "TestsharesdkModule";

	// You can define constants with @Kroll.constant, for example:
	// @Kroll.constant public static final String EXTERNAL_NAME = value;
	
	public TestsharesdkModule()
	{
		super();
	}

	@Kroll.onAppCreate
	public static void onAppCreate(TiApplication app)
	{
		Log.d(TAG, "inside onAppCreate");
		ShareSDK.initSDK(app);
		// put module init code that needs to run when the application is created
	}
	
	@Kroll.method
    public void share(final HashMap args){
      Log.d(TAG, "share");
      Log.d(TAG, getActivity().toString());

      Activity activity = TiApplication.getInstance().getCurrentActivity();
      Log.d(TAG, activity.toString());
      ShareSDK.initSDK(activity);

      String title = "" , content = "", url ="", type= "";
      if (args.containsKey("title")) {
        Object otitle = args.get("title");
        if (otitle instanceof String) {
          title = (String)otitle;
        }
      }
      if (args.containsKey("content")) {
        Object ocontent = args.get("content");
        if (ocontent instanceof String) {
          content = (String)ocontent;
        }
      }
      if (args.containsKey("url")) {
        Object ourl = args.get("url");
        if (ourl instanceof String) {
          url = (String)ourl;
        }
      }
      if (args.containsKey("type")) {
        Object otype = args.get("type");
        if (otype instanceof String) {
          type = (String)otype;
        }
      }

      Log.d(TAG, title);
      Log.d(TAG, content);
      Log.d(TAG, url);
      Log.d(TAG, type);

      final OnekeyShare oks = new OnekeyShare();

      int appicon = 0x7f020000;

      try {
        appicon = TiRHelper.getApplicationResource("drawable.appicon");
        Log.d(TAG, "getApplicationResource drawable.appicon");
      } catch (ResourceNotFoundException e) {
      }

      oks.setNotification(appicon, "测试ShareSDK");

      oks.setAddress("000000");
      oks.setTitle(title);
      oks.setText(content);
      Log.d(TAG, resolveUrl(null,""));
//      oks.setImagePath(resolveUrl(null,""));
//      oks.setImageUrl("http://img.appgo.cn/imgs/sharesdk/content/2013/07/25/1374723172663.jpg");
      if (url != ""){
        oks.setUrl(url);
      }
//      oks.setFilePath(resolveUrl(null,""));
//      oks.setComment(menu.getContext().getString(R.string.share));

//      oks.setSite(menu.getContext().getString(R.string.app_name));
//      oks.setSiteUrl("http://sharesdk.cn");

//      oks.setVenueName("ShareSDK");
//      oks.setVenueDescription("This is a beautiful place!");
//      oks.setLatitude(23.056081f);
//      oks.setLongitude(113.385708f);
      oks.setSilent(false);

//      oks.setShareContentCustomizeCallback(new ShareContentCustomizeDemo());
      Log.d(TAG, activity.toString());
      oks.show(activity.getBaseContext());
      Log.d(TAG, "show finish");
    }

	// Methods
	@Kroll.method
	public String example()
	{
		Log.d(TAG, "example called");
		return "hello world";
	}
	
	// Properties
	@Kroll.getProperty
	public String getExampleProp()
	{
		Log.d(TAG, "get example property");
		return "hello world";
	}
	
	
	@Kroll.setProperty
	public void setExampleProp(String value) {
		Log.d(TAG, "set example property: " + value);
	}

}

