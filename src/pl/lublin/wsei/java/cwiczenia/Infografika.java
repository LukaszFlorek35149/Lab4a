package pl.lublin.wsei.java.cwiczenia;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Infografika {

    public String tytul;
    public String adresStrony;
    public String adresGrafiki;
    public String adresMiniaturki;
    public Integer szerokosc;
    public Integer wysokosc;


    public Infografika(String text)
    {
        Pattern pat = Pattern.compile("<title><!\\[CDATA\\[(.*)\\]\\]");
        Matcher m = pat.matcher(text);
        if(m.find())
        {
            tytul = m.group(1);
        }
        else tytul="";

        pat = Pattern.compile("<link>(.*)<\\/link>");
        m = pat.matcher(text);
        if(m.find())
        {
            adresStrony = m.group(1);
        }
        else adresStrony="";

        pat = Pattern.compile("<media:content url=\"(.*)\" type");
        m = pat.matcher(text);
        if(m.find())
        {
            adresGrafiki = m.group(1);
        }
        else adresGrafiki="";

        pat = Pattern.compile("<media:thumbnail url=\"(.*)\"");
        m = pat.matcher(text);
        if(m.find()) {
            adresMiniaturki = m.group(1);
        }
        else
            adresMiniaturki="";

        pat = Pattern.compile("\" width=\"(.*)\" height=(.*)\">");
        m = pat.matcher(text);
        if(m.find())
        {
            szerokosc = Integer.parseInt(m.group(1));
        }
        else szerokosc = 0;

        pat = Pattern.compile("height=\"(.*)\">");
        m = pat.matcher(text);
        if(m.find())
        {
            wysokosc = Integer.parseInt(m.group(1));
        }
        else wysokosc = 0;
    }

    public void print()
    {
        System.out.println("Tutuł: "+tytul);
        System.out.println("adres strony: "+adresStrony);
        System.out.println("adres grafiki: "+adresGrafiki);
        System.out.println("adres miniaturki: "+adresMiniaturki);
        System.out.println("rozmiary: "+szerokosc.toString()+"x"+wysokosc.toString()+"\n");
    }


}
