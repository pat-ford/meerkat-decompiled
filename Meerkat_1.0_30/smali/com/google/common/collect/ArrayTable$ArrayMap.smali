.class abstract Lcom/google/common/collect/ArrayTable$ArrayMap;
.super Lcom/google/common/collect/Maps$ImprovedAbstractMap;
.source "ArrayTable.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/common/collect/ArrayTable;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x40a
    name = "ArrayMap"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<K:",
        "Ljava/lang/Object;",
        "V:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/google/common/collect/Maps$ImprovedAbstractMap",
        "<TK;TV;>;"
    }
.end annotation


# instance fields
.field private final keyIndex:Lcom/google/common/collect/ImmutableMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/common/collect/ImmutableMap",
            "<TK;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method private constructor <init>(Lcom/google/common/collect/ImmutableMap;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/common/collect/ImmutableMap",
            "<TK;",
            "Ljava/lang/Integer;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 198
    .local p0, "this":Lcom/google/common/collect/ArrayTable$ArrayMap;, "Lcom/google/common/collect/ArrayTable$ArrayMap<TK;TV;>;"
    .local p1, "keyIndex":Lcom/google/common/collect/ImmutableMap;, "Lcom/google/common/collect/ImmutableMap<TK;Ljava/lang/Integer;>;"
    invoke-direct {p0}, Lcom/google/common/collect/Maps$ImprovedAbstractMap;-><init>()V

    .line 199
    iput-object p1, p0, Lcom/google/common/collect/ArrayTable$ArrayMap;->keyIndex:Lcom/google/common/collect/ImmutableMap;

    .line 200
    return-void
.end method

.method synthetic constructor <init>(Lcom/google/common/collect/ImmutableMap;Lcom/google/common/collect/ArrayTable$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/google/common/collect/ImmutableMap;
    .param p2, "x1"    # Lcom/google/common/collect/ArrayTable$1;

    .prologue
    .line 195
    .local p0, "this":Lcom/google/common/collect/ArrayTable$ArrayMap;, "Lcom/google/common/collect/ArrayTable$ArrayMap<TK;TV;>;"
    invoke-direct {p0, p1}, Lcom/google/common/collect/ArrayTable$ArrayMap;-><init>(Lcom/google/common/collect/ImmutableMap;)V

    return-void
.end method


# virtual methods
.method public clear()V
    .locals 1

    .prologue
    .line 296
    .local p0, "this":Lcom/google/common/collect/ArrayTable$ArrayMap;, "Lcom/google/common/collect/ArrayTable$ArrayMap<TK;TV;>;"
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public containsKey(Ljava/lang/Object;)Z
    .locals 1
    .param p1, "key"    # Ljava/lang/Object;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    .line 266
    .local p0, "this":Lcom/google/common/collect/ArrayTable$ArrayMap;, "Lcom/google/common/collect/ArrayTable$ArrayMap<TK;TV;>;"
    iget-object v0, p0, Lcom/google/common/collect/ArrayTable$ArrayMap;->keyIndex:Lcom/google/common/collect/ImmutableMap;

    invoke-virtual {v0, p1}, Lcom/google/common/collect/ImmutableMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method protected createEntrySet()Ljava/util/Set;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Ljava/util/Map$Entry",
            "<TK;TV;>;>;"
        }
    .end annotation

    .prologue
    .line 229
    .local p0, "this":Lcom/google/common/collect/ArrayTable$ArrayMap;, "Lcom/google/common/collect/ArrayTable$ArrayMap<TK;TV;>;"
    new-instance v0, Lcom/google/common/collect/ArrayTable$ArrayMap$1;

    invoke-direct {v0, p0}, Lcom/google/common/collect/ArrayTable$ArrayMap$1;-><init>(Lcom/google/common/collect/ArrayTable$ArrayMap;)V

    return-object v0
.end method

.method public get(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 2
    .param p1, "key"    # Ljava/lang/Object;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Object;",
            ")TV;"
        }
    .end annotation

    .prologue
    .line 271
    .local p0, "this":Lcom/google/common/collect/ArrayTable$ArrayMap;, "Lcom/google/common/collect/ArrayTable$ArrayMap<TK;TV;>;"
    iget-object v1, p0, Lcom/google/common/collect/ArrayTable$ArrayMap;->keyIndex:Lcom/google/common/collect/ImmutableMap;

    invoke-virtual {v1, p1}, Lcom/google/common/collect/ImmutableMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    .line 272
    .local v0, "index":Ljava/lang/Integer;
    if-nez v0, :cond_0

    .line 273
    const/4 v1, 0x0

    .line 275
    :goto_0
    return-object v1

    :cond_0
    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v1

    invoke-virtual {p0, v1}, Lcom/google/common/collect/ArrayTable$ArrayMap;->getValue(I)Ljava/lang/Object;

    move-result-object v1

    goto :goto_0
