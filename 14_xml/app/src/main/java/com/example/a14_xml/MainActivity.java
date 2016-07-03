package com.example.a14_xml;

import android.os.AsyncTask;
import android.provider.DocumentsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MainActivity extends AppCompatActivity {

    class MyDomParser extends AsyncTask<String, Void, Document> {
        TextView textView;
        public MyDomParser(TextView textView){
            this.textView = textView;

            //Alt + Insert키로 입력하고자 하는 기능을 고를 수있다.
        }

    private String getTextvalue(Element data, String tag){
        NodeList hourList = data.getElementsByTagName(tag);
        Element hour = (Element) hourList.item(0);
        return hour.getFirstChild().getNodeValue();

    }

        protected void onPostExecute(Document document) {
            super.onPostExecute(document);
            String res = "";
            NodeList nodeList = document.getElementsByTagName("data");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element data = nodeList.item(i);
               String strHour = getTextvalue(data, "hour");
                String strDay = getTextvalue(data, "day");
                String strTemp = getTextvalue(data, "temp");
                String wfKor = getTextvalue(data, "wfKor");

                res += "day : "+strDay+"hour : "+strHour+ "temp :"+strTemp+"wfKor :" +wfKor;
                res +="\n";

                Log.d("WEATHER", "hour :" + hour);
            }
            textView.setText(res);

        }

        protected Document doInBackground(String... strings) {
            URL url;
            try {
                url = new URL(strings[0]);
                //Document를 만들어준다
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                Document doc = db.parse(url.openStream());
            } catch (Exception e) {
                e.printStackTrace();
                return doc;

            }


            return null;

        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            textView = (Text)findViewById(R.id.textView);
            MyDomParser task = new MyDomParser(textView);
            task.execute("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1159068000");
        }
    }
}
