// Copyright 2018 Sebastian Kuerten
//
// This file is part of android-intent-factory.
//
// android-intent-factory is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// android-intent-factory is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with android-intent-factory. If not, see <http://www.gnu.org/licenses/>.

package de.topobyte.android.intent.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class IntentFactory
{

	public static Intent createUrlIntent(String url)
	{
		Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
		return intent;
	}

	public static Intent createWikipediaIntent(String languageCode,
			String pageName)
	{
		String url = "http://" + languageCode + ".wikipedia.org/wiki/"
				+ pageName;
		return createUrlIntent(url);
	}

	public static Intent createGooglePlaySearchIntent(String query)
	{
		String link = "market://search?q=" + query;
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri.parse(link));
		return intent;
	}

	public static Intent createGooglePlayPublisherIntent(String publisher)
	{
		return createGooglePlaySearchIntent("pub:" + publisher);
	}

	public static Intent createGooglePlayAppDetailsIntent(String packageName)
	{
		String link = "market://details?id=" + packageName;
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri.parse(link));
		return intent;
	}

	public static Intent createRateAppIntent(Context context)
	{
		String packageName = context.getApplicationContext().getPackageName();
		return createGooglePlayAppDetailsIntent(packageName);
	}

}
