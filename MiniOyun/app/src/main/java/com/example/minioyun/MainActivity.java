package com.example.minioyun;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView imageViewOyuncu, imageViewBilgisayar;
    TextView textViewOyuncu, textViewBilgisayar;
    Button btnTas, btnKagit, btnMakas;

    int [] resimler={R.drawable.indir, R.drawable.kagit, R.drawable.makas};
    int oyuncuPuan;
    int bilgisayarPuan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViewOyuncu = findViewById(R.id.image_oyuncu);
        imageViewBilgisayar = findViewById(R.id.image_bilgisayar);
        textViewOyuncu = findViewById(R.id.tV_oyuncupuan);
        textViewBilgisayar = findViewById(R.id.tV_bilgisayarpuan);
        btnTas = findViewById(R.id.button_tas);
        btnKagit = findViewById(R.id.button_kagit);
        btnMakas = findViewById(R.id.button_makas);

        oyuncuPuan=0;
        bilgisayarPuan=0;



        btnTas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                oyna(0);

            }
        });

        btnKagit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                oyna(1);

            }
        });

        btnMakas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                oyna(2);

            }
        });


    }

    private void oyna(int oyuncusecim) {

        int bilgisayarSecim = (int)(Math.random()*3);

        imageViewOyuncu.setImageResource(resimler[oyuncusecim]);
        imageViewBilgisayar.setImageResource(resimler[bilgisayarSecim]);

        if (oyuncusecim==bilgisayarSecim){
            Toast.makeText(this, "Berabere", Toast.LENGTH_SHORT).show();
            
        } else if (oyuncusecim == 0 && bilgisayarSecim == 2 ||
                  oyuncusecim == 1 && bilgisayarSecim == 0 ||
                  oyuncusecim == 2 && bilgisayarSecim == 1 ) {
            oyuncuPuan++;
        }
        else {
            bilgisayarPuan++;
        }
        textViewOyuncu.setText("Oyuncu: "+oyuncuPuan);
        textViewBilgisayar.setText("Bilgisayar: "+bilgisayarPuan);

    }

}
