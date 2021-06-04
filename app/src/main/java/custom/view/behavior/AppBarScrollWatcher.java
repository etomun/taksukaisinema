package custom.view.behavior;

import com.google.android.material.appbar.AppBarLayout;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

public class AppBarScrollWatcher implements AppBarLayout.OnOffsetChangedListener {
    private int scrollRange = -1;
    private OffsetListener listener;

    public AppBarScrollWatcher(OffsetListener listener) {
        this.listener = listener;
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        if (scrollRange == -1) {
            scrollRange = appBarLayout.getTotalScrollRange();
        }

        int appbarHeight = scrollRange + verticalOffset;
        float alpha = (float) appbarHeight / scrollRange;
        if (alpha < 0) {
            alpha = 0;
        }
        float alphaZeroOnCollapsed = shrinkAlpha(alpha);
        float alphaZeroOnExpanded = Math.abs(alphaZeroOnCollapsed - 1);
        int argbZeroOnExpanded = (int) Math.abs((alphaZeroOnCollapsed * 255) - 255);
        int argbZeroOnCollapsed = (int) Math.abs(alphaZeroOnCollapsed * 255);

        listener.onAppBarExpanding(alphaZeroOnExpanded <= 0, alphaZeroOnCollapsed <= 0, argbZeroOnExpanded, argbZeroOnCollapsed, alphaZeroOnCollapsed, alphaZeroOnExpanded);
    }

    private float shrinkAlpha(float alpha) {
        NumberFormat formatter = NumberFormat.getInstance(Locale.getDefault());
        formatter.setMaximumFractionDigits(2);
        formatter.setMinimumFractionDigits(2);
        formatter.setRoundingMode(RoundingMode.HALF_DOWN);
        return Float.parseFloat(formatter.format(alpha));
    }

    public interface OffsetListener {
        void onAppBarExpanding(boolean expanded, boolean collapsed, int argbZeroOnExpanded, int argbZeroOnCollapsed, float alphaZeroOnCollapsed, float alphaZeroOnExpanded);
    }
}
