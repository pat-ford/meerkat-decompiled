.class public final Lcom/google/android/exoplayer/hls/HlsMediaPlaylist;
.super Lcom/google/android/exoplayer/hls/HlsPlaylist;
.source "HlsMediaPlaylist.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/exoplayer/hls/HlsMediaPlaylist$Segment;
    }
.end annotation


# static fields
.field public static final ENCRYPTION_METHOD_AES_128:Ljava/lang/String; = "AES-128"

.field public static final ENCRYPTION_METHOD_NONE:Ljava/lang/String; = "NONE"


# instance fields
.field public final durationUs:J

.field public final live:Z

.field public final mediaSequence:I

.field public final segments:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/google/android/exoplayer/hls/HlsMediaPlaylist$Segment;",
            ">;"
        }
    .end annotation
.end field

.field public final targetDurationSecs:I

.field public final version:I


# direct methods
.method public constructor <init>(Landroid/net/Uri;IIIZLjava/util/List;)V
    .locals 8
    .param p1, "baseUri"    # Landroid/net/Uri;
    .param p2, "mediaSequence"    # I
    .param p3, "targetDurationSecs"    # I
    .param p4, "version"    # I
    .param p5, "live"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/net/Uri;",
            "IIIZ",
            "Ljava/util/List",
            "<",
            "Lcom/google/android/exoplayer/hls/HlsMediaPlaylist$Segment;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 75
    .local p6, "segments":Ljava/util/List;, "Ljava/util/List<Lcom/google/android/exoplayer/hls/HlsMediaPlaylist$Segment;>;"
    const/4 v1, 0x1

    invoke-direct {p0, p1, v1}, Lcom/google/android/exoplayer/hls/HlsPlaylist;-><init>(Landroid/net/Uri;I)V

    .line 76
    iput p2, p0, Lcom/google/android/exoplayer/hls/HlsMediaPlaylist;->mediaSequence:I

    .line 77
    iput p3, p0, Lcom/google/android/exoplayer/hls/HlsMediaPlaylist;->targetDurationSecs:I

    .line 78
    iput p4, p0, Lcom/google/android/exoplayer/hls/HlsMediaPlaylist;->version:I

    .line 79
    iput-boolean p5, p0, Lcom/google/android/exoplayer/hls/HlsMediaPlaylist;->live:Z

    .line 80
    iput-object p6, p0, Lcom/google/android/exoplayer/hls/HlsMediaPlaylist;->segments:Ljava/util/List;

    .line 82
    invoke-interface {p6}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_0

    .line 83
    invoke-interface {p6}, Ljava/util/List;->size()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    invoke-interface {p6, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/exoplayer/hls/HlsMediaPlaylist$Segment;

    .line 84
    .local v0, "last":Lcom/google/android/exoplayer/hls/HlsMediaPlaylist$Segment;
    iget-wide v2, v0, Lcom/google/android/exoplayer/hls/HlsMediaPlaylist$Segment;->startTimeUs:J

    iget-wide v4, v0, Lcom/google/android/exoplayer/hls/HlsMediaPlaylist$Segment;->durationSecs:D

    const-wide v6, 0x412e848000000000L    # 1000000.0

    mul-double/2addr v4, v6

    double-to-long v4, v4

    add-long/2addr v2, v4

    iput-wide v2, p0, Lcom/google/android/exoplayer/hls/HlsMediaPlaylist;->durationUs:J

    .line 88
    .end local v0    # "last":Lcom/google/android/exoplayer/hls/HlsMediaPlaylist$Segment;
    :goto_0
    return-void

    .line 86
    :cond_0
    const-wide/16 v2, 0x0

    iput-wide v2, p0, Lcom/google/android/exoplayer/hls/HlsMediaPlaylist;->durationUs:J

    goto :goto_0
.end method
