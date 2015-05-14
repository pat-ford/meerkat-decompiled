.class public final Lcom/google/android/exoplayer/upstream/Loader;
.super Ljava/lang/Object;
.source "Loader.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/exoplayer/upstream/Loader$LoadTask;,
        Lcom/google/android/exoplayer/upstream/Loader$Callback;,
        Lcom/google/android/exoplayer/upstream/Loader$Loadable;,
        Lcom/google/android/exoplayer/upstream/Loader$UnexpectedLoaderException;
    }
.end annotation


# static fields
.field private static final MSG_END_OF_SOURCE:I = 0x0

.field private static final MSG_ERROR:I = 0x1


# instance fields
.field private currentTask:Lcom/google/android/exoplayer/upstream/Loader$LoadTask;

.field private final downloadExecutorService:Ljava/util/concurrent/ExecutorService;

.field private loading:Z


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 1
    .param p1, "threadName"    # Ljava/lang/String;

    .prologue
    .line 112
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 113
    invoke-static {p1}, Lcom/google/android/exoplayer/util/Util;->newSingleThreadExecutor(Ljava/lang/String;)Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/exoplayer/upstream/Loader;->downloadExecutorService:Ljava/util/concurrent/ExecutorService;

    .line 114
    return-void
.end method

.method static synthetic access$002(Lcom/google/android/exoplayer/upstream/Loader;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/google/android/exoplayer/upstream/Loader;
    .param p1, "x1"    # Z

    .prologue
    .line 33
    iput-boolean p1, p0, Lcom/google/android/exoplayer/upstream/Loader;->loading:Z

    return p1
.end method

.method static synthetic access$102(Lcom/google/android/exoplayer/upstream/Loader;Lcom/google/android/exoplayer/upstream/Loader$LoadTask;)Lcom/google/android/exoplayer/upstream/Loader$LoadTask;
    .locals 0
    .param p0, "x0"    # Lcom/google/android/exoplayer/upstream/Loader;
    .param p1, "x1"    # Lcom/google/android/exoplayer/upstream/Loader$LoadTask;

    .prologue
    .line 33
    iput-object p1, p0, Lcom/google/android/exoplayer/upstream/Loader;->currentTask:Lcom/google/android/exoplayer/upstream/Loader$LoadTask;

    return-object p1
.end method


# virtual methods
.method public cancelLoading()V
    .locals 1

    .prologue
    .line 162
    iget-boolean v0, p0, Lcom/google/android/exoplayer/upstream/Loader;->loading:Z

    invoke-static {v0}, Lcom/google/android/exoplayer/util/Assertions;->checkState(Z)V

    .line 163
    iget-object v0, p0, Lcom/google/android/exoplayer/upstream/Loader;->currentTask:Lcom/google/android/exoplayer/upstream/Loader$LoadTask;

    invoke-virtual {v0}, Lcom/google/android/exoplayer/upstream/Loader$LoadTask;->quit()V

    .line 164
    return-void
.end method

.method public isLoading()Z
    .locals 1

    .prologue
    .line 153
    iget-boolean v0, p0, Lcom/google/android/exoplayer/upstream/Loader;->loading:Z

    return v0
.end method

.method public release()V
    .locals 1

    .prologue
    .line 172
    iget-boolean v0, p0, Lcom/google/android/exoplayer/upstream/Loader;->loading:Z

    if-eqz v0, :cond_0

    .line 173
    invoke-virtual {p0}, Lcom/google/android/exoplayer/upstream/Loader;->cancelLoading()V

    .line 175
    :cond_0
    iget-object v0, p0, Lcom/google/android/exoplayer/upstream/Loader;->downloadExecutorService:Ljava/util/concurrent/ExecutorService;

    invoke-interface {v0}, Ljava/util/concurrent/ExecutorService;->shutdown()V

    .line 176
    return-void
.end method

.method public startLoading(Landroid/os/Looper;Lcom/google/android/exoplayer/upstream/Loader$Loadable;Lcom/google/android/exoplayer/upstream/Loader$Callback;)V
    .locals 2
    .param p1, "looper"    # Landroid/os/Looper;
    .param p2, "loadable"    # Lcom/google/android/exoplayer/upstream/Loader$Loadable;
    .param p3, "callback"    # Lcom/google/android/exoplayer/upstream/Loader$Callback;

    .prologue
    const/4 v1, 0x1

    .line 141
    iget-boolean v0, p0, Lcom/google/android/exoplayer/upstream/Loader;->loading:Z

    if-nez v0, :cond_0

    move v0, v1

    :goto_0
    invoke-static {v0}, Lcom/google/android/exoplayer/util/Assertions;->checkState(Z)V

    .line 142
    iput-boolean v1, p0, Lcom/google/android/exoplayer/upstream/Loader;->loading:Z

    .line 143
    new-instance v0, Lcom/google/android/exoplayer/upstream/Loader$LoadTask;

    invoke-direct {v0, p0, p1, p2, p3}, Lcom/google/android/exoplayer/upstream/Loader$LoadTask;-><init>(Lcom/google/android/exoplayer/upstream/Loader;Landroid/os/Looper;Lcom/google/android/exoplayer/upstream/Loader$Loadable;Lcom/google/android/exoplayer/upstream/Loader$Callback;)V

    iput-object v0, p0, Lcom/google/android/exoplayer/upstream/Loader;->currentTask:Lcom/google/android/exoplayer/upstream/Loader$LoadTask;

    .line 144
    iget-object v0, p0, Lcom/google/android/exoplayer/upstream/Loader;->downloadExecutorService:Ljava/util/concurrent/ExecutorService;

    iget-object v1, p0, Lcom/google/android/exoplayer/upstream/Loader;->currentTask:Lcom/google/android/exoplayer/upstream/Loader$LoadTask;

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/lang/Runnable;)Ljava/util/concurrent/Future;

    .line 145
    return-void

    .line 141
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public startLoading(Lcom/google/android/exoplayer/upstream/Loader$Loadable;Lcom/google/android/exoplayer/upstream/Loader$Callback;)V
    .locals 2
    .param p1, "loadable"    # Lcom/google/android/exoplayer/upstream/Loader$Loadable;
    .param p2, "callback"    # Lcom/google/android/exoplayer/upstream/Loader$Callback;

    .prologue
    .line 125
    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v0

    .line 126
    .local v0, "myLooper":Landroid/os/Looper;
    if-eqz v0, :cond_0

    const/4 v1, 0x1

    :goto_0
    invoke-static {v1}, Lcom/google/android/exoplayer/util/Assertions;->checkState(Z)V

    .line 127
    invoke-virtual {p0, v0, p1, p2}, Lcom/google/android/exoplayer/upstream/Loader;->startLoading(Landroid/os/Looper;Lcom/google/android/exoplayer/upstream/Loader$Loadable;Lcom/google/android/exoplayer/upstream/Loader$Callback;)V

    .line 128
    return-void

    .line 126
    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method
