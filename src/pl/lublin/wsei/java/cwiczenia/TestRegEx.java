package pl.lublin.wsei.java.cwiczenia;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegEx {
    public static void main(String[] args) {
        String exItem="<item>\n" +
                "\t\t\t<title><![CDATA[Infografika - Dzień Matki 26 maja]]></title>\n" +
                "\t\t\t<pubDate><![CDATA[Wed, 26 May 2021 10:03:00 +0200]]></pubDate>\n" +
                "\t\t\t<link>https://stat.gov.pl/infografiki-widzety/infografiki/infografika-dzien-matki-26-maja,112,1.html</link>\n" +
                "\t\t\t<guid isPermaLink=\"false\">https://stat.gov.pl/infografiki-widzety/infografiki/infografika-dzien-matki-26-maja,112,1.html</guid>\n" +
                "\t\t\t<media:content url=\"https://stat.gov.pl/files/gfx/portalinformacyjny/pl/defaultaktualnosci/5866/112/1/1/dzien_matki_2021-01.png\" type=\"image/png\" width=\"1024\" height=\"2272\">\n" +
                "\t\t\t\t<media:description type=\"plain\"><![CDATA[]]></media:description>\n" +
                "\t\t\t\t<media:thumbnail url=\"https://stat.gov.pl//gfx/portalinformacyjny/_thumbs/pl/defaultaktualnosci/5866/112/1/1/dzien_matki_2021-01,k1uUwl-caFOE6tCTiHtf.png\" />\n" +
                "\t\t\t</media:content>\n" +
                "\t\t\t<description><![CDATA[<div><img src=\"https://stat.gov.pl//gfx/portalinformacyjny/_thumbs/pl/defaultaktualnosci/5866/112/1/1/dzien_matki_2021-01,k1uUwl-caFOE6tCTiHtf.png\" alt=\"\" width=\"280\" height=\"212\"/></div>]]></description>\n" +
                "\t\t</item>";
    }
//    Pattern pat = Pattern.compile("<title><!\\[CDATA\\[(.*)\\]]");
//    Matcher m = pat.matcher(exItem);
//    if(m.find())
//        System.out.println("Znaleziono tytuł: "+m.group(1));
//    else
//        System.out.println("Nie znaleziono tytułu ...");


}
