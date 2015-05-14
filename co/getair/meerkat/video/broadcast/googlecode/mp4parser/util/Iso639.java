package co.getair.meerkat.video.broadcast.googlecode.mp4parser.util;

import java.util.HashMap;
import java.util.Map;

public class Iso639
{
  static Map<String, String> threeToTwo;
  static Map<String, String> twoToThree = new HashMap();

  static
  {
    threeToTwo = new HashMap();
    doublePut("ab", "abk");
    doublePut("aa", "aar");
    doublePut("af", "afr");
    doublePut("ak", "aka");
    doublePut("sq", "sqi");
    doublePut("am", "amh");
    doublePut("ar", "ara");
    doublePut("an", "arg");
    doublePut("hy", "hye");
    doublePut("as", "asm");
    doublePut("av", "ava");
    doublePut("ae", "ave");
    doublePut("ay", "aym");
    doublePut("az", "aze");
    doublePut("bm", "bam");
    doublePut("ba", "bak");
    doublePut("eu", "eus");
    doublePut("be", "bel");
    doublePut("bn", "ben");
    doublePut("bh", "bih");
    doublePut("bi", "bis");
    doublePut("bs", "bos");
    doublePut("br", "bre");
    doublePut("bg", "bul");
    doublePut("my", "mya");
    doublePut("ca", "cat");
    doublePut("ch", "cha");
    doublePut("ce", "che");
    doublePut("ny", "nya");
    doublePut("zh", "zho");
    doublePut("cv", "chv");
    doublePut("kw", "cor");
    doublePut("co", "cos");
    doublePut("cr", "cre");
    doublePut("hr", "hrv");
    doublePut("cs", "ces");
    doublePut("da", "dan");
    doublePut("dv", "div");
    doublePut("nl", "nld");
    doublePut("dz", "dzo");
    doublePut("en", "eng");
    doublePut("eo", "epo");
    doublePut("et", "est");
    doublePut("ee", "ewe");
    doublePut("fo", "fao");
    doublePut("fj", "fij");
    doublePut("fi", "fin");
    doublePut("fr", "fra");
    doublePut("ff", "ful");
    doublePut("gl", "glg");
    doublePut("ka", "kat");
    doublePut("de", "deu");
    doublePut("el", "ell");
    doublePut("gn", "grn");
    doublePut("gu", "guj");
    doublePut("ht", "hat");
    doublePut("ha", "hau");
    doublePut("he", "heb");
    doublePut("hz", "her");
    doublePut("hi", "hin");
    doublePut("ho", "hmo");
    doublePut("hu", "hun");
    doublePut("ia", "ina");
    doublePut("id", "ind");
    doublePut("ie", "ile");
    doublePut("ga", "gle");
    doublePut("ig", "ibo");
    doublePut("ik", "ipk");
    doublePut("io", "ido");
    doublePut("is", "isl");
    doublePut("it", "ita");
    doublePut("iu", "iku");
    doublePut("ja", "jpn");
    doublePut("jv", "jav");
    doublePut("kl", "kal");
    doublePut("kn", "kan");
    doublePut("kr", "kau");
    doublePut("ks", "kas");
    doublePut("kk", "kaz");
    doublePut("km", "khm");
    doublePut("ki", "kik");
    doublePut("rw", "kin");
    doublePut("ky", "kir");
    doublePut("kv", "kom");
    doublePut("kg", "kon");
    doublePut("ko", "kor");
    doublePut("ku", "kur");
    doublePut("kj", "kua");
    doublePut("la", "lat");
    doublePut("lb", "ltz");
    doublePut("lg", "lug");
    doublePut("li", "lim");
    doublePut("ln", "lin");
    doublePut("lo", "lao");
    doublePut("lt", "lit");
    doublePut("lu", "lub");
    doublePut("lv", "lav");
    doublePut("gv", "glv");
    doublePut("mk", "mkd");
    doublePut("mg", "mlg");
    doublePut("ms", "msa");
    doublePut("ml", "mal");
    doublePut("mt", "mlt");
    doublePut("mi", "mri");
    doublePut("mr", "mar");
    doublePut("mh", "mah");
    doublePut("mn", "mon");
    doublePut("na", "nau");
    doublePut("nv", "nav");
    doublePut("nd", "nde");
    doublePut("ne", "nep");
    doublePut("ng", "ndo");
    doublePut("nb", "nob");
    doublePut("nn", "nno");
    doublePut("no", "nor");
    doublePut("ii", "iii");
    doublePut("nr", "nbl");
    doublePut("oc", "oci");
    doublePut("oj", "oji");
    doublePut("cu", "chu");
    doublePut("om", "orm");
    doublePut("or", "ori");
    doublePut("os", "oss");
    doublePut("pa", "pan");
    doublePut("pi", "pli");
    doublePut("fa", "fas");
    doublePut("pl", "pol");
    doublePut("ps", "pus");
    doublePut("pt", "por");
    doublePut("qu", "que");
    doublePut("rm", "roh");
    doublePut("rn", "run");
    doublePut("ro", "ron");
    doublePut("ru", "rus");
    doublePut("sa", "san");
    doublePut("sc", "srd");
    doublePut("sd", "snd");
    doublePut("se", "sme");
    doublePut("sm", "smo");
    doublePut("sg", "sag");
    doublePut("sr", "srp");
    doublePut("gd", "gla");
    doublePut("sn", "sna");
    doublePut("si", "sin");
    doublePut("sk", "slk");
    doublePut("sl", "slv");
    doublePut("so", "som");
    doublePut("st", "sot");
    doublePut("es", "spa");
    doublePut("su", "sun");
    doublePut("sw", "swa");
    doublePut("ss", "ssw");
    doublePut("sv", "swe");
    doublePut("ta", "tam");
    doublePut("te", "tel");
    doublePut("tg", "tgk");
    doublePut("th", "tha");
    doublePut("ti", "tir");
    doublePut("bo", "bod");
    doublePut("tk", "tuk");
    doublePut("tl", "tgl");
    doublePut("tn", "tsn");
    doublePut("to", "ton");
    doublePut("tr", "tur");
    doublePut("ts", "tso");
    doublePut("tt", "tat");
    doublePut("tw", "twi");
    doublePut("ty", "tah");
    doublePut("ug", "uig");
    doublePut("uk", "ukr");
    doublePut("ur", "urd");
    doublePut("uz", "uzb");
    doublePut("ve", "ven");
    doublePut("vi", "vie");
    doublePut("vo", "vol");
    doublePut("wa", "wln");
    doublePut("cy", "cym");
    doublePut("wo", "wol");
    doublePut("fy", "fry");
    doublePut("xh", "xho");
    doublePut("yi", "yid");
    doublePut("yo", "yor");
    doublePut("za", "zha");
    doublePut("zu", "zul");
  }

  public static String convert2to3(String paramString)
  {
    return (String)twoToThree.get(paramString);
  }

  public static String convert3to2(String paramString)
  {
    return (String)threeToTwo.get(paramString);
  }

  private static void doublePut(String paramString1, String paramString2)
  {
    twoToThree.put(paramString1, paramString2);
    threeToTwo.put(paramString2, paramString1);
  }
}