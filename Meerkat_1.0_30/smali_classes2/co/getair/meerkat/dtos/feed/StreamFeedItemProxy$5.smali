.class Lco/getair/meerkat/dtos/feed/StreamFeedItemProxy$5;
.super Ljava/lang/Object;
.source "StreamFeedItemProxy.java"

# interfaces
.implements Lcom/android/volley/Response$Listener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lco/getair/meerkat/dtos/feed/StreamFeedItemProxy;->restreamSchduledStream(Lco/getair/meerkat/utilities/RunnableWithResultObject;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/android/volley/Response$Listener",
        "<",
        "Lorg/json/JSONObject;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lco/getair/meerkat/dtos/feed/StreamFeedItemProxy;

.field final synthetic val$runnableWithResultObject:Lco/getair/meerkat/utilities/RunnableWithResultObject;


# direct methods
.method constructor <init>(Lco/getair/meerkat/dtos/feed/StreamFeedItemProxy;Lco/getair/meerkat/utilities/RunnableWithResultObject;)V
    .locals 0
    .param p1, "this$0"    # Lco/getair/meerkat/dtos/feed/StreamFeedItemProxy;

    .prologue
    .line 154
    .local p0, "this":Lco/getair/meerkat/dtos/feed/StreamFeedItemProxy$5;, "Lco/getair/meerkat/dtos/feed/StreamFeedItemProxy$5;"
    iput-object p1, p0, Lco/getair/meerkat/dtos/feed/StreamFeedItemProxy$5;->this$0:Lco/getair/meerkat/dtos/feed/StreamFeedItemProxy;

    iput-object p2, p0, Lco/getair/meerkat/dtos/feed/StreamFeedItemProxy$5;->val$runnableWithResultObject:Lco/getair/meerkat/utilities/RunnableWithResultObject;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic onResponse(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 154
    .local p0, "this":Lco/getair/meerkat/dtos/feed/StreamFeedItemProxy$5;, "Lco/getair/meerkat/dtos/feed/StreamFeedItemProxy$5;"
    check-cast p1, Lorg/json/JSONObject;

    invoke-virtual {p0, p1}, Lco/getair/meerkat/dtos/feed/StreamFeedItemProxy$5;->onResponse(Lorg/json/JSONObject;)V

    return-void
.end method

.method public onResponse(Lorg/json/JSONObject;)V
    .locals 2
    .param p1, "response"    # Lorg/json/JSONObject;

    .prologue
    .line 157
    .local p0, "this":Lco/getair/meerkat/dtos/feed/StreamFeedItemProxy$5;, "Lco/getair/meerkat/dtos/feed/StreamFeedItemProxy$5;"
    const-string v0, "restream successfully"

    invoke-static {v0}, Lco/getair/meerkat/utilities/MLog;->e(Ljava/lang/String;)V

    .line 158
    iget-object v0, p0, Lco/getair/meerkat/dtos/feed/StreamFeedItemProxy$5;->val$runnableWithResultObject:Lco/getair/meerkat/utilities/RunnableWithResultObject;

    const/4 v1, 0x1

    iput-boolean v1, v0, Lco/getair/meerkat/utilities/RunnableWithResultObject;->success:Z

    .line 159
    iget-object v0, p0, Lco/getair/meerkat/dtos/feed/StreamFeedItemProxy$5;->val$runnableWithResultObject:Lco/getair/meerkat/utilities/RunnableWithResultObject;

    invoke-virtual {v0}, Lco/getair/meerkat/utilities/RunnableWithResultObject;->run()V

    .line 160
    return-void
.end method