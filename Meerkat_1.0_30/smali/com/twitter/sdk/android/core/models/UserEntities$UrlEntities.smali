.class public Lcom/twitter/sdk/android/core/models/UserEntities$UrlEntities;
.super Ljava/lang/Object;
.source "UserEntities.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/twitter/sdk/android/core/models/UserEntities;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UrlEntities"
.end annotation


# instance fields
.field public final urls:Ljava/util/List;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "urls"
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/twitter/sdk/android/core/models/UrlEntity;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/twitter/sdk/android/core/models/UrlEntity;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 30
    .local p1, "urls":Ljava/util/List;, "Ljava/util/List<Lcom/twitter/sdk/android/core/models/UrlEntity;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 31
    invoke-direct {p0, p1}, Lcom/twitter/sdk/android/core/models/UserEntities$UrlEntities;->getSafeList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/twitter/sdk/android/core/models/UserEntities$UrlEntities;->urls:Ljava/util/List;

    .line 32
    return-void
.end method

.method private getSafeList(Ljava/util/List;)Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/util/List",
            "<TT;>;)",
            "Ljava/util/List",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 37
    .local p1, "entities":Ljava/util/List;, "Ljava/util/List<TT;>;"
    if-nez p1, :cond_0

    .line 38
    sget-object v0, Ljava/util/Collections;->EMPTY_LIST:Ljava/util/List;

    .line 40
    :goto_0
    return-object v0

    :cond_0
    invoke-static {p1}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    goto :goto_0
.end method
