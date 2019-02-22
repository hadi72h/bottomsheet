package com.flipboard.bottomsheet.sample;

import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.flipboard.bottomsheet.BottomSheetLayout;
import com.flipboard.bottomsheet.R;
import com.flipboard.bottomsheet.commons.ImagePickerSheetView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Activity demonstrating the use of {@link ImagePickerSheetView}
 */
public final class BottomSheetFragmentActivity extends AppCompatActivity {

    protected BottomSheetLayout bottomSheetLayout;
    protected MyFragment myFragment;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet_fragment);
        bottomSheetLayout = (BottomSheetLayout) findViewById(R.id.bottomsheet);
        bottomSheetLayout.setAspectRatio(0.75f);
        bottomSheetLayout.setEnableExpandOnLayoutChange(false);
        bottomSheetLayout.setInterceptContentTouch(false);

        EditText editText = findViewById(R.id.bottomsheet_fragment_edt);

        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                myFragment = new MyFragment();
                myFragment.show(getSupportFragmentManager(), R.id.bottomsheet);
            }
        };

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                handler.removeCallbacks(runnable);

                if (myFragment != null) {
                    myFragment.dismiss();
                    myFragment = null;
                }

                handler.postDelayed(runnable, 500);
            }
        });
    }
}
