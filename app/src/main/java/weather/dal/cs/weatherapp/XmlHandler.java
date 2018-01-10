package weather.dal.cs.weatherapp;

import android.content.Context;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;

/**
 * Created by Bhavya on 3/13/2017.
 */

public class XmlHandler {

    private String urlString = null;
    private XmlPullParserFactory xmlObject;
    public volatile boolean xmlparsingComplete = true;
    public XmlHandler(String url){
        this.urlString = url;
    }

    public void XmlParseandStore(XmlPullParser myxmlParser){
     int event;
        String text = null;
        try {
            event=myxmlParser.getEventType();
            while(event!=XmlPullParser.END_DOCUMENT){
                String name = myxmlParser.getName();
                switch(event){
                    case XmlPullParser.START_TAG:
                        break;
                    case XmlPullParser.TEXT:
                        text = myxmlParser.getText();
                        break;
                    case XmlPullParser.END_TAG:
                        if(name.equals("textSummary") ){
                            name = text;
                        }else if (name.equals("temperature")){
                            Temperatures.temperature = myxmlParser.getAttributeValue(null, "value");
                        }else if (name.equals("dateTimeUTC")){
                            hourlyForecast.dateTimeUTC = myxmlParser.nextText();
                        }else if (name.equals("condition")){
                            hourlyForecast.condition = myxmlParser.getAttributeValue(null, "value");
                        }else if (name.equals("windChill")){
                            hourlyForecast.windChill = myxmlParser.getAttributeValue(null, "value");
                        }
                        else{}
                        break;


                }
                event=myxmlParser.next();

            }
            xmlparsingComplete=false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



   public void fetchxmlData(){
        Thread thread = new Thread(new Runnable(){

            public void setApplicationContext(Context applicationContext) {
                this.applicationContext = applicationContext;
            }

            private Context applicationContext;

            public Context getApplicationContext() {
                return applicationContext;
            }

            @Override
            public void run() {

                try {
                    /*URL url = new URL(urlString);
                    HttpURLConnection connection = (HttpURLConnection)url.openConnection();
                    connection.setReadTimeout(20000);
                    connection.setConnectTimeout(10000);
                    connection.setRequestMethod("GET");
                    connection.setDoInput(true);
                    connection.connect();*/
                   xmlObject = XmlPullParserFactory.newInstance();
                    XmlPullParser myxmlParser = xmlObject.newPullParser();

                    InputStream inputStream = getApplicationContext().getAssets().open("Source.xml");

                    myxmlParser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
                    myxmlParser.setInput(inputStream, null);
                    XmlParseandStore(myxmlParser);
                    inputStream.close();


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}
