.class final Lcom/instabug/library/internal/storage/h;
.super Ljava/lang/Object;
.source "IssueCloudDataStore.java"

# interfaces
.implements Lcom/instabug/library/interactor/a$a;


# instance fields
.field private synthetic a:Lcom/instabug/library/model/a;

.field private synthetic b:Lcom/instabug/library/internal/storage/e$a;

.field private synthetic c:Lcom/instabug/library/internal/storage/g;


# direct methods
.method constructor <init>(Lcom/instabug/library/internal/storage/g;Lcom/instabug/library/model/a;Lcom/instabug/library/internal/storage/e$a;)V
    .locals 0

    .prologue
    .line 26
    iput-object p1, p0, Lcom/instabug/library/internal/storage/h;->c:Lcom/instabug/library/internal/storage/g;

    iput-object p2, p0, Lcom/instabug/library/internal/storage/h;->a:Lcom/instabug/library/model/a;

    iput-object p3, p0, Lcom/instabug/library/internal/storage/h;->b:Lcom/instabug/library/internal/storage/e$a;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a()V
    .locals 3

    .prologue
    .line 29
    iget-object v0, p0, Lcom/instabug/library/internal/storage/h;->a:Lcom/instabug/library/model/a;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/instabug/library/model/a;->d(I)V

    .line 30
    iget-object v0, p0, Lcom/instabug/library/internal/storage/h;->a:Lcom/instabug/library/model/a;

    invoke-virtual {v0}, Lcom/instabug/library/model/a;->d()V

    .line 31
    iget-object v0, p0, Lcom/instabug/library/internal/storage/h;->c:Lcom/instabug/library/internal/storage/g;

    iget-object v1, p0, Lcom/instabug/library/internal/storage/h;->a:Lcom/instabug/library/model/a;

    iget-object v2, p0, Lcom/instabug/library/internal/storage/h;->b:Lcom/instabug/library/internal/storage/e$a;

    invoke-static {v0, v1, v2}, Lcom/instabug/library/internal/storage/g;->a(Lcom/instabug/library/internal/storage/g;Lcom/instabug/library/model/a;Lcom/instabug/library/internal/storage/e$a;)V

    .line 32
    iget-object v0, p0, Lcom/instabug/library/internal/storage/h;->a:Lcom/instabug/library/model/a;

    invoke-virtual {v0}, Lcom/instabug/library/model/a;->k()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/instabug/library/internal/storage/a;->a(Ljava/lang/String;)V

    .line 33
    return-void
.end method

.method public final a(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lcom/instabug/library/internal/storage/h;->a:Lcom/instabug/library/model/a;

    invoke-virtual {v0}, Lcom/instabug/library/model/a;->d()V

    .line 38
    iget-object v0, p0, Lcom/instabug/library/internal/storage/h;->a:Lcom/instabug/library/model/a;

    invoke-virtual {v0}, Lcom/instabug/library/model/a;->c()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 39
    iget-object v0, p0, Lcom/instabug/library/internal/storage/h;->b:Lcom/instabug/library/internal/storage/e$a;

    invoke-interface {v0, p1}, Lcom/instabug/library/internal/storage/e$a;->a(Ljava/lang/String;)V

    .line 40
    :cond_0
    return-void
.end method
