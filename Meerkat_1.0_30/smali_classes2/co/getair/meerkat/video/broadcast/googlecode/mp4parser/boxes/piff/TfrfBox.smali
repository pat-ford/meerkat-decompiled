.class public Lco/getair/meerkat/video/broadcast/googlecode/mp4parser/boxes/piff/TfrfBox;
.super Lco/getair/meerkat/video/broadcast/googlecode/mp4parser/AbstractFullBox;
.source "TfrfBox.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/getair/meerkat/video/broadcast/googlecode/mp4parser/boxes/piff/TfrfBox$Entry;
    }
.end annotation


# instance fields
.field public entries:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lco/getair/meerkat/video/broadcast/googlecode/mp4parser/boxes/piff/TfrfBox$Entry;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 42
    const-string v0, "uuid"

    invoke-direct {p0, v0}, Lco/getair/meerkat/video/broadcast/googlecode/mp4parser/AbstractFullBox;-><init>(Ljava/lang/String;)V

    .line 39
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lco/getair/meerkat/video/broadcast/googlecode/mp4parser/boxes/piff/TfrfBox;->entries:Ljava/util/List;

    .line 43
    return-void
.end method


# virtual methods
.method public _parseDetails(Ljava/nio/ByteBuffer;)V
    .locals 6
    .param p1, "content"    # Ljava/nio/ByteBuffer;

    .prologue
    .line 74
    invoke-virtual {p0, p1}, Lco/getair/meerkat/video/broadcast/googlecode/mp4parser/boxes/piff/TfrfBox;->parseVersionAndFlags(Ljava/nio/ByteBuffer;)J

    .line 75
    invoke-static {p1}, Lco/getair/meerkat/video/broadcast/coremedia/iso/IsoTypeReader;->readUInt8(Ljava/nio/ByteBuffer;)I

    move-result v1

    .line 77
    .local v1, "fragmentCount":I
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    if-ge v2, v1, :cond_1

    .line 78
    new-instance v0, Lco/getair/meerkat/video/broadcast/googlecode/mp4parser/boxes/piff/TfrfBox$Entry;

    invoke-direct {v0, p0}, Lco/getair/meerkat/video/broadcast/googlecode/mp4parser/boxes/piff/TfrfBox$Entry;-><init>(Lco/getair/meerkat/video/broadcast/googlecode/mp4parser/boxes/piff/TfrfBox;)V

    .line 79
    .local v0, "entry":Lco/getair/meerkat/video/broadcast/googlecode/mp4parser/boxes/piff/TfrfBox$Entry;
    invoke-virtual {p0}, Lco/getair/meerkat/video/broadcast/googlecode/mp4parser/boxes/piff/TfrfBox;->getVersion()I

    move-result v3

    const/4 v4, 0x1

    if-ne v3, v4, :cond_0

    .line 80
    invoke-static {p1}, Lco/getair/meerkat/video/broadcast/coremedia/iso/IsoTypeReader;->readUInt64(Ljava/nio/ByteBuffer;)J

    move-result-wide v4

    iput-wide v4, v0, Lco/getair/meerkat/video/broadcast/googlecode/mp4parser/boxes/piff/TfrfBox$Entry;->fragmentAbsoluteTime:J

    .line 81
    invoke-static {p1}, Lco/getair/meerkat/video/broadcast/coremedia/iso/IsoTypeReader;->readUInt64(Ljava/nio/ByteBuffer;)J

    move-result-wide v4

    iput-wide v4, v0, Lco/getair/meerkat/video/broadcast/googlecode/mp4parser/boxes/piff/TfrfBox$Entry;->fragmentAbsoluteDuration:J

    .line 86
    :goto_1
    iget-object v3, p0, Lco/getair/meerkat/video/broadcast/googlecode/mp4parser/boxes/piff/TfrfBox;->entries:Ljava/util/List;

    invoke-interface {v3, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 77
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 83
    :cond_0
    invoke-static {p1}, Lco/getair/meerkat/video/broadcast/coremedia/iso/IsoTypeReader;->readUInt32(Ljava/nio/ByteBuffer;)J

    move-result-wide v4

    iput-wide v4, v0, Lco/getair/meerkat/video/broadcast/googlecode/mp4parser/boxes/piff/TfrfBox$Entry;->fragmentAbsoluteTime:J

    .line 84
    invoke-static {p1}, Lco/getair/meerkat/video/broadcast/coremedia/iso/IsoTypeReader;->readUInt32(Ljava/nio/ByteBuffer;)J

    move-result-wide v4

    iput-wide v4, v0, Lco/getair/meerkat/video/broadcast/googlecode/mp4parser/boxes/piff/TfrfBox$Entry;->fragmentAbsoluteDuration:J

    goto :goto_1

    .line 88
    .end local v0    # "entry":Lco/getair/meerkat/video/broadcast/googlecode/mp4parser/boxes/piff/TfrfBox$Entry;
    :cond_1
    return-void
.end method

.method protected getContent(Ljava/nio/ByteBuffer;)V
    .locals 4
    .param p1, "byteBuffer"    # Ljava/nio/ByteBuffer;

    .prologue
    .line 58
    invoke-virtual {p0, p1}, Lco/getair/meerkat/video/broadcast/googlecode/mp4parser/boxes/piff/TfrfBox;->writeVersionAndFlags(Ljava/nio/ByteBuffer;)V

    .line 59
    iget-object v1, p0, Lco/getair/meerkat/video/broadcast/googlecode/mp4parser/boxes/piff/TfrfBox;->entries:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    invoke-static {p1, v1}, Lco/getair/meerkat/video/broadcast/coremedia/iso/IsoTypeWriter;->writeUInt8(Ljava/nio/ByteBuffer;I)V

    .line 61
    iget-object v1, p0, Lco/getair/meerkat/video/broadcast/googlecode/mp4parser/boxes/piff/TfrfBox;->entries:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/getair/meerkat/video/broadcast/googlecode/mp4parser/boxes/piff/TfrfBox$Entry;

    .line 62
    .local v0, "entry":Lco/getair/meerkat/video/broadcast/googlecode/mp4parser/boxes/piff/TfrfBox$Entry;
    invoke-virtual {p0}, Lco/getair/meerkat/video/broadcast/googlecode/mp4parser/boxes/piff/TfrfBox;->getVersion()I

    move-result v2

    const/4 v3, 0x1

    if-ne v2, v3, :cond_0

    .line 63
    iget-wide v2, v0, Lco/getair/meerkat/video/broadcast/googlecode/mp4parser/boxes/piff/TfrfBox$Entry;->fragmentAbsoluteTime:J

    invoke-static {p1, v2, v3}, Lco/getair/meerkat/video/broadcast/coremedia/iso/IsoTypeWriter;->writeUInt64(Ljava/nio/ByteBuffer;J)V

    .line 64
    iget-wide v2, v0, Lco/getair/meerkat/video/broadcast/googlecode/mp4parser/boxes/piff/TfrfBox$Entry;->fragmentAbsoluteDuration:J

    invoke-static {p1, v2, v3}, Lco/getair/meerkat/video/broadcast/coremedia/iso/IsoTypeWriter;->writeUInt64(Ljava/nio/ByteBuffer;J)V

    goto :goto_0

    .line 66
    :cond_0
    iget-wide v2, v0, Lco/getair/meerkat/video/broadcast/googlecode/mp4parser/boxes/piff/TfrfBox$Entry;->fragmentAbsoluteTime:J

    invoke-static {p1, v2, v3}, Lco/getair/meerkat/video/broadcast/coremedia/iso/IsoTypeWriter;->writeUInt32(Ljava/nio/ByteBuffer;J)V

    .line 67
    iget-wide v2, v0, Lco/getair/meerkat/video/broadcast/googlecode/mp4parser/boxes/piff/TfrfBox$Entry;->fragmentAbsoluteDuration:J

    invoke-static {p1, v2, v3}, Lco/getair/meerkat/video/broadcast/coremedia/iso/IsoTypeWriter;->writeUInt32(Ljava/nio/ByteBuffer;J)V

    goto :goto_0

    .line 70
    .end local v0    # "entry":Lco/getair/meerkat/video/broadcast/googlecode/mp4parser/boxes/piff/TfrfBox$Entry;
    :cond_1
    return-void
.end method

.method protected getContentSize()J
    .locals 3

    .prologue
    .line 53
    iget-object v0, p0, Lco/getair/meerkat/video/broadcast/googlecode/mp4parser/boxes/piff/TfrfBox;->entries:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    invoke-virtual {p0}, Lco/getair/meerkat/video/broadcast/googlecode/mp4parser/boxes/piff/TfrfBox;->getVersion()I

    move-result v0

    const/4 v2, 0x1

    if-ne v0, v2, :cond_0

    const/16 v0, 0x10

    :goto_0
    mul-int/2addr v0, v1

    add-int/lit8 v0, v0, 0x5

    int-to-long v0, v0

    return-wide v0

    :cond_0
    const/16 v0, 0x8

    goto :goto_0
.end method

.method public getEntries()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lco/getair/meerkat/video/broadcast/googlecode/mp4parser/boxes/piff/TfrfBox$Entry;",
            ">;"
        }
    .end annotation

    .prologue
    .line 96
    iget-object v0, p0, Lco/getair/meerkat/video/broadcast/googlecode/mp4parser/boxes/piff/TfrfBox;->entries:Ljava/util/List;

    return-object v0
.end method

.method public getFragmentCount()J
    .locals 2

    .prologue
    .line 92
    iget-object v0, p0, Lco/getair/meerkat/video/broadcast/googlecode/mp4parser/boxes/piff/TfrfBox;->entries:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    int-to-long v0, v0

    return-wide v0
.end method

.method public getUserType()[B
    .locals 1

    .prologue
    .line 47
    const/16 v0, 0x10

    new-array v0, v0, [B

    fill-array-data v0, :array_0

    return-object v0

    :array_0
    .array-data 1
        -0x2ct
        -0x80t
        0x7et
        -0xet
        -0x36t
        0x39t
        0x46t
        -0x6bt
        -0x72t
        0x54t
        0x26t
        -0x35t
        -0x62t
        0x46t
        -0x59t
        -0x61t
    .end array-data
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 101
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 102
    .local v0, "sb":Ljava/lang/StringBuilder;
    const-string v1, "TfrfBox"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 103
    const-string v1, "{entries="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lco/getair/meerkat/video/broadcast/googlecode/mp4parser/boxes/piff/TfrfBox;->entries:Ljava/util/List;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 104
    const/16 v1, 0x7d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 105
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method
