package com.digits.sdk.android;

import io.fabric.sdk.android.services.concurrency.AsyncTask;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

class CountryListLoadTask extends AsyncTask<Void, Void, List<CountryInfo>>
{
  private static final int MAX_COUNTRIES = 291;
  private final Listener listener;

  public CountryListLoadTask(Listener paramListener)
  {
    this.listener = paramListener;
  }

  protected List<CountryInfo> doInBackground(Void[] paramArrayOfVoid)
  {
    ArrayList localArrayList = new ArrayList(291);
    localArrayList.add(new CountryInfo(new Locale("", "AF").getDisplayCountry(), 93));
    localArrayList.add(new CountryInfo(new Locale("", "AX").getDisplayCountry(), 358));
    localArrayList.add(new CountryInfo(new Locale("", "AL").getDisplayCountry(), 355));
    localArrayList.add(new CountryInfo(new Locale("", "DZ").getDisplayCountry(), 213));
    localArrayList.add(new CountryInfo(new Locale("", "AS").getDisplayCountry(), 1));
    localArrayList.add(new CountryInfo(new Locale("", "AD").getDisplayCountry(), 376));
    localArrayList.add(new CountryInfo(new Locale("", "AO").getDisplayCountry(), 244));
    localArrayList.add(new CountryInfo(new Locale("", "AI").getDisplayCountry(), 1));
    localArrayList.add(new CountryInfo(new Locale("", "AG").getDisplayCountry(), 1));
    localArrayList.add(new CountryInfo(new Locale("", "AR").getDisplayCountry(), 54));
    localArrayList.add(new CountryInfo(new Locale("", "AM").getDisplayCountry(), 374));
    localArrayList.add(new CountryInfo(new Locale("", "AW").getDisplayCountry(), 297));
    localArrayList.add(new CountryInfo(new Locale("", "AC").getDisplayCountry(), 247));
    localArrayList.add(new CountryInfo(new Locale("", "AU").getDisplayCountry(), 61));
    localArrayList.add(new CountryInfo(new Locale("", "AT").getDisplayCountry(), 43));
    localArrayList.add(new CountryInfo(new Locale("", "AZ").getDisplayCountry(), 994));
    localArrayList.add(new CountryInfo(new Locale("", "BS").getDisplayCountry(), 1));
    localArrayList.add(new CountryInfo(new Locale("", "BH").getDisplayCountry(), 973));
    localArrayList.add(new CountryInfo(new Locale("", "BD").getDisplayCountry(), 880));
    localArrayList.add(new CountryInfo(new Locale("", "BB").getDisplayCountry(), 1));
    localArrayList.add(new CountryInfo(new Locale("", "BY").getDisplayCountry(), 375));
    localArrayList.add(new CountryInfo(new Locale("", "BE").getDisplayCountry(), 32));
    localArrayList.add(new CountryInfo(new Locale("", "BZ").getDisplayCountry(), 501));
    localArrayList.add(new CountryInfo(new Locale("", "BJ").getDisplayCountry(), 229));
    localArrayList.add(new CountryInfo(new Locale("", "BM").getDisplayCountry(), 1));
    localArrayList.add(new CountryInfo(new Locale("", "BT").getDisplayCountry(), 975));
    localArrayList.add(new CountryInfo(new Locale("", "BO").getDisplayCountry(), 591));
    localArrayList.add(new CountryInfo(new Locale("", "BA").getDisplayCountry(), 387));
    localArrayList.add(new CountryInfo(new Locale("", "BW").getDisplayCountry(), 267));
    localArrayList.add(new CountryInfo(new Locale("", "BR").getDisplayCountry(), 55));
    localArrayList.add(new CountryInfo(new Locale("", "IO").getDisplayCountry(), 246));
    localArrayList.add(new CountryInfo(new Locale("", "VG").getDisplayCountry(), 1));
    localArrayList.add(new CountryInfo(new Locale("", "BN").getDisplayCountry(), 673));
    localArrayList.add(new CountryInfo(new Locale("", "BG").getDisplayCountry(), 359));
    localArrayList.add(new CountryInfo(new Locale("", "BF").getDisplayCountry(), 226));
    localArrayList.add(new CountryInfo(new Locale("", "BI").getDisplayCountry(), 257));
    localArrayList.add(new CountryInfo(new Locale("", "KH").getDisplayCountry(), 855));
    localArrayList.add(new CountryInfo(new Locale("", "CM").getDisplayCountry(), 237));
    localArrayList.add(new CountryInfo(new Locale("", "CA").getDisplayCountry(), 1));
    localArrayList.add(new CountryInfo(new Locale("", "CV").getDisplayCountry(), 238));
    localArrayList.add(new CountryInfo(new Locale("", "BQ").getDisplayCountry(), 599));
    localArrayList.add(new CountryInfo(new Locale("", "KY").getDisplayCountry(), 1));
    localArrayList.add(new CountryInfo(new Locale("", "CF").getDisplayCountry(), 236));
    localArrayList.add(new CountryInfo(new Locale("", "TD").getDisplayCountry(), 235));
    localArrayList.add(new CountryInfo(new Locale("", "CL").getDisplayCountry(), 56));
    localArrayList.add(new CountryInfo(new Locale("", "CN").getDisplayCountry(), 86));
    localArrayList.add(new CountryInfo(new Locale("", "CX").getDisplayCountry(), 61));
    localArrayList.add(new CountryInfo(new Locale("", "CC").getDisplayCountry(), 61));
    localArrayList.add(new CountryInfo(new Locale("", "CO").getDisplayCountry(), 57));
    localArrayList.add(new CountryInfo(new Locale("", "KM").getDisplayCountry(), 269));
    localArrayList.add(new CountryInfo(new Locale("", "CD").getDisplayCountry(), 243));
    localArrayList.add(new CountryInfo(new Locale("", "CG").getDisplayCountry(), 242));
    localArrayList.add(new CountryInfo(new Locale("", "CK").getDisplayCountry(), 682));
    localArrayList.add(new CountryInfo(new Locale("", "CR").getDisplayCountry(), 506));
    localArrayList.add(new CountryInfo(new Locale("", "CI").getDisplayCountry(), 225));
    localArrayList.add(new CountryInfo(new Locale("", "HR").getDisplayCountry(), 385));
    localArrayList.add(new CountryInfo(new Locale("", "CU").getDisplayCountry(), 53));
    localArrayList.add(new CountryInfo(new Locale("", "CW").getDisplayCountry(), 599));
    localArrayList.add(new CountryInfo(new Locale("", "CY").getDisplayCountry(), 357));
    localArrayList.add(new CountryInfo(new Locale("", "CZ").getDisplayCountry(), 420));
    localArrayList.add(new CountryInfo(new Locale("", "DK").getDisplayCountry(), 45));
    localArrayList.add(new CountryInfo(new Locale("", "DJ").getDisplayCountry(), 253));
    localArrayList.add(new CountryInfo(new Locale("", "DM").getDisplayCountry(), 1));
    localArrayList.add(new CountryInfo(new Locale("", "DO").getDisplayCountry(), 1));
    localArrayList.add(new CountryInfo(new Locale("", "TL").getDisplayCountry(), 670));
    localArrayList.add(new CountryInfo(new Locale("", "EC").getDisplayCountry(), 593));
    localArrayList.add(new CountryInfo(new Locale("", "EG").getDisplayCountry(), 20));
    localArrayList.add(new CountryInfo(new Locale("", "SV").getDisplayCountry(), 503));
    localArrayList.add(new CountryInfo(new Locale("", "GQ").getDisplayCountry(), 240));
    localArrayList.add(new CountryInfo(new Locale("", "ER").getDisplayCountry(), 291));
    localArrayList.add(new CountryInfo(new Locale("", "EE").getDisplayCountry(), 372));
    localArrayList.add(new CountryInfo(new Locale("", "ET").getDisplayCountry(), 251));
    localArrayList.add(new CountryInfo(new Locale("", "FK").getDisplayCountry(), 500));
    localArrayList.add(new CountryInfo(new Locale("", "FO").getDisplayCountry(), 298));
    localArrayList.add(new CountryInfo(new Locale("", "FJ").getDisplayCountry(), 679));
    localArrayList.add(new CountryInfo(new Locale("", "FI").getDisplayCountry(), 358));
    localArrayList.add(new CountryInfo(new Locale("", "FR").getDisplayCountry(), 33));
    localArrayList.add(new CountryInfo(new Locale("", "GF").getDisplayCountry(), 594));
    localArrayList.add(new CountryInfo(new Locale("", "PF").getDisplayCountry(), 689));
    localArrayList.add(new CountryInfo(new Locale("", "GA").getDisplayCountry(), 241));
    localArrayList.add(new CountryInfo(new Locale("", "GM").getDisplayCountry(), 220));
    localArrayList.add(new CountryInfo(new Locale("", "GE").getDisplayCountry(), 995));
    localArrayList.add(new CountryInfo(new Locale("", "DE").getDisplayCountry(), 49));
    localArrayList.add(new CountryInfo(new Locale("", "GH").getDisplayCountry(), 233));
    localArrayList.add(new CountryInfo(new Locale("", "GI").getDisplayCountry(), 350));
    localArrayList.add(new CountryInfo(new Locale("", "GR").getDisplayCountry(), 30));
    localArrayList.add(new CountryInfo(new Locale("", "GL").getDisplayCountry(), 299));
    localArrayList.add(new CountryInfo(new Locale("", "GD").getDisplayCountry(), 1));
    localArrayList.add(new CountryInfo(new Locale("", "GP").getDisplayCountry(), 590));
    localArrayList.add(new CountryInfo(new Locale("", "GU").getDisplayCountry(), 1));
    localArrayList.add(new CountryInfo(new Locale("", "GT").getDisplayCountry(), 502));
    localArrayList.add(new CountryInfo(new Locale("", "GG").getDisplayCountry(), 44));
    localArrayList.add(new CountryInfo(new Locale("", "GN").getDisplayCountry(), 224));
    localArrayList.add(new CountryInfo(new Locale("", "GW").getDisplayCountry(), 245));
    localArrayList.add(new CountryInfo(new Locale("", "GY").getDisplayCountry(), 592));
    localArrayList.add(new CountryInfo(new Locale("", "HT").getDisplayCountry(), 509));
    localArrayList.add(new CountryInfo(new Locale("", "HM").getDisplayCountry(), 672));
    localArrayList.add(new CountryInfo(new Locale("", "HN").getDisplayCountry(), 504));
    localArrayList.add(new CountryInfo(new Locale("", "HK").getDisplayCountry(), 852));
    localArrayList.add(new CountryInfo(new Locale("", "HU").getDisplayCountry(), 36));
    localArrayList.add(new CountryInfo(new Locale("", "IS").getDisplayCountry(), 354));
    localArrayList.add(new CountryInfo(new Locale("", "IN").getDisplayCountry(), 91));
    localArrayList.add(new CountryInfo(new Locale("", "ID").getDisplayCountry(), 62));
    localArrayList.add(new CountryInfo(new Locale("", "IR").getDisplayCountry(), 98));
    localArrayList.add(new CountryInfo(new Locale("", "IQ").getDisplayCountry(), 964));
    localArrayList.add(new CountryInfo(new Locale("", "IE").getDisplayCountry(), 353));
    localArrayList.add(new CountryInfo(new Locale("", "IM").getDisplayCountry(), 44));
    localArrayList.add(new CountryInfo(new Locale("", "IL").getDisplayCountry(), 972));
    localArrayList.add(new CountryInfo(new Locale("", "IT").getDisplayCountry(), 39));
    localArrayList.add(new CountryInfo(new Locale("", "JM").getDisplayCountry(), 1));
    localArrayList.add(new CountryInfo(new Locale("", "JP").getDisplayCountry(), 81));
    localArrayList.add(new CountryInfo(new Locale("", "JE").getDisplayCountry(), 44));
    localArrayList.add(new CountryInfo(new Locale("", "JO").getDisplayCountry(), 962));
    localArrayList.add(new CountryInfo(new Locale("", "KZ").getDisplayCountry(), 7));
    localArrayList.add(new CountryInfo(new Locale("", "KE").getDisplayCountry(), 254));
    localArrayList.add(new CountryInfo(new Locale("", "KI").getDisplayCountry(), 686));
    localArrayList.add(new CountryInfo(new Locale("", "XK").getDisplayCountry(), 381));
    localArrayList.add(new CountryInfo(new Locale("", "KW").getDisplayCountry(), 965));
    localArrayList.add(new CountryInfo(new Locale("", "KG").getDisplayCountry(), 996));
    localArrayList.add(new CountryInfo(new Locale("", "LA").getDisplayCountry(), 856));
    localArrayList.add(new CountryInfo(new Locale("", "LV").getDisplayCountry(), 371));
    localArrayList.add(new CountryInfo(new Locale("", "LB").getDisplayCountry(), 961));
    localArrayList.add(new CountryInfo(new Locale("", "LS").getDisplayCountry(), 266));
    localArrayList.add(new CountryInfo(new Locale("", "LR").getDisplayCountry(), 231));
    localArrayList.add(new CountryInfo(new Locale("", "LY").getDisplayCountry(), 218));
    localArrayList.add(new CountryInfo(new Locale("", "LI").getDisplayCountry(), 423));
    localArrayList.add(new CountryInfo(new Locale("", "LT").getDisplayCountry(), 370));
    localArrayList.add(new CountryInfo(new Locale("", "LU").getDisplayCountry(), 352));
    localArrayList.add(new CountryInfo(new Locale("", "MO").getDisplayCountry(), 853));
    localArrayList.add(new CountryInfo(new Locale("", "MK").getDisplayCountry(), 389));
    localArrayList.add(new CountryInfo(new Locale("", "MG").getDisplayCountry(), 261));
    localArrayList.add(new CountryInfo(new Locale("", "MW").getDisplayCountry(), 265));
    localArrayList.add(new CountryInfo(new Locale("", "MY").getDisplayCountry(), 60));
    localArrayList.add(new CountryInfo(new Locale("", "MV").getDisplayCountry(), 960));
    localArrayList.add(new CountryInfo(new Locale("", "ML").getDisplayCountry(), 223));
    localArrayList.add(new CountryInfo(new Locale("", "MT").getDisplayCountry(), 356));
    localArrayList.add(new CountryInfo(new Locale("", "MH").getDisplayCountry(), 692));
    localArrayList.add(new CountryInfo(new Locale("", "MQ").getDisplayCountry(), 596));
    localArrayList.add(new CountryInfo(new Locale("", "MR").getDisplayCountry(), 222));
    localArrayList.add(new CountryInfo(new Locale("", "MU").getDisplayCountry(), 230));
    localArrayList.add(new CountryInfo(new Locale("", "YT").getDisplayCountry(), 262));
    localArrayList.add(new CountryInfo(new Locale("", "MX").getDisplayCountry(), 52));
    localArrayList.add(new CountryInfo(new Locale("", "FM").getDisplayCountry(), 691));
    localArrayList.add(new CountryInfo(new Locale("", "MD").getDisplayCountry(), 373));
    localArrayList.add(new CountryInfo(new Locale("", "MC").getDisplayCountry(), 377));
    localArrayList.add(new CountryInfo(new Locale("", "MN").getDisplayCountry(), 976));
    localArrayList.add(new CountryInfo(new Locale("", "ME").getDisplayCountry(), 382));
    localArrayList.add(new CountryInfo(new Locale("", "MS").getDisplayCountry(), 1));
    localArrayList.add(new CountryInfo(new Locale("", "MA").getDisplayCountry(), 212));
    localArrayList.add(new CountryInfo(new Locale("", "MZ").getDisplayCountry(), 258));
    localArrayList.add(new CountryInfo(new Locale("", "MM").getDisplayCountry(), 95));
    localArrayList.add(new CountryInfo(new Locale("", "NA").getDisplayCountry(), 264));
    localArrayList.add(new CountryInfo(new Locale("", "NR").getDisplayCountry(), 674));
    localArrayList.add(new CountryInfo(new Locale("", "NP").getDisplayCountry(), 977));
    localArrayList.add(new CountryInfo(new Locale("", "NL").getDisplayCountry(), 31));
    localArrayList.add(new CountryInfo(new Locale("", "NC").getDisplayCountry(), 687));
    localArrayList.add(new CountryInfo(new Locale("", "NZ").getDisplayCountry(), 64));
    localArrayList.add(new CountryInfo(new Locale("", "NI").getDisplayCountry(), 505));
    localArrayList.add(new CountryInfo(new Locale("", "NE").getDisplayCountry(), 227));
    localArrayList.add(new CountryInfo(new Locale("", "NG").getDisplayCountry(), 234));
    localArrayList.add(new CountryInfo(new Locale("", "NU").getDisplayCountry(), 683));
    localArrayList.add(new CountryInfo(new Locale("", "NF").getDisplayCountry(), 672));
    localArrayList.add(new CountryInfo(new Locale("", "KP").getDisplayCountry(), 850));
    localArrayList.add(new CountryInfo(new Locale("", "MP").getDisplayCountry(), 1));
    localArrayList.add(new CountryInfo(new Locale("", "NO").getDisplayCountry(), 47));
    localArrayList.add(new CountryInfo(new Locale("", "OM").getDisplayCountry(), 968));
    localArrayList.add(new CountryInfo(new Locale("", "PK").getDisplayCountry(), 92));
    localArrayList.add(new CountryInfo(new Locale("", "PW").getDisplayCountry(), 680));
    localArrayList.add(new CountryInfo(new Locale("", "PS").getDisplayCountry(), 970));
    localArrayList.add(new CountryInfo(new Locale("", "PA").getDisplayCountry(), 507));
    localArrayList.add(new CountryInfo(new Locale("", "PG").getDisplayCountry(), 675));
    localArrayList.add(new CountryInfo(new Locale("", "PY").getDisplayCountry(), 595));
    localArrayList.add(new CountryInfo(new Locale("", "PE").getDisplayCountry(), 51));
    localArrayList.add(new CountryInfo(new Locale("", "PH").getDisplayCountry(), 63));
    localArrayList.add(new CountryInfo(new Locale("", "PL").getDisplayCountry(), 48));
    localArrayList.add(new CountryInfo(new Locale("", "PT").getDisplayCountry(), 351));
    localArrayList.add(new CountryInfo(new Locale("", "PR").getDisplayCountry(), 1));
    localArrayList.add(new CountryInfo(new Locale("", "QA").getDisplayCountry(), 974));
    localArrayList.add(new CountryInfo(new Locale("", "RE").getDisplayCountry(), 262));
    localArrayList.add(new CountryInfo(new Locale("", "RO").getDisplayCountry(), 40));
    localArrayList.add(new CountryInfo(new Locale("", "RU").getDisplayCountry(), 7));
    localArrayList.add(new CountryInfo(new Locale("", "RW").getDisplayCountry(), 250));
    localArrayList.add(new CountryInfo(new Locale("", "BL").getDisplayCountry(), 590));
    localArrayList.add(new CountryInfo(new Locale("", "SH").getDisplayCountry(), 290));
    localArrayList.add(new CountryInfo(new Locale("", "KN").getDisplayCountry(), 1));
    localArrayList.add(new CountryInfo(new Locale("", "LC").getDisplayCountry(), 1));
    localArrayList.add(new CountryInfo(new Locale("", "MF").getDisplayCountry(), 590));
    localArrayList.add(new CountryInfo(new Locale("", "PM").getDisplayCountry(), 508));
    localArrayList.add(new CountryInfo(new Locale("", "VC").getDisplayCountry(), 1));
    localArrayList.add(new CountryInfo(new Locale("", "WS").getDisplayCountry(), 685));
    localArrayList.add(new CountryInfo(new Locale("", "SM").getDisplayCountry(), 378));
    localArrayList.add(new CountryInfo(new Locale("", "ST").getDisplayCountry(), 239));
    localArrayList.add(new CountryInfo(new Locale("", "SA").getDisplayCountry(), 966));
    localArrayList.add(new CountryInfo(new Locale("", "SN").getDisplayCountry(), 221));
    localArrayList.add(new CountryInfo(new Locale("", "RS").getDisplayCountry(), 381));
    localArrayList.add(new CountryInfo(new Locale("", "SC").getDisplayCountry(), 248));
    localArrayList.add(new CountryInfo(new Locale("", "SL").getDisplayCountry(), 232));
    localArrayList.add(new CountryInfo(new Locale("", "SG").getDisplayCountry(), 65));
    localArrayList.add(new CountryInfo(new Locale("", "SX").getDisplayCountry(), 1));
    localArrayList.add(new CountryInfo(new Locale("", "SK").getDisplayCountry(), 421));
    localArrayList.add(new CountryInfo(new Locale("", "SI").getDisplayCountry(), 386));
    localArrayList.add(new CountryInfo(new Locale("", "SB").getDisplayCountry(), 677));
    localArrayList.add(new CountryInfo(new Locale("", "SO").getDisplayCountry(), 252));
    localArrayList.add(new CountryInfo(new Locale("", "ZA").getDisplayCountry(), 27));
    localArrayList.add(new CountryInfo(new Locale("", "GS").getDisplayCountry(), 500));
    localArrayList.add(new CountryInfo(new Locale("", "KR").getDisplayCountry(), 82));
    localArrayList.add(new CountryInfo(new Locale("", "SS").getDisplayCountry(), 211));
    localArrayList.add(new CountryInfo(new Locale("", "ES").getDisplayCountry(), 34));
    localArrayList.add(new CountryInfo(new Locale("", "LK").getDisplayCountry(), 94));
    localArrayList.add(new CountryInfo(new Locale("", "SD").getDisplayCountry(), 249));
    localArrayList.add(new CountryInfo(new Locale("", "SR").getDisplayCountry(), 597));
    localArrayList.add(new CountryInfo(new Locale("", "SJ").getDisplayCountry(), 47));
    localArrayList.add(new CountryInfo(new Locale("", "SZ").getDisplayCountry(), 268));
    localArrayList.add(new CountryInfo(new Locale("", "SE").getDisplayCountry(), 46));
    localArrayList.add(new CountryInfo(new Locale("", "CH").getDisplayCountry(), 41));
    localArrayList.add(new CountryInfo(new Locale("", "SY").getDisplayCountry(), 963));
    localArrayList.add(new CountryInfo(new Locale("", "TW").getDisplayCountry(), 886));
    localArrayList.add(new CountryInfo(new Locale("", "TJ").getDisplayCountry(), 992));
    localArrayList.add(new CountryInfo(new Locale("", "TZ").getDisplayCountry(), 255));
    localArrayList.add(new CountryInfo(new Locale("", "TH").getDisplayCountry(), 66));
    localArrayList.add(new CountryInfo(new Locale("", "TG").getDisplayCountry(), 228));
    localArrayList.add(new CountryInfo(new Locale("", "TK").getDisplayCountry(), 690));
    localArrayList.add(new CountryInfo(new Locale("", "TO").getDisplayCountry(), 676));
    localArrayList.add(new CountryInfo(new Locale("", "TT").getDisplayCountry(), 1));
    localArrayList.add(new CountryInfo(new Locale("", "TN").getDisplayCountry(), 216));
    localArrayList.add(new CountryInfo(new Locale("", "TR").getDisplayCountry(), 90));
    localArrayList.add(new CountryInfo(new Locale("", "TM").getDisplayCountry(), 993));
    localArrayList.add(new CountryInfo(new Locale("", "TC").getDisplayCountry(), 1));
    localArrayList.add(new CountryInfo(new Locale("", "TV").getDisplayCountry(), 688));
    localArrayList.add(new CountryInfo(new Locale("", "VI").getDisplayCountry(), 1));
    localArrayList.add(new CountryInfo(new Locale("", "UG").getDisplayCountry(), 256));
    localArrayList.add(new CountryInfo(new Locale("", "UA").getDisplayCountry(), 380));
    localArrayList.add(new CountryInfo(new Locale("", "AE").getDisplayCountry(), 971));
    localArrayList.add(new CountryInfo(new Locale("", "GB").getDisplayCountry(), 44));
    localArrayList.add(new CountryInfo(new Locale("", "US").getDisplayCountry(), 1));
    localArrayList.add(new CountryInfo(new Locale("", "UY").getDisplayCountry(), 598));
    localArrayList.add(new CountryInfo(new Locale("", "UZ").getDisplayCountry(), 998));
    localArrayList.add(new CountryInfo(new Locale("", "VU").getDisplayCountry(), 678));
    localArrayList.add(new CountryInfo(new Locale("", "VA").getDisplayCountry(), 379));
    localArrayList.add(new CountryInfo(new Locale("", "VE").getDisplayCountry(), 58));
    localArrayList.add(new CountryInfo(new Locale("", "VN").getDisplayCountry(), 84));
    localArrayList.add(new CountryInfo(new Locale("", "WF").getDisplayCountry(), 681));
    localArrayList.add(new CountryInfo(new Locale("", "EH").getDisplayCountry(), 212));
    localArrayList.add(new CountryInfo(new Locale("", "YE").getDisplayCountry(), 967));
    localArrayList.add(new CountryInfo(new Locale("", "ZM").getDisplayCountry(), 260));
    localArrayList.add(new CountryInfo(new Locale("", "ZW").getDisplayCountry(), 263));
    Collections.sort(localArrayList);
    return localArrayList;
  }

  protected void onPostExecute(List<CountryInfo> paramList)
  {
    if (this.listener != null)
      this.listener.onLoadComplete(paramList);
  }

  public static abstract interface Listener
  {
    public abstract void onLoadComplete(List<CountryInfo> paramList);
  }
}