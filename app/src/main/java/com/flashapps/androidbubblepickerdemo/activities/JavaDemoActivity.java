package com.flashapps.androidbubblepickerdemo.activities;

import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.flashapps.androidbubblepickerdemo.R;
import com.flashapps.bubblepicker.BubblePickerListener;
import com.flashapps.bubblepicker.adapter.BubblePickerAdapter;
import com.flashapps.bubblepicker.model.PickerItem;
import com.flashapps.bubblepicker.rendering.BubblePicker;

import org.jetbrains.annotations.NotNull;

public class JavaDemoActivity extends AppCompatActivity {

    private String ROBOTO_BOLD = "roboto_bold.ttf";
    private String ROBOTO_MEDIUM = "roboto_medium.ttf";
    private String ROBOTO_REGULAR = "roboto_regular.ttf";

    private Typeface boldTypeface;
    private Typeface mediumTypeface;
    private Typeface regularTypeface;

    TextView titleTextView;
    TextView subtitleTextView;
    TextView hintTextView;

    BubblePicker picker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        titleTextView = (TextView) findViewById(R.id.titleTextView);
        subtitleTextView = (TextView) findViewById(R.id.subtitleTextView);
        hintTextView = (TextView) findViewById(R.id.hintTextView);
        picker = (BubblePicker) findViewById(R.id.picker);

        boldTypeface = Typeface.createFromAsset(getAssets(), ROBOTO_BOLD);
        mediumTypeface = Typeface.createFromAsset(getAssets(), ROBOTO_MEDIUM);
        regularTypeface = Typeface.createFromAsset(getAssets(), ROBOTO_REGULAR);

        titleTextView.setTypeface(mediumTypeface);
        subtitleTextView.setTypeface(boldTypeface);
        hintTextView.setTypeface(regularTypeface);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            subtitleTextView.setLetterSpacing(0.06f);
            hintTextView.setLetterSpacing(0.05f);
        }

        final String[] titles = getResources().getStringArray(R.array.countries);
        final TypedArray colors = getResources().obtainTypedArray(R.array.colors);

        picker.setAdapter(new BubblePickerAdapter() {
            @Override
            public int getTotalCount() {
                return titles.length;
            }

            @NotNull
            @Override
            public PickerItem getItem(int position) {
                PickerItem pickerItem = new PickerItem();
                pickerItem.setTitle(titles[position]);
                pickerItem.setColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
                pickerItem.setSelectedColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimaryDark));
                pickerItem.setTypeface(mediumTypeface);
                pickerItem.setTextColor(ContextCompat.getColor(JavaDemoActivity.this, android.R.color.white));
                pickerItem.setSelectedTextColor(ContextCompat.getColor(JavaDemoActivity.this, android.R.color.holo_green_dark));
                pickerItem.setBorderSize(5);
                pickerItem.setBorderColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimaryDark));
                pickerItem.setBorderSelectedColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
                return pickerItem;
            }
        });

        colors.recycle();

        picker.setBubbleSize(20);
        picker.setListener(new BubblePickerListener() {
            @Override
            public void onBubbleSelected(@NotNull PickerItem item) {
                toast(item.getTitle() + "selected");
            }

            @Override
            public void onBubbleDeselected(@NotNull PickerItem item) {
                toast(item.getTitle() + "deselected");
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        picker.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        picker.onPause();
    }

    private void toast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }


}
