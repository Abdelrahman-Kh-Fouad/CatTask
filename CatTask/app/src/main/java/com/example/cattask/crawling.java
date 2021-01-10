package com.example.cattask;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class crawling {

    private ArrayList<FilmListItem>arr ;
    public crawling() throws IOException {

        Document doc = Jsoup.connect("https://www.boxofficemojo.com/showdown/?ref_=bo_nb_cso_tab").get();
        Elements all =  doc.select("a");
        Pattern p = Pattern.compile(">.+</a>");
        ArrayList<String> names = new ArrayList<String>();
        for(Element i  : all)
        {
            String cur = i.toString();

            if (cur.indexOf("/release/")!=-1)
            {
                Matcher m = p.matcher(cur);
                if(m.find())
                {
                    String tmp = m.group();
                    tmp = tmp.substring( 1 , tmp.length()-4);
                    names.add(tmp);
                }
            }
        }
        arr = new ArrayList<FilmListItem>();
        int COUNT =100 ;
        int cnt = 0;
        //TODO using threads to get images and ubdate it in recycler view one by one

        for (String i : names )
        {
            if(cnt==COUNT)break;
            getimg img = new getimg(i);
            arr.add(new FilmListItem(i , img.get()));
            cnt++;
        }

    }
    public ArrayList<FilmListItem> getArr(){return arr;}



}
