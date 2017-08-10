package com.example.android.camera2video;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.annotation.IdRes;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class OptionsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioGroup);


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

                RadioButton radioButton = (RadioButton)findViewById(checkedId);

                saveInSharedPrefs(radioButton.getText().toString(), "resolution");
            }
        });


        RadioGroup radioGroupFps = (RadioGroup) findViewById(R.id.fpsRadioGroup);

        radioGroupFps.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                RadioButton radioButton = (RadioButton)findViewById(checkedId);

                int fps = Integer.parseInt(radioButton.getText().toString());

                saveInSharedPrefs(fps, "fps");
            }
        });

       RadioGroup bitRateRadioGroup = (RadioGroup) findViewById(R.id.bitrateRadioGroup);

        bitRateRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                RadioButton radioButton = (RadioButton)findViewById(checkedId);

                int bitrate = Integer.parseInt(radioButton.getText().toString());

                saveInSharedPrefs(bitrate, "bitrate");
            }
        });

    }

    /**
     *
     * @param value
     * @param key key used in the shared prefs for the object
     */
    private void saveInSharedPrefs(int value, String key) {

        SharedPreferences prefs = this.getSharedPreferences("appPrefs", MODE_PRIVATE);

        SharedPreferences.Editor editor = prefs.edit();

        editor.putInt(key, value);

        editor.apply();

    }


    private void saveInSharedPrefs(String value, String key) {
        SharedPreferences prefs = this.getSharedPreferences("appPrefs", MODE_PRIVATE);

        SharedPreferences.Editor editor = prefs.edit();

        editor.putString(key, value);

        editor.apply();
    }
}
