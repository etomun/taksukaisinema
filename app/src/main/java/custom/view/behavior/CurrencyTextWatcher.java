package custom.view.behavior;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.text.DecimalFormat;
import java.text.ParseException;

public class CurrencyTextWatcher implements TextWatcher {
    private static final String CURRENCY = "Rp";

    private final DecimalFormat df;
    private final DecimalFormat dfNd;
    private final EditText et;
    private boolean hasFractionalPart;
    private int trailingZeroCount;

    public CurrencyTextWatcher(EditText editText) {
        df = new DecimalFormat("##,###");
        df.setDecimalSeparatorAlwaysShown(true);
        dfNd = new DecimalFormat("##,###.00");
        this.et = editText;
        hasFractionalPart = false;
    }

    @Override
    public void afterTextChanged(Editable s) {
        et.removeTextChangedListener(this);

        if (s != null && !s.toString().isEmpty()) {
            try {
                int inLen, endLen;
                inLen = et.getText().length();
                String v = s.toString().replace(String.valueOf(df.getDecimalFormatSymbols().getGroupingSeparator()), "").replace(CURRENCY, "");
                Number n = df.parse(v);
                int cp = et.getSelectionStart();
                if (hasFractionalPart) {
                    StringBuilder trailingZeros = new StringBuilder();
                    while (trailingZeroCount-- > 0)
                        trailingZeros.append('0');
                    String formatted = df.format(n) + trailingZeros.toString();
                    et.setText(formatted);
                } else {
                    et.setText(dfNd.format(n));
                }
                et.setText(CURRENCY.concat(et.getText().toString()));
                endLen = et.getText().length();
                int sel = (cp + (endLen - inLen));
                if (sel > 0 && sel < et.getText().length()) {
                    et.setSelection(sel);
                } else if (trailingZeroCount > -1) {
                    et.setSelection(et.getText().length() - 3);
                } else {
                    et.setSelection(et.getText().length());
                }
            } catch (NumberFormatException | ParseException e) {
                e.printStackTrace();
            }
        }

        et.addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        int index = s.toString().indexOf(String.valueOf(df.getDecimalFormatSymbols().getDecimalSeparator()));
        trailingZeroCount = 0;
        if (index > -1) {
            for (index++; index < s.length(); index++) {
                if (s.charAt(index) == '0')
                    trailingZeroCount++;
                else {
                    trailingZeroCount = 0;
                }
            }
            hasFractionalPart = true;
        } else {
            hasFractionalPart = false;
        }
    }
}
