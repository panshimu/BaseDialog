package com.miaozi.basedialog;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.miaozi.basedialog.dialog.MyAlertDialog;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void show(View view) {
        final MyAlertDialog dialog = new MyAlertDialog.Builder(this)
                .setContentView(R.layout.dialog_layout)
                .setWidth(500)
                .setHeight(300)
                .create();
        dialog.show();
        dialog.getViewById(R.id.bt_confirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TAG","909090");
                dialog.dismiss();
            }
        });
    }
}
