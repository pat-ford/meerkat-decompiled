.class Lcom/google/android/exoplayer/drm/StreamingDrmSessionManager$1;
.super Ljava/lang/Object;
.source "StreamingDrmSessionManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/exoplayer/drm/StreamingDrmSessionManager;->onError(Ljava/lang/Exception;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/google/android/exoplayer/drm/StreamingDrmSessionManager;

.field final synthetic val$e:Ljava/lang/Exception;


# direct methods
.method constructor <init>(Lcom/google/android/exoplayer/drm/StreamingDrmSessionManager;Ljava/lang/Exception;)V
    .locals 0
    .param p1, "this$0"    # Lcom/google/android/exoplayer/drm/StreamingDrmSessionManager;

    .prologue
    .line 305
    iput-object p1, p0, Lcom/google/android/exoplayer/drm/StreamingDrmSessionManager$1;->this$0:Lcom/google/android/exoplayer/drm/StreamingDrmSessionManager;

    iput-object p2, p0, Lcom/google/android/exoplayer/drm/StreamingDrmSessionManager$1;->val$e:Ljava/lang/Exception;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 308
    iget-object v0, p0, Lcom/google/android/exoplayer/drm/StreamingDrmSessionManager$1;->this$0:Lcom/google/android/exoplayer/drm/StreamingDrmSessionManager;

    # getter for: Lcom/google/android/exoplayer/drm/StreamingDrmSessionManager;->eventListener:Lcom/google/android/exoplayer/drm/StreamingDrmSessionManager$EventListener;
    invoke-static {v0}, Lcom/google/android/exoplayer/drm/StreamingDrmSessionManager;->access$100(Lcom/google/android/exoplayer/drm/StreamingDrmSessionManager;)Lcom/google/android/exoplayer/drm/StreamingDrmSessionManager$EventListener;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/exoplayer/drm/StreamingDrmSessionManager$1;->val$e:Ljava/lang/Exception;

    invoke-interface {v0, v1}, Lcom/google/android/exoplayer/drm/StreamingDrmSessionManager$EventListener;->onDrmSessionManagerError(Ljava/lang/Exception;)V

    .line 309
    return-void
.end method
