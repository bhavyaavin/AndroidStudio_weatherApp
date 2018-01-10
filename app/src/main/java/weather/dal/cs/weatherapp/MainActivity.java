package weather.dal.cs.weatherapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private EditText text1, text2, text3, text4;



    private Temperatures object;
    Button buttonChange_location;

    public MainActivity(ImageView imageview, Temperatures object, Temperatures object1) {

        this.object = object;
        this.object = object1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonChange_location = (Button) findViewById(R.id.button);

        text1 = (EditText) findViewById(R.id.textview2);
        text2 = (EditText) findViewById(R.id.editview1);
        text3 = (EditText) findViewById(R.id.editview2);
        text4 = (EditText) findViewById(R.id.editview3);
        //imageview= (ImageView) findViewById(R.id.imageView);
        buttonChange_location.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                // String url = text1.getText().toString();
                // String finalurl = reference_url + url + url2;
                // text2.setText(finalurl);
                // object = new XmlHandler(finalurl);
                hourlyForecast object1 = null;
                assert object1 != null;
                object1.fetchxmlData();
                while  (object.xmlparsingComplete);
                text2.setText(object.getTemperature());
                 text3.setText(object1.getCondition());

                XmlPullParserFactory pullParserFactory;
                try {
                    pullParserFactory = XmlPullParserFactory.newInstance();
                    XmlPullParser myxmlParser = pullParserFactory.newPullParser();

                    InputStream in_s = getApplicationContext().getAssets().open("Source.xml");
                    myxmlParser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
                    myxmlParser.setInput(in_s, null);

                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        });

    }
}