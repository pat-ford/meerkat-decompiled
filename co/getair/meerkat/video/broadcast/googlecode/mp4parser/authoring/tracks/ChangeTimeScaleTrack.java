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
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class ChangeTimeScaleTrack
  implements Track
{
  private static final Logger LOG = Logger.getLogger(ChangeTimeScaleTrack.class.getName());
  List<CompositionTimeToSample.Entry> ctts;
  long[] decodingTimes;
  Track source;
  long timeScale;

  public ChangeTimeScaleTrack(Track paramTrack, long paramLong, long[] paramArrayOfLong)
  {
    this.source = paramTrack;
    this.timeScale = paramLong;
    double d = paramLong / paramTrack.getTrackMetaData().getTimescale();
    this.ctts = adjustCtts(paramTrack.getCompositionTimeEntries(), d);
    this.decodingTimes = adjustTts(paramTrack.getSampleDurations(), d, paramArrayOfLong, getTimes(paramTrack, paramArrayOfLong, paramLong));
  }

  static List<CompositionTimeToSample.Entry> adjustCtts(List<CompositionTimeToSample.Entry> paramList, double paramDouble)
  {
    if (paramList != null)
    {
      localArrayList = new ArrayList(paramList.size());
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        CompositionTimeToSample.Entry localEntry = (CompositionTimeToSample.Entry)localIterator.next();
        localArrayList.add(new CompositionTimeToSample.Entry(localEntry.getCount(), (int)Math.round(paramDouble * localEntry.getOffset())));
      }
    }
    ArrayList localArrayList = null;
    return localArrayList;
  }

  static long[] adjustTts(long[] paramArrayOfLong1, double paramDouble, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    long l1 = 0L;
    long[] arrayOfLong = new long[paramArrayOfLong1.length];
    for (int i = 1; i <= paramArrayOfLong1.length; i++)
    {
      long l2 = Math.round(paramDouble * paramArrayOfLong1[(i - 1)]);
      int j = Arrays.binarySearch(paramArrayOfLong2, i + 1);
      if ((j >= 0) && (paramArrayOfLong3[j] != l1))
      {
        long l3 = paramArrayOfLong3[j] - (l1 + l2);
        Logger localLogger = LOG;
        Object[] arrayOfObject = new Object[4];
        arrayOfObject[0] = Integer.valueOf(i);
        arrayOfObject[1] = Long.valueOf(l1);
        arrayOfObject[2] = Long.valueOf(paramArrayOfLong3[j]);
        arrayOfObject[3] = Long.valueOf(l3);
        localLogger.finest(String.format("Sample %d %d / %d - correct by %d", arrayOfObject));
        l2 += l3;
      }
      l1 += l2;
      arrayOfLong[(i - 1)] = l2;
    }
    return arrayOfLong;
  }

  private static long[] getTimes(Track paramTrack, long[] paramArrayOfLong, long paramLong)
  {
    long[] arrayOfLong = new long[paramArrayOfLong.length];
    int i = 1;
    long l = 0L;
    int j = 0;
    while (i <= paramArrayOfLong[(-1 + paramArrayOfLong.length)])
    {
      if (i == paramArrayOfLong[j])
      {
        int k = j + 1;
        arrayOfLong[j] = (l * paramLong / paramTrack.getTrackMetaData().getTimescale());
        j = k;
      }
      l += paramTrack.getSampleDurations()[(i - 1)];
      i++;
    }
    return arrayOfLong;
  }

  public void close()
    throws IOException
  {
    this.source.close();
  }

  public List<CompositionTimeToSample.Entry> getCompositionTimeEntries()
  {
    return this.ctts;
  }

  public long getDuration()
  {
    long l = 0L;
    long[] arrayOfLong = this.decodingTimes;
    int i = arrayOfLong.length;
    for (int j = 0; j < i; j++)
      l += arrayOfLong[j];
    return l;
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
    return "timeScale(" + this.source.getName() + ")";
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
    return this.decodingTimes;
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
    localTrackMetaData.setTimescale(this.timeScale);
    return localTrackMetaData;
  }

  public String toString()
  {
    return "ChangeTimeScaleTrack{source=" + this.source + '}';
  }
}