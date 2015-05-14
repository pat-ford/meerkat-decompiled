.class Lcom/digits/sdk/android/LoginCodeActivityDelegate;
.super Lcom/digits/sdk/android/DigitsActivityDelegateImpl;
.source "LoginCodeActivityDelegate.java"


# instance fields
.field activity:Landroid/app/Activity;

.field controller:Lcom/digits/sdk/android/DigitsController;

.field editText:Landroid/widget/EditText;

.field receiver:Lcom/digits/sdk/android/SmsBroadcastReceiver;

.field stateButton:Lcom/digits/sdk/android/StateButton;

.field termsText:Landroid/widget/TextView;


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Lcom/digits/sdk/android/DigitsActivityDelegateImpl;-><init>()V

    return-void
.end method


# virtual methods
.method public getLayoutId()I
    .locals 1

    .prologue
    .line 74
    sget v0, Lcom/digits/sdk/android/R$layout;->dgts__activity_confirmation:I

    return v0
.end method

.method public init(Landroid/app/Activity;Landroid/os/Bundle;)V
    .locals 3
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "bundle"    # Landroid/os/Bundle;

    .prologue
    .line 23
    iput-object p1, p0, Lcom/digits/sdk/android/LoginCodeActivityDelegate;->activity:Landroid/app/Activity;

    .line 24
    sget v1, Lcom/digits/sdk/android/R$id;->dgts__confirmationEditText:I

    invoke-virtual {p1, v1}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/EditText;

    iput-object v1, p0, Lcom/digits/sdk/android/LoginCodeActivityDelegate;->editText:Landroid/widget/EditText;

    .line 25
    sget v1, Lcom/digits/sdk/android/R$id;->dgts__createAccount:I

    invoke-virtual {p1, v1}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/digits/sdk/android/StateButton;

    iput-object v1, p0, Lcom/digits/sdk/android/LoginCodeActivityDelegate;->stateButton:Lcom/digits/sdk/android/StateButton;

    .line 26
    sget v1, Lcom/digits/sdk/android/R$id;->dgts__termsTextCreateAccount:I

    invoke-virtual {p1, v1}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/digits/sdk/android/LoginCodeActivityDelegate;->termsText:Landroid/widget/TextView;

    .line 27
    sget v1, Lcom/digits/sdk/android/R$id;->dgts__resendConfirmation:I

    invoke-virtual {p1, v1}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 29
    .local v0, "resendText":Landroid/widget/TextView;
    invoke-virtual {p0, p2}, Lcom/digits/sdk/android/LoginCodeActivityDelegate;->initController(Landroid/os/Bundle;)Lcom/digits/sdk/android/DigitsController;

    move-result-object v1

    iput-object v1, p0, Lcom/digits/sdk/android/LoginCodeActivityDelegate;->controller:Lcom/digits/sdk/android/DigitsController;

    .line 31
    iget-object v1, p0, Lcom/digits/sdk/android/LoginCodeActivityDelegate;->controller:Lcom/digits/sdk/android/DigitsController;

    iget-object v2, p0, Lcom/digits/sdk/android/LoginCodeActivityDelegate;->editText:Landroid/widget/EditText;

    invoke-virtual {p0, p1, v1, v2}, Lcom/digits/sdk/android/LoginCodeActivityDelegate;->setUpEditText(Landroid/app/Activity;Lcom/digits/sdk/android/DigitsController;Landroid/widget/EditText;)V

    .line 32
    iget-object v1, p0, Lcom/digits/sdk/android/LoginCodeActivityDelegate;->controller:Lcom/digits/sdk/android/DigitsController;

    iget-object v2, p0, Lcom/digits/sdk/android/LoginCodeActivityDelegate;->stateButton:Lcom/digits/sdk/android/StateButton;

    invoke-virtual {p0, p1, v1, v2}, Lcom/digits/sdk/android/LoginCodeActivityDelegate;->setUpSendButton(Landroid/app/Activity;Lcom/digits/sdk/android/DigitsController;Lcom/digits/sdk/android/StateButton;)V

    .line 33
    iget-object v1, p0, Lcom/digits/sdk/android/LoginCodeActivityDelegate;->controller:Lcom/digits/sdk/android/DigitsController;

    iget-object v2, p0, Lcom/digits/sdk/android/LoginCodeActivityDelegate;->termsText:Landroid/widget/TextView;

    invoke-virtual {p0, p1, v1, v2}, Lcom/digits/sdk/android/LoginCodeActivityDelegate;->setUpTermsText(Landroid/app/Activity;Lcom/digits/sdk/android/DigitsController;Landroid/widget/TextView;)V

    .line 34
    invoke-virtual {p0, p1, v0}, Lcom/digits/sdk/android/LoginCodeActivityDelegate;->setUpResendText(Landroid/app/Activity;Landroid/widget/TextView;)V

    .line 35
    iget-object v1, p0, Lcom/digits/sdk/android/LoginCodeActivityDelegate;->editText:Landroid/widget/EditText;

    invoke-virtual {p0, p1, v1}, Lcom/digits/sdk/android/LoginCodeActivityDelegate;->setUpSmsIntercept(Landroid/app/Activity;Landroid/widget/EditText;)V

    .line 37
    iget-object v1, p0, Lcom/digits/sdk/android/LoginCodeActivityDelegate;->editText:Landroid/widget/EditText;

    invoke-static {p1, v1}, Lio/fabric/sdk/android/services/common/CommonUtils;->openKeyboard(Landroid/content/Context;Landroid/view/View;)V

    .line 38
    return-void
