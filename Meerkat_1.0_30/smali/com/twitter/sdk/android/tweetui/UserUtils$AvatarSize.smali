.class final enum Lcom/twitter/sdk/android/tweetui/UserUtils$AvatarSize;
.super Ljava/lang/Enum;
.source "UserUtils.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/twitter/sdk/android/tweetui/UserUtils;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4018
    name = "AvatarSize"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/twitter/sdk/android/tweetui/UserUtils$AvatarSize;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/twitter/sdk/android/tweetui/UserUtils$AvatarSize;

.field public static final enum BIGGER:Lcom/twitter/sdk/android/tweetui/UserUtils$AvatarSize;

.field public static final enum MINI:Lcom/twitter/sdk/android/tweetui/UserUtils$AvatarSize;

.field public static final enum NORMAL:Lcom/twitter/sdk/android/tweetui/UserUtils$AvatarSize;

.field public static final enum ORIGINAL:Lcom/twitter/sdk/android/tweetui/UserUtils$AvatarSize;

.field public static final enum REASONABLY_SMALL:Lcom/twitter/sdk/android/tweetui/UserUtils$AvatarSize;


# instance fields
.field private final suffix:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 14
    new-instance v0, Lcom/twitter/sdk/android/tweetui/UserUtils$AvatarSize;

    const-string v1, "NORMAL"

    const-string v2, "_normal"

    invoke-direct {v0, v1, v3, v2}, Lcom/twitter/sdk/android/tweetui/UserUtils$AvatarSize;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/twitter/sdk/android/tweetui/UserUtils$AvatarSize;->NORMAL:Lcom/twitter/sdk/android/tweetui/UserUtils$AvatarSize;

    .line 15
    new-instance v0, Lcom/twitter/sdk/android/tweetui/UserUtils$AvatarSize;

    const-string v1, "BIGGER"

    const-string v2, "_bigger"

    invoke-direct {v0, v1, v4, v2}, Lcom/twitter/sdk/android/tweetui/UserUtils$AvatarSize;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/twitter/sdk/android/tweetui/UserUtils$AvatarSize;->BIGGER:Lcom/twitter/sdk/android/tweetui/UserUtils$AvatarSize;

    .line 16
    new-instance v0, Lcom/twitter/sdk/android/tweetui/UserUtils$AvatarSize;

    const-string v1, "MINI"

    const-string v2, "_mini"

    invoke-direct {v0, v1, v5, v2}, Lcom/twitter/sdk/android/tweetui/UserUtils$AvatarSize;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/twitter/sdk/android/tweetui/UserUtils$AvatarSize;->MINI:Lcom/twitter/sdk/android/tweetui/UserUtils$AvatarSize;

    .line 17
    new-instance v0, Lcom/twitter/sdk/android/tweetui/UserUtils$AvatarSize;

    const-string v1, "ORIGINAL"

    const-string v2, "_original"

    invoke-direct {v0, v1, v6, v2}, Lcom/twitter/sdk/android/tweetui/UserUtils$AvatarSize;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/twitter/sdk/android/tweetui/UserUtils$AvatarSize;->ORIGINAL:Lcom/twitter/sdk/android/tweetui/UserUtils$AvatarSize;

    .line 18
    new-instance v0, Lcom/twitter/sdk/android/tweetui/UserUtils$AvatarSize;

    const-string v1, "REASONABLY_SMALL"

    const-string v2, "_reasonably_small"

    invoke-direct {v0, v1, v7, v2}, Lcom/twitter/sdk/android/tweetui/UserUtils$AvatarSize;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/twitter/sdk/android/tweetui/UserUtils$AvatarSize;->REASONABLY_SMALL:Lcom/twitter/sdk/android/tweetui/UserUtils$AvatarSize;

    .line 13
    const/4 v0, 0x5

    new-array v0, v0, [Lcom/twitter/sdk/android/tweetui/UserUtils$AvatarSize;

    sget-object v1, Lcom/twitter/sdk/android/tweetui/UserUtils$AvatarSize;->NORMAL:Lcom/twitter/sdk/android/tweetui/UserUtils$AvatarSize;

    aput-object v1, v0, v3

    sget-object v1, Lcom/twitter/sdk/android/tweetui/UserUtils$AvatarSize;->BIGGER:Lcom/twitter/sdk/android/tweetui/UserUtils$AvatarSize;

    aput-object v1, v0, v4

    sget-object v1, Lcom/twitter/sdk/android/tweetui/UserUtils$AvatarSize;->MINI:Lcom/twitter/sdk/android/tweetui/UserUtils$AvatarSize;

    aput-object v1, v0, v5

    sget-object v1, Lcom/twitter/sdk/android/tweetui/UserUtils$AvatarSize;->ORIGINAL:Lcom/twitter/sdk/android/tweetui/UserUtils$AvatarSize;

    aput-object v1, v0, v6

    sget-object v1, Lcom/twitter/sdk/android/tweetui/UserUtils$AvatarSize;->REASONABLY_SMALL:Lcom/twitter/sdk/android/tweetui/UserUtils$AvatarSize;

    aput-object v1, v0, v7

    sput-object v0, Lcom/twitter/sdk/android/tweetui/UserUtils$AvatarSize;->$VALUES:[Lcom/twitter/sdk/android/tweetui/UserUtils$AvatarSize;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .param p3, "suffix"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 22
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 23
    iput-object p3, p0, Lcom/twitter/sdk/android/tweetui/UserUtils$AvatarSize;->suffix:Ljava/lang/String;

    .line 24
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/twitter/sdk/android/tweetui/UserUtils$AvatarSize;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 13
    const-class v0, Lcom/twitter/sdk/android/tweetui/UserUtils$AvatarSize;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/twitter/sdk/android/tweetui/UserUtils$AvatarSize;

    return-object v0
.end method

.method public static values()[Lcom/twitter/sdk/android/tweetui/UserUtils$AvatarSize;
    .locals 1

    .prologue
    .line 13
    sget-object v0, Lcom/twitter/sdk/android/tweetui/UserUtils$AvatarSize;->$VALUES:[Lcom/twitter/sdk/android/tweetui/UserUtils$AvatarSize;

    invoke-virtual {v0}, [Lcom/twitter/sdk/android/tweetui/UserUtils$AvatarSize;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/twitter/sdk/android/tweetui/UserUtils$AvatarSize;

    return-object v0
.end method


# virtual methods
.method getSuffix()Ljava/lang/String;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/twitter/sdk/android/tweetui/UserUtils$AvatarSize;->suffix:Ljava/lang/String;

    return-object v0
.end method
