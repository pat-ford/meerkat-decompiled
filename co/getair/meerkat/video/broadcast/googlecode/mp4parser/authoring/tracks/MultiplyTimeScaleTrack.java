package co.getair.meerkat.video.broadcast.googlecode.mp4parser.authoring.tracks;

import co.getair.meerkat.video.broadcast.coremedia.iso.boxes.CompositionTimeToSample.Entry;
import co.getair.meerkat.video.broadcast.coremedia.iso.boxes.SampleDependencyTypeBox.Entry;
import co.getair.meerkat.video.broadcast.coremedia.iso.boxes.SampleDescriptionBox;
import co.getair.meerkat.video.broadcast.coremedia.iso.boxes.SubSampleInformationBox;
import co.getair.meerkat.video.broadcast.googlecode.mp4parser.authoring.Edit;
import co.getair.meerkat.video.broadcast.googlecode.mp4parser.authoring.Sample;
import co.getair.meerkat.video.broadcast.googlecode.mp4parser.authoring.Track;
import co.getair.meerkat.video.broadcast.googlecode.mp4parser.authoring.TrackMetaData;
import co.getair.meerkat.video.broadcast.googlecode.mp4parser.boxes.mp4.samplegrouping.GroupEntry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MultiplyTimeScaleTrack
  implements Track
{
  Track source;
  private int timeScaleFactor;

  public MultiplyTimeScaleTrack(Track paramTrack, int paramInt)
  {
    this.source = paramTrack;
    this.timeScaleFactor = paramInt;
  }

  static List<CompositionTimeToSample.Entry> adjustCtts(List<CompositionTimeToSample.Entry> paramList, int paramInt)
  {
    if (paramList != null)
    {
      localArrayList = new ArrayList(paramList.size());
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        CompositionTimeToSample.Entry localEntry = (CompositionTimeToSample.Entry)localIterator.next();
        localArrayList.add(new CompositionTimeToSample.Entry(localEntry.getCount(), paramInt * localEntry.getOffset()));
      }
    }
    ArrayList localArrayList = null;
    return localArrayList;
  }

  public void close()
    throws IOException
  {
    this.source.close();
  }

  public List<CompositionTimeToSample.Entry> getCompositionTimeEntries()
  {
    return adjustCtts(this.source.getCompositionTimeEntries(), this.timeScaleFactor);
  }

  public long getDuration()
  {
    return this.source.getDuration() * this.timeScaleFactor;
  }

  public List<Edit> getEdits()
  {
    return this.source.getEdits();
  }

  public String getHandler()
  {
    return this.source.getHandler();
  }

  public String getName()
  {
    return "timscale(" + this.source.getName() + ")";
  }

  public List<SampleDependencyTypeBox.Entry> getSampleDependencies()
  {
    return this.source.getSampleDependencies();
  }

  public SampleDescriptionBox getSampleDescriptionBox()
  {
    return this.source.getSampleDescriptionBox();
  }

  public long[] getSampleDurations()
  {
    long[] arrayOfLong = new long[this.source.getSampleDurations().length];
    for (int i = 0; i < this.source.getSampleDurations().length; i++)
      arrayOfLong[i] = (this.source.getSampleDurations()[i] * this.timeScaleFactor);
    return arrayOfLong;
  }

  public Map<GroupEntry, long[]> getSampleGroups()
  {
    return this.source.getSampleGroups();
  }

  public List<Sample> getSamples()
  {
    return this.source.getSamples();
  }

  public SubSampleInformationBox getSubsampleInformationBox()
  {
    return this.source.getSubsampleInformationBox();
  }

  public long[] getSyncSamples()
  {
    return this.source.getSyncSamples();
  }

  public TrackMetaData getTrackMetaData()
  {
    TrackMetaData localTrackMetaData = (TrackMetaData)this.source.getTrackMetaData().clone();
    localTrackMetaData.setTimescale(this.source.getTrackMetaData().getTimescale() * this.timeScaleFactor);
    return localTrackMetaData;
  }

  public String toString()
  {
    return "MultiplyTimeScaleTrack{source=" + this.source + '}';
  }
}