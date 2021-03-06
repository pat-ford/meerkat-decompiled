package com.crashlytics.android.answers;

import android.content.Context;
import io.fabric.sdk.android.services.common.ApiKey;
import io.fabric.sdk.android.services.events.EnabledEventsStrategy;
import io.fabric.sdk.android.services.events.FilesSender;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import io.fabric.sdk.android.services.settings.AnalyticsSettingsData;
import java.util.concurrent.ScheduledExecutorService;

class EnabledSessionAnalyticsManagerStrategy extends EnabledEventsStrategy<SessionEvent>
  implements SessionAnalyticsManagerStrategy<SessionEvent>
{
  FilesSender filesSender;
  private final HttpRequestFactory httpRequestFactory;

  public EnabledSessionAnalyticsManagerStrategy(Context paramContext, ScheduledExecutorService paramScheduledExecutorService, SessionAnalyticsFilesManager paramSessionAnalyticsFilesManager, HttpRequestFactory paramHttpRequestFactory)
  {
    super(paramContext, paramScheduledExecutorService, paramSessionAnalyticsFilesManager);
    this.httpRequestFactory = paramHttpRequestFactory;
  }

  public FilesSender getFilesSender()
  {
    return this.filesSender;
  }

  public void setAnalyticsSettingsData(AnalyticsSettingsData paramAnalyticsSettingsData, String paramString)
  {
    this.filesSender = new DefaultSessionAnalyticsFilesSender(Answers.getInstance(), paramString, paramAnalyticsSettingsData.analyticsURL, this.httpRequestFactory, new ApiKey().getValue(this.context));
    ((SessionAnalyticsFilesManager)this.filesManager).setAnalyticsSettingsData(paramAnalyticsSettingsData);
    configureRollover(paramAnalyticsSettingsData.flushIntervalSeconds);
  }
}