.end method

.method getKey(I)Ljava/lang/Object;
    .locals 1
    .param p1, "index"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)TK;"
        }
    .end annotation

    .prologue
    .line 208
    .local p0, "this":Lcom/google/common/collect/ArrayTable$ArrayMap;, "Lcom/google/common/collect/ArrayTable$ArrayMap<TK;TV;>;"
    iget-object v0, p0, Lcom/google/common/collect/ArrayTable$ArrayMap;->keyIndex:Lcom/google/common/collect/ImmutableMap;

    invoke-virtual {v0}, Lcom/google/common/collect/ImmutableMap;->keySet()Lcom/google/common/collect/ImmutableSet;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/common/collect/ImmutableSet;->asList()Lcom/google/common/collect/ImmutableList;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/google/common/collect/ImmutableList;->get(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method abstract getKeyRole()Ljava/lang/String;
.end method

.method abstract getValue(I)Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)TV;"
        }
    .end annotation

    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end method

.method public isEmpty()Z
    .locals 1

    .prologue
    .line 224
    .local p0, "this":Lcom/google/common/collect/ArrayTable$ArrayMap;, "Lcom/google/common/collect/ArrayTable$ArrayMap<TK;TV;>;"
    iget-object v0, p0, Lcom/google/common/collect/ArrayTable$ArrayMap;->keyIndex:Lcom/google/common/collect/ImmutableMap;

    invoke-virtual {v0}, Lcom/google/common/collect/ImmutableMap;->isEmpty()Z

    move-result v0

    return v0
.end method

.method public keySet()Ljava/util/Set;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<TK;>;"
        }
    .end annotation

    .prologue
    .line 204
    .local p0, "this":Lcom/google/common/collect/ArrayTable$ArrayMap;, "Lcom/google/common/collect/ArrayTable$ArrayMap<TK;TV;>;"
    iget-object v0, p0, Lcom/google/common/collect/ArrayTable$ArrayMap;->keyIndex:Lcom/google/common/collect/ImmutableMap;

    invoke-virtual {v0}, Lcom/google/common/collect/ImmutableMap;->keySet()Lcom/google/common/collect/ImmutableSet;

    move-result-object v0

    return-object v0
.end method

.method public put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TK;TV;)TV;"
        }
    .end annotation

    .prologue
    .line 281
    .local p0, "this":Lcom/google/common/collect/ArrayTable$ArrayMap;, "Lcom/google/common/collect/ArrayTable$ArrayMap<TK;TV;>;"
    .local p1, "key":Ljava/lang/Object;, "TK;"
    .local p2, "value":Ljava/lang/Object;, "TV;"
    iget-object v1, p0, Lcom/google/common/collect/ArrayTable$ArrayMap;->keyIndex:Lcom/google/common/collect/ImmutableMap;

    invoke-virtual {v1, p1}, Lcom/google/common/collect/ImmutableMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    .line 282
    .local v0, "index":Ljava/lang/Integer;
    if-nez v0, :cond_0

    .line 283
    new-instance v1, Ljava/lang/IllegalArgumentException;

    invoke-virtual {p0}, Lcom/google/common/collect/ArrayTable$ArrayMap;->getKeyRole()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/google/common/collect/ArrayTable$ArrayMap;->keyIndex:Lcom/google/common/collect/ImmutableMap;

    invoke-virtual {v4}, Lcom/google/common/collect/ImmutableMap;->keySet()Lcom/google/common/collect/ImmutableSet;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v6

    add-int/lit8 v6, v6, 0x9

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v7

    add-int/2addr v6, v7

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v7

    add-int/2addr v6, v7

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(I)V

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v5, " "

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " not in "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 286
    :cond_0
    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v1

    invoke-virtual {p0, v1, p2}, Lcom/google/common/collect/ArrayTable$ArrayMap;->setValue(ILjava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    return-object v1
.end method

.method public remove(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "key"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Object;",
            ")TV;"
        }
    .end annotation

    .prologue
    .line 291
    .local p0, "this":Lcom/google/common/collect/ArrayTable$ArrayMap;, "Lcom/google/common/collect/ArrayTable$ArrayMap<TK;TV;>;"
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method abstract setValue(ILjava/lang/Object;)Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(ITV;)TV;"
        }
    .end annotation

    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end method

.method public size()I
    .locals 1

    .prologue
    .line 219
    .local p0, "this":Lcom/google/common/collect/ArrayTable$ArrayMap;, "Lcom/google/common/collect/ArrayTable$ArrayMap<TK;TV;>;"
    iget-object v0, p0, Lcom/google/common/collect/ArrayTable$ArrayMap;->keyIndex:Lcom/google/common/collect/ImmutableMap;

    invoke-virtual {v0}, Lcom/google/common/collect/ImmutableMap;->size()I

    move-result v0

    return v0
.end method
