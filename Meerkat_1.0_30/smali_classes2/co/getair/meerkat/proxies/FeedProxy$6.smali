.class Lco/getair/meerkat/proxies/FeedProxy$6;
.super Ljava/lang/Object;
.source "FeedProxy.java"

# interfaces
.implements Lcom/android/volley/Response$ErrorListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lco/getair/meerkat/proxies/FeedProxy;->requestStreamSummary(Lco/getair/meerkat/dtos/feed/FeedStream;Ljava/lang/Class;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/getair/meerkat/proxies/FeedProxy;


# direct methods
.method constructor <init>(Lco/getair/meerkat/proxies/FeedProxy;)V
    .locals 0
    .param p1, "this$0"    # Lco/getair/meerkat/proxies/FeedProxy;

    .prologue
    .line 211
    iput-object p1, p0, Lco/getair/meerkat/proxies/FeedProxy$6;->this$0:Lco/getair/meerkat/proxies/FeedProxy;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onErrorResponse(Lcom/android/volley/VolleyError;)V
    .locals 1
    .param p1, "error"    # Lcom/android/volley/VolleyError;

    .prologue
    .line 215
    const-string v0, "FAILED getting live feed"

    invoke-static {v0}, Lco/getair/meerkat/utilities/MLog;->e(Ljava/lang/String;)V

    .line 216
    return-void
.end method
