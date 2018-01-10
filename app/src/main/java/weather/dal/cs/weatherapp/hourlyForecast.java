package weather.dal.cs.weatherapp;

/**
 * Created by Bhavya on 3/14/2017.
 */

public class hourlyForecast {

    public static String dateTimeUTC = "dateTimeUTC";
    public static String condition = "condition";
    public static String windChill = "windChill";

    public String getDateTimeUTC() {
        return dateTimeUTC;
    }

    public void setDateTimeUTC(String dateTimeUTC) {
        this.dateTimeUTC = dateTimeUTC;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getWindChill() {
        return windChill;
    }

    public void setWindChill(String windChill) {
        this.windChill = windChill;
    }

    public void fetchxmlData() {
    }

  /* public void fetchxmlData() {

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
                   /* XmlPullParserFactory xmlObject = XmlPullParserFactory.newInstance();
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

            private void XmlParseandStore(XmlPullParser myxmlParser) {
            }
        });
        thread.start();
    }*/
    }


