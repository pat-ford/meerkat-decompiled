.class public Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter;
.super Ljava/lang/Object;
.source "DefaultBandwidthMeter.java"

# interfaces
.implements Lcom/google/android/exoplayer/upstream/BandwidthMeter;
.implements Lcom/google/android/exoplayer/upstream/TransferListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter$EventListener;
    }
.end annotation


# static fields
.field private static final DEFAULT_MAX_WEIGHT:I = 0x7d0


# instance fields
.field private bitrateEstimate:J

.field private bytesAccumulator:J

.field private final clock:Lcom/google/android/exoplayer/util/Clock;

.field private final eventHandler:Landroid/os/Handler;

.field private final eventListener:Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter$EventListener;

.field private final slidingPercentile:Lcom/google/android/exoplayer/util/SlidingPercentile;

.field private startTimeMs:J

.field private streamCount:I


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 62
    invoke-direct {p0, v0, v0}, Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter;-><init>(Landroid/os/Handler;Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter$EventListener;)V

    .line 63
    return-void
.end method

.method public constructor <init>(Landroid/os/Handler;Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter$EventListener;)V
    .locals 1
    .param p1, "eventHandler"    # Landroid/os/Handler;
    .param p2, "eventListener"    # Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter$EventListener;

    .prologue
    .line 66
    new-instance v0, Lcom/google/android/exoplayer/util/SystemClock;

    invoke-direct {v0}, Lcom/google/android/exoplayer/util/SystemClock;-><init>()V

    invoke-direct {p0, p1, p2, v0}, Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter;-><init>(Landroid/os/Handler;Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter$EventListener;Lcom/google/android/exoplayer/util/Clock;)V

    .line 67
    return-void
.end method

.method public constructor <init>(Landroid/os/Handler;Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter$EventListener;I)V
    .locals 1
    .param p1, "eventHandler"    # Landroid/os/Handler;
    .param p2, "eventListener"    # Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter$EventListener;
    .param p3, "maxWeight"    # I

    .prologue
    .line 74
    new-instance v0, Lcom/google/android/exoplayer/util/SystemClock;

    invoke-direct {v0}, Lcom/google/android/exoplayer/util/SystemClock;-><init>()V

    invoke-direct {p0, p1, p2, v0, p3}, Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter;-><init>(Landroid/os/Handler;Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter$EventListener;Lcom/google/android/exoplayer/util/Clock;I)V

    .line 75
    return-void
.end method

.method public constructor <init>(Landroid/os/Handler;Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter$EventListener;Lcom/google/android/exoplayer/util/Clock;)V
    .locals 1
    .param p1, "eventHandler"    # Landroid/os/Handler;
    .param p2, "eventListener"    # Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter$EventListener;
    .param p3, "clock"    # Lcom/google/android/exoplayer/util/Clock;

    .prologue
    .line 70
    const/16 v0, 0x7d0

    invoke-direct {p0, p1, p2, p3, v0}, Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter;-><init>(Landroid/os/Handler;Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter$EventListener;Lcom/google/android/exoplayer/util/Clock;I)V

    .line 71
    return-void
.end method

.method public constructor <init>(Landroid/os/Handler;Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter$EventListener;Lcom/google/android/exoplayer/util/Clock;I)V
    .locals 2
    .param p1, "eventHandler"    # Landroid/os/Handler;
    .param p2, "eventListener"    # Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter$EventListener;
    .param p3, "clock"    # Lcom/google/android/exoplayer/util/Clock;
    .param p4, "maxWeight"    # I

    .prologue
    .line 78
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 79
    iput-object p1, p0, Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter;->eventHandler:Landroid/os/Handler;

    .line 80
    iput-object p2, p0, Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter;->eventListener:Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter$EventListener;

    .line 81
    iput-object p3, p0, Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter;->clock:Lcom/google/android/exoplayer/util/Clock;

    .line 82
    new-instance v0, Lcom/google/android/exoplayer/util/SlidingPercentile;

    invoke-direct {v0, p4}, Lcom/google/android/exoplayer/util/SlidingPercentile;-><init>(I)V

    iput-object v0, p0, Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter;->slidingPercentile:Lcom/google/android/exoplayer/util/SlidingPercentile;

    .line 83
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter;->bitrateEstimate:J

    .line 84
    return-void
.end method

.method static synthetic access$000(Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter;)Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter$EventListener;
    .locals 1
    .param p0, "x0"    # Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter;

    .prologue
    .line 29
    iget-object v0, p0, Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter;->eventListener:Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter$EventListener;

    return-object v0
.end method

.method private notifyBandwidthSample(IJJ)V
    .locals 8
    .param p1, "elapsedMs"    # I
    .param p2, "bytes"    # J
    .param p4, "bitrate"    # J

    .prologue
    .line 125
    iget-object v0, p0, Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter;->eventHandler:Landroid/os/Handler;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter;->eventListener:Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter$EventListener;

    if-eqz v0, :cond_0

    .line 126
    iget-object v0, p0, Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter;->eventHandler:Landroid/os/Handler;

    new-instance v1, Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter$1;

    move-object v2, p0

    move v3, p1

    move-wide v4, p2

    move-wide v6, p4

    invoke-direct/range {v1 .. v7}, Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter$1;-><init>(Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter;IJJ)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 133
    :cond_0
    return-void
.end method


