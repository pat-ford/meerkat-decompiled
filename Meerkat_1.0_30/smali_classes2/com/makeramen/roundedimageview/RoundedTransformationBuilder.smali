.class public final Lcom/makeramen/roundedimageview/RoundedTransformationBuilder;
.super Ljava/lang/Object;
.source "RoundedTransformationBuilder.java"


# instance fields
.field private mBorderColor:Landroid/content/res/ColorStateList;

.field private mBorderWidth:F

.field private mCornerRadius:F

.field private final mDisplayMetrics:Landroid/util/DisplayMetrics;

.field private mOval:Z

.field private mScaleType:Landroid/widget/ImageView$ScaleType;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 39
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 32
    iput v1, p0, Lcom/makeramen/roundedimageview/RoundedTransformationBuilder;->mCornerRadius:F

    .line 33
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/makeramen/roundedimageview/RoundedTransformationBuilder;->mOval:Z

    .line 34
    iput v1, p0, Lcom/makeramen/roundedimageview/RoundedTransformationBuilder;->mBorderWidth:F

    .line 35
    const/high16 v0, -0x1000000

    .line 36
    invoke-static {v0}, Landroid/content/res/ColorStateList;->valueOf(I)Landroid/content/res/ColorStateList;

    move-result-object v0

    iput-object v0, p0, Lcom/makeramen/roundedimageview/RoundedTransformationBuilder;->mBorderColor:Landroid/content/res/ColorStateList;

    .line 37
    sget-object v0, Landroid/widget/ImageView$ScaleType;->FIT_CENTER:Landroid/widget/ImageView$ScaleType;

    iput-object v0, p0, Lcom/makeramen/roundedimageview/RoundedTransformationBuilder;->mScaleType:Landroid/widget/ImageView$ScaleType;

    .line 40
    invoke-static {}, Landroid/content/res/Resources;->getSystem()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    iput-object v0, p0, Lcom/makeramen/roundedimageview/RoundedTransformationBuilder;->mDisplayMetrics:Landroid/util/DisplayMetrics;

    .line 41
    return-void
.end method

.method static synthetic access$000(Lcom/makeramen/roundedimageview/RoundedTransformationBuilder;)Z
    .locals 1
    .param p0, "x0"    # Lcom/makeramen/roundedimageview/RoundedTransformationBuilder;

    .prologue
    .line 27
    iget-boolean v0, p0, Lcom/makeramen/roundedimageview/RoundedTransformationBuilder;->mOval:Z

    return v0
.end method

.method static synthetic access$100(Lcom/makeramen/roundedimageview/RoundedTransformationBuilder;)Landroid/content/res/ColorStateList;
    .locals 1
    .param p0, "x0"    # Lcom/makeramen/roundedimageview/RoundedTransformationBuilder;

    .prologue
    .line 27
    iget-object v0, p0, Lcom/makeramen/roundedimageview/RoundedTransformationBuilder;->mBorderColor:Landroid/content/res/ColorStateList;

    return-object v0
.end method

.method static synthetic access$200(Lcom/makeramen/roundedimageview/RoundedTransformationBuilder;)F
    .locals 1
    .param p0, "x0"    # Lcom/makeramen/roundedimageview/RoundedTransformationBuilder;

    .prologue
    .line 27
    iget v0, p0, Lcom/makeramen/roundedimageview/RoundedTransformationBuilder;->mBorderWidth:F

    return v0
.end method

.method static synthetic access$300(Lcom/makeramen/roundedimageview/RoundedTransformationBuilder;)F
    .locals 1
    .param p0, "x0"    # Lcom/makeramen/roundedimageview/RoundedTransformationBuilder;

    .prologue
    .line 27
    iget v0, p0, Lcom/makeramen/roundedimageview/RoundedTransformationBuilder;->mCornerRadius:F

    return v0
.end method

.method static synthetic access$400(Lcom/makeramen/roundedimageview/RoundedTransformationBuilder;)Landroid/widget/ImageView$ScaleType;
    .locals 1
    .param p0, "x0"    # Lcom/makeramen/roundedimageview/RoundedTransformationBuilder;

    .prologue
    .line 27
    iget-object v0, p0, Lcom/makeramen/roundedimageview/RoundedTransformationBuilder;->mScaleType:Landroid/widget/ImageView$ScaleType;

    return-object v0
