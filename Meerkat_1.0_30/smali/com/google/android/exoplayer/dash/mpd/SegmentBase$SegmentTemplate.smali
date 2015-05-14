.class public Lcom/google/android/exoplayer/dash/mpd/SegmentBase$SegmentTemplate;
.super Lcom/google/android/exoplayer/dash/mpd/SegmentBase$MultiSegmentBase;
.source "SegmentBase.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/exoplayer/dash/mpd/SegmentBase;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SegmentTemplate"
.end annotation


# instance fields
.field private final baseUrl:Landroid/net/Uri;

.field final initializationTemplate:Lcom/google/android/exoplayer/dash/mpd/UrlTemplate;

.field final mediaTemplate:Lcom/google/android/exoplayer/dash/mpd/UrlTemplate;


# direct methods
.method public constructor <init>(Lcom/google/android/exoplayer/dash/mpd/RangedUri;JJJIJLjava/util/List;Lcom/google/android/exoplayer/dash/mpd/UrlTemplate;Lcom/google/android/exoplayer/dash/mpd/UrlTemplate;Landroid/net/Uri;)V
    .locals 0
    .param p1, "initialization"    # Lcom/google/android/exoplayer/dash/mpd/RangedUri;
    .param p2, "timescale"    # J
    .param p4, "presentationTimeOffset"    # J
    .param p6, "periodDurationMs"    # J
    .param p8, "startNumber"    # I
    .param p9, "duration"    # J
    .param p12, "initializationTemplate"    # Lcom/google/android/exoplayer/dash/mpd/UrlTemplate;
    .param p13, "mediaTemplate"    # Lcom/google/android/exoplayer/dash/mpd/UrlTemplate;
    .param p14, "baseUrl"    # Landroid/net/Uri;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/exoplayer/dash/mpd/RangedUri;",
            "JJJIJ",
            "Ljava/util/List",
            "<",
            "Lcom/google/android/exoplayer/dash/mpd/SegmentBase$SegmentTimelineElement;",
            ">;",
            "Lcom/google/android/exoplayer/dash/mpd/UrlTemplate;",
            "Lcom/google/android/exoplayer/dash/mpd/UrlTemplate;",
            "Landroid/net/Uri;",
            ")V"
        }
    .end annotation

    .prologue
    .line 318
    .local p11, "segmentTimeline":Ljava/util/List;, "Ljava/util/List<Lcom/google/android/exoplayer/dash/mpd/SegmentBase$SegmentTimelineElement;>;"
    invoke-direct/range {p0 .. p11}, Lcom/google/android/exoplayer/dash/mpd/SegmentBase$MultiSegmentBase;-><init>(Lcom/google/android/exoplayer/dash/mpd/RangedUri;JJJIJLjava/util/List;)V

    .line 320
    iput-object p12, p0, Lcom/google/android/exoplayer/dash/mpd/SegmentBase$SegmentTemplate;->initializationTemplate:Lcom/google/android/exoplayer/dash/mpd/UrlTemplate;

    .line 321
    iput-object p13, p0, Lcom/google/android/exoplayer/dash/mpd/SegmentBase$SegmentTemplate;->mediaTemplate:Lcom/google/android/exoplayer/dash/mpd/UrlTemplate;

    .line 322
    iput-object p14, p0, Lcom/google/android/exoplayer/dash/mpd/SegmentBase$SegmentTemplate;->baseUrl:Landroid/net/Uri;

    .line 323
    return-void
.end method