.end method

.method initController(Landroid/os/Bundle;)Lcom/digits/sdk/android/DigitsController;
    .locals 9
    .param p1, "bundle"    # Landroid/os/Bundle;

    .prologue
    .line 41
    new-instance v1, Lcom/digits/sdk/android/LoginCodeController;

    const-string v0, "receiver"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v2

    check-cast v2, Landroid/os/ResultReceiver;

    iget-object v3, p0, Lcom/digits/sdk/android/LoginCodeActivityDelegate;->stateButton:Lcom/digits/sdk/android/StateButton;

    iget-object v4, p0, Lcom/digits/sdk/android/LoginCodeActivityDelegate;->editText:Landroid/widget/EditText;

    const-string v0, "request_id"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    const-string v0, "user_id"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v6

    const-string v0, "phone_number"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-direct/range {v1 .. v8}, Lcom/digits/sdk/android/LoginCodeController;-><init>(Landroid/os/ResultReceiver;Lcom/digits/sdk/android/StateButton;Landroid/widget/EditText;Ljava/lang/String;JLjava/lang/String;)V

    return-object v1
.end method

.method public isValid(Landroid/os/Bundle;)Z
    .locals 3
    .param p1, "bundle"    # Landroid/os/Bundle;

    .prologue
    .line 79
    const/4 v0, 0x4

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "receiver"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "phone_number"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-string v2, "request_id"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-string v2, "user_id"

    aput-object v2, v0, v1

    invoke-static {p1, v0}, Lcom/digits/sdk/android/BundleManager;->assertContains(Landroid/os/Bundle;[Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public onDestroy()V
    .locals 2

    .prologue
    .line 91
    iget-object v0, p0, Lcom/digits/sdk/android/LoginCodeActivityDelegate;->receiver:Lcom/digits/sdk/android/SmsBroadcastReceiver;

    if-eqz v0, :cond_0

    .line 92
    iget-object v0, p0, Lcom/digits/sdk/android/LoginCodeActivityDelegate;->activity:Landroid/app/Activity;

    iget-object v1, p0, Lcom/digits/sdk/android/LoginCodeActivityDelegate;->receiver:Lcom/digits/sdk/android/SmsBroadcastReceiver;

    invoke-virtual {v0, v1}, Landroid/app/Activity;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 94
    :cond_0
    return-void
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 86
    iget-object v0, p0, Lcom/digits/sdk/android/LoginCodeActivityDelegate;->controller:Lcom/digits/sdk/android/DigitsController;

    invoke-interface {v0}, Lcom/digits/sdk/android/DigitsController;->onResume()V

    .line 87
    return-void
.end method

.method protected setUpResendText(Landroid/app/Activity;Landroid/widget/TextView;)V
    .locals 1
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "resendText"    # Landroid/widget/TextView;

    .prologue
    .line 64
    new-instance v0, Lcom/digits/sdk/android/LoginCodeActivityDelegate$1;

    invoke-direct {v0, p0, p1}, Lcom/digits/sdk/android/LoginCodeActivityDelegate$1;-><init>(Lcom/digits/sdk/android/LoginCodeActivityDelegate;Landroid/app/Activity;)V

    invoke-virtual {p2, v0}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 70
    return-void
.end method

.method public setUpSendButton(Landroid/app/Activity;Lcom/digits/sdk/android/DigitsController;Lcom/digits/sdk/android/StateButton;)V
    .locals 3
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "controller"    # Lcom/digits/sdk/android/DigitsController;
    .param p3, "stateButton"    # Lcom/digits/sdk/android/StateButton;

    .prologue
    .line 57
    sget v0, Lcom/digits/sdk/android/R$string;->dgts__sign_in:I

    sget v1, Lcom/digits/sdk/android/R$string;->dgts__signing_in:I

    sget v2, Lcom/digits/sdk/android/R$string;->dgts__sign_in:I

    invoke-virtual {p3, v0, v1, v2}, Lcom/digits/sdk/android/StateButton;->setStatesText(III)V

    .line 59
    invoke-virtual {p3}, Lcom/digits/sdk/android/StateButton;->showStart()V

    .line 60
    invoke-super {p0, p1, p2, p3}, Lcom/digits/sdk/android/DigitsActivityDelegateImpl;->setUpSendButton(Landroid/app/Activity;Lcom/digits/sdk/android/DigitsController;Lcom/digits/sdk/android/StateButton;)V

    .line 61
    return-void
.end method

.method protected setUpSmsIntercept(Landroid/app/Activity;Landroid/widget/EditText;)V
    .locals 2
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "editText"    # Landroid/widget/EditText;

    .prologue
    .line 97
    const-string v1, "android.permission.RECEIVE_SMS"

    invoke-static {p1, v1}, Lio/fabric/sdk/android/services/common/CommonUtils;->checkPermission(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 98
    new-instance v0, Landroid/content/IntentFilter;

    const-string v1, "android.provider.Telephony.SMS_RECEIVED"

    invoke-direct {v0, v1}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    .line 99
    .local v0, "filter":Landroid/content/IntentFilter;
    new-instance v1, Lcom/digits/sdk/android/SmsBroadcastReceiver;

    invoke-direct {v1, p2}, Lcom/digits/sdk/android/SmsBroadcastReceiver;-><init>(Landroid/widget/EditText;)V

    iput-object v1, p0, Lcom/digits/sdk/android/LoginCodeActivityDelegate;->receiver:Lcom/digits/sdk/android/SmsBroadcastReceiver;

    .line 100
    iget-object v1, p0, Lcom/digits/sdk/android/LoginCodeActivityDelegate;->receiver:Lcom/digits/sdk/android/SmsBroadcastReceiver;

    invoke-virtual {p1, v1, v0}, Landroid/app/Activity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 102
    .end local v0    # "filter":Landroid/content/IntentFilter;
    :cond_0
    return-void
.end method

.method public setUpTermsText(Landroid/app/Activity;Lcom/digits/sdk/android/DigitsController;Landroid/widget/TextView;)V
    .locals 1
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "controller"    # Lcom/digits/sdk/android/DigitsController;
    .param p3, "termsText"    # Landroid/widget/TextView;

    .prologue
    .line 51
    const/16 v0, 0x8

    invoke-virtual {p3, v0}, Landroid/widget/TextView;->setVisibility(I)V

    .line 52
    return-void
.end method