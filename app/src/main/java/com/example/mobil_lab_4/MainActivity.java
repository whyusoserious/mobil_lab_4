package com.example.mobil_lab_4;

import android.graphics.Color;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    TextView tcolor;
    TextView tfrom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Cat murzik = new Cat();
        murzik.name = "Мурзик";
        murzik.age = 9;
        murzik.color = Color.YELLOW;

        //конвертация в JSON
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Log.i("GSON", gson.toJson(murzik));
        String[] text_gson = (gson.toJson(murzik).toString()).split("\"");

        //вывод результата
        tv = (TextView) findViewById(R.id.tv);
        tcolor = (TextView) findViewById(R.id.color);
        tv.setText("Кот: " + text_gson[7] + ", " + text_gson[2].substring(1,2) + " лет, " + "цвет: ");
        tcolor.setBackgroundColor(Integer.parseInt(text_gson[4].substring(1,5)));

        //конвератция из JSON
        String jsonText = "{\"name\":\"Барсик\",\"color\":-16777216,\"age\":7}";
        Cat barsik = gson.fromJson(jsonText, Cat.class);
        Log.i("GSON", "Имя: " + barsik.name + "\nВозраст: " + barsik.age);

        //вывод результата
        tfrom = (TextView) findViewById(R.id.fromJson);
        tfrom.setText("Имя: " + barsik.name + "\nВозраст: " + barsik.age);
    }
}