# virtual methods
.method public getInitialization(Lcom/google/android/exoplayer/dash/mpd/Representation;)Lcom/google/android/exoplayer/dash/mpd/RangedUri;
    .locals 8
    .param p1, "representation"    # Lcom/google/android/exoplayer/dash/mpd/Representation;

    .prologue
    const-wide/16 v4, 0x0

    .line 327
    iget-object v0, p0, Lcom/google/android/exoplayer/dash/mpd/SegmentBase$SegmentTemplate;->initializationTemplate:Lcom/google/android/exoplayer/dash/mpd/UrlTemplate;

    if-eqz v0, :cond_0

    .line 328
    iget-object v0, p0, Lcom/google/android/exoplayer/dash/mpd/SegmentBase$SegmentTemplate;->initializationTemplate:Lcom/google/android/exoplayer/dash/mpd/UrlTemplate;

    iget-object v1, p1, Lcom/google/android/exoplayer/dash/mpd/Representation;->format:Lcom/google/android/exoplayer/chunk/Format;

    iget-object v1, v1, Lcom/google/android/exoplayer/chunk/Format;->id:Ljava/lang/String;

    const/4 v2, 0x0

    iget-object v6, p1, Lcom/google/android/exoplayer/dash/mpd/Representation;->format:Lcom/google/android/exoplayer/chunk/Format;

    iget v3, v6, Lcom/google/android/exoplayer/chunk/Format;->bitrate:I

    invoke-virtual/range {v0 .. v5}, Lcom/google/android/exoplayer/dash/mpd/UrlTemplate;->buildUri(Ljava/lang/String;IIJ)Ljava/lang/String;

    move-result-object v3

    .line 330
    .local v3, "urlString":Ljava/lang/String;
    new-instance v1, Lcom/google/android/exoplayer/dash/mpd/RangedUri;

    iget-object v2, p0, Lcom/google/android/exoplayer/dash/mpd/SegmentBase$SegmentTemplate;->baseUrl:Landroid/net/Uri;

    const-wide/16 v6, -0x1

    invoke-direct/range {v1 .. v7}, Lcom/google/android/exoplayer/dash/mpd/RangedUri;-><init>(Landroid/net/Uri;Ljava/lang/String;JJ)V

    .line 332
    .end local v3    # "urlString":Ljava/lang/String;
    :goto_0
    return-object v1

    :cond_0
    invoke-super {p0, p1}, Lcom/google/android/exoplayer/dash/mpd/SegmentBase$MultiSegmentBase;->getInitialization(Lcom/google/android/exoplayer/dash/mpd/Representation;)Lcom/google/android/exoplayer/dash/mpd/RangedUri;

    move-result-object v1

    goto :goto_0
.end method

.method public getLastSegmentNum()I
    .locals 8

    .prologue
    .line 351
    iget-object v2, p0, Lcom/google/android/exoplayer/dash/mpd/SegmentBase$SegmentTemplate;->segmentTimeline:Ljava/util/List;

    if-eqz v2, :cond_0

    .line 352
    iget-object v2, p0, Lcom/google/android/exoplayer/dash/mpd/SegmentBase$SegmentTemplate;->segmentTimeline:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    iget v3, p0, Lcom/google/android/exoplayer/dash/mpd/SegmentBase$SegmentTemplate;->startNumber:I

    add-int/2addr v2, v3

    add-int/lit8 v2, v2, -0x1

    .line 357
    :goto_0
    return v2

    .line 353
    :cond_0
    iget-wide v2, p0, Lcom/google/android/exoplayer/dash/mpd/SegmentBase$SegmentTemplate;->periodDurationMs:J

    const-wide/16 v4, -0x1

    cmp-long v2, v2, v4

    if-nez v2, :cond_1

    .line 354
    const/4 v2, -0x1

    goto :goto_0

    .line 356
    :cond_1
    iget-wide v2, p0, Lcom/google/android/exoplayer/dash/mpd/SegmentBase$SegmentTemplate;->duration:J

    const-wide/16 v4, 0x3e8

    mul-long/2addr v2, v4

    iget-wide v4, p0, Lcom/google/android/exoplayer/dash/mpd/SegmentBase$SegmentTemplate;->timescale:J

    div-long v0, v2, v4

    .line 357
    .local v0, "durationMs":J
    iget v2, p0, Lcom/google/android/exoplayer/dash/mpd/SegmentBase$SegmentTemplate;->startNumber:I

    iget-wide v4, p0, Lcom/google/android/exoplayer/dash/mpd/SegmentBase$SegmentTemplate;->periodDurationMs:J

    add-long/2addr v4, v0

    const-wide/16 v6, 0x1

    sub-long/2addr v4, v6

    div-long/2addr v4, v0

    long-to-int v3, v4

    add-int/2addr v2, v3

    add-int/lit8 v2, v2, -0x1

    goto :goto_0
