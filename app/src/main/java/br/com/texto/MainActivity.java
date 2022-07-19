package br.com.texto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import br.com.texto.storagesd.Log;
import br.com.texto.storagesd.StorageSD;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StorageSD
                .init(this)
                .setFolderAndFileName("Manipula","Log.txt")
                .setLog(new Log() {
                    @Override
                    public void onLog(String message) {
                        System.out.println(message);
                    }
                })
                .build();

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aqui();
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    private void aqui(){
        try{
            int x = 10 / 0;
        }catch (Exception e){
            StorageSD.processaException(getClass(), e);
        }
    }
}