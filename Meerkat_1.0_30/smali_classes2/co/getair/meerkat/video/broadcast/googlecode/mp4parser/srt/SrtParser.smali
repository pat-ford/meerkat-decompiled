.class public Lco/getair/meerkat/video/broadcast/googlecode/mp4parser/srt/SrtParser;
.super Ljava/lang/Object;
.source "SrtParser.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static parse(Ljava/lang/String;)J
    .locals 14
    .param p0, "in"    # Ljava/lang/String;

    .prologue
    .line 51
    const-string v8, ":"

    invoke-virtual {p0, v8}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v8

    const/4 v9, 0x0

    aget-object v8, v8, v9

    invoke-virtual {v8}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v0

    .line 52
    .local v0, "hours":J
    const-string v8, ":"

    invoke-virtual {p0, v8}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v8

    const/4 v9, 0x1

    aget-object v8, v8, v9

    invoke-virtual {v8}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v4

    .line 53
    .local v4, "minutes":J
    const-string v8, ":"

    invoke-virtual {p0, v8}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v8

    const/4 v9, 0x2

    aget-object v8, v8, v9

    const-string v9, ","

    invoke-virtual {v8, v9}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v8

    const/4 v9, 0x0

    aget-object v8, v8, v9

    invoke-virtual {v8}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v6

    .line 54
    .local v6, "seconds":J
    const-string v8, ":"

    invoke-virtual {p0, v8}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v8

    const/4 v9, 0x2

    aget-object v8, v8, v9

    const-string v9, ","

    invoke-virtual {v8, v9}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v8

    const/4 v9, 0x1

    aget-object v8, v8, v9

    invoke-virtual {v8}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v2

    .line 56
    .local v2, "millies":J
    const-wide/16 v8, 0x3c

    mul-long/2addr v8, v0

    const-wide/16 v10, 0x3c

    mul-long/2addr v8, v10

    const-wide/16 v10, 0x3e8

    mul-long/2addr v8, v10

    const-wide/16 v10, 0x3c

    mul-long/2addr v10, v4

    const-wide/16 v12, 0x3e8

    mul-long/2addr v10, v12

    add-long/2addr v8, v10

    const-wide/16 v10, 0x3e8

    mul-long/2addr v10, v6

    add-long/2addr v8, v10

    add-long/2addr v8, v2

    return-wide v8
.end method

.method public static parse(Ljava/io/InputStream;)Lco/getair/meerkat/video/broadcast/googlecode/mp4parser/authoring/tracks/TextTrackImpl;
    .locals 12
    .param p0, "is"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 30
    new-instance v7, Ljava/io/LineNumberReader;

    new-instance v1, Ljava/io/InputStreamReader;

    const-string v11, "UTF-8"

    invoke-direct {v1, p0, v11}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;Ljava/lang/String;)V

    invoke-direct {v7, v1}, Ljava/io/LineNumberReader;-><init>(Ljava/io/Reader;)V

    .line 31
    .local v7, "r":Ljava/io/LineNumberReader;
    new-instance v10, Lco/getair/meerkat/video/broadcast/googlecode/mp4parser/authoring/tracks/TextTrackImpl;

    invoke-direct {v10}, Lco/getair/meerkat/video/broadcast/googlecode/mp4parser/authoring/tracks/TextTrackImpl;-><init>()V

    .line 33
    .local v10, "track":Lco/getair/meerkat/video/broadcast/googlecode/mp4parser/authoring/tracks/TextTrackImpl;
    :goto_0
    invoke-virtual {v7}, Ljava/io/LineNumberReader;->readLine()Ljava/lang/String;

    move-result-object v0

    .local v0, "numberString":Ljava/lang/String;
    if-eqz v0, :cond_1

    .line 34
    invoke-virtual {v7}, Ljava/io/LineNumberReader;->readLine()Ljava/lang/String;

    move-result-object v9

    .line 35
    .local v9, "timeString":Ljava/lang/String;
    const-string v6, ""

    .line 37
    .local v6, "lineString":Ljava/lang/String;
    :goto_1
    invoke-virtual {v7}, Ljava/io/LineNumberReader;->readLine()Ljava/lang/String;

    move-result-object v8

    .local v8, "s":Ljava/lang/String;
    if-eqz v8, :cond_0

    invoke-virtual {v8}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    const-string v11, ""

    invoke-virtual {v1, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 38
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v11, "\n"

    invoke-virtual {v1, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    goto :goto_1

    .line 41
    :cond_0
    const-string v1, "-->"

    invoke-virtual {v9, v1}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    const/4 v11, 0x0

    aget-object v1, v1, v11

    invoke-static {v1}, Lco/getair/meerkat/video/broadcast/googlecode/mp4parser/srt/SrtParser;->parse(Ljava/lang/String;)J

    move-result-wide v2

    .line 42
    .local v2, "startTime":J
    const-string v1, "-->"

    invoke-virtual {v9, v1}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    const/4 v11, 0x1

    aget-object v1, v1, v11

    invoke-static {v1}, Lco/getair/meerkat/video/broadcast/googlecode/mp4parser/srt/SrtParser;->parse(Ljava/lang/String;)J

    move-result-wide v4

    .line 44
    .local v4, "endTime":J
    invoke-virtual {v10}, Lco/getair/meerkat/video/broadcast/googlecode/mp4parser/authoring/tracks/TextTrackImpl;->getSubs()Ljava/util/List;

    move-result-object v11

    new-instance v1, Lco/getair/meerkat/video/broadcast/googlecode/mp4parser/authoring/tracks/TextTrackImpl$Line;

    invoke-direct/range {v1 .. v6}, Lco/getair/meerkat/video/broadcast/googlecode/mp4parser/authoring/tracks/TextTrackImpl$Line;-><init>(JJLjava/lang/String;)V

    invoke-interface {v11, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 47
    .end local v2    # "startTime":J
    .end local v4    # "endTime":J
    .end local v6    # "lineString":Ljava/lang/String;
    .end local v8    # "s":Ljava/lang/String;
    .end local v9    # "timeString":Ljava/lang/String;
    :cond_1
    return-object v10
.end method