.end method


# virtual methods
.method public borderColor(I)Lcom/makeramen/roundedimageview/RoundedTransformationBuilder;
    .locals 1
    .param p1, "color"    # I

    .prologue
    .line 85
    invoke-static {p1}, Landroid/content/res/ColorStateList;->valueOf(I)Landroid/content/res/ColorStateList;

    move-result-object v0

    iput-object v0, p0, Lcom/makeramen/roundedimageview/RoundedTransformationBuilder;->mBorderColor:Landroid/content/res/ColorStateList;

    .line 86
    return-object p0
.end method

.method public borderColor(Landroid/content/res/ColorStateList;)Lcom/makeramen/roundedimageview/RoundedTransformationBuilder;
    .locals 0
    .param p1, "colors"    # Landroid/content/res/ColorStateList;

    .prologue
    .line 90
    iput-object p1, p0, Lcom/makeramen/roundedimageview/RoundedTransformationBuilder;->mBorderColor:Landroid/content/res/ColorStateList;

    .line 91
    return-object p0
.end method

.method public borderWidth(F)Lcom/makeramen/roundedimageview/RoundedTransformationBuilder;
    .locals 0
    .param p1, "widthPx"    # F

    .prologue
    .line 68
    iput p1, p0, Lcom/makeramen/roundedimageview/RoundedTransformationBuilder;->mBorderWidth:F

    .line 69
    return-object p0
.end method

.method public borderWidthDp(F)Lcom/makeramen/roundedimageview/RoundedTransformationBuilder;
    .locals 2
    .param p1, "widthDp"    # F

    .prologue
    .line 76
    const/4 v0, 0x1

    iget-object v1, p0, Lcom/makeramen/roundedimageview/RoundedTransformationBuilder;->mDisplayMetrics:Landroid/util/DisplayMetrics;

    invoke-static {v0, p1, v1}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v0

    iput v0, p0, Lcom/makeramen/roundedimageview/RoundedTransformationBuilder;->mBorderWidth:F

    .line 77
    return-object p0
.end method

.method public build()Lcom/squareup/picasso/Transformation;
    .locals 1

    .prologue
    .line 100
    new-instance v0, Lcom/makeramen/roundedimageview/RoundedTransformationBuilder$1;

    invoke-direct {v0, p0}, Lcom/makeramen/roundedimageview/RoundedTransformationBuilder$1;-><init>(Lcom/makeramen/roundedimageview/RoundedTransformationBuilder;)V

    return-object v0
.end method

.method public cornerRadius(F)Lcom/makeramen/roundedimageview/RoundedTransformationBuilder;
    .locals 0
    .param p1, "radiusPx"    # F

    .prologue
    .line 52
    iput p1, p0, Lcom/makeramen/roundedimageview/RoundedTransformationBuilder;->mCornerRadius:F

    .line 53
    return-object p0
.end method

.method public cornerRadiusDp(F)Lcom/makeramen/roundedimageview/RoundedTransformationBuilder;
    .locals 2
    .param p1, "radiusDp"    # F

    .prologue
    .line 60
    const/4 v0, 0x1

    iget-object v1, p0, Lcom/makeramen/roundedimageview/RoundedTransformationBuilder;->mDisplayMetrics:Landroid/util/DisplayMetrics;

    invoke-static {v0, p1, v1}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v0

    iput v0, p0, Lcom/makeramen/roundedimageview/RoundedTransformationBuilder;->mCornerRadius:F

    .line 61
    return-object p0
.end method

.method public oval(Z)Lcom/makeramen/roundedimageview/RoundedTransformationBuilder;
    .locals 0
    .param p1, "oval"    # Z

    .prologue
    .line 95
    iput-boolean p1, p0, Lcom/makeramen/roundedimageview/RoundedTransformationBuilder;->mOval:Z

    .line 96
    return-object p0
.end method

.method public scaleType(Landroid/widget/ImageView$ScaleType;)Lcom/makeramen/roundedimageview/RoundedTransformationBuilder;
    .locals 0
    .param p1, "scaleType"    # Landroid/widget/ImageView$ScaleType;

    .prologue
    .line 44
    iput-object p1, p0, Lcom/makeramen/roundedimageview/RoundedTransformationBuilder;->mScaleType:Landroid/widget/ImageView$ScaleType;

    .line 45
    return-object p0
.end method