.end method

.method public getSegmentUrl(Lcom/google/android/exoplayer/dash/mpd/Representation;I)Lcom/google/android/exoplayer/dash/mpd/RangedUri;
    .locals 14
    .param p1, "representation"    # Lcom/google/android/exoplayer/dash/mpd/Representation;
    .param p2, "sequenceNumber"    # I

    .prologue
    .line 338
    const-wide/16 v4, 0x0

    .line 339
    .local v4, "time":J
    iget-object v0, p0, Lcom/google/android/exoplayer/dash/mpd/SegmentBase$SegmentTemplate;->segmentTimeline:Ljava/util/List;

    if-eqz v0, :cond_0

    .line 340
    iget-object v0, p0, Lcom/google/android/exoplayer/dash/mpd/SegmentBase$SegmentTemplate;->segmentTimeline:Ljava/util/List;

    iget v1, p0, Lcom/google/android/exoplayer/dash/mpd/SegmentBase$SegmentTemplate;->startNumber:I

    sub-int v1, p2, v1

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/exoplayer/dash/mpd/SegmentBase$SegmentTimelineElement;

    iget-wide v4, v0, Lcom/google/android/exoplayer/dash/mpd/SegmentBase$SegmentTimelineElement;->startTime:J

    .line 344
    :goto_0
    iget-object v0, p0, Lcom/google/android/exoplayer/dash/mpd/SegmentBase$SegmentTemplate;->mediaTemplate:Lcom/google/android/exoplayer/dash/mpd/UrlTemplate;

    iget-object v1, p1, Lcom/google/android/exoplayer/dash/mpd/Representation;->format:Lcom/google/android/exoplayer/chunk/Format;

    iget-object v1, v1, Lcom/google/android/exoplayer/chunk/Format;->id:Ljava/lang/String;

    iget-object v2, p1, Lcom/google/android/exoplayer/dash/mpd/Representation;->format:Lcom/google/android/exoplayer/chunk/Format;

    iget v3, v2, Lcom/google/android/exoplayer/chunk/Format;->bitrate:I

    move/from16 v2, p2

    invoke-virtual/range {v0 .. v5}, Lcom/google/android/exoplayer/dash/mpd/UrlTemplate;->buildUri(Ljava/lang/String;IIJ)Ljava/lang/String;

    move-result-object v9

    .line 346
    .local v9, "uriString":Ljava/lang/String;
    new-instance v7, Lcom/google/android/exoplayer/dash/mpd/RangedUri;

    iget-object v8, p0, Lcom/google/android/exoplayer/dash/mpd/SegmentBase$SegmentTemplate;->baseUrl:Landroid/net/Uri;

    const-wide/16 v10, 0x0

    const-wide/16 v12, -0x1

    invoke-direct/range {v7 .. v13}, Lcom/google/android/exoplayer/dash/mpd/RangedUri;-><init>(Landroid/net/Uri;Ljava/lang/String;JJ)V

    return-object v7

    .line 342
    .end local v9    # "uriString":Ljava/lang/String;
    :cond_0
    iget v0, p0, Lcom/google/android/exoplayer/dash/mpd/SegmentBase$SegmentTemplate;->startNumber:I

    sub-int v0, p2, v0

    int-to-long v0, v0

    iget-wide v2, p0, Lcom/google/android/exoplayer/dash/mpd/SegmentBase$SegmentTemplate;->duration:J

    mul-long v4, v0, v2

    goto :goto_0
.end method
