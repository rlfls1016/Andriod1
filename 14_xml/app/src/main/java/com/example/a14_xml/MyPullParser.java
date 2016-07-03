package com.example.a14_xml;

import android.os.AsyncTask;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.net.URL;

/**
 * Created by 최희선 on 2016-07-03.
 */

public class MyPullParser extends AsyncTask<String, Void, String>{
TextView textView;
    public MyPullParser(TextView textView){
    this.textView = textView;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        textView.setText(s);
    }

    protected String doInBackground(String... strings){
        String res = "";
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new URL(strings[0].openStream(), "utf-8"));
            int eventType = xpp.getEventType();
            boolean bRead = false;
            boolean bLineBreak = false;

            while(eventType !=XmlPullParser.END_DOCUMENT){
                switch (eventType){
                    case XmlPullParser.START_TAG:
                        if(xpp.getName().equals("hour")){
                            res += "hour :";
                            bRead = true;
                        }else  if(xpp.getName().equals("day")){
                            res += "day :";
                            bRead = true;

                        }else  if(xpp.getName().equals("temp")){
                            res += "temp :";
                            bRead = true;

                        }else  if(xpp.getName().equals("wfKor")){
                            res += "wfKor :";
                            bRead = true;
                            bLineBreak = true;

                        }
                        break;
                    case XmlPullParser.END_TAG:
                        break;
                    case XmlPullParser.TEXT:
                        if(bRead){
                            res +=xpp.getText();
                            bRead = false;
                        }
                        if(bLineBreak){
                            bLineBreak = false;
                            res += "\n";
                        }
                        break;
                }
                eventType = xpp.next();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return  res;
    }

}