# virtual methods
.method public declared-synchronized getBitrateEstimate()J
    .locals 2

    .prologue
    .line 88
    monitor-enter p0

    :try_start_0
    iget-wide v0, p0, Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter;->bitrateEstimate:J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-wide v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized onBytesTransferred(I)V
    .locals 4
    .param p1, "bytes"    # I

    .prologue
    .line 101
    monitor-enter p0

    :try_start_0
    iget-wide v0, p0, Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter;->bytesAccumulator:J

    int-to-long v2, p1

    add-long/2addr v0, v2

    iput-wide v0, p0, Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter;->bytesAccumulator:J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 102
    monitor-exit p0

    return-void

    .line 101
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized onTransferEnd()V
    .locals 10

    .prologue
    .line 106
    monitor-enter p0

    :try_start_0
    iget v0, p0, Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter;->streamCount:I

    if-lez v0, :cond_2

    const/4 v0, 0x1

    :goto_0
    invoke-static {v0}, Lcom/google/android/exoplayer/util/Assertions;->checkState(Z)V

    .line 107
    iget-object v0, p0, Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter;->clock:Lcom/google/android/exoplayer/util/Clock;

    invoke-interface {v0}, Lcom/google/android/exoplayer/util/Clock;->elapsedRealtime()J

    move-result-wide v8

    .line 108
    .local v8, "nowMs":J
    iget-wide v2, p0, Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter;->startTimeMs:J

    sub-long v2, v8, v2

    long-to-int v1, v2

    .line 109
    .local v1, "elapsedMs":I
    if-lez v1, :cond_0

    .line 110
    iget-wide v2, p0, Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter;->bytesAccumulator:J

    const-wide/16 v4, 0x1f40

    mul-long/2addr v2, v4

    int-to-long v4, v1

    div-long/2addr v2, v4

    long-to-float v7, v2

    .line 111
    .local v7, "bitsPerSecond":F
    iget-object v0, p0, Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter;->slidingPercentile:Lcom/google/android/exoplayer/util/SlidingPercentile;

    iget-wide v2, p0, Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter;->bytesAccumulator:J

    long-to-double v2, v2

    invoke-static {v2, v3}, Ljava/lang/Math;->sqrt(D)D

    move-result-wide v2

    double-to-int v2, v2

    invoke-virtual {v0, v2, v7}, Lcom/google/android/exoplayer/util/SlidingPercentile;->addSample(IF)V

    .line 112
    iget-object v0, p0, Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter;->slidingPercentile:Lcom/google/android/exoplayer/util/SlidingPercentile;

    const/high16 v2, 0x3f000000    # 0.5f

    invoke-virtual {v0, v2}, Lcom/google/android/exoplayer/util/SlidingPercentile;->getPercentile(F)F

    move-result v6

    .line 113
    .local v6, "bandwidthEstimateFloat":F
    invoke-static {v6}, Ljava/lang/Float;->isNaN(F)Z

    move-result v0

    if-eqz v0, :cond_3

    const-wide/16 v2, -0x1

    :goto_1
    iput-wide v2, p0, Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter;->bitrateEstimate:J

    .line 115
    iget-wide v2, p0, Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter;->bytesAccumulator:J

    iget-wide v4, p0, Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter;->bitrateEstimate:J

    move-object v0, p0

    invoke-direct/range {v0 .. v5}, Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter;->notifyBandwidthSample(IJJ)V

    .line 117
    .end local v6    # "bandwidthEstimateFloat":F
    .end local v7    # "bitsPerSecond":F
    :cond_0
    iget v0, p0, Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter;->streamCount:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter;->streamCount:I

    .line 118
    iget v0, p0, Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter;->streamCount:I

    if-lez v0, :cond_1

    .line 119
    iput-wide v8, p0, Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter;->startTimeMs:J

    .line 121
    :cond_1
    const-wide/16 v2, 0x0

    iput-wide v2, p0, Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter;->bytesAccumulator:J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 122
    monitor-exit p0

    return-void

    .line 106
    .end local v1    # "elapsedMs":I
    .end local v8    # "nowMs":J
    :cond_2
    const/4 v0, 0x0

    goto :goto_0

    .line 113
    .restart local v1    # "elapsedMs":I
    .restart local v6    # "bandwidthEstimateFloat":F
    .restart local v7    # "bitsPerSecond":F
    .restart local v8    # "nowMs":J
    :cond_3
    float-to-long v2, v6

    goto :goto_1

    .line 106
    .end local v1    # "elapsedMs":I
    .end local v6    # "bandwidthEstimateFloat":F
    .end local v7    # "bitsPerSecond":F
    .end local v8    # "nowMs":J
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized onTransferStart()V
    .locals 2

    .prologue
    .line 93
    monitor-enter p0

    :try_start_0
    iget v0, p0, Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter;->streamCount:I

    if-nez v0, :cond_0

    .line 94
    iget-object v0, p0, Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter;->clock:Lcom/google/android/exoplayer/util/Clock;

    invoke-interface {v0}, Lcom/google/android/exoplayer/util/Clock;->elapsedRealtime()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter;->startTimeMs:J

    .line 96
    :cond_0
    iget v0, p0, Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter;->streamCount:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/google/android/exoplayer/upstream/DefaultBandwidthMeter;->streamCount:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 97
    monitor-exit p0

    return-void

    .line 93
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